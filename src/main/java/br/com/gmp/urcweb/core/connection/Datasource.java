package br.com.gmp.urcweb.core.connection;

import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

/**
 *
 * @author kaciano
 */
public class Datasource implements Serializable {

    private InitialContext ctx;
    private static DataSource ds;
    private static final Logger LOG = Logger.getLogger(Datasource.class.getName());

    /**
     * Contrutor da classe
     */
    private Datasource() {
        try {
            ctx = new InitialContext();
            ds = (DataSource) ctx.lookup("jdbc/URC");
        } catch (NamingException ex) {
            LOG.log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Retorna sempre a mesma instancia do Data source.
     *
     * @return
     */
    public synchronized static DataSource getInstance() {
        if (ds == null) {
            try {
                InitialContext ctx = new InitialContext();
                MysqlDataSource dataSource = new MysqlDataSource();
                dataSource.setDatabaseName("urc");
                dataSource.setPortNumber(3306);
                dataSource.setServerName("127.0.0.1");
                dataSource.setUser("root");
                dataSource.setPassword("d0v4hk11n");

                ctx.rebind("jdbc/URC", dataSource);
                ds = (DataSource) ctx.lookup("jdbc/URC");
            } catch (NamingException ex) {
                LOG.log(Level.SEVERE, null, ex);
                throw new ExceptionInInitializerError(ex);
            }
        }
        return ds;
    }
}
