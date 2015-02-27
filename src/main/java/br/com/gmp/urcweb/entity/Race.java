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
@Table(name = "race")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Race.findAll", query = "SELECT r FROM Race r"),
    @NamedQuery(name = "Race.findByIdrace", query = "SELECT r FROM Race r WHERE r.idrace = :idrace"),
    @NamedQuery(name = "Race.findByName", query = "SELECT r FROM Race r WHERE r.name = :name"),
    @NamedQuery(name = "Race.findByMinHeight", query = "SELECT r FROM Race r WHERE r.minHeight = :minHeight"),
    @NamedQuery(name = "Race.findByMaxHeight", query = "SELECT r FROM Race r WHERE r.maxHeight = :maxHeight"),
    @NamedQuery(name = "Race.findByMinWeight", query = "SELECT r FROM Race r WHERE r.minWeight = :minWeight"),
    @NamedQuery(name = "Race.findByMaxWeight", query = "SELECT r FROM Race r WHERE r.maxWeight = :maxWeight"),
    @NamedQuery(name = "Race.findByMaturity", query = "SELECT r FROM Race r WHERE r.maturity = :maturity"),
    @NamedQuery(name = "Race.findByMaxAge", query = "SELECT r FROM Race r WHERE r.maxAge = :maxAge")})
public class Race implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idrace")
    private Long idrace;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "name")
    private String name;
    @Column(name = "min_height")
    private Long minHeight;
    @Column(name = "max_height")
    private Long maxHeight;
    @Column(name = "min_weight")
    private Long minWeight;
    @Column(name = "max_weight")
    private Long maxWeight;
    @Column(name = "maturity")
    private Integer maturity;
    @Column(name = "max_age")
    private Integer maxAge;
    @ManyToMany(mappedBy = "raceList")
    private List<AttrModifier> attrModifierList;
    @JoinTable(name = "race_allowed_weapons", joinColumns = {
        @JoinColumn(name = "idrace", referencedColumnName = "idrace")}, inverseJoinColumns = {
        @JoinColumn(name = "idweapon_type", referencedColumnName = "idweapon_type")})
    @ManyToMany
    private List<WeaponType> weaponTypeList;
    @ManyToMany(mappedBy = "raceList")
    private List<ArmorType> armorTypeList;
    @ManyToMany(mappedBy = "raceList")
    private List<Perk> perkList;
    @JoinTable(name = "race_skill", joinColumns = {
        @JoinColumn(name = "idrace", referencedColumnName = "idrace")}, inverseJoinColumns = {
        @JoinColumn(name = "idskill", referencedColumnName = "idskill")})
    @ManyToMany
    private List<Skill> skillList;
    @JoinColumn(name = "idnative_language", referencedColumnName = "idlanguage_type")
    @ManyToOne(optional = false)
    private LanguageType idnativeLanguage;
    @JoinColumn(name = "iddice", referencedColumnName = "iddice")
    @ManyToOne(optional = false)
    private Dice iddice;
    @JoinColumn(name = "idalignment", referencedColumnName = "idalignment")
    @ManyToOne(optional = false)
    private Alignment idalignment;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idrace")
    private List<CharacterSheet> characterSheetList;

    public Race() {
    }

    public Race(Long idrace) {
        this.idrace = idrace;
    }

    public Race(Long idrace, String name) {
        this.idrace = idrace;
        this.name = name;
    }

    public Long getIdrace() {
        return idrace;
    }

    public void setIdrace(Long idrace) {
        this.idrace = idrace;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getMinHeight() {
        return minHeight;
    }

    public void setMinHeight(Long minHeight) {
        this.minHeight = minHeight;
    }

    public Long getMaxHeight() {
        return maxHeight;
    }

    public void setMaxHeight(Long maxHeight) {
        this.maxHeight = maxHeight;
    }

    public Long getMinWeight() {
        return minWeight;
    }

    public void setMinWeight(Long minWeight) {
        this.minWeight = minWeight;
    }

    public Long getMaxWeight() {
        return maxWeight;
    }

    public void setMaxWeight(Long maxWeight) {
        this.maxWeight = maxWeight;
    }

    public Integer getMaturity() {
        return maturity;
    }

    public void setMaturity(Integer maturity) {
        this.maturity = maturity;
    }

    public Integer getMaxAge() {
        return maxAge;
    }

    public void setMaxAge(Integer maxAge) {
        this.maxAge = maxAge;
    }

    @XmlTransient
    public List<AttrModifier> getAttrModifierList() {
        return attrModifierList;
    }

    public void setAttrModifierList(List<AttrModifier> attrModifierList) {
        this.attrModifierList = attrModifierList;
    }

    @XmlTransient
    public List<WeaponType> getWeaponTypeList() {
        return weaponTypeList;
    }

    public void setWeaponTypeList(List<WeaponType> weaponTypeList) {
        this.weaponTypeList = weaponTypeList;
    }

    @XmlTransient
    public List<ArmorType> getArmorTypeList() {
        return armorTypeList;
    }

    public void setArmorTypeList(List<ArmorType> armorTypeList) {
        this.armorTypeList = armorTypeList;
    }

    @XmlTransient
    public List<Perk> getPerkList() {
        return perkList;
    }

    public void setPerkList(List<Perk> perkList) {
        this.perkList = perkList;
    }

    @XmlTransient
    public List<Skill> getSkillList() {
        return skillList;
    }

    public void setSkillList(List<Skill> skillList) {
        this.skillList = skillList;
    }

    public LanguageType getIdnativeLanguage() {
        return idnativeLanguage;
    }

    public void setIdnativeLanguage(LanguageType idnativeLanguage) {
        this.idnativeLanguage = idnativeLanguage;
    }

    public Dice getIddice() {
        return iddice;
    }

    public void setIddice(Dice iddice) {
        this.iddice = iddice;
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
        hash += (idrace != null ? idrace.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Race)) {
            return false;
        }
        Race other = (Race) object;
        if ((this.idrace == null && other.idrace != null) || (this.idrace != null && !this.idrace.equals(other.idrace))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.gmp.urcweb.entity.Race[ idrace=" + idrace + " ]";
    }
    
}
