package br.com.gmp.urcweb.data;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author kaciano
 */
@Stateless
public class ConnectionManager {

    @PersistenceContext(unitName = "br.com.gmp_URC-Web_war_1.0PU")
    private EntityManager em;

    public EntityManager getEntityManager() {
        return em;
    }

}
