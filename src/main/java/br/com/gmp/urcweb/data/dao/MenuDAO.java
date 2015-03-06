package br.com.gmp.urcweb.data.dao;

import static br.com.gmp.urcweb.core.Controller.factory;
import br.com.gmp.urcweb.entity.Menu;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 * DAO de controle de menus
 *
 * @author kaciano
 */
@Stateless
@LocalBean
public class MenuDAO implements DAO<Menu> {

    /**
     * Gerenciador de logs
     */
    protected static final Logger LOGGER = Logger.getLogger(MenuDAO.class.getName());

    @Override
    public Menu build(ResultSet rs) throws Exception {
        try {
            Menu menu = new Menu();
            menu.setAdminOnly(rs.getBoolean("admin_only"));
            menu.setIcon(rs.getString("icon"));
            menu.setIdmenu(rs.getLong("idmenu"));
            menu.setIdparentMenu(rs.getLong("idparent_menu"));
            menu.setTitle(rs.getString("title"));
            return menu;
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public void delete(Menu entity) throws Exception {
        try {
            String sql = "DELETE FROM menu WHERE idmenu = ?";
            try (PreparedStatement ps = factory.createStatement(sql)) {
                ps.setLong(1, entity.getIdmenu());
                ps.executeUpdate();
            }
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, null, e);
        } finally {
            factory.close();
        }
    }

    @Override
    public void deleteAll(List<Menu> entities) throws Exception {
        try {
            for (Menu entity : entities) {
                delete(entity);
            }
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, null, e);
        }
    }

    @Override
    public void deleteAll() throws Exception {
        try {
            String sql = "DELETE FROM menu";
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
    public List<Menu> getList() throws Exception {
        try {
            String sql = "SELECT idmenu, title, idparent_menu, admin_only, icon FROM menu";
            List<Menu> list = new ArrayList<>();

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
    public void insert(Menu entity) throws Exception {
        try {
            String sql = "INSERT INTO menu "
                    + " (idmenu, title, idparent_menu, admin_only, icon) "
                    + " VALUES (?, ?, ?, ?, ?)";
            int i = 1;
            try (PreparedStatement ps = factory.createStatement(sql)) {
                ps.setLong(i++, entity.getIdmenu());
                ps.setString(i++, entity.getTitle());
                ps.setLong(i++, entity.getIdparentMenu());
                ps.setBoolean(i++, entity.getAdminOnly());
                ps.setString(i++, entity.getIcon());
                ps.executeUpdate();
            }
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, null, e);
        } finally {
            factory.close();
        }
    }

    @Override
    public void insertAll(List<Menu> entities) throws Exception {
        try {
            for (Menu entity : entities) {
                insert(entity);
            }
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, null, e);
        }
    }

    @Override
    public Menu queryByID(Long id) throws Exception {
        try {
            String sql = "SELECT idmenu, title, idparent_menu, admin_only, icon FROM menu"
                    + "WHERE idmenu = ?";
            Menu menu = null;

            try (PreparedStatement ps = factory.createStatement(sql)) {
                ps.setLong(1, id);
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    menu = build(rs);
                }
            }
            return menu;
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, null, e);
            return null;
        } finally {
            factory.close();
        }
    }

    @Override
    public void replaceAll(List<Menu> entities) throws Exception {
        try {
            deleteAll();
            insertAll(entities);
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, null, e);
        }
    }

    @Override
    public void update(Menu entity) throws IllegalArgumentException, IllegalAccessException {
        try {
            String sql = "UPDATE menu SET "
                    + " title = ?, idparent_menu = ?, admin_only = ?, icon = ? "
                    + " WHERE idmenu = ?";
            int i = 1;
            try (PreparedStatement ps = factory.createStatement(sql)) {
                ps.setString(i++, entity.getTitle());
                ps.setLong(i++, entity.getIdparentMenu());
                ps.setBoolean(i++, entity.getAdminOnly());
                ps.setString(i++, entity.getIcon());
                ps.setLong(i++, entity.getIdmenu());
                ps.executeUpdate();
            }
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, null, e);
        } finally {
            factory.close();
        }
    }

}
