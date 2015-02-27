package br.com.gmp.urcweb.beans;

import java.util.logging.Logger;

/**
 * Interface de padronização para beans gerenciados
 *
 * @author kaciano
 */
public interface BackgroundBean {

    /**
     * 
     */
    public static final Logger LOG = Logger.getLogger(IndexBean.class.getName());

    /**
     * Evento de submissão de dados
     */
    public void onCommit();

    /**
     * Evento de processamento de dados
     */
    public void onProcess();

    /**
     * Evento de remoção de dados
     */
    public void onClear();

    /**
     * Evento de carregamento de dados
     */
    public void onLoad();
}
