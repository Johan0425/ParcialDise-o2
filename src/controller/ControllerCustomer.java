/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dao.CustomerDAO;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Customer;

/**
 *
 * @author joanp
 */
public class ControllerCustomer {

    private final CustomerDAO customerdao;

    public ControllerCustomer() {
        this.customerdao = new CustomerDAO();
    }

    public ArrayList<Customer> listCustomer() {
        return customerdao.listCustomer();
    }

    public Customer searchCustomer(int id) {
        return customerdao.searchCustomer(id);
    }

    public void addCustomer(Customer customer) throws SQLException {
        customerdao.addCustomer(customer);
    }

    public void updatedCustomer(int id, String name, String email) throws SQLException {
        customerdao.updatedCustomer(id, name, email);
    }

    public void deleteCustomer(int id) {
        customerdao.deleteCustomer(id);
    }
}
