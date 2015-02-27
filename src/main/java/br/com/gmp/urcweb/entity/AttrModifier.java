/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gmp.urcweb.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
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
@Table(name = "attr_modifier")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AttrModifier.findAll", query = "SELECT a FROM AttrModifier a"),
    @NamedQuery(name = "AttrModifier.findByIdmodifier", query = "SELECT a FROM AttrModifier a WHERE a.idmodifier = :idmodifier"),
    @NamedQuery(name = "AttrModifier.findByValue", query = "SELECT a FROM AttrModifier a WHERE a.value = :value")})
public class AttrModifier implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idmodifier")
    private Long idmodifier;
    @Basic(optional = false)
    @NotNull
    @Column(name = "value")
    private int value;
    @JoinTable(name = "race_attr_modifier", joinColumns = {
        @JoinColumn(name = "idmodifier", referencedColumnName = "idmodifier")}, inverseJoinColumns = {
        @JoinColumn(name = "idrace", referencedColumnName = "idrace")})
    @ManyToMany
    private List<Race> raceList;
    @JoinColumn(name = "idattribute", referencedColumnName = "idattribute")
    @ManyToOne(optional = false)
    private Attribute idattribute;

    public AttrModifier() {
    }

    public AttrModifier(Long idmodifier) {
        this.idmodifier = idmodifier;
    }

    public AttrModifier(Long idmodifier, int value) {
        this.idmodifier = idmodifier;
        this.value = value;
    }

    public Long getIdmodifier() {
        return idmodifier;
    }

    public void setIdmodifier(Long idmodifier) {
        this.idmodifier = idmodifier;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @XmlTransient
    public List<Race> getRaceList() {
        return raceList;
    }

    public void setRaceList(List<Race> raceList) {
        this.raceList = raceList;
    }

    public Attribute getIdattribute() {
        return idattribute;
    }

    public void setIdattribute(Attribute idattribute) {
        this.idattribute = idattribute;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idmodifier != null ? idmodifier.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AttrModifier)) {
            return false;
        }
        AttrModifier other = (AttrModifier) object;
        if ((this.idmodifier == null && other.idmodifier != null) || (this.idmodifier != null && !this.idmodifier.equals(other.idmodifier))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.gmp.urcweb.entity.AttrModifier[ idmodifier=" + idmodifier + " ]";
    }
    
}
