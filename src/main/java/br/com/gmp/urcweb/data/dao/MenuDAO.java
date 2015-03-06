package br.com.gmp.urcweb.data.dao;

import br.com.gmp.urcweb.data.ConnectionManager;
import br.com.gmp.urcweb.entity.Menu;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;

/**
 *
 * @author kaciano
 */
@Stateless
public class MenuDAO extends GenericDAO<Menu> {

    @EJB
    ConnectionManager manager;

    public MenuDAO() {
        super(Menu.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return manager.getEntityManager();
    }

}
