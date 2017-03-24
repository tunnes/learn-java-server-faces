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
 * @author lab2
 */
@Named(value = "loginBean")
@SessionScoped
public class LoginBean implements Serializable{
    private boolean logado;
    public LoginBean(){}
    public boolean getLogado(){
        LoginBean login = (LoginBean)((HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true)).getAttribute("loginBean");
        return (login != null) ? login.getLogado() : true;
    }
    public void setLogado(boolean logado){
        this.logado = logado;
    }
    
}
