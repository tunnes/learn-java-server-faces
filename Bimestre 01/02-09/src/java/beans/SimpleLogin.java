/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;
import javax.faces.model.SelectItem;

/**
 *
 * @author lab2
 */
@Named(value = "user")
@SessionScoped
public class SimpleLogin implements Serializable {

    private static final String LOGIN = "ciro";
    private static final String PASSWORD = "123";
    private String login;
    private String password;
    private boolean contato;
    private List<String> cores;
    private String educacao;
    private String anos;
    private List<String> idiomas;

    public SimpleLogin() {
    }

    public String getEducacao() {
        return this.educacao;
    }

    public void setEducacao(String educacao) {
        this.educacao = educacao;
    }

    public boolean getContato() {
        return contato;
    }

    public void setContato(boolean contato) {
        this.contato = contato;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String validar() {
        if (login.equals(LOGIN)
                && password.equals(PASSWORD)) {
            return "/success";
        }
        return "/fail";
    }

    public List<String> getCores() {
        return cores;
    }

    public void setCores(List<String> cores) {
        this.cores = cores;
    }

    public String getAnos() {
        return anos;
    }

    public String[] getAnosEducacao() {
        String[] anos = new String[20];
        int anoAtual = new GregorianCalendar().get(GregorianCalendar.YEAR);
        for (int i = 0; i < 20; i++) { anos[i] = String.valueOf(anoAtual - i);}
        return anos;
    }

    public void setAnos(String anos) {
        this.anos = anos;
    }

    public List<String> getIdiomas() {
        return idiomas;
    }
    public void setIdiomas(List<String> idiomas) {
        this.idiomas = idiomas;
    }
    public List<SelectItem> listaDeIdiomas(){
        List<SelectItem> items = new ArrayList<>();
        items.add(new SelectItem("ING", "Inglês"));
        items.add(new SelectItem("FRA", "Francês"));
        items.add(new SelectItem("ESP", "Espanhol"));
        items.add(new SelectItem("ITA", "Italiano"));
        return items;
    }
}
