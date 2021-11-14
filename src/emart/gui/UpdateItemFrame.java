/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package emart.gui;

import emart.dao.ProductsDAO;
import emart.pojo.ProductsPojo;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author KRATI VAISHNAO
 */
public class UpdateItemFrame extends javax.swing.JFrame {

    DefaultTableModel dfm;
    public UpdateItemFrame() {
        initComponents();
        this.setLocationRelativeTo(null);
        loadProductsDetails(); 
    }
     private boolean validateInputs()
    {
        return !(txtProductId.getText().isEmpty() || txtProductComp.getText().isEmpty() || txtProductPrice.getText().isEmpty() || txtProductName.getText().isEmpty() || txtOurPrice.getText().isEmpty() || txtQuantity.getText().isEmpty() || jcTax.getSelectedIndex() == -1);
    }


    private void loadProductsDetails() {
        try
        {
            List<ProductsPojo> productList = ProductsDAO.getProductDetails();
            if(productList.isEmpty())
            {
                 JOptionPane.showMessageDialog(null, "No products are added yet!","Error!",JOptionPane.ERROR_MESSAGE);
                 return;
            }
            Object [] rows = new Object[7];
            dfm = (DefaultTableModel)tbProducts.getModel();
            for(ProductsPojo p : productList)
            {
                rows[0] = p.getProductId();
                rows[1] = p.getProductName();
                rows[2] = p.getProductCompany();
                rows[3] = p.getProductPrice();
                rows[4] = p.getOurPrice();
                rows[5] = p.getQuantity();
                rows[6] = p.getTax()+"%";
                dfm.addRow(rows);
                
            }
        }
        catch(SQLException ex)
        {
             JOptionPane.showMessageDialog(null, "DB Error!","Error!",JOptionPane.ERROR_MESSAGE);
             ex.printStackTrace();
             return;
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel4 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnBack = new javax.swing.JButton();
        btnLogout = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        lblProductId = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        txtQuantity = new javax.swing.JTextField();
        txtOurPrice = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        txtProductPrice = new javax.swing.JTextField();
        txtProductComp = new javax.swing.JTextField();
        txtProductName = new javax.swing.JTextField();
        jLabel29 = new javax.swing.JLabel();
        txtProductId = new javax.swing.JTextField();
        jcTax = new javax.swing.JComboBox<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbProducts = new javax.swing.JTable();
        btnUpdate = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel4.setBackground(new java.awt.Color(204, 0, 0));

        jPanel7.setBackground(new java.awt.Color(204, 0, 0));

        jLabel1.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Update Item Panel");

        btnBack.setBackground(new java.awt.Color(204, 0, 51));
        btnBack.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        btnBack.setForeground(new java.awt.Color(255, 255, 255));
        btnBack.setText("Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        btnLogout.setBackground(new java.awt.Color(204, 0, 51));
        btnLogout.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        btnLogout.setForeground(new java.awt.Color(255, 255, 255));
        btnLogout.setText("Logout");
        btnLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogoutActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(67, 67, 67)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 410, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(138, 138, 138)
                .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(btnLogout, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(72, 72, 72)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLogout, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(76, Short.MAX_VALUE))
        );

        jPanel8.setBackground(new java.awt.Color(204, 0, 0));
        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Update Item", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 36), new java.awt.Color(255, 255, 255))); // NOI18N

        lblProductId.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        lblProductId.setForeground(new java.awt.Color(255, 255, 255));
        lblProductId.setText("Product Id");

        jLabel24.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(255, 255, 255));
        jLabel24.setText("Product Name");

        jLabel25.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(255, 255, 255));
        jLabel25.setText("Tax");

        txtQuantity.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        txtQuantity.setForeground(new java.awt.Color(51, 51, 51));

        txtOurPrice.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        txtOurPrice.setForeground(new java.awt.Color(51, 51, 51));

