package beans;

import java.io.Serializable;
import model.Reserva;
import java.util.List;
import javax.inject.Named;
import java.util.ArrayList;
import javax.enterprise.context.Conversation;
import javax.enterprise.context.ConversationScoped;
import javax.faces.model.SelectItem;
import javax.inject.Inject;

/**
 *
 * @author tunnes (Ayrton Felipe)
 * @author gmoraiz (Gabriel Morais)
 * @author tarcisioLima (Tarcisio Lima)
 * 
 */
@Named(value = "reservaBean")
@ConversationScoped
public class ReservaBean implements Serializable {

    private @Inject Conversation conversation;
    private Reserva reserva = new Reserva();
    private List<Reserva> reservas = new ArrayList<>();

    public ReservaBean() {
    }

    public String adicionarReserva() {
        this.iniciarConversacao();
        reservas.add(reserva);
        reserva = new Reserva();
        return null;
    }
    
    public void iniciarConversacao() {
        if (conversation.isTransient()) {
            conversation.begin();
        }
    }

    public void finalizarConversacao() {
        if (!conversation.isTransient()) {
            conversation.end();
        }
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
