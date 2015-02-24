/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.opijotain.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
@Table(name = "owners")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Owners.findAll", query = "SELECT o FROM Owners o"),
    @NamedQuery(name = "Owners.findByInstance", query = "SELECT o FROM Owners o WHERE o.instance = :instance"),
    @NamedQuery(name = "Owners.findByOwner", query = "SELECT o FROM Owners o WHERE o.owner = :owner")})
public class Owners implements Serializable {
    private static final long serialVersionUID = 1L;
    @Size(max = 255)
    @Column(name = "instance")
    private String instance;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "owner")
    private String owner;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "owners")
    private Weather weather;

    public Owners() {
    }

    public Owners(String owner) {
        this.owner = owner;
    }

    public String getInstance() {
        return instance;
    }

    public void setInstance(String instance) {
        this.instance = instance;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public Weather getWeather() {
        return weather;
    }

    public void setWeather(Weather weather) {
        this.weather = weather;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (owner != null ? owner.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Owners)) {
            return false;
        }
        Owners other = (Owners) object;
        if ((this.owner == null && other.owner != null) || (this.owner != null && !this.owner.equals(other.owner))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.opijotain.entity.Owners[ owner=" + owner + " ]";
    }
    
}
