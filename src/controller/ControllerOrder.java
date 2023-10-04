/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dao.OrderDAO;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Customer;
import model.Order;

/**
 *
 * @author joanp
 */
public class ControllerOrder {

    private final OrderDAO orderdao;

    public ControllerOrder() {
        this.orderdao = new OrderDAO();
    }

    public ArrayList<Order> listOrders() {
        return orderdao.listOrders();
    }

    public ArrayList<Customer> getAllCustomers() {
        return orderdao.getAllCustomers();
    }

    public Order searchOrder(int id) {
        return orderdao.searchOrder(id);
    }

    public ArrayList<Order> searchOrderByCustomer(int id) {
        return orderdao.searchOrderByCustomer(id);
    }

    public void addOrder(Order order) throws SQLException {
        orderdao.addOrder(order);
    }

    public boolean updatedOrder(Order order) {
        return orderdao.updatedOrder(order);
    }

    public boolean deleteOrder(int id) {
        return orderdao.deleteOrder(id);
    }
}
