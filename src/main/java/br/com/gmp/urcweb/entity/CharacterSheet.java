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
@Table(name = "character_sheet")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CharacterSheet.findAll", query = "SELECT c FROM CharacterSheet c"),
    @NamedQuery(name = "CharacterSheet.findByIdcharacter", query = "SELECT c FROM CharacterSheet c WHERE c.idcharacter = :idcharacter"),
    @NamedQuery(name = "CharacterSheet.findByName", query = "SELECT c FROM CharacterSheet c WHERE c.name = :name"),
    @NamedQuery(name = "CharacterSheet.findByWeight", query = "SELECT c FROM CharacterSheet c WHERE c.weight = :weight"),
    @NamedQuery(name = "CharacterSheet.findByHeight", query = "SELECT c FROM CharacterSheet c WHERE c.height = :height"),
    @NamedQuery(name = "CharacterSheet.findByAge", query = "SELECT c FROM CharacterSheet c WHERE c.age = :age")})
public class CharacterSheet implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idcharacter")
    private Long idcharacter;
    @Size(max = 45)
    @Column(name = "name")
    private String name;
    @Column(name = "weight")
    private Long weight;
    @Column(name = "height")
    private Long height;
    @Column(name = "age")
    private Integer age;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idcharacter")
    private List<CharacterInfo> characterInfoList;
    @JoinColumn(name = "iduser_owner", referencedColumnName = "iduser")
    @ManyToOne(optional = false)
    private SystemUser iduserOwner;
    @JoinColumn(name = "idrace", referencedColumnName = "idrace")
    @ManyToOne(optional = false)
    private Race idrace;
    @JoinColumn(name = "idclass_base", referencedColumnName = "idclass_base")
    @ManyToOne(optional = false)
    private ClassBase idclassBase;

    public CharacterSheet() {
    }

    public CharacterSheet(Long idcharacter) {
        this.idcharacter = idcharacter;
    }

    public Long getIdcharacter() {
        return idcharacter;
    }

    public void setIdcharacter(Long idcharacter) {
        this.idcharacter = idcharacter;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getWeight() {
        return weight;
    }

    public void setWeight(Long weight) {
        this.weight = weight;
    }

    public Long getHeight() {
        return height;
    }

    public void setHeight(Long height) {
        this.height = height;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @XmlTransient
    public List<CharacterInfo> getCharacterInfoList() {
        return characterInfoList;
    }

    public void setCharacterInfoList(List<CharacterInfo> characterInfoList) {
        this.characterInfoList = characterInfoList;
    }

    public SystemUser getIduserOwner() {
        return iduserOwner;
    }

    public void setIduserOwner(SystemUser iduserOwner) {
        this.iduserOwner = iduserOwner;
    }

    public Race getIdrace() {
        return idrace;
    }

    public void setIdrace(Race idrace) {
        this.idrace = idrace;
    }

    public ClassBase getIdclassBase() {
        return idclassBase;
    }

    public void setIdclassBase(ClassBase idclassBase) {
        this.idclassBase = idclassBase;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idcharacter != null ? idcharacter.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CharacterSheet)) {
            return false;
        }
        CharacterSheet other = (CharacterSheet) object;
        if ((this.idcharacter == null && other.idcharacter != null) || (this.idcharacter != null && !this.idcharacter.equals(other.idcharacter))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.gmp.urcweb.entity.CharacterSheet[ idcharacter=" + idcharacter + " ]";
    }
    
}
