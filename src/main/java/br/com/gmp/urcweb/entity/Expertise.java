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
import javax.persistence.ManyToOne;
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
@Table(name = "expertise")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Expertise.findAll", query = "SELECT e FROM Expertise e"),
    @NamedQuery(name = "Expertise.findByIdexpertise", query = "SELECT e FROM Expertise e WHERE e.idexpertise = :idexpertise"),
    @NamedQuery(name = "Expertise.findByName", query = "SELECT e FROM Expertise e WHERE e.name = :name"),
    @NamedQuery(name = "Expertise.findByModifier", query = "SELECT e FROM Expertise e WHERE e.modifier = :modifier")})
public class Expertise implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idexpertise")
    private Long idexpertise;
    @Size(max = 45)
    @Column(name = "name")
    private String name;
    @Column(name = "modifier")
    private Integer modifier;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idexpertise")
    private List<ClassBase> classBaseList;
    @JoinColumn(name = "idexpertise_type", referencedColumnName = "idexpertise_type")
    @ManyToOne(optional = false)
    private ExpertiseType idexpertiseType;
    @JoinColumn(name = "idattribute", referencedColumnName = "idattribute")
    @ManyToOne(optional = false)
    private Attribute idattribute;

    public Expertise() {
    }

    public Expertise(Long idexpertise) {
        this.idexpertise = idexpertise;
    }

    public Long getIdexpertise() {
        return idexpertise;
    }

    public void setIdexpertise(Long idexpertise) {
        this.idexpertise = idexpertise;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getModifier() {
        return modifier;
    }

    public void setModifier(Integer modifier) {
        this.modifier = modifier;
    }

    @XmlTransient
    public List<ClassBase> getClassBaseList() {
        return classBaseList;
    }

    public void setClassBaseList(List<ClassBase> classBaseList) {
        this.classBaseList = classBaseList;
    }

    public ExpertiseType getIdexpertiseType() {
        return idexpertiseType;
    }

    public void setIdexpertiseType(ExpertiseType idexpertiseType) {
        this.idexpertiseType = idexpertiseType;
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
        hash += (idexpertise != null ? idexpertise.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Expertise)) {
            return false;
        }
        Expertise other = (Expertise) object;
        if ((this.idexpertise == null && other.idexpertise != null) || (this.idexpertise != null && !this.idexpertise.equals(other.idexpertise))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.gmp.urcweb.entity.Expertise[ idexpertise=" + idexpertise + " ]";
    }
    
}
