package beans;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.model.SelectItem;
import model.EstadoService;

@Named(value = "populacaoBean")
@SessionScoped
public class PopulacaoBean implements Serializable {

    private String estado;
    private String cidade;
    private boolean listaCidadesDesabilitada;

    public PopulacaoBean() {
        listaCidadesDesabilitada = true;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
        this.listaCidadesDesabilitada = "Selecione o estado".equals(this.estado);
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
        
    }

    public boolean isListaCidadesDesabilitada() {
        return listaCidadesDesabilitada;
    }

    public void setListaCidadesDesabilitada(boolean listaCidadesDesabilitada) {
        this.listaCidadesDesabilitada= listaCidadesDesabilitada;
    }

    public List<SelectItem> getEstados() {
        List<SelectItem> estados = new ArrayList<>();
        estados.add(new SelectItem("Selecione o estado"));
        for (EstadoService s : EstadoService.ESTADOS) {
            estados.add(new SelectItem(s.getSigla()));
        }
        return estados;
    }

    public SelectItem[] getCidades() {
        SelectItem[] cidades = { new SelectItem("Selecione a cidade") };
        if (!listaCidadesDesabilitada && estado != null) {
            for (EstadoService s : EstadoService.ESTADOS) {
                if (s.getSigla().equals(estado)) {
                    cidades = s.getCidades();
                    break;
                }
            }
        }
        return cidades;
    }

    
}
