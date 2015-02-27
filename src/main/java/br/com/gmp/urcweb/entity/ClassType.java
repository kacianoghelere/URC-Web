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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author kaciano
 */
@Entity
@Table(name = "class_type")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ClassType.findAll", query = "SELECT c FROM ClassType c"),
    @NamedQuery(name = "ClassType.findByIdclassType", query = "SELECT c FROM ClassType c WHERE c.idclassType = :idclassType"),
    @NamedQuery(name = "ClassType.findByName", query = "SELECT c FROM ClassType c WHERE c.name = :name"),
    @NamedQuery(name = "ClassType.findByMagic", query = "SELECT c FROM ClassType c WHERE c.magic = :magic"),
    @NamedQuery(name = "ClassType.findByProtection", query = "SELECT c FROM ClassType c WHERE c.protection = :protection")})
public class ClassType implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idclass_type")
    private Long idclassType;
    @Size(max = 45)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @NotNull
    @Column(name = "magic")
    private boolean magic;
    @Basic(optional = false)
    @NotNull
    @Column(name = "protection")
    private int protection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idclassType")
    private List<ClassBase> classBaseList;

    public ClassType() {
    }

    public ClassType(Long idclassType) {
        this.idclassType = idclassType;
    }

    public ClassType(Long idclassType, boolean magic, int protection) {
        this.idclassType = idclassType;
        this.magic = magic;
        this.protection = protection;
    }

    public Long getIdclassType() {
        return idclassType;
    }

    public void setIdclassType(Long idclassType) {
        this.idclassType = idclassType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean getMagic() {
        return magic;
    }

    public void setMagic(boolean magic) {
        this.magic = magic;
    }

    public int getProtection() {
        return protection;
    }

    public void setProtection(int protection) {
        this.protection = protection;
    }

    @XmlTransient
    public List<ClassBase> getClassBaseList() {
        return classBaseList;
    }

    public void setClassBaseList(List<ClassBase> classBaseList) {
        this.classBaseList = classBaseList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idclassType != null ? idclassType.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ClassType)) {
            return false;
        }
        ClassType other = (ClassType) object;
        if ((this.idclassType == null && other.idclassType != null) || (this.idclassType != null && !this.idclassType.equals(other.idclassType))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.gmp.urcweb.entity.ClassType[ idclassType=" + idclassType + " ]";
    }
    
}
