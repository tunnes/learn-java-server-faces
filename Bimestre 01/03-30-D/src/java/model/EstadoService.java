package model;

import javax.faces.model.SelectItem;

public class EstadoService {

    private String sigla;
    private SelectItem[] cidades;
    public static final EstadoService[] ESTADOS = {
        
        new EstadoService("SP",
            new SelectItem("","Selecione a cidade"),
            new SelectItem("34953", "Adamantina"),
            new SelectItem("224551", "Americana"),
            new SelectItem("222036", "Araraquara"),
            new SelectItem("433153", "Santos"),
            new SelectItem("11821876", "São Paulo")
        ),
        
        new EstadoService("RJ",
            new SelectItem("","Selecione a cidade"),
            new SelectItem("882729", "Duque de Caxias"),
            new SelectItem("6476631", "Rio de Janeiro"),
            new SelectItem("1038081", "São Gonçalo")
        )
    // outros estados
    };

    public EstadoService(String sigla, SelectItem... cidades) {
        this.sigla = sigla;
        this.cidades = cidades;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public SelectItem[] getCidades() {
        return cidades;
    }

    public void setCidades(SelectItem[] cidades) {
        this.cidades = cidades;
    }
  
}
