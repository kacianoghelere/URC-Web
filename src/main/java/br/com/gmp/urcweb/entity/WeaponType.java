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
import javax.persistence.ManyToMany;
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
@Table(name = "weapon_type")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "WeaponType.findAll", query = "SELECT w FROM WeaponType w"),
    @NamedQuery(name = "WeaponType.findByIdweaponType", query = "SELECT w FROM WeaponType w WHERE w.idweaponType = :idweaponType"),
    @NamedQuery(name = "WeaponType.findByName", query = "SELECT w FROM WeaponType w WHERE w.name = :name")})
public class WeaponType implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idweapon_type")
    private Long idweaponType;
    @Size(max = 45)
    @Column(name = "name")
    private String name;
    @ManyToMany(mappedBy = "weaponTypeList")
    private List<Race> raceList;
    @ManyToMany(mappedBy = "weaponTypeList")
    private List<ClassBase> classBaseList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idweaponType")
    private List<Weapon> weaponList;

    public WeaponType() {
    }

    public WeaponType(Long idweaponType) {
        this.idweaponType = idweaponType;
    }

    public Long getIdweaponType() {
        return idweaponType;
    }

    public void setIdweaponType(Long idweaponType) {
        this.idweaponType = idweaponType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @XmlTransient
    public List<Race> getRaceList() {
        return raceList;
    }

    public void setRaceList(List<Race> raceList) {
        this.raceList = raceList;
    }

    @XmlTransient
    public List<ClassBase> getClassBaseList() {
        return classBaseList;
    }

    public void setClassBaseList(List<ClassBase> classBaseList) {
        this.classBaseList = classBaseList;
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
        hash += (idweaponType != null ? idweaponType.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof WeaponType)) {
            return false;
        }
        WeaponType other = (WeaponType) object;
        if ((this.idweaponType == null && other.idweaponType != null) || (this.idweaponType != null && !this.idweaponType.equals(other.idweaponType))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.gmp.urcweb.entity.WeaponType[ idweaponType=" + idweaponType + " ]";
    }
    
}
