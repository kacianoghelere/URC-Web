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
@Table(name = "dice")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Dice.findAll", query = "SELECT d FROM Dice d"),
    @NamedQuery(name = "Dice.findByIddice", query = "SELECT d FROM Dice d WHERE d.iddice = :iddice"),
    @NamedQuery(name = "Dice.findByName", query = "SELECT d FROM Dice d WHERE d.name = :name")})
public class Dice implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "iddice")
    private Long iddice;
    @Size(max = 45)
    @Column(name = "name")
    private String name;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "iddice")
    private List<Race> raceList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idlifeDice")
    private List<ClassBase> classBaseList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "iddice")
    private List<Weapon> weaponList;

    public Dice() {
    }

    public Dice(Long iddice) {
        this.iddice = iddice;
    }

    public Long getIddice() {
        return iddice;
    }

    public void setIddice(Long iddice) {
        this.iddice = iddice;
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
        hash += (iddice != null ? iddice.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Dice)) {
            return false;
        }
        Dice other = (Dice) object;
        if ((this.iddice == null && other.iddice != null) || (this.iddice != null && !this.iddice.equals(other.iddice))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.gmp.urcweb.entity.Dice[ iddice=" + iddice + " ]";
    }
    
}
