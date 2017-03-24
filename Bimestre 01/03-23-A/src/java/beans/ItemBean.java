/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import model.Item;

/**
 *
 * @author ciro
 */
@Named(value = "itemBean")
@SessionScoped
public class ItemBean implements Serializable {
    private List<Item> itens = new ArrayList<>();
    
    public ItemBean() {
        itens.add(new Item(1, "Cerveja", 48, 2.86));
        itens.add(new Item(2, "Refrigerante", 20, 2.09));
        itens.add(new Item(3, "Suco", 15, 4.59));
        itens.add(new Item(4, "Carvão", 10, 7.89));
        itens.add(new Item(5, "Carne", 5, 39.9));
    }

    public List<Item> getItens() {
        return itens;
    }

    public void setItens(List<Item> itens) {
        this.itens = itens;
    }

}
