package beans;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import model.Item;

/**
 *
 * @author tunnes
 */
@Named(value = "carrinhoBean")
@SessionScoped
public class CarrinhoBean implements Serializable {

    private List<Item> itens = new ArrayList<>();

    /**
     * Creates a new instance of CarrinhoBean
     */
    public CarrinhoBean() {
    }

    public List<Item> getItens() {
        return itens;
    }

    public void setItens(List<Item> itens) {
        this.itens = itens;
    }

    public Double getTotal() {
        Double total = 0.0;
        for (Item i : itens) {
            total += i.getQuantidade() * i.getValor();
        }
        return total;
    }

    public String adicionar(Item item) {
        boolean novo = true;
        item.setQuantidade(item.getQuantidade() - 1);
        for (Item i : itens) {
        //  Condicional para verificar se o item adicionado já foi adicionado anteriormente:    
            if (i.equals(item)) {    
                i.setQuantidade(i.getQuantidade() + 1);
                novo = false;
                break;
            }
        }
        if(novo){
            itens.add(new Item(item.getId(), item.getDescricao(), 1, item.getValor()));
        }
        return null;
    }

    public String excluir(Item item) {
        FacesContext fc = FacesContext.getCurrentInstance();
        HttpSession session = (HttpSession) fc.getExternalContext().getSession(false);
        ItemBean itemBean = (ItemBean) session.getAttribute("itemBean");
        if (itemBean != null) {
            for (Item i : itemBean.getItens()) {
                if (i.equals(item)) {
                    i.setQuantidade(i.getQuantidade() + 1);
                    break;
                }
            }
        }
        if (item.getQuantidade() > 1) {
            item.setQuantidade(item.getQuantidade() - 1);
        } else {
            itens.remove(item);
        }
        return null;
    }

}
