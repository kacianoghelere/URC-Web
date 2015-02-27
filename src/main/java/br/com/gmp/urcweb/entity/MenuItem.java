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
@Table(name = "menu_item")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MenuItem.findAll", query = "SELECT m FROM MenuItem m"),
    @NamedQuery(name = "MenuItem.findByIdmenuItem", query = "SELECT m FROM MenuItem m WHERE m.idmenuItem = :idmenuItem"),
    @NamedQuery(name = "MenuItem.findByTitle", query = "SELECT m FROM MenuItem m WHERE m.title = :title"),
    @NamedQuery(name = "MenuItem.findByViewPath", query = "SELECT m FROM MenuItem m WHERE m.viewPath = :viewPath"),
    @NamedQuery(name = "MenuItem.findByAdminOnly", query = "SELECT m FROM MenuItem m WHERE m.adminOnly = :adminOnly"),
    @NamedQuery(name = "MenuItem.findByIcon", query = "SELECT m FROM MenuItem m WHERE m.icon = :icon")})
public class MenuItem implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idmenu_item")
    private Long idmenuItem;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "title")
    private String title;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 64)
    @Column(name = "view_path")
    private String viewPath;
    @Basic(optional = false)
    @NotNull
    @Column(name = "admin_only")
    private boolean adminOnly;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "icon")
    private String icon;
    @JoinColumn(name = "idmenu", referencedColumnName = "idmenu")
    @ManyToOne(optional = false)
    private Menu idmenu;

    public MenuItem() {
    }

    public MenuItem(Long idmenuItem) {
        this.idmenuItem = idmenuItem;
    }

    public MenuItem(Long idmenuItem, String title, String viewPath, boolean adminOnly, String icon) {
        this.idmenuItem = idmenuItem;
        this.title = title;
        this.viewPath = viewPath;
        this.adminOnly = adminOnly;
        this.icon = icon;
    }

    public Long getIdmenuItem() {
        return idmenuItem;
    }

    public void setIdmenuItem(Long idmenuItem) {
        this.idmenuItem = idmenuItem;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getViewPath() {
        return viewPath;
    }

    public void setViewPath(String viewPath) {
        this.viewPath = viewPath;
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

    public Menu getIdmenu() {
        return idmenu;
    }

    public void setIdmenu(Menu idmenu) {
        this.idmenu = idmenu;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idmenuItem != null ? idmenuItem.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MenuItem)) {
            return false;
        }
        MenuItem other = (MenuItem) object;
        if ((this.idmenuItem == null && other.idmenuItem != null) || (this.idmenuItem != null && !this.idmenuItem.equals(other.idmenuItem))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.gmp.urcweb.entity.MenuItem[ idmenuItem=" + idmenuItem + " ]";
    }
    
}
