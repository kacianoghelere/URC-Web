package br.com.gmp.urcweb.core;

import br.com.gmp.urcweb.data.dao.DAO;
import br.com.gmp.urcweb.data.dao.MenuItemDAO;
import br.com.gmp.urcweb.entity.MenuItem;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 *
 * @author kaciano
 */
@Stateless
@LocalBean
public class MenuItemController implements Controller<MenuItem> {

    @EJB
    MenuItemDAO menuItemDao;

    @Override
    public List<MenuItem> getList() {
        try {
            return menuItemDao.getList();
        } catch (Exception ex) {
            Logger.getLogger(MenuItemController.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public void insert(MenuItem entity) {
        try {
            menuItemDao.insert(entity);
        } catch (Exception ex) {
            Logger.getLogger(MenuItemController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(MenuItem entity) {
        try {
            menuItemDao.update(entity);
        } catch (IllegalArgumentException | IllegalAccessException ex) {
            LOGGER.log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete(MenuItem entity) {
        try {
            menuItemDao.delete(entity);
        } catch (Exception ex) {
            Logger.getLogger(MenuItemController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public DAO<MenuItem> getDao() {
        return menuItemDao;
    }

}