        jLabel26.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(255, 255, 255));
        jLabel26.setText("Product Company");

        jLabel27.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(255, 255, 255));
        jLabel27.setText("Quantity");

        jLabel28.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(255, 255, 255));
        jLabel28.setText("Product Price");

        txtProductPrice.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        txtProductPrice.setForeground(new java.awt.Color(51, 51, 51));

        txtProductComp.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        txtProductComp.setForeground(new java.awt.Color(51, 51, 51));

        txtProductName.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        txtProductName.setForeground(new java.awt.Color(51, 51, 51));

        jLabel29.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(255, 255, 255));
        jLabel29.setText("Our Price");

        txtProductId.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        txtProductId.setForeground(new java.awt.Color(51, 51, 51));

        jcTax.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jcTax.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "0%", "5%", "18%", "28%", " " }));

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(301, 301, 301)
                                .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel8Layout.createSequentialGroup()
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel8Layout.createSequentialGroup()
                                        .addComponent(lblProductId, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(37, 37, 37)
                                        .addComponent(txtProductId, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel8Layout.createSequentialGroup()
                                        .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(37, 37, 37)
                                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jcTax, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtProductName, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(72, 72, 72)
                                .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtProductPrice, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtOurPrice, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel8Layout.createSequentialGroup()
                        .addGap(476, 476, 476)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
                                .addComponent(txtProductComp, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(188, 188, 188))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblProductId)
                            .addComponent(txtProductId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtProductComp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel26))))
                .addGap(18, 18, 18)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel27)
                    .addComponent(txtQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel24)
                    .addComponent(txtProductName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(2, 2, 2)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtProductPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel28))
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel29)
                            .addComponent(txtOurPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel25)
                            .addComponent(jcTax, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(65, Short.MAX_VALUE))
        );

        tbProducts.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        tbProducts.setForeground(new java.awt.Color(51, 51, 51));
        tbProducts.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Product Id", "Product Name", "Product Company", "Product Price", "Our Price", "Quantity", "Tax"
            }
        ));
        tbProducts.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbProductsMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbProducts);

        btnUpdate.setBackground(new java.awt.Color(204, 0, 51));
        btnUpdate.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        btnUpdate.setForeground(new java.awt.Color(255, 255, 255));
        btnUpdate.setText("Update");
        btnUpdate.setEnabled(false);
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(423, 423, 423)
                .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
         if(!validateInputs())
         {
             JOptionPane.showMessageDialog(null, "Please fill all the fields!","Error!",JOptionPane.ERROR_MESSAGE);
             return;
         }
         try
         {
             int n = jcTax.getSelectedItem().toString().length();
             int tax = Integer.parseInt(jcTax.getSelectedItem().toString().substring(0,n-1));
             ProductsPojo p = new ProductsPojo();
             p.setProductId(txtProductId.getText());
             p.setProductName(txtProductName.getText());
             p.setProductCompany(txtProductComp.getText());
             p.setProductPrice(Double.parseDouble(txtProductPrice.getText()));
             p.setOurPrice(Double.parseDouble(txtOurPrice.getText()));
             p.setQuantity(Integer.parseInt(txtQuantity.getText()));
             p.setTax(tax);
             boolean result = ProductsDAO.updateProduct(p);
             if(result)
             {
                  JOptionPane.showMessageDialog(null, "Item updated successfully","Success!",JOptionPane.INFORMATION_MESSAGE);
                  dfm.setRowCount(0);
                  btnUpdate.setEnabled(false);
                  loadProductsDetails();
                  return;
             }
              JOptionPane.showMessageDialog(null, "Item not updated! Please try again!","Error!",JOptionPane.ERROR_MESSAGE);
         }
         catch(SQLException ex)
         {
             JOptionPane.showMessageDialog(null, "DB Error!","Error!",JOptionPane.ERROR_MESSAGE);
             ex.printStackTrace();
             return;
         }
         catch(NumberFormatException ex)
         {
             JOptionPane.showMessageDialog(null, "Please input numeric data!","Error!",JOptionPane.ERROR_MESSAGE);
             ex.printStackTrace();
             return;
         }
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void tbProductsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbProductsMouseClicked
         int row = tbProducts.getSelectedRow();
         txtProductId.setText(dfm.getValueAt(row, 0).toString());
         txtProductName.setText(dfm.getValueAt(row, 1).toString());
         txtProductComp.setText(dfm.getValueAt(row, 2).toString());
         txtProductPrice.setText(dfm.getValueAt(row, 3).toString());
         txtOurPrice.setText(dfm.getValueAt(row,4).toString());
         txtQuantity.setText(dfm.getValueAt(row, 5).toString());
         String tax = dfm.getValueAt(row, 6).toString();
         jcTax.setSelectedItem(tax);
         btnUpdate.setEnabled(true);
    }//GEN-LAST:event_tbProductsMouseClicked

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
         ManageStocksFrame msframe = new ManageStocksFrame();
        msframe.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogoutActionPerformed
         LoginFrame lframe = new LoginFrame();
        lframe.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnLogoutActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(UpdateItemFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UpdateItemFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UpdateItemFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UpdateItemFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UpdateItemFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnLogout;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JComboBox<String> jcTax;
    private javax.swing.JLabel lblProductId;
    private javax.swing.JTable tbProducts;
    private javax.swing.JTextField txtOurPrice;
    private javax.swing.JTextField txtProductComp;
    private javax.swing.JTextField txtProductId;
    private javax.swing.JTextField txtProductName;
    private javax.swing.JTextField txtProductPrice;
    private javax.swing.JTextField txtQuantity;
    // End of variables declaration//GEN-END:variables
}
