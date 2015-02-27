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
@Table(name = "spell_class")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SpellClass.findAll", query = "SELECT s FROM SpellClass s"),
    @NamedQuery(name = "SpellClass.findByIdspellClass", query = "SELECT s FROM SpellClass s WHERE s.idspellClass = :idspellClass"),
    @NamedQuery(name = "SpellClass.findByName", query = "SELECT s FROM SpellClass s WHERE s.name = :name")})
public class SpellClass implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idspell_class")
    private Long idspellClass;
    @Size(max = 45)
    @Column(name = "name")
    private String name;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idspellClass")
    private List<Spell> spellList;

    public SpellClass() {
    }

    public SpellClass(Long idspellClass) {
        this.idspellClass = idspellClass;
    }

    public Long getIdspellClass() {
        return idspellClass;
    }

    public void setIdspellClass(Long idspellClass) {
        this.idspellClass = idspellClass;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @XmlTransient
    public List<Spell> getSpellList() {
        return spellList;
    }

    public void setSpellList(List<Spell> spellList) {
        this.spellList = spellList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idspellClass != null ? idspellClass.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SpellClass)) {
            return false;
        }
        SpellClass other = (SpellClass) object;
        if ((this.idspellClass == null && other.idspellClass != null) || (this.idspellClass != null && !this.idspellClass.equals(other.idspellClass))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.gmp.urcweb.entity.SpellClass[ idspellClass=" + idspellClass + " ]";
    }
    
}
