package br.com.gmp.urcweb.core.connection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Implementação do padrão factory para gerenciar as conexões. Só vai pegar uma
 * nova conexão quando não tiver conexão
 *
 * @author kaciano
 * @version 1.0
 */
public class ConnectionFactory {

    private static final Logger LOG = Logger.getLogger(ConnectionFactory.class.getName());
    private Connection connection = null;

    /**
     * Recupera a conexão via datasource
     *
     * @return Connection
     * @throws SQLException
     * @see Datasource#getInstance()
     * @since 1.0
     */
    public Connection getConnection() throws SQLException {
        if (connection == null || connection.isClosed()) {
            connection = Datasource.getInstance().getConnection();
            connection.setAutoCommit(false);
        }
        return connection;
    }

    /**
     * Cria um prepared Statement baseado em uma query
     *
     * @param sql a ser compilado
     * @return PreparedStatement
     * @throws SQLException
     * @since 1.0
     */
    public PreparedStatement createStatement(String sql) throws SQLException {
        return getConnection().prepareStatement(sql);
    }

    /**
     * Efetua commit na Conexão atual e fecha a conexao.
     *
     * @throws SQLException
     */
    public void commit() throws SQLException {
        try {
            getConnection().commit();
            close();
        } catch (SQLException e) {
            LOG.log(Level.SEVERE, null, e);
            throw new IllegalStateException("Erro efetuando commit", e);
        }
    }

    /**
     * Efetua Rollback na conexão atua e fecha a conexão. A SQLEXception é
     * encapsulada, gera um IllegalStateException
     *
     * @since 1.0
     */
    public void rollback() {
        try {
            getConnection().rollback();
            close();
        } catch (SQLException e) {
            LOG.log(Level.SEVERE, null, e);
            throw new IllegalStateException("Erro efetuando rollback", e);
        }
    }

    public void close() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.commit();
                connection.close();
            }
        } catch (SQLException e) {
            LOG.log(Level.SEVERE, null, e);
            throw new IllegalStateException("Erro efetuando close", e);
        }
    }
}
