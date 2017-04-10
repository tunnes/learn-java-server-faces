/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class CustomerService {

    private List<Customer> customers;

    public CustomerService() {
        customers = new ArrayList<>();
        customers.add(new Customer(1000, "123", "Ciro", "Trindade", 500.0f));
        customers.add(new Customer(1001, "321", "Alexandre", "Garcia", 10000.0f));
    }

    public Customer findCustomer(Integer account) {
        for (Customer c : customers) {
            if (Objects.equals(c.getAccount(), account)) {
                return c;
            }
        }
        return null;
    }
}
