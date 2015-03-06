package br.com.gmp.urcweb.beans;

import br.com.gmp.urcweb.beans.datamodel.MenuDataModel;
import static br.com.gmp.urcweb.core.Controller.LOGGER;
import br.com.gmp.urcweb.core.MenuController;
import br.com.gmp.urcweb.entity.Menu;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

/**
 *
 * @author kaciano
 */
@Named(value = "menuRegisterBean")
@ViewScoped
public class MenuBean implements Serializable {

    private MenuDataModel mdm;
    private Menu selected = new Menu();

    @EJB
    MenuController controller;

    public MenuBean() {
        try {
            mdm = new MenuDataModel(getMenuList());
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, null, e);
        }
    }

    public List<Menu> getMenuList() {
        return controller.getList();
    }

    public MenuDataModel getMdm() {
        return mdm;
    }

    public void setMdm(MenuDataModel mdm) {
        this.mdm = mdm;
    }

    public Menu getSelected() {
        return selected;
    }

    public void setSelected(Menu selected) {
        this.selected = selected;
    }

    public void perdeuFoco() {
        LOGGER.info("PERDEU FOCO!");
    }

}
