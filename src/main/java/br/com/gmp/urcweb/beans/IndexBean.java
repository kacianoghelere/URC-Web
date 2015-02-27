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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void onProcess() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void onClear() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void onLoad() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
