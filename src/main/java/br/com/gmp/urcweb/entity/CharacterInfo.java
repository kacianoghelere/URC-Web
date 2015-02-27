/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gmp.urcweb.entity;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author kaciano
 */
@Entity
@Table(name = "character_info")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CharacterInfo.findAll", query = "SELECT c FROM CharacterInfo c"),
    @NamedQuery(name = "CharacterInfo.findByIdcharacterInfo", query = "SELECT c FROM CharacterInfo c WHERE c.idcharacterInfo = :idcharacterInfo"),
    @NamedQuery(name = "CharacterInfo.findByCurrentLevel", query = "SELECT c FROM CharacterInfo c WHERE c.currentLevel = :currentLevel"),
    @NamedQuery(name = "CharacterInfo.findByCurrentExp", query = "SELECT c FROM CharacterInfo c WHERE c.currentExp = :currentExp"),
    @NamedQuery(name = "CharacterInfo.findByIdactive", query = "SELECT c FROM CharacterInfo c WHERE c.idactive = :idactive"),
    @NamedQuery(name = "CharacterInfo.findByIncDate", query = "SELECT c FROM CharacterInfo c WHERE c.incDate = :incDate")})
public class CharacterInfo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idcharacter_info")
    private Long idcharacterInfo;
    @Column(name = "current_level")
    private Integer currentLevel;
    @Column(name = "current_exp")
    private Integer currentExp;
    @Basic(optional = false)
    @NotNull
    @Column(name = "idactive")
    private boolean idactive;
    @Basic(optional = false)
    @NotNull
    @Column(name = "inc_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date incDate;
    @JoinColumn(name = "idcharacter", referencedColumnName = "idcharacter")
    @ManyToOne(optional = false)
    private CharacterSheet idcharacter;
    @JoinColumn(name = "idalignment", referencedColumnName = "idalignment")
    @ManyToOne(optional = false)
    private Alignment idalignment;

    public CharacterInfo() {
    }

    public CharacterInfo(Long idcharacterInfo) {
        this.idcharacterInfo = idcharacterInfo;
    }

    public CharacterInfo(Long idcharacterInfo, boolean idactive, Date incDate) {
        this.idcharacterInfo = idcharacterInfo;
        this.idactive = idactive;
        this.incDate = incDate;
    }

    public Long getIdcharacterInfo() {
        return idcharacterInfo;
    }

    public void setIdcharacterInfo(Long idcharacterInfo) {
        this.idcharacterInfo = idcharacterInfo;
    }

    public Integer getCurrentLevel() {
        return currentLevel;
    }

    public void setCurrentLevel(Integer currentLevel) {
        this.currentLevel = currentLevel;
    }

    public Integer getCurrentExp() {
        return currentExp;
    }

    public void setCurrentExp(Integer currentExp) {
        this.currentExp = currentExp;
    }

    public boolean getIdactive() {
        return idactive;
    }

    public void setIdactive(boolean idactive) {
        this.idactive = idactive;
    }

    public Date getIncDate() {
        return incDate;
    }

    public void setIncDate(Date incDate) {
        this.incDate = incDate;
    }

    public CharacterSheet getIdcharacter() {
        return idcharacter;
    }

    public void setIdcharacter(CharacterSheet idcharacter) {
        this.idcharacter = idcharacter;
    }

    public Alignment getIdalignment() {
        return idalignment;
    }

    public void setIdalignment(Alignment idalignment) {
        this.idalignment = idalignment;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idcharacterInfo != null ? idcharacterInfo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CharacterInfo)) {
            return false;
        }
        CharacterInfo other = (CharacterInfo) object;
        if ((this.idcharacterInfo == null && other.idcharacterInfo != null) || (this.idcharacterInfo != null && !this.idcharacterInfo.equals(other.idcharacterInfo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.gmp.urcweb.entity.CharacterInfo[ idcharacterInfo=" + idcharacterInfo + " ]";
    }
    
}
