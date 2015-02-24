/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.opijotain.jpa;

import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import com.opijotain.entity.Owners;
import com.opijotain.entity.Weather;
import com.opijotain.jpa.exceptions.IllegalOrphanException;
import com.opijotain.jpa.exceptions.NonexistentEntityException;
import com.opijotain.jpa.exceptions.PreexistingEntityException;
import com.opijotain.jpa.exceptions.RollbackFailureException;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.transaction.UserTransaction;

/**
 *
 * @author Ohjelmistokehitys
 */
public class WeatherJpaController implements Serializable {

    public WeatherJpaController(UserTransaction utx, EntityManagerFactory emf) {
        this.utx = utx;
        this.emf = emf;
    }
    private UserTransaction utx = null;
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Weather weather) throws IllegalOrphanException, PreexistingEntityException, RollbackFailureException, Exception {
        List<String> illegalOrphanMessages = null;
        Owners ownersOrphanCheck = weather.getOwners();
        if (ownersOrphanCheck != null) {
            Weather oldWeatherOfOwners = ownersOrphanCheck.getWeather();
            if (oldWeatherOfOwners != null) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("The Owners " + ownersOrphanCheck + " already has an item of type Weather whose owners column cannot be null. Please make another selection for the owners field.");
            }
        }
        if (illegalOrphanMessages != null) {
            throw new IllegalOrphanException(illegalOrphanMessages);
        }
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            Owners owners = weather.getOwners();
            if (owners != null) {
                owners = em.getReference(owners.getClass(), owners.getOwner());
                weather.setOwners(owners);
            }
            em.persist(weather);
            if (owners != null) {
                owners.setWeather(weather);
                owners = em.merge(owners);
            }
            utx.commit();
        } catch (Exception ex) {
            try {
                utx.rollback();
            } catch (Exception re) {
                throw new RollbackFailureException("An error occurred attempting to roll back the transaction.", re);
            }
            if (findWeather(weather.getInstance()) != null) {
                throw new PreexistingEntityException("Weather " + weather + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Weather weather) throws IllegalOrphanException, NonexistentEntityException, RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            Weather persistentWeather = em.find(Weather.class, weather.getInstance());
            Owners ownersOld = persistentWeather.getOwners();
            Owners ownersNew = weather.getOwners();
            List<String> illegalOrphanMessages = null;
            if (ownersNew != null && !ownersNew.equals(ownersOld)) {
                Weather oldWeatherOfOwners = ownersNew.getWeather();
                if (oldWeatherOfOwners != null) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("The Owners " + ownersNew + " already has an item of type Weather whose owners column cannot be null. Please make another selection for the owners field.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            if (ownersNew != null) {
                ownersNew = em.getReference(ownersNew.getClass(), ownersNew.getOwner());
                weather.setOwners(ownersNew);
            }
            weather = em.merge(weather);
            if (ownersOld != null && !ownersOld.equals(ownersNew)) {
                ownersOld.setWeather(null);
                ownersOld = em.merge(ownersOld);
            }
            if (ownersNew != null && !ownersNew.equals(ownersOld)) {
                ownersNew.setWeather(weather);
                ownersNew = em.merge(ownersNew);
            }
            utx.commit();
        } catch (Exception ex) {
            try {
                utx.rollback();
            } catch (Exception re) {
                throw new RollbackFailureException("An error occurred attempting to roll back the transaction.", re);
            }
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = weather.getInstance();
                if (findWeather(id) == null) {
                    throw new NonexistentEntityException("The weather with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(String id) throws NonexistentEntityException, RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            Weather weather;
            try {
                weather = em.getReference(Weather.class, id);
                weather.getInstance();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The weather with id " + id + " no longer exists.", enfe);
            }
            Owners owners = weather.getOwners();
            if (owners != null) {
                owners.setWeather(null);
                owners = em.merge(owners);
            }
            em.remove(weather);
            utx.commit();
        } catch (Exception ex) {
            try {
                utx.rollback();
            } catch (Exception re) {
                throw new RollbackFailureException("An error occurred attempting to roll back the transaction.", re);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Weather> findWeatherEntities() {
        return findWeatherEntities(true, -1, -1);
    }

    public List<Weather> findWeatherEntities(int maxResults, int firstResult) {
        return findWeatherEntities(false, maxResults, firstResult);
    }

    private List<Weather> findWeatherEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Weather.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Weather findWeather(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Weather.class, id);
        } finally {
            em.close();
        }
    }

    public int getWeatherCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Weather> rt = cq.from(Weather.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
