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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
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
@Table(name = "armor_type")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ArmorType.findAll", query = "SELECT a FROM ArmorType a"),
    @NamedQuery(name = "ArmorType.findByIdarmorType", query = "SELECT a FROM ArmorType a WHERE a.idarmorType = :idarmorType"),
    @NamedQuery(name = "ArmorType.findByName", query = "SELECT a FROM ArmorType a WHERE a.name = :name")})
public class ArmorType implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idarmor_type")
    private Long idarmorType;
    @Size(max = 45)
    @Column(name = "name")
    private String name;
    @JoinTable(name = "race_allowed_armors", joinColumns = {
        @JoinColumn(name = "idarmor_type", referencedColumnName = "idarmor_type")}, inverseJoinColumns = {
        @JoinColumn(name = "idrace", referencedColumnName = "idrace")})
    @ManyToMany
    private List<Race> raceList;
    @JoinTable(name = "class_base_armor_type", joinColumns = {
        @JoinColumn(name = "idarmor_type", referencedColumnName = "idarmor_type")}, inverseJoinColumns = {
        @JoinColumn(name = "idclass_base", referencedColumnName = "idclass_base")})
    @ManyToMany
    private List<ClassBase> classBaseList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idarmorType")
    private List<Armor> armorList;

    public ArmorType() {
    }

    public ArmorType(Long idarmorType) {
        this.idarmorType = idarmorType;
    }

    public Long getIdarmorType() {
        return idarmorType;
    }

    public void setIdarmorType(Long idarmorType) {
        this.idarmorType = idarmorType;
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
    public List<Armor> getArmorList() {
        return armorList;
    }

    public void setArmorList(List<Armor> armorList) {
        this.armorList = armorList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idarmorType != null ? idarmorType.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ArmorType)) {
            return false;
        }
        ArmorType other = (ArmorType) object;
        if ((this.idarmorType == null && other.idarmorType != null) || (this.idarmorType != null && !this.idarmorType.equals(other.idarmorType))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.gmp.urcweb.entity.ArmorType[ idarmorType=" + idarmorType + " ]";
    }
    
}
