/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

/**
 *
 * @author ciro
 */
@Named(value = "contaAcessos")
@SessionScoped
public class ContaAcessos implements Serializable {
    private int contador = 0;

    /**
     * Creates a new instance of ContaAcessos
     */
    public ContaAcessos() {
    }

    public int getContador() {
        return contador;
    }
    
    public int getContadorDaSessao() {
        HttpSession s = (HttpSession) 
                FacesContext.getCurrentInstance().
                        getExternalContext().
                        getSession(true);
        System.out.println("session: " + (s!=null));
        ContaAcessos c = (ContaAcessos) 
                s.getAttribute("contaAcessos");
        if (c != null) return c.getContador();
        return 0;
    }

    public void setContador(int contador) {
        this.contador = contador;
    }
    
}
