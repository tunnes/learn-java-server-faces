package beans;

import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import model.Customer;
import model.CustomerService;


@Named(value = "customerBean")
@RequestScoped
public class CustomerBean {

    private Customer customer = new Customer();
    private String message;

    public CustomerBean() {}

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void showBalance() {
        CustomerService service = new CustomerService();
        Customer c = service.findCustomer( customer.getAccount());
        if (c == null) {
            message = "Conta desconhecida";
        } else {
            if (!customer.getPassword().equals(c.getPassword())) {
                message = "Senha incorreta";
            } else {
                message = String.format("Saldo de %s %s é R$ %.2f", c.getFirstName(), c.getLastName(), c.getBalance());
            }
        }
        // return null;;
    }
}
