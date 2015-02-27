/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gmp.urcweb.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author kaciano
 */
@Entity
@Table(name = "spell")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Spell.findAll", query = "SELECT s FROM Spell s"),
    @NamedQuery(name = "Spell.findByIdspell", query = "SELECT s FROM Spell s WHERE s.idspell = :idspell"),
    @NamedQuery(name = "Spell.findByName", query = "SELECT s FROM Spell s WHERE s.name = :name"),
    @NamedQuery(name = "Spell.findByMagicCost", query = "SELECT s FROM Spell s WHERE s.magicCost = :magicCost"),
    @NamedQuery(name = "Spell.findByRange", query = "SELECT s FROM Spell s WHERE s.range = :range"),
    @NamedQuery(name = "Spell.findByDuration", query = "SELECT s FROM Spell s WHERE s.duration = :duration"),
    @NamedQuery(name = "Spell.findByDescription", query = "SELECT s FROM Spell s WHERE s.description = :description")})
public class Spell implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idspell")
    private Long idspell;
    @Size(max = 45)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @NotNull
    @Column(name = "magic_cost")
    private int magicCost;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "range")
    private String range;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "duration")
    private String duration;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 500)
    @Column(name = "description")
    private String description;
    @JoinColumn(name = "idspell_type", referencedColumnName = "idspell_type")
    @ManyToOne(optional = false)
    private SpellType idspellType;
    @JoinColumn(name = "idspell_class", referencedColumnName = "idspell_class")
    @ManyToOne(optional = false)
    private SpellClass idspellClass;
    @JoinColumn(name = "idspell_category", referencedColumnName = "idspell_category")
    @ManyToOne(optional = false)
    private SpellCategory idspellCategory;
    @JoinColumn(name = "idelement_type", referencedColumnName = "idelement_type")
    @ManyToOne(optional = false)
    private ElementType idelementType;

    public Spell() {
    }

    public Spell(Long idspell) {
        this.idspell = idspell;
    }

    public Spell(Long idspell, int magicCost, String range, String duration, String description) {
        this.idspell = idspell;
        this.magicCost = magicCost;
        this.range = range;
        this.duration = duration;
        this.description = description;
    }

    public Long getIdspell() {
        return idspell;
    }

    public void setIdspell(Long idspell) {
        this.idspell = idspell;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMagicCost() {
        return magicCost;
    }

    public void setMagicCost(int magicCost) {
        this.magicCost = magicCost;
    }

    public String getRange() {
        return range;
    }

    public void setRange(String range) {
        this.range = range;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public SpellType getIdspellType() {
        return idspellType;
    }

    public void setIdspellType(SpellType idspellType) {
        this.idspellType = idspellType;
    }

    public SpellClass getIdspellClass() {
        return idspellClass;
    }

    public void setIdspellClass(SpellClass idspellClass) {
        this.idspellClass = idspellClass;
    }

    public SpellCategory getIdspellCategory() {
        return idspellCategory;
    }

    public void setIdspellCategory(SpellCategory idspellCategory) {
        this.idspellCategory = idspellCategory;
    }

    public ElementType getIdelementType() {
        return idelementType;
    }

    public void setIdelementType(ElementType idelementType) {
        this.idelementType = idelementType;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idspell != null ? idspell.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Spell)) {
            return false;
        }
        Spell other = (Spell) object;
        if ((this.idspell == null && other.idspell != null) || (this.idspell != null && !this.idspell.equals(other.idspell))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.gmp.urcweb.entity.Spell[ idspell=" + idspell + " ]";
    }
    
}
