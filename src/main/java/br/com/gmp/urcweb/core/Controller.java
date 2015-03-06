package br.com.gmp.urcweb.core;

import br.com.gmp.urcweb.data.dao.DAO;
import br.com.gmp.urcweb.entity.Menu;
import java.util.List;
import java.util.logging.Logger;

/**
 *
 * @author kaciano
 * @param <T>
 */
public interface Controller<T> {

    /**
     * Gerenciador de logs
     */
    public static final Logger LOGGER = Logger.getLogger(Controller.class.getName());

    public void insert(T entity);

    public void update(T entity);

    public void delete(T entity);

    public DAO<T> getDao();

    public List<Menu> getList();
}
