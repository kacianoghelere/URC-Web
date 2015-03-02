/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gmp.urcweb.beans;

import java.io.Serializable;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

/**
 *
 * @author kaciano
 */
@Named(value = "bean")
@ViewScoped
public class GenericBean implements Serializable, BackgroundBean {
    
    public void onHome() {
        LOG.info("HOME.");
    }
    
    @Override
    public void onCommit() {
        LOG.info("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public void onProcess() {
        LOG.info("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public void onClear() {
        LOG.info("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public void onLoad() {
        LOG.info("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
