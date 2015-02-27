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
@Table(name = "perk_type")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PerkType.findAll", query = "SELECT p FROM PerkType p"),
    @NamedQuery(name = "PerkType.findByIdperkType", query = "SELECT p FROM PerkType p WHERE p.idperkType = :idperkType"),
    @NamedQuery(name = "PerkType.findByName", query = "SELECT p FROM PerkType p WHERE p.name = :name")})
public class PerkType implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idperk_type")
    private Long idperkType;
    @Size(max = 45)
    @Column(name = "name")
    private String name;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idperkType")
    private List<Perk> perkList;

    public PerkType() {
    }

    public PerkType(Long idperkType) {
        this.idperkType = idperkType;
    }

    public Long getIdperkType() {
        return idperkType;
    }

    public void setIdperkType(Long idperkType) {
        this.idperkType = idperkType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @XmlTransient
    public List<Perk> getPerkList() {
        return perkList;
    }

    public void setPerkList(List<Perk> perkList) {
        this.perkList = perkList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idperkType != null ? idperkType.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PerkType)) {
            return false;
        }
        PerkType other = (PerkType) object;
        if ((this.idperkType == null && other.idperkType != null) || (this.idperkType != null && !this.idperkType.equals(other.idperkType))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.gmp.urcweb.entity.PerkType[ idperkType=" + idperkType + " ]";
    }
    
}
