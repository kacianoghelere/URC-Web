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
@Table(name = "alignment")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Alignment.findAll", query = "SELECT a FROM Alignment a"),
    @NamedQuery(name = "Alignment.findByIdalignment", query = "SELECT a FROM Alignment a WHERE a.idalignment = :idalignment"),
    @NamedQuery(name = "Alignment.findByName", query = "SELECT a FROM Alignment a WHERE a.name = :name")})
public class Alignment implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idalignment")
    private Long idalignment;
    @Size(max = 15)
    @Column(name = "name")
    private String name;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idalignment")
    private List<Armor> armorList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idalignment")
    private List<Race> raceList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idalignment")
    private List<ClassBase> classBaseList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idalignment")
    private List<Weapon> weaponList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idalignment")
    private List<CharacterInfo> characterInfoList;

    public Alignment() {
    }

    public Alignment(Long idalignment) {
        this.idalignment = idalignment;
    }

    public Long getIdalignment() {
        return idalignment;
    }

    public void setIdalignment(Long idalignment) {
        this.idalignment = idalignment;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @XmlTransient
    public List<Armor> getArmorList() {
        return armorList;
    }

    public void setArmorList(List<Armor> armorList) {
        this.armorList = armorList;
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

    @XmlTransient
    public List<CharacterInfo> getCharacterInfoList() {
        return characterInfoList;
    }

    public void setCharacterInfoList(List<CharacterInfo> characterInfoList) {
        this.characterInfoList = characterInfoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idalignment != null ? idalignment.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Alignment)) {
            return false;
        }
        Alignment other = (Alignment) object;
        if ((this.idalignment == null && other.idalignment != null) || (this.idalignment != null && !this.idalignment.equals(other.idalignment))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.gmp.urcweb.entity.Alignment[ idalignment=" + idalignment + " ]";
    }
    
}
