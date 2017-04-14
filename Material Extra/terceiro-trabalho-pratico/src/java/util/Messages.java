/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.util.MissingResourceException;
import java.util.ResourceBundle;
import javax.faces.context.FacesContext;

/**
 *
 * @author tunnes (Ayrton Felipe)
 * @author gmoraiz (Gabriel Morais)
 * @author tarcisioLima (Tarcisio Lima)
 * 
 */
public class Messages {

    public static String getString(String resourceBundleName, String resourceBundleKey, Object... params) throws MissingResourceException {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        ResourceBundle bundle = facesContext.getApplication().getResourceBundle(facesContext, resourceBundleName);
        String msg = bundle.getString(resourceBundleKey);
        for (Object param : params) {
            msg += param;
        }
        return msg;
    }
}
