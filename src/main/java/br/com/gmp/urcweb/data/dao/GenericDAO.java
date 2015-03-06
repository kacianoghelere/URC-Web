package br.com.gmp.urcweb.data.dao;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaQuery;

/**
 *
 * @author kaciano
 * @param <T>
 */
public abstract class GenericDAO<T> implements DAO<T> {

    /**
     * Gerenciador de logs
     */
    protected static final Logger LOGGER = Logger.getLogger(GenericDAO.class.getName());
    private Class<T> entityClass;

    public GenericDAO(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    /**
     * Retorna o gerenciador de entidades
     *
     * @return {@code EntityManager} Gerenciador de entidades
     */
    protected abstract EntityManager getEntityManager();

    @Override
    public void delete(T entity) {
        try {
            getEntityManager().remove(getEntityManager().merge(entity));
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, null, e);
        }
    }

    @Override
    public void deleteAll(List<T> entities) {
        try {
            for (T entity : entities) {
                getEntityManager().remove(getEntityManager().merge(entity));
            }
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, null, e);
        }
    }

    @Override
    public void deleteAll() {
        try {
            deleteAll(getList());
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, null, e);
        }
    }

    @Override
    public List<T> getList() {
        CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        cq.select(cq.from(entityClass));
        return getEntityManager().createQuery(cq).getResultList();
    }

    @Override
    public Object[] getArray() {
        return getList().toArray();
    }

    @Override
    public Class<T> getObjClass() {
        return entityClass;
    }

    @Override
    public void insert(T entity) {
        try {
            getEntityManager().persist(entity);
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, null, e);
        }
    }

    @Override
    public void insertAll(List<T> entities) {
        try {
            for (T entity : entities) {
                getEntityManager().persist(entity);
            }
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, null, e);
        }
    }

    @Override
    public T queryByID(Long id) {
        return getEntityManager().find(entityClass, id);
    }

    @Override
    public void replaceAll(List<T> entities) {
        try {
            deleteAll();
            insertAll(entities);
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, null, e);
        }
    }

    @Override
    public void setObjClass(Class<T> oClass) {
        this.entityClass = oClass;
    }

    @Override
    public void update(T entity) throws IllegalArgumentException, IllegalAccessException {
        try {
            getEntityManager().merge(entity);
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, null, e);
        }
    }

}
