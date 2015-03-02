package br.com.gmp.urcweb.beans;

import java.io.Serializable;
import java.util.logging.Logger;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

/**
 *
 * @author kaciano
 */
@Named(value = "indexBean")
@ViewScoped
public class IndexBean implements Serializable, BackgroundBean {

    /**
     * Creates a new instance of IndexBean
     */
    public IndexBean() {
    }

    @Override
    public void onCommit() {
        LOG.info("INDEX:ONCOMMIT");
    }

    @Override
    public void onProcess() {
        LOG.info("INDEX:ONPROCESS");
    }

    @Override
    public void onClear() {
        LOG.info("INDEX:ONCLEAR");
    }

    @Override
    public void onLoad() {
        LOG.info("INDEX:ONLOAD");
    }

}
