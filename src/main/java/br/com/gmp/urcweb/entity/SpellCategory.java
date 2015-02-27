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
import javax.persistence.ManyToMany;
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
@Table(name = "spell_category")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SpellCategory.findAll", query = "SELECT s FROM SpellCategory s"),
    @NamedQuery(name = "SpellCategory.findByIdspellCategory", query = "SELECT s FROM SpellCategory s WHERE s.idspellCategory = :idspellCategory"),
    @NamedQuery(name = "SpellCategory.findByName", query = "SELECT s FROM SpellCategory s WHERE s.name = :name")})
public class SpellCategory implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idspell_category")
    private Long idspellCategory;
    @Size(max = 45)
    @Column(name = "name")
    private String name;
    @ManyToMany(mappedBy = "spellCategoryList")
    private List<ClassBase> classBaseList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idspellCategory")
    private List<Spell> spellList;

    public SpellCategory() {
    }

    public SpellCategory(Long idspellCategory) {
        this.idspellCategory = idspellCategory;
    }

    public Long getIdspellCategory() {
        return idspellCategory;
    }

    public void setIdspellCategory(Long idspellCategory) {
        this.idspellCategory = idspellCategory;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @XmlTransient
    public List<ClassBase> getClassBaseList() {
        return classBaseList;
    }

    public void setClassBaseList(List<ClassBase> classBaseList) {
        this.classBaseList = classBaseList;
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
        hash += (idspellCategory != null ? idspellCategory.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SpellCategory)) {
            return false;
        }
        SpellCategory other = (SpellCategory) object;
        if ((this.idspellCategory == null && other.idspellCategory != null) || (this.idspellCategory != null && !this.idspellCategory.equals(other.idspellCategory))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.gmp.urcweb.entity.SpellCategory[ idspellCategory=" + idspellCategory + " ]";
    }
    
}
