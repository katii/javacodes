/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.opiframe.beans;


import com.opiframe.entity.OpiframeUser;
import com.opiframe.jpa.OpiframeUserJpaController;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.event.ActionEvent;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.UserTransaction;

/**
 *
 * @author Opiframe
 */
@ManagedBean
@RequestScoped
public class UserBean {

    @PersistenceContext(unitName="WeatherAppPU")
    EntityManager em;
    @Resource
    UserTransaction utx;
    
    private String name;
    
    public UserBean() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public void saveUser(ActionEvent e)
    {
        OpiframeUserJpaController jpa = new OpiframeUserJpaController(utx,em.getEntityManagerFactory());
        OpiframeUser temp = new OpiframeUser();
        temp.setName(this.getName());
        
        try {
            jpa.create(temp);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
