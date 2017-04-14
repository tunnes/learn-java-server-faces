package beans;

import java.io.Serializable;
import model.Reserva;
import java.util.List;
import javax.inject.Named;
import java.util.ArrayList;
import javax.enterprise.context.SessionScoped;
import javax.faces.model.SelectItem;

/**
 *
 * @author tunnes (Ayrton Felipe)
 * @author gmoraiz (Gabriel Morais)
 * @author tarcisioLima (Tarcisio Lima)
 * 
 */
@Named(value = "reservaBean")
@SessionScoped
public class ReservaBean implements Serializable {
    private Reserva reserva;
    private List<Reserva> reservas = new ArrayList<>();

            
    public ReservaBean() {
        this.reserva = new Reserva();
    }

    public String adicionarReserva() {
        this.reservas.add(this.reserva);
        this.reserva = new Reserva();
        return "/pagina_reservas?faces-redirect=true";
    }
    
    public Reserva getReserva() {
        return this.reserva;
    }

    public List<Reserva> getReservas() {
        return this.reservas;
    }

    public void setReserva(Reserva r) {
        this.reserva = r;
    }

    public void setReservas(List<Reserva> rs) {
        this.reservas = rs;
    }

    public List<SelectItem> listarDestinos() {
        List<SelectItem> items = new ArrayList<>();
        items.add(new SelectItem("SAO", "São Paulo"));
        items.add(new SelectItem("RIO", "Rio de Janeiro"));
        items.add(new SelectItem("CAM", "Campinas"));
        items.add(new SelectItem("CUR", "Curitiba"));
        return items;
    }
}
