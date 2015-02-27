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
@Table(name = "requirement")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Requirement.findAll", query = "SELECT r FROM Requirement r"),
    @NamedQuery(name = "Requirement.findByIdrequirement", query = "SELECT r FROM Requirement r WHERE r.idrequirement = :idrequirement"),
    @NamedQuery(name = "Requirement.findByStrength", query = "SELECT r FROM Requirement r WHERE r.strength = :strength"),
    @NamedQuery(name = "Requirement.findByDexterity", query = "SELECT r FROM Requirement r WHERE r.dexterity = :dexterity"),
    @NamedQuery(name = "Requirement.findByConstitution", query = "SELECT r FROM Requirement r WHERE r.constitution = :constitution"),
    @NamedQuery(name = "Requirement.findByIntelligence", query = "SELECT r FROM Requirement r WHERE r.intelligence = :intelligence"),
    @NamedQuery(name = "Requirement.findByWisdom", query = "SELECT r FROM Requirement r WHERE r.wisdom = :wisdom"),
    @NamedQuery(name = "Requirement.findByCharisma", query = "SELECT r FROM Requirement r WHERE r.charisma = :charisma")})
public class Requirement implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idrequirement")
    private Long idrequirement;
    @Size(max = 45)
    @Column(name = "strength")
    private String strength;
    @Size(max = 45)
    @Column(name = "dexterity")
    private String dexterity;
    @Size(max = 45)
    @Column(name = "constitution")
    private String constitution;
    @Size(max = 45)
    @Column(name = "intelligence")
    private String intelligence;
    @Size(max = 45)
    @Column(name = "wisdom")
    private String wisdom;
    @Size(max = 45)
    @Column(name = "charisma")
    private String charisma;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idrequirement")
    private List<ClassBase> classBaseList;

    public Requirement() {
    }

    public Requirement(Long idrequirement) {
        this.idrequirement = idrequirement;
    }

    public Long getIdrequirement() {
        return idrequirement;
    }

    public void setIdrequirement(Long idrequirement) {
        this.idrequirement = idrequirement;
    }

    public String getStrength() {
        return strength;
    }

    public void setStrength(String strength) {
        this.strength = strength;
    }

    public String getDexterity() {
        return dexterity;
    }

    public void setDexterity(String dexterity) {
        this.dexterity = dexterity;
    }

    public String getConstitution() {
        return constitution;
    }

    public void setConstitution(String constitution) {
        this.constitution = constitution;
    }

    public String getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(String intelligence) {
        this.intelligence = intelligence;
    }

    public String getWisdom() {
        return wisdom;
    }

    public void setWisdom(String wisdom) {
        this.wisdom = wisdom;
    }

    public String getCharisma() {
        return charisma;
    }

    public void setCharisma(String charisma) {
        this.charisma = charisma;
    }

    @XmlTransient
    public List<ClassBase> getClassBaseList() {
        return classBaseList;
    }

    public void setClassBaseList(List<ClassBase> classBaseList) {
        this.classBaseList = classBaseList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idrequirement != null ? idrequirement.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Requirement)) {
            return false;
        }
        Requirement other = (Requirement) object;
        if ((this.idrequirement == null && other.idrequirement != null) || (this.idrequirement != null && !this.idrequirement.equals(other.idrequirement))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.gmp.urcweb.entity.Requirement[ idrequirement=" + idrequirement + " ]";
    }
    
}
