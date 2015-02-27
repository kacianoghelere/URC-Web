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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author kaciano
 */
@Entity
@Table(name = "attribute")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Attribute.findAll", query = "SELECT a FROM Attribute a"),
    @NamedQuery(name = "Attribute.findByIdattribute", query = "SELECT a FROM Attribute a WHERE a.idattribute = :idattribute"),
    @NamedQuery(name = "Attribute.findByName", query = "SELECT a FROM Attribute a WHERE a.name = :name"),
    @NamedQuery(name = "Attribute.findByShortname", query = "SELECT a FROM Attribute a WHERE a.shortname = :shortname")})
public class Attribute implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idattribute")
    private Long idattribute;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "shortname")
    private String shortname;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idattribute")
    private List<AttrModifier> attrModifierList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idkeyAttribute")
    private List<ClassBase> classBaseList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idattribute")
    private List<Expertise> expertiseList;

    public Attribute() {
    }

    public Attribute(Long idattribute) {
        this.idattribute = idattribute;
    }

    public Attribute(Long idattribute, String name, String shortname) {
        this.idattribute = idattribute;
        this.name = name;
        this.shortname = shortname;
    }

    public Long getIdattribute() {
        return idattribute;
    }

    public void setIdattribute(Long idattribute) {
        this.idattribute = idattribute;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getShortname() {
        return shortname;
    }

    public void setShortname(String shortname) {
        this.shortname = shortname;
    }

    @XmlTransient
    public List<AttrModifier> getAttrModifierList() {
        return attrModifierList;
    }

    public void setAttrModifierList(List<AttrModifier> attrModifierList) {
        this.attrModifierList = attrModifierList;
    }

    @XmlTransient
    public List<ClassBase> getClassBaseList() {
        return classBaseList;
    }

    public void setClassBaseList(List<ClassBase> classBaseList) {
        this.classBaseList = classBaseList;
    }

    @XmlTransient
    public List<Expertise> getExpertiseList() {
        return expertiseList;
    }

    public void setExpertiseList(List<Expertise> expertiseList) {
        this.expertiseList = expertiseList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idattribute != null ? idattribute.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Attribute)) {
            return false;
        }
        Attribute other = (Attribute) object;
        if ((this.idattribute == null && other.idattribute != null) || (this.idattribute != null && !this.idattribute.equals(other.idattribute))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.gmp.urcweb.entity.Attribute[ idattribute=" + idattribute + " ]";
    }
    
}
