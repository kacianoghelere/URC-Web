/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gmp.urcweb.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author kaciano
 */
@Entity
@Table(name = "origin")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Origin.findAll", query = "SELECT o FROM Origin o"),
    @NamedQuery(name = "Origin.findByIdorigin", query = "SELECT o FROM Origin o WHERE o.idorigin = :idorigin"),
    @NamedQuery(name = "Origin.findByName", query = "SELECT o FROM Origin o WHERE o.name = :name"),
    @NamedQuery(name = "Origin.findByVariation", query = "SELECT o FROM Origin o WHERE o.variation = :variation"),
    @NamedQuery(name = "Origin.findByBonus", query = "SELECT o FROM Origin o WHERE o.bonus = :bonus")})
public class Origin implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idorigin")
    private Long idorigin;
    @Size(max = 45)
    @Column(name = "name")
    private String name;
    @Size(max = 45)
    @Column(name = "variation")
    private String variation;
    @Column(name = "bonus")
    private Integer bonus;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idorigin")
    private List<Armor> armorList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "originIdorigin")
    private List<Weapon> weaponList;

    public Origin() {
    }

    public Origin(Long idorigin) {
        this.idorigin = idorigin;
    }

    public Long getIdorigin() {
        return idorigin;
    }

    public void setIdorigin(Long idorigin) {
        this.idorigin = idorigin;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVariation() {
        return variation;
    }

    public void setVariation(String variation) {
        this.variation = variation;
    }

    public Integer getBonus() {
        return bonus;
    }

    public void setBonus(Integer bonus) {
        this.bonus = bonus;
    }

    @XmlTransient
    public List<Armor> getArmorList() {
        return armorList;
    }

    public void setArmorList(List<Armor> armorList) {
        this.armorList = armorList;
    }

    @XmlTransient
    public List<Weapon> getWeaponList() {
        return weaponList;
    }

    public void setWeaponList(List<Weapon> weaponList) {
        this.weaponList = weaponList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idorigin != null ? idorigin.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Origin)) {
            return false;
        }
        Origin other = (Origin) object;
        if ((this.idorigin == null && other.idorigin != null) || (this.idorigin != null && !this.idorigin.equals(other.idorigin))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.gmp.urcweb.entity.Origin[ idorigin=" + idorigin + " ]";
    }
    
}
