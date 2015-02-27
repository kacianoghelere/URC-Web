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
@Table(name = "language_type")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "LanguageType.findAll", query = "SELECT l FROM LanguageType l"),
    @NamedQuery(name = "LanguageType.findByIdlanguageType", query = "SELECT l FROM LanguageType l WHERE l.idlanguageType = :idlanguageType"),
    @NamedQuery(name = "LanguageType.findByName", query = "SELECT l FROM LanguageType l WHERE l.name = :name")})
public class LanguageType implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idlanguage_type")
    private Long idlanguageType;
    @Size(max = 45)
    @Column(name = "name")
    private String name;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idnativeLanguage")
    private List<Race> raceList;

    public LanguageType() {
    }

    public LanguageType(Long idlanguageType) {
        this.idlanguageType = idlanguageType;
    }

    public Long getIdlanguageType() {
        return idlanguageType;
    }

    public void setIdlanguageType(Long idlanguageType) {
        this.idlanguageType = idlanguageType;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idlanguageType != null ? idlanguageType.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LanguageType)) {
            return false;
        }
        LanguageType other = (LanguageType) object;
        if ((this.idlanguageType == null && other.idlanguageType != null) || (this.idlanguageType != null && !this.idlanguageType.equals(other.idlanguageType))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.gmp.urcweb.entity.LanguageType[ idlanguageType=" + idlanguageType + " ]";
    }
    
}
