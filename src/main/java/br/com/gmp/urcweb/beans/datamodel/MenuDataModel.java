package br.com.gmp.urcweb.beans.datamodel;

import br.com.gmp.urcweb.entity.Menu;
import java.util.List;
import javax.faces.model.ListDataModel;
import org.primefaces.model.SelectableDataModel;

/**
 *
 * @author kaciano
 */
public class MenuDataModel extends ListDataModel<Menu> implements SelectableDataModel<Menu> {

    /**
     *
     */
    public MenuDataModel() {
    }

    /**
     *
     * @param data
     */
    public MenuDataModel(List<Menu> data) {
        super(data);
    }

    /**
     *
     * @param rowKey
     * @return
     */
    @Override
    public Menu getRowData(String rowKey) {
        List<Menu> list = (List<Menu>) getWrappedData();
        System.out.println(rowKey);
        for (Menu usu : list) {
            if (String.valueOf(usu.getIdmenu()).equals(rowKey)) {
                return usu;
            }
        }

        return null;
    }

    /**
     *
     * @param usu
     * @return
     */
    @Override
    public Object getRowKey(Menu usu) {
        return String.valueOf(usu.getIdmenu());
    }
}
