package beans;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named
@RequestScoped
public class AjaxBean {

    private String name = "";

    public AjaxBean() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void upperCaseName() {
        name = name.toUpperCase();
    }
}
