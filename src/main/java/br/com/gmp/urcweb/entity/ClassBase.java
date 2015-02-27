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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
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
@Table(name = "class_base")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ClassBase.findAll", query = "SELECT c FROM ClassBase c"),
    @NamedQuery(name = "ClassBase.findByIdclassBase", query = "SELECT c FROM ClassBase c WHERE c.idclassBase = :idclassBase"),
    @NamedQuery(name = "ClassBase.findByName", query = "SELECT c FROM ClassBase c WHERE c.name = :name"),
    @NamedQuery(name = "ClassBase.findByArmorBonus", query = "SELECT c FROM ClassBase c WHERE c.armorBonus = :armorBonus"),
    @NamedQuery(name = "ClassBase.findByDescription", query = "SELECT c FROM ClassBase c WHERE c.description = :description")})
public class ClassBase implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idclass_base")
    private Long idclassBase;
    @Size(max = 45)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @NotNull
    @Column(name = "armor_bonus")
    private int armorBonus;
    @Size(max = 500)
    @Column(name = "description")
    private String description;
    @JoinTable(name = "class_base_level", joinColumns = {
        @JoinColumn(name = "idclass_base", referencedColumnName = "idclass_base")}, inverseJoinColumns = {
        @JoinColumn(name = "idclass_level", referencedColumnName = "idclass_level")})
    @ManyToMany
    private List<ClassLevel> classLevelList;
    @JoinTable(name = "class_base_spell_category", joinColumns = {
        @JoinColumn(name = "idclass_base", referencedColumnName = "idclass_base")}, inverseJoinColumns = {
        @JoinColumn(name = "idspell_category", referencedColumnName = "idspell_category")})
    @ManyToMany
    private List<SpellCategory> spellCategoryList;
    @ManyToMany(mappedBy = "classBaseList")
    private List<ArmorType> armorTypeList;
    @JoinTable(name = "class_base_weapon", joinColumns = {
        @JoinColumn(name = "idclass_base", referencedColumnName = "idclass_base")}, inverseJoinColumns = {
        @JoinColumn(name = "idweapon_type", referencedColumnName = "idweapon_type")})
    @ManyToMany
    private List<WeaponType> weaponTypeList;
    @JoinTable(name = "class_base_item_type", joinColumns = {
        @JoinColumn(name = "idclass_base", referencedColumnName = "idclass_base")}, inverseJoinColumns = {
        @JoinColumn(name = "iditem_type", referencedColumnName = "iditem_type")})
    @ManyToMany
    private List<ItemType> itemTypeList;
    @JoinColumn(name = "idrequirement", referencedColumnName = "idrequirement")
    @ManyToOne(optional = false)
    private Requirement idrequirement;
    @JoinColumn(name = "idperk", referencedColumnName = "idperk")
    @ManyToOne(optional = false)
    private Perk idperk;
    @JoinColumn(name = "idexpertise", referencedColumnName = "idexpertise")
    @ManyToOne(optional = false)
    private Expertise idexpertise;
    @JoinColumn(name = "idlife_dice", referencedColumnName = "iddice")
    @ManyToOne(optional = false)
    private Dice idlifeDice;
    @JoinColumn(name = "idclass_type", referencedColumnName = "idclass_type")
    @ManyToOne(optional = false)
    private ClassType idclassType;
    @JoinColumn(name = "idkey_attribute", referencedColumnName = "idattribute")
    @ManyToOne(optional = false)
    private Attribute idkeyAttribute;
    @JoinColumn(name = "idalignment", referencedColumnName = "idalignment")
    @ManyToOne(optional = false)
    private Alignment idalignment;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idclassBase")
    private List<CharacterSheet> characterSheetList;

    public ClassBase() {
    }

    public ClassBase(Long idclassBase) {
        this.idclassBase = idclassBase;
    }

    public ClassBase(Long idclassBase, int armorBonus) {
        this.idclassBase = idclassBase;
        this.armorBonus = armorBonus;
    }

    public Long getIdclassBase() {
        return idclassBase;
    }

    public void setIdclassBase(Long idclassBase) {
        this.idclassBase = idclassBase;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getArmorBonus() {
        return armorBonus;
    }

    public void setArmorBonus(int armorBonus) {
        this.armorBonus = armorBonus;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @XmlTransient
    public List<ClassLevel> getClassLevelList() {
        return classLevelList;
    }

    public void setClassLevelList(List<ClassLevel> classLevelList) {
        this.classLevelList = classLevelList;
    }

    @XmlTransient
    public List<SpellCategory> getSpellCategoryList() {
        return spellCategoryList;
    }

    public void setSpellCategoryList(List<SpellCategory> spellCategoryList) {
        this.spellCategoryList = spellCategoryList;
    }

    @XmlTransient
    public List<ArmorType> getArmorTypeList() {
        return armorTypeList;
    }

    public void setArmorTypeList(List<ArmorType> armorTypeList) {
        this.armorTypeList = armorTypeList;
    }

    @XmlTransient
    public List<WeaponType> getWeaponTypeList() {
        return weaponTypeList;
    }

    public void setWeaponTypeList(List<WeaponType> weaponTypeList) {
        this.weaponTypeList = weaponTypeList;
    }

    @XmlTransient
    public List<ItemType> getItemTypeList() {
        return itemTypeList;
    }

    public void setItemTypeList(List<ItemType> itemTypeList) {
        this.itemTypeList = itemTypeList;
    }

    public Requirement getIdrequirement() {
        return idrequirement;
    }

    public void setIdrequirement(Requirement idrequirement) {
        this.idrequirement = idrequirement;
    }

    public Perk getIdperk() {
        return idperk;
    }

    public void setIdperk(Perk idperk) {
        this.idperk = idperk;
    }

    public Expertise getIdexpertise() {
        return idexpertise;
    }

    public void setIdexpertise(Expertise idexpertise) {
        this.idexpertise = idexpertise;
    }

    public Dice getIdlifeDice() {
        return idlifeDice;
    }

    public void setIdlifeDice(Dice idlifeDice) {
        this.idlifeDice = idlifeDice;
    }

    public ClassType getIdclassType() {
        return idclassType;
    }

    public void setIdclassType(ClassType idclassType) {
        this.idclassType = idclassType;
    }

    public Attribute getIdkeyAttribute() {
        return idkeyAttribute;
    }

    public void setIdkeyAttribute(Attribute idkeyAttribute) {
        this.idkeyAttribute = idkeyAttribute;
    }

    public Alignment getIdalignment() {
        return idalignment;
    }

    public void setIdalignment(Alignment idalignment) {
        this.idalignment = idalignment;
    }

    @XmlTransient
    public List<CharacterSheet> getCharacterSheetList() {
        return characterSheetList;
    }

    public void setCharacterSheetList(List<CharacterSheet> characterSheetList) {
        this.characterSheetList = characterSheetList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idclassBase != null ? idclassBase.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ClassBase)) {
            return false;
        }
        ClassBase other = (ClassBase) object;
        if ((this.idclassBase == null && other.idclassBase != null) || (this.idclassBase != null && !this.idclassBase.equals(other.idclassBase))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.gmp.urcweb.entity.ClassBase[ idclassBase=" + idclassBase + " ]";
    }
    
}
