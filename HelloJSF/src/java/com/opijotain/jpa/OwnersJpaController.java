/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.opijotain.jpa;

import com.opijotain.entity.Owners;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
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
public class OwnersJpaController implements Serializable {

    public OwnersJpaController(UserTransaction utx, EntityManagerFactory emf) {
        this.utx = utx;
        this.emf = emf;
    }
    private UserTransaction utx = null;
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Owners owners) throws PreexistingEntityException, RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            Weather weather = owners.getWeather();
            if (weather != null) {
                weather = em.getReference(weather.getClass(), weather.getInstance());
                owners.setWeather(weather);
            }
            em.persist(owners);
            if (weather != null) {
                Owners oldOwnersOfWeather = weather.getOwners();
                if (oldOwnersOfWeather != null) {
                    oldOwnersOfWeather.setWeather(null);
                    oldOwnersOfWeather = em.merge(oldOwnersOfWeather);
                }
                weather.setOwners(owners);
                weather = em.merge(weather);
            }
            utx.commit();
        } catch (Exception ex) {
            try {
                utx.rollback();
            } catch (Exception re) {
                throw new RollbackFailureException("An error occurred attempting to roll back the transaction.", re);
            }
            if (findOwners(owners.getOwner()) != null) {
                throw new PreexistingEntityException("Owners " + owners + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Owners owners) throws IllegalOrphanException, NonexistentEntityException, RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            Owners persistentOwners = em.find(Owners.class, owners.getOwner());
            Weather weatherOld = persistentOwners.getWeather();
            Weather weatherNew = owners.getWeather();
            List<String> illegalOrphanMessages = null;
            if (weatherOld != null && !weatherOld.equals(weatherNew)) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("You must retain Weather " + weatherOld + " since its owners field is not nullable.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            if (weatherNew != null) {
                weatherNew = em.getReference(weatherNew.getClass(), weatherNew.getInstance());
                owners.setWeather(weatherNew);
            }
            owners = em.merge(owners);
            if (weatherNew != null && !weatherNew.equals(weatherOld)) {
                Owners oldOwnersOfWeather = weatherNew.getOwners();
                if (oldOwnersOfWeather != null) {
                    oldOwnersOfWeather.setWeather(null);
                    oldOwnersOfWeather = em.merge(oldOwnersOfWeather);
                }
                weatherNew.setOwners(owners);
                weatherNew = em.merge(weatherNew);
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
                String id = owners.getOwner();
                if (findOwners(id) == null) {
                    throw new NonexistentEntityException("The owners with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(String id) throws IllegalOrphanException, NonexistentEntityException, RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            Owners owners;
            try {
                owners = em.getReference(Owners.class, id);
                owners.getOwner();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The owners with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            Weather weatherOrphanCheck = owners.getWeather();
            if (weatherOrphanCheck != null) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Owners (" + owners + ") cannot be destroyed since the Weather " + weatherOrphanCheck + " in its weather field has a non-nullable owners field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            em.remove(owners);
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

    public List<Owners> findOwnersEntities() {
        return findOwnersEntities(true, -1, -1);
    }

    public List<Owners> findOwnersEntities(int maxResults, int firstResult) {
        return findOwnersEntities(false, maxResults, firstResult);
    }

    private List<Owners> findOwnersEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Owners.class));
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

    public Owners findOwners(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Owners.class, id);
        } finally {
            em.close();
        }
    }

    public int getOwnersCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Owners> rt = cq.from(Owners.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
