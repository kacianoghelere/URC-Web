/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gmp.urcweb.entity;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author kaciano
 */
@Entity
@Table(name = "class_level")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ClassLevel.findAll", query = "SELECT c FROM ClassLevel c"),
    @NamedQuery(name = "ClassLevel.findByIdclassLevel", query = "SELECT c FROM ClassLevel c WHERE c.idclassLevel = :idclassLevel"),
    @NamedQuery(name = "ClassLevel.findByExp", query = "SELECT c FROM ClassLevel c WHERE c.exp = :exp"),
    @NamedQuery(name = "ClassLevel.findByLifeAmount", query = "SELECT c FROM ClassLevel c WHERE c.lifeAmount = :lifeAmount"),
    @NamedQuery(name = "ClassLevel.findByHasPlusLife", query = "SELECT c FROM ClassLevel c WHERE c.hasPlusLife = :hasPlusLife"),
    @NamedQuery(name = "ClassLevel.findByAttackBase", query = "SELECT c FROM ClassLevel c WHERE c.attackBase = :attackBase"),
    @NamedQuery(name = "ClassLevel.findByProtection", query = "SELECT c FROM ClassLevel c WHERE c.protection = :protection")})
public class ClassLevel implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idclass_level")
    private Long idclassLevel;
    @Column(name = "exp")
    private BigInteger exp;
    @Column(name = "life_amount")
    private Integer lifeAmount;
    @Basic(optional = false)
    @NotNull
    @Column(name = "has_plus_life")
    private boolean hasPlusLife;
    @Basic(optional = false)
    @NotNull
    @Column(name = "attack_base")
    private int attackBase;
    @Basic(optional = false)
    @NotNull
    @Column(name = "protection")
    private int protection;
    @ManyToMany(mappedBy = "classLevelList")
    private List<ClassBase> classBaseList;

    public ClassLevel() {
    }

    public ClassLevel(Long idclassLevel) {
        this.idclassLevel = idclassLevel;
    }

    public ClassLevel(Long idclassLevel, boolean hasPlusLife, int attackBase, int protection) {
        this.idclassLevel = idclassLevel;
        this.hasPlusLife = hasPlusLife;
        this.attackBase = attackBase;
        this.protection = protection;
    }

    public Long getIdclassLevel() {
        return idclassLevel;
    }

    public void setIdclassLevel(Long idclassLevel) {
        this.idclassLevel = idclassLevel;
    }

    public BigInteger getExp() {
        return exp;
    }

    public void setExp(BigInteger exp) {
        this.exp = exp;
    }

    public Integer getLifeAmount() {
        return lifeAmount;
    }

    public void setLifeAmount(Integer lifeAmount) {
        this.lifeAmount = lifeAmount;
    }

    public boolean getHasPlusLife() {
        return hasPlusLife;
    }

    public void setHasPlusLife(boolean hasPlusLife) {
        this.hasPlusLife = hasPlusLife;
    }

    public int getAttackBase() {
        return attackBase;
    }

    public void setAttackBase(int attackBase) {
        this.attackBase = attackBase;
    }

    public int getProtection() {
        return protection;
    }

    public void setProtection(int protection) {
        this.protection = protection;
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
        hash += (idclassLevel != null ? idclassLevel.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ClassLevel)) {
            return false;
        }
        ClassLevel other = (ClassLevel) object;
        if ((this.idclassLevel == null && other.idclassLevel != null) || (this.idclassLevel != null && !this.idclassLevel.equals(other.idclassLevel))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.gmp.urcweb.entity.ClassLevel[ idclassLevel=" + idclassLevel + " ]";
    }
    
}
