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
@Table(name = "effect_type")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EffectType.findAll", query = "SELECT e FROM EffectType e"),
    @NamedQuery(name = "EffectType.findByIdeffectType", query = "SELECT e FROM EffectType e WHERE e.ideffectType = :ideffectType"),
    @NamedQuery(name = "EffectType.findByName", query = "SELECT e FROM EffectType e WHERE e.name = :name")})
public class EffectType implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ideffect_type")
    private Long ideffectType;
    @Size(max = 45)
    @Column(name = "name")
    private String name;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ideffectType")
    private List<Effect> effectList;

    public EffectType() {
    }

    public EffectType(Long ideffectType) {
        this.ideffectType = ideffectType;
    }

    public Long getIdeffectType() {
        return ideffectType;
    }

    public void setIdeffectType(Long ideffectType) {
        this.ideffectType = ideffectType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @XmlTransient
    public List<Effect> getEffectList() {
        return effectList;
    }

    public void setEffectList(List<Effect> effectList) {
        this.effectList = effectList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ideffectType != null ? ideffectType.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EffectType)) {
            return false;
        }
        EffectType other = (EffectType) object;
        if ((this.ideffectType == null && other.ideffectType != null) || (this.ideffectType != null && !this.ideffectType.equals(other.ideffectType))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.gmp.urcweb.entity.EffectType[ ideffectType=" + ideffectType + " ]";
    }
    
}
