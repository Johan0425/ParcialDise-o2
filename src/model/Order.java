/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author joanp
 */
public class Order {

    private int orderID;
    private String dateOrder;
    private String total;
    private final Customer customer;

    public Order(int orderID, String fechaPedido, String total, Customer customer) {
        this.orderID = orderID;
        this.dateOrder = fechaPedido;
        this.total = total;
        this.customer = customer;
    }

    public Order(String fechaPedido, String total, Customer customer) {
        this.dateOrder = fechaPedido;
        this.total = total;
        this.customer = customer;
    }

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public String getDateOrder() {
        return dateOrder;
    }

    public void setDateOrder(String fechaPedido) {
        this.dateOrder = fechaPedido;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public Customer getCustomer() {
        return customer;
    }

}
