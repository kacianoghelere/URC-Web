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
@Table(name = "effect")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Effect.findAll", query = "SELECT e FROM Effect e"),
    @NamedQuery(name = "Effect.findByIdeffect", query = "SELECT e FROM Effect e WHERE e.ideffect = :ideffect"),
    @NamedQuery(name = "Effect.findByName", query = "SELECT e FROM Effect e WHERE e.name = :name"),
    @NamedQuery(name = "Effect.findByDescription", query = "SELECT e FROM Effect e WHERE e.description = :description")})
public class Effect implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ideffect")
    private Long ideffect;
    @Size(max = 45)
    @Column(name = "name")
    private String name;
    @Size(max = 500)
    @Column(name = "description")
    private String description;
    @JoinColumn(name = "ideffect_type", referencedColumnName = "ideffect_type")
    @ManyToOne(optional = false)
    private EffectType ideffectType;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ideffect")
    private List<Skill> skillList;

    public Effect() {
    }

    public Effect(Long ideffect) {
        this.ideffect = ideffect;
    }

    public Long getIdeffect() {
        return ideffect;
    }

    public void setIdeffect(Long ideffect) {
        this.ideffect = ideffect;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public EffectType getIdeffectType() {
        return ideffectType;
    }

    public void setIdeffectType(EffectType ideffectType) {
        this.ideffectType = ideffectType;
    }

    @XmlTransient
    public List<Skill> getSkillList() {
        return skillList;
    }

    public void setSkillList(List<Skill> skillList) {
        this.skillList = skillList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ideffect != null ? ideffect.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Effect)) {
            return false;
        }
        Effect other = (Effect) object;
        if ((this.ideffect == null && other.ideffect != null) || (this.ideffect != null && !this.ideffect.equals(other.ideffect))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.gmp.urcweb.entity.Effect[ ideffect=" + ideffect + " ]";
    }
    
}
