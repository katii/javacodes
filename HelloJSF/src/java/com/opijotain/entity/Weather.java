/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.opijotain.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Ohjelmistokehitys
 */
@Entity
@Table(name = "weather")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Weather.findAll", query = "SELECT w FROM Weather w"),
    @NamedQuery(name = "Weather.findByTemp", query = "SELECT w FROM Weather w WHERE w.temp = :temp"),
    @NamedQuery(name = "Weather.findByInstance", query = "SELECT w FROM Weather w WHERE w.instance = :instance")})
public class Weather implements Serializable {
    private static final long serialVersionUID = 1L;
    @Size(max = 255)
    @Column(name = "temp")
    private String temp;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "instance")
    private String instance;
    @JoinColumn(name = "instance", referencedColumnName = "instance", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Owners owners;

    public Weather() {
    }

    public Weather(String instance) {
        this.instance = instance;
    }

    public String getTemp() {
        return temp;
    }

    public void setTemp(String temp) {
        this.temp = temp;
    }

    public String getInstance() {
        return instance;
    }

    public void setInstance(String instance) {
        this.instance = instance;
    }

    public Owners getOwners() {
        return owners;
    }

    public void setOwners(Owners owners) {
        this.owners = owners;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (instance != null ? instance.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Weather)) {
            return false;
        }
        Weather other = (Weather) object;
        if ((this.instance == null && other.instance != null) || (this.instance != null && !this.instance.equals(other.instance))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.opijotain.entity.Weather[ instance=" + instance + " ]";
    }
    
}
