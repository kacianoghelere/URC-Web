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
@Named(value = "testeBean")
@ViewScoped
public class TesteBean implements Serializable, BackgroundBean {

    @Override
    public void onCommit() {
        LOG.info("TESTE:ONCOMMIT");
    }

    @Override
    public void onProcess() {
        LOG.info("TESTE:ONPROCESS");
    }

    @Override
    public void onClear() {
        LOG.info("TESTE:ONCLEAR");
    }

    @Override
    public void onLoad() {
        LOG.info("TESTE:ONLOAD");
    }

}
