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
@Table(name = "menu")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Menu.findAll", query = "SELECT m FROM Menu m"),
    @NamedQuery(name = "Menu.findByIdmenu", query = "SELECT m FROM Menu m WHERE m.idmenu = :idmenu"),
    @NamedQuery(name = "Menu.findByTitle", query = "SELECT m FROM Menu m WHERE m.title = :title"),
    @NamedQuery(name = "Menu.findByIdparentMenu", query = "SELECT m FROM Menu m WHERE m.idparentMenu = :idparentMenu"),
    @NamedQuery(name = "Menu.findByAdminOnly", query = "SELECT m FROM Menu m WHERE m.adminOnly = :adminOnly"),
    @NamedQuery(name = "Menu.findByIcon", query = "SELECT m FROM Menu m WHERE m.icon = :icon")})
public class Menu implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idmenu")
    private Long idmenu;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "title")
    private String title;
    @Basic(optional = false)
    @NotNull
    @Column(name = "idparent_menu")
    private long idparentMenu;
    @Basic(optional = false)
    @NotNull
    @Column(name = "admin_only")
    private boolean adminOnly;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 64)
    @Column(name = "icon")
    private String icon;
    @JoinTable(name = "profile_item", joinColumns = {
        @JoinColumn(name = "idmenu", referencedColumnName = "idmenu")}, inverseJoinColumns = {
        @JoinColumn(name = "idprofile", referencedColumnName = "idprofile")})
    @ManyToMany
    private List<Profile> profileList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idmenu")
    private List<MenuItem> menuItemList;

    public Menu() {
    }

    public Menu(Long idmenu) {
        this.idmenu = idmenu;
    }

    public Menu(Long idmenu, String title, long idparentMenu, boolean adminOnly, String icon) {
        this.idmenu = idmenu;
        this.title = title;
        this.idparentMenu = idparentMenu;
        this.adminOnly = adminOnly;
        this.icon = icon;
    }

    public Long getIdmenu() {
        return idmenu;
    }

    public void setIdmenu(Long idmenu) {
        this.idmenu = idmenu;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public long getIdparentMenu() {
        return idparentMenu;
    }

    public void setIdparentMenu(long idparentMenu) {
        this.idparentMenu = idparentMenu;
    }

    public boolean getAdminOnly() {
        return adminOnly;
    }

    public void setAdminOnly(boolean adminOnly) {
        this.adminOnly = adminOnly;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    @XmlTransient
    public List<Profile> getProfileList() {
        return profileList;
    }

    public void setProfileList(List<Profile> profileList) {
        this.profileList = profileList;
    }

    @XmlTransient
    public List<MenuItem> getMenuItemList() {
        return menuItemList;
    }

    public void setMenuItemList(List<MenuItem> menuItemList) {
        this.menuItemList = menuItemList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idmenu != null ? idmenu.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Menu)) {
            return false;
        }
        Menu other = (Menu) object;
        if ((this.idmenu == null && other.idmenu != null) || (this.idmenu != null && !this.idmenu.equals(other.idmenu))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.gmp.urcweb.entity.Menu[ idmenu=" + idmenu + " ]";
    }
    
}
