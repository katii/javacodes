/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.opijotain.beans;

import javax.annotation.Resource;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.UserTransaction;

/**
 *
 * @author Ohjelmistokehitys
 */
@ManagedBean
@RequestScoped
public class userBean {
    
    @PersistenceContext
    EntityManager emf;
    @Resource
    UserTransaction utx;
    
    private String name;

    /**
     * Creates a new instance of userBean
     */
    public userBean() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public void saveUser()
    {
        OwnersJpaController jpa = new opiframeUserJpaController(utx,emf.getEntityManagerFactory());
        opiframeUser temp = new opiframeUser();
        temp.setUser(this.getName());
        
        try{
            jpa.create(name);
        }catch{
            ex.printStackTrace();
        }
    }
}
