/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view.Customers;

import controller.ControllerCustomer;
import exceptions.CustomerException;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Customer;
import view.main.MainView;

/**
 *
 * @author joanp
 */
public class CustomersManagmentView extends javax.swing.JFrame {

    private final ControllerCustomer controller;

    /**
     * Creates new form CustomersManagment
     */
    public CustomersManagmentView() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setTitle("Clientes");
        controller = new ControllerCustomer();
        fillTable();
    }

    private void fillTable() {
        DefaultTableModel model = new DefaultTableModel();

        ArrayList<Customer> customers = controller.listCustomer();
        model.setColumnIdentifiers(new Object[]{
            "ID", "Nombre", "Email"
        });

        categoriesTable.setModel(model);

        for (Customer customer : customers) {
            model.addRow(new Object[]{
                customer.getCustomerId(),
                customer.getName(),
                customer.getEmail()
            });
        }

    }

    private void cleanFields() {
        txtId.setText("");
        txtName.setText("");
        txtEmail.setText("");
        txtFilter.setText("");
    }

    private void cleanTable() {
        DefaultTableModel model = (DefaultTableModel) categoriesTable.getModel();
        model.setRowCount(0);
    }

    private boolean isEmptyFields() {
        return (txtId.getText().isEmpty() || txtName.getText().isEmpty() || txtEmail.getText().isEmpty());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainPanel = new javax.swing.JPanel();
        btnSearchCategory = new javax.swing.JButton();
        btnShowAllCategories = new javax.swing.JButton();
        txtName = new javax.swing.JTextField();
        btnClean = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        btnReturn = new javax.swing.JButton();
        btnAdd = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        categoriesTable = new javax.swing.JTable();
        btnUpdated = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        ID = new javax.swing.JLabel();
        txtFilter = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        mainPanel.setBackground(new java.awt.Color(255, 255, 255));

        btnSearchCategory.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        btnSearchCategory.setText("Buscar");
        btnSearchCategory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchCategoryActionPerformed(evt);
            }
        });

        btnShowAllCategories.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        btnShowAllCategories.setText("Ver todos");
        btnShowAllCategories.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnShowAllCategoriesActionPerformed(evt);
            }
        });

        txtName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNameKeyTyped(evt);
            }
        });

        btnClean.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        btnClean.setText("Limpiar");
        btnClean.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCleanActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("NOMBRE:");

        btnReturn.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        btnReturn.setText("Volver");
        btnReturn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnReturn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReturnActionPerformed(evt);
            }
        });

        btnAdd.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        btnAdd.setText("Registrar");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        categoriesTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        categoriesTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                categoriesTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(categoriesTable);

        btnUpdated.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        btnUpdated.setText("Editar");
        btnUpdated.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdatedActionPerformed(evt);
            }
        });

        btnDelete.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        btnDelete.setText("Eliminar");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        ID.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        ID.setForeground(new java.awt.Color(0, 0, 0));
        ID.setText("ID:");

        jLabel4.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("EMAIL:");

        txtId.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtIdKeyTyped(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("ID:");

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(mainPanelLayout.createSequentialGroup()
                                .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnUpdated, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(mainPanelLayout.createSequentialGroup()
                                .addGap(57, 57, 57)
                                .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)
                            .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)
                            .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 235, Short.MAX_VALUE)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addComponent(ID)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtFilter, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnSearchCategory)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnShowAllCategories)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnClean))
                    .addComponent(jScrollPane1))
                .addGap(72, 72, 72))
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(btnReturn, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addContainerGap(70, Short.MAX_VALUE)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(5, 5, 5)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnAdd)
                            .addComponent(btnUpdated))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnDelete))
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addGap(64, 64, 64)
                        .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(ID)
                            .addComponent(txtFilter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnSearchCategory)
                            .addComponent(btnShowAllCategories)
                            .addComponent(btnClean))
                        .addGap(15, 15, 15)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnReturn)
                .addGap(22, 22, 22))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSearchCategoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchCategoryActionPerformed
        int name = Integer.parseInt(txtFilter.getText().toLowerCase());
        if (name == 0) {
            JOptionPane.showMessageDialog(null, "Ingrese el nombre del cliente");
            return;
        }

        DefaultTableModel model = new DefaultTableModel();

        model.setColumnIdentifiers(new Object[]{
            "ID", "Nombre", "Email"
        });

        categoriesTable.setModel(model);
        Customer customer = controller.searchCustomer(name);

        if (customer != null) {
            model.addRow(new Object[]{
                customer.getCustomerId(),
                customer.getName(),
                customer.getEmail()
            });
        } else {
            JOptionPane.showMessageDialog(null, "Cliente no encontrado");
            fillTable();
            cleanFields();
        }
    }//GEN-LAST:event_btnSearchCategoryActionPerformed

    private void btnShowAllCategoriesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnShowAllCategoriesActionPerformed
        fillTable();
        cleanFields();
    }//GEN-LAST:event_btnShowAllCategoriesActionPerformed

    private void btnCleanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCleanActionPerformed
        cleanFields();
        cleanTable();
    }//GEN-LAST:event_btnCleanActionPerformed

    private void btnReturnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReturnActionPerformed
        new MainView().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnReturnActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        int id = Integer.parseInt(txtId.getText());
        String name = txtName.getText();
        String email = txtEmail.getText();

        if (isEmptyFields()) {
            JOptionPane.showMessageDialog(null, "Ingrese el nombre del cliente");
            return;
        }

        Customer customer = controller.searchCustomer(id);
        if (customer != null) {
            JOptionPane.showMessageDialog(null, "Ya existe un cliente con ese id");
            return;
        }

        try {
            Customer newCustomer = new Customer(id, name, email);
            controller.addCustomer(newCustomer);
            JOptionPane.showMessageDialog(null, "Cliente registrado correctamente");
            fillTable();
            cleanFields();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al registrar el cliente");
        }
    }//GEN-LAST:event_btnAddActionPerformed

    private void categoriesTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_categoriesTableMouseClicked
        int selected = categoriesTable.getSelectedRow();

        txtId.setText(categoriesTable.getValueAt(selected, 0).toString());
        txtName.setText(categoriesTable.getValueAt(selected, 1).toString());
        txtEmail.setText(categoriesTable.getValueAt(selected, 2).toString());
    }//GEN-LAST:event_categoriesTableMouseClicked

    private void btnUpdatedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdatedActionPerformed
        if (isEmptyFields()) {
            JOptionPane.showMessageDialog(null, "Ingrese todos los datos");
            return;
        }

        int id = Integer.parseInt(txtId.getText());
        String name = txtName.getText();
        String email = txtEmail.getText();

        try {
            controller.updatedCustomer(id, name, email);
            JOptionPane.showMessageDialog(null, "Categoria editada correctamente");
            fillTable();
            cleanFields();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al editar la categoría");
        }


    }//GEN-LAST:event_btnUpdatedActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        int selected = categoriesTable.getSelectedRow();

        if (selected >= 0) {

            int id = (int) categoriesTable.getModel().getValueAt(selected, 0);

            int answer = JOptionPane.showConfirmDialog(null, "¿Está seguro de eliminar la categoria?",
                    "Confirmación", JOptionPane.YES_NO_OPTION);

            if (answer == 0) {
                try {
                    controller.deleteCustomer(id);
                    fillTable();
                    JOptionPane.showMessageDialog(null, "Categoria eliminada correctamente");
                    cleanFields();
                } catch (CustomerException ex) {
                    JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
                    cleanFields();
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Seleccione una categoría de la tabla");
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void txtIdKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtIdKeyTyped
        char c = evt.getKeyChar();
        if (!Character.isDigit(c)) {
            evt.consume();
        }
    }//GEN-LAST:event_txtIdKeyTyped

    private void txtNameKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNameKeyTyped
        char c = evt.getKeyChar();
        if (Character.isDigit(c)) {
            evt.consume();
        }
    }//GEN-LAST:event_txtNameKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel ID;
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnClean;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnReturn;
    private javax.swing.JButton btnSearchCategory;
    private javax.swing.JButton btnShowAllCategories;
    private javax.swing.JButton btnUpdated;
    private javax.swing.JTable categoriesTable;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtFilter;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtName;
    // End of variables declaration//GEN-END:variables
}
