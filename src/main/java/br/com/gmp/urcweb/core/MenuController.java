package br.com.gmp.urcweb.core;

import br.com.gmp.urcweb.data.dao.DAO;
import br.com.gmp.urcweb.data.dao.MenuDAO;
import br.com.gmp.urcweb.entity.Menu;
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
public class MenuController implements Controller<Menu> {

    @EJB
    MenuDAO menuDao;

    @Override
    public List<Menu> getList() {
        try {
            return menuDao.getList();
        } catch (Exception ex) {
            Logger.getLogger(MenuController.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public void insert(Menu entity) {
        try {
            menuDao.insert(entity);
        } catch (Exception ex) {
            Logger.getLogger(MenuController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(Menu entity) {
        try {
            menuDao.update(entity);
        } catch (IllegalArgumentException | IllegalAccessException ex) {
            LOGGER.log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete(Menu entity) {
        try {
            menuDao.delete(entity);
        } catch (Exception ex) {
            Logger.getLogger(MenuController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public DAO<Menu> getDao() {
        return menuDao;
    }

}
