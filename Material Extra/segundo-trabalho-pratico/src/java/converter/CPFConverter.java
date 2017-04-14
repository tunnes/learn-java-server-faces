/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package converter;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;
import model.CPF;
import util.Messages;

/**
 *
 * @author tunnes (Ayrton Felipe)
 * @author gmoraiz (Gabriel Morais)
 * @author tarcisioLima (Tarcisio Lima)
 * 
 */
@FacesConverter(forClass = CPF.class)
public class CPFConverter implements Converter {

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        StringBuilder convertida = new StringBuilder(value);
        boolean invalido = false;
        char caractereInvalido = '\0';
        for (int i = 0; i < convertida.length() && !invalido; i++) {
            char ch = convertida.charAt(i);
            if (!Character.isDigit(ch)) {
                if (ch == '.' || ch == '-') {
                    convertida.deleteCharAt(i);
                } else {
                    invalido = true;
                    caractereInvalido = ch;
                }
            }
        }
        if (invalido) {
            String msg = Messages.getString("msgs", "erroConversaoCPF", 
                    " (" + caractereInvalido + ")");
            FacesMessage message = new FacesMessage(msg);
            message.setSeverity(FacesMessage.SEVERITY_ERROR);
            throw new ConverterException(message);
        }
        return new CPF(convertida.toString());
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        // retorna o cartão no formato XXX.XXX.XXX-XX =D
        int[] limites = {3, 6, 9};
        int fim, inicio = 0;
        StringBuilder resultado = new StringBuilder();
        String valor = value.toString();
        for (int i = 0; i < limites.length && limites[i] < valor.length(); i++) {
            fim = limites[i];
            resultado.append(valor.substring(inicio, fim));
            resultado.append((resultado.length() == 11) ? "-" : ".");
            inicio = fim;
        }
        resultado.append(valor.substring(inicio));
        return resultado.toString();
    }

}
