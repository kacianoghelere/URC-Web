package br.com.gmp.urcweb.data.dao;

import static br.com.gmp.urcweb.core.Controller.factory;
import br.com.gmp.urcweb.entity.MenuItem;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 * DAO de controle de itens de menus
 *
 * @author kaciano
 */
@Stateless
@LocalBean
public class MenuItemDAO implements DAO<MenuItem> {

    /**
     * Gerenciador de logs
     */
    protected static final Logger LOGGER = Logger.getLogger(MenuItemDAO.class.getName());

    @Override
    public MenuItem build(ResultSet rs) throws Exception {
        try {
            MenuItem item = new MenuItem();

            return item;
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public void delete(MenuItem entity) throws Exception {
        try {
            String sql = "DELETE FROM menu_item WHERE idmenu_item = ?";
            try (PreparedStatement ps = factory.createStatement(sql)) {
                ps.setLong(1, entity.getIdmenuItem());
                ps.executeUpdate();
            }
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, null, e);
        } finally {
            factory.close();
        }
    }

    @Override
    public void deleteAll(List<MenuItem> entities) throws Exception {
        try {
            for (MenuItem entity : entities) {
                delete(entity);
            }
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, null, e);
        }
    }

    @Override
    public void deleteAll() throws Exception {
        try {
            String sql = "DELETE FROM menu_item";
            try (PreparedStatement ps = factory.createStatement(sql)) {
                ps.executeUpdate();
            }
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, null, e);
        } finally {
            factory.close();
        }
    }

    @Override
    public Object[] getArray() throws Exception {
        return getList().toArray();
    }

    @Override
    public List<MenuItem> getList() throws Exception {
        try {
            String sql = "SELECT idmenu_item, title, view_path, admin_only, icon, idmenu FROM menu";
            List<MenuItem> list = new ArrayList<>();

            try (PreparedStatement ps = factory.createStatement(sql)) {
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    list.add(build(rs));
                }
            }
            return list;
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, null, e);
            return null;
        } finally {
            factory.close();
        }
    }

    @Override
    public void insert(MenuItem entity) throws Exception {
        try {
            String sql = "INSERT INTO menu "
                    + " (idmenu_item, title, view_path, admin_only, icon, idmenu) "
                    + " VALUES (?, ?, ?, ?, ?, ?)";
            int i = 1;
            try (PreparedStatement ps = factory.createStatement(sql)) {
                ps.setLong(i++, entity.getIdmenuItem());
                ps.setString(i++, entity.getTitle());
                ps.setString(i++, entity.getViewPath());                
                ps.setBoolean(i++, entity.getAdminOnly());
                ps.setString(i++, entity.getIcon());
                ps.setLong(i++, entity.getIdmenu().getIdmenu());                
                ps.executeUpdate();
            }
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, null, e);
        } finally {
            factory.close();
        }
    }

    @Override
    public void insertAll(List<MenuItem> entities) throws Exception {
        try {
            for (MenuItem entity : entities) {
                insert(entity);
            }
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, null, e);
        }
    }

    @Override
    public MenuItem queryByID(Long id) throws Exception {
        try {
            String sql = "SELECT idmenu_item, title, view_path, admin_only, icon, idmenu FROM menu"
                    + "WHERE idmenu_item = ?";
            MenuItem item = null;

            try (PreparedStatement ps = factory.createStatement(sql)) {
                ps.setLong(1, id);
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    item = build(rs);
                }
            }
            return item;
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, null, e);
            return null;
        } finally {
            factory.close();
        }
    }

    @Override
    public void replaceAll(List<MenuItem> entities) throws Exception {
        try {
            deleteAll();
            insertAll(entities);
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, null, e);
        }
    }

    @Override
    public void update(MenuItem entity) throws IllegalArgumentException, IllegalAccessException {
        try {
            String sql = "UPDATE menu_item SET "
                    + " title=?, view_path=?, admin_only=?, icon=?, idmenu=? "
                    + " WHERE idmenu_item = ?";
            int i = 1;
            try (PreparedStatement ps = factory.createStatement(sql)) {
                ps.setString(i++, entity.getTitle());
                ps.setString(i++, entity.getViewPath());                
                ps.setBoolean(i++, entity.getAdminOnly());
                ps.setString(i++, entity.getIcon());
                ps.setLong(i++, entity.getIdmenu().getIdmenu());
                ps.setLong(i++, entity.getIdmenuItem());
                ps.executeUpdate();
            }
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, null, e);
        } finally {
            factory.close();
        }
    }

}
