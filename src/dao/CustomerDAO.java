/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import exceptions.CustomerException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Customer;
import org.mariadb.jdbc.Connection;
import singleton.Singleton;

/**
 *
 * @author joanp
 */
public class CustomerDAO {
    
    private final Connection con;
    
    public CustomerDAO() {
        this.con = Singleton.getINSTANCE().getConnection();
    }
    
    public ArrayList<Customer> listCustomer() {
        ArrayList<Customer> customers = new ArrayList<>();
        
        try {
            PreparedStatement ps;
            ResultSet rs;
            
            String query = "SELECT * FROM clientes";
            
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
    
    public Customer searchCustomer(int id) {
        try {
            PreparedStatement ps;
            ResultSet rs;
            
            String query = "SELECT ClienteID, Nombre, Email  FROM Clientes WHERE ClienteID = ?";
            
            ps = con.prepareStatement(query);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            
            if (rs.next()) {
                return getCustomer(rs);
            }
        } catch (SQLException ex) {
            System.err.println(ex.toString());
        }
        return null;
    }
    
    public void addCustomer(Customer customer) throws SQLException {
        try {
            PreparedStatement ps;
            
            String query = "INSERT INTO Clientes (ClienteID, Nombre, Email) VALUES (?, ?,?)";
            
            ps = con.prepareStatement(query);
            
            ps.setInt(1, customer.getCustomerId());
            ps.setString(2, customer.getName());
            ps.setString(3, customer.getEmail());
            
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.err.println(ex.toString());
            throw new SQLException();
        }
    }
    
    public void updatedCustomer(int id, String name, String email) throws SQLException {
        try {
            PreparedStatement ps;
            
            String query = "UPDATE Clientes SET Nombre = ? , email = ? WHERE ClienteID = ?";
            
            ps = con.prepareStatement(query);
            ps.setString(1, name);
            ps.setString(2, email);
            ps.setInt(3, id);
            
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.err.println(ex.toString());
            throw new SQLException();
        }
    }
    
    public void deleteCustomer(int id) {
        try {
            PreparedStatement ps;
            
                String query = "DELETE FROM Clientes WHERE ClienteID = ? AND NOT EXISTS (SELECT 1 FROM Pedidos WHERE ClienteID = ?)";
            
            ps = con.prepareStatement(query);
            ps.setInt(1, id);
            ps.setInt(2, id);
            
            int rowsDeleted = ps.executeUpdate();
            
            if (rowsDeleted == 0) {
                throw new CustomerException("No se pudo eliminar el clientes con id: " + id);
            }
        } catch (SQLException ex) {
            System.err.println(ex.toString());
        }
    }
    
    private Customer getCustomer(ResultSet rs) throws SQLException {
        int id = rs.getInt("ClienteID");
        String name = rs.getString("Nombre");
        String email = rs.getString("Email");
        
        return new Customer(id, name, email);
    }
    
}
