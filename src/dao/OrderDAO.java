/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Customer;
import model.Order;
import org.mariadb.jdbc.Connection;
import singleton.Singleton;

/**
 *
 * @author joanp
 */
public class OrderDAO {

    private final Connection con;

    public OrderDAO() {
        con = Singleton.getINSTANCE().getConnection();
    }

    public ArrayList<Order> listOrders() {
        ArrayList<Order> orders = new ArrayList<>();

        try {
            PreparedStatement ps;
            ResultSet rs;

            String query = "SELECT Pedidos.PedidoID, Pedidos.FechaPedido, Pedidos.Total, Pedidos.ClienteID, "
                    + " Clientes.Nombre, Clientes.Email FROM Pedidos JOIN Clientes ON Pedidos.ClienteID = Clientes.ClienteID";

            ps = con.prepareStatement(query);
            rs = ps.executeQuery();

            while (rs.next()) {
                int idCustomer = rs.getInt("ClienteID");
                String name = rs.getString("Nombre");
                String email = rs.getString("Email");
                int idPedido = rs.getInt("PedidoID");
                String fechaPedido = rs.getString("FechaPedido");
                String total = rs.getString("Total");

                Customer customer = new Customer(idCustomer, name, email);

                Order order = new Order(idPedido, fechaPedido, total, customer);
                orders.add(order);

            }
        } catch (SQLException ex) {
            System.err.println(ex.toString());
        }
        return orders;
    }

    /**
     * @return
     */
    public ArrayList<Customer> getAllCustomers() {
        ArrayList<Customer> customers = new ArrayList<>();

        try {
            PreparedStatement ps;
            ResultSet rs;

            String query = "SELECT * FROM Clientes";

            ps = con.prepareStatement(query);
            rs = ps.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("ClienteID");
                String name = rs.getString("Nombre");
                String email = rs.getString("Email");
                Customer customer = new Customer(id, name, email);
                customers.add(customer);
            }
        } catch (SQLException ex) {
            System.err.println(ex.toString());
        }
        return customers;
    }

    /**
     * @param id
     * @return
     */
    public Order searchOrder(int id) {
        try {
            PreparedStatement ps;
            ResultSet rs;

            String query = "SELECT Pedidos.PedidoID, Pedidos.FechaPedido, Pedidos.Total, Pedidos.ClienteID, "
                    + " Clientes.Nombre, Clientes.Email FROM Pedidos JOIN Clientes ON Pedidos.ClienteID = Clientes.ClienteID WHERE Pedidos.PedidoID = ?";

            ps = con.prepareStatement(query);
            ps.setInt(1, id);
            rs = ps.executeQuery();

            if (rs.next()) {
                int idCustomer = rs.getInt("ClienteID");
                String name = rs.getString("Nombre");
                String email = rs.getString("Email");
                int idPedido = rs.getInt("PedidoID");
                String fechaPedido = rs.getString("FechaPedido");
                String total = rs.getString("Total");

                Customer customer = new Customer(idCustomer, name, email);

                Order order = new Order(idPedido, fechaPedido, total, customer);

                return order;
            }
        } catch (SQLException ex) {
            System.err.println(ex.toString());
        }
        return null;
    }

    public ArrayList<Order> searchOrderByCustomer(int id) {
        ArrayList<Order> orders = new ArrayList<>();

        try {
            PreparedStatement ps;
            ResultSet rs;

            String query = "SELECT Pedidos.PedidoID, Pedidos.FechaPedido, Pedidos.Total, Pedidos.ClienteID, "
                    + " Clientes.Nombre, Clientes.Email FROM Pedidos JOIN Clientes ON Pedidos.ClienteID = Clientes.ClienteID "
                    + "WHERE Pedidos.ClienteID = ?";

            ps = con.prepareStatement(query);
            ps.setInt(1, id);
            rs = ps.executeQuery();

            while (rs.next()) {
                int idCustomer = rs.getInt("ClienteID");
                String name = rs.getString("Nombre");
                String email = rs.getString("Email");
                int idPedido = rs.getInt("PedidoID");
                String fechaPedido = rs.getString("FechaPedido");
                String total = rs.getString("Total");

                Customer customer = new Customer(idCustomer, name, email);

                Order order = new Order(idPedido, fechaPedido, total, customer);
                orders.add(order);

            }
        } catch (SQLException ex) {
            System.err.println(ex.toString());
        }
        return orders;
    }

    /**
     * @param order
     * @throws java.sql.SQLException
     */
    public void addOrder(Order order) throws SQLException {
        try {
            PreparedStatement ps;

            String query = "INSERT INTO Pedidos (PedidoID, FechaPedido, Total, Clienteid) VALUES (?, ?, ?, ?)";

            ps = con.prepareStatement(query);

            ps.setInt(1, order.getOrderID());
            ps.setString(2, order.getDateOrder());
            ps.setString(3, order.getTotal());
            ps.setInt(4, order.getCustomer().getCustomerId());

            ps.executeUpdate();

        } catch (SQLException ex) {
            System.err.println(ex.toString());
            throw new SQLException();
        }
    }

    /**
     * @param order
     * @return
     */
    public boolean updatedOrder(Order order) {
        try {
            PreparedStatement ps;

            String query = "UPDATE Pedidos SET Total = ? , ClienteID = ? WHERE PedidoID = ?";

            ps = con.prepareStatement(query);
            ps.setString(1, order.getTotal());
            ps.setInt(2, order.getCustomer().getCustomerId());
            ps.setInt(3, order.getOrderID());

            int rowsUpdated = ps.executeUpdate();

            return rowsUpdated > 0;
        } catch (SQLException ex) {
            System.err.println(ex.toString());
            return false;
        }
    }

    /**
     * @param id
     * @return
     */
    public boolean deleteOrder(int id) {
        try {
            PreparedStatement ps;

            String query = "DELETE FROM Pedidos WHERE PedidoID = ?";

            ps = con.prepareStatement(query);
            ps.setInt(1, id);

            int rowDeleted = ps.executeUpdate();

            return rowDeleted > 0;
        } catch (SQLException ex) {
            System.err.println(ex.toString());
            return false;
        }
    }

}
