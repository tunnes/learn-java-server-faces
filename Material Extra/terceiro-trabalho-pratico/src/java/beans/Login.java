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
 * @author tunnes (Ayrton Felipe)
 * @author gmoraiz (Gabriel Morais)
 * @author tarcisioLima (Tarcisio Lima)
 * 
 */
@Named(value = "login")
@SessionScoped
public class Login implements Serializable{
    private final String login = "root";
    private final String senha = "root";
    private String loginIO;
    private String senhaIO;
    
    public Login() {}
    
    public String getLoginIO() {
        return loginIO;
    }

    public void setLoginIO(String loginIO) {
        this.loginIO = loginIO;
    }

    public String getSenhaIO() {
        return senhaIO;
    }

    public void setSenhaIO(String senhaIO) {
        this.senhaIO = senhaIO;
    }
    public String criarSessao(){
        HttpSession sessao = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
        Login log = new Login();
        sessao.setAttribute("login", log);
        return "pagina_principal?faces-redirect=true";
    }
    public String efetuarAutenticacao(){
        return (login.equals(loginIO) && senha.equals(senhaIO)) ? criarSessao() : "pagina_deslogado?faces-redirect=true";
    }
    public String encerrarSessao(){
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        return "pagina_login?faces-redirect=true";
    } 
    public void verificar(){
   
    }
}
