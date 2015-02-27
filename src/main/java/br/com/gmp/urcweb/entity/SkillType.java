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
@Table(name = "skill_type")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SkillType.findAll", query = "SELECT s FROM SkillType s"),
    @NamedQuery(name = "SkillType.findByIdskillType", query = "SELECT s FROM SkillType s WHERE s.idskillType = :idskillType"),
    @NamedQuery(name = "SkillType.findByName", query = "SELECT s FROM SkillType s WHERE s.name = :name")})
public class SkillType implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idskill_type")
    private Long idskillType;
    @Size(max = 45)
    @Column(name = "name")
    private String name;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idskillType")
    private List<Skill> skillList;

    public SkillType() {
    }

    public SkillType(Long idskillType) {
        this.idskillType = idskillType;
    }

    public Long getIdskillType() {
        return idskillType;
    }

    public void setIdskillType(Long idskillType) {
        this.idskillType = idskillType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
        hash += (idskillType != null ? idskillType.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SkillType)) {
            return false;
        }
        SkillType other = (SkillType) object;
        if ((this.idskillType == null && other.idskillType != null) || (this.idskillType != null && !this.idskillType.equals(other.idskillType))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.gmp.urcweb.entity.SkillType[ idskillType=" + idskillType + " ]";
    }
    
}
