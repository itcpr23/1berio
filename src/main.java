
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author LENOVO
 */
public class main extends javax.swing.JFrame {

    /**
     * Creates new form main
     */
    public main() {
        initComponents();
        refresh();
    }
    Object id="";
    public void search(){
         String prodname = sflds.getText();
         try{
             String sql = "select * from product where Product_Name like ?;";
             Class.forName("com.mysql.jdbc.Driver");
             Connection conn = (Connection)DriverManager.getConnection("jdbc:mysql://localhost/berioreg?", "root", "");
             PreparedStatement pstmt = conn.prepareStatement(sql);
             pstmt.setString(1, "%"+prodname+"%");
             ResultSet rs = pstmt.executeQuery();
             DefaultTableModel tbl1 = (DefaultTableModel)table1.getModel();
             tbl1.setRowCount(0);
             if(!rs.isBeforeFirst()){
                 tbl1.addRow(new Object[]{"NO DATA", "NO DATA", "NO DATA", "NO DATA"});
             }else{
                 while(rs.next()){
                     tbl1.addRow(new Object[]{rs.getString("ID"),rs.getString("Product_name"),rs.getString("Quantity"),rs.getString("Price")});
                 }
             }
         } catch (ClassNotFoundException ex) {
            Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void refresh(){
        String sql = "SELECT * FROM product;";
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = (Connection)DriverManager.getConnection("jdbc:mysql://localhost/berioreg?", "root", "");
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            DefaultTableModel tab = (DefaultTableModel)table1.getModel();
            tab.setRowCount(0);
            while(rs.next()){
             tab.addRow(new Object[]{rs.getString("ID"),rs.getString("Product_Name"),rs.getInt("Quantity"),rs.getString("Price")});
            }
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        addFrame = new javax.swing.JFrame();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        pn = new javax.swing.JTextField();
        qt = new javax.swing.JSpinner();
        pr = new javax.swing.JFormattedTextField();
        ab = new javax.swing.JButton();
        sb = new javax.swing.JButton();
        idl = new javax.swing.JLabel();
        addq = new javax.swing.JButton();
        qnty = new javax.swing.JLabel();
        ab1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        sflds = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();

        addFrame.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addFrame.setMinimumSize(new java.awt.Dimension(450, 360));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("PRODUCT NAME:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("QUANTITY:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setText("PRICE:");

        qt.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));

        pr.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter()));
        pr.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        ab.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        ab.setText("ADD");
        ab.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                abActionPerformed(evt);
            }
        });

        sb.setText("SAVE");
        sb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sbActionPerformed(evt);
            }
        });

        idl.setText("jLabel5");

        addq.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        addq.setText("ADD QUANTITY");
        addq.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addqActionPerformed(evt);
            }
        });

        ab1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        ab1.setText("Back");
        ab1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ab1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout addFrameLayout = new javax.swing.GroupLayout(addFrame.getContentPane());
        addFrame.getContentPane().setLayout(addFrameLayout);
        addFrameLayout.setHorizontalGroup(
            addFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addFrameLayout.createSequentialGroup()
                .addGroup(addFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(addFrameLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(addFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(addFrameLayout.createSequentialGroup()
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(pr))
                            .addGroup(addFrameLayout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(qnty, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(qt, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(addFrameLayout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(addFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(pn)
                                    .addGroup(addFrameLayout.createSequentialGroup()
                                        .addComponent(idl, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE))))))
                    .addGroup(addFrameLayout.createSequentialGroup()
                        .addGap(171, 171, 171)
                        .addGroup(addFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(ab, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(sb, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(addq, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addComponent(ab1, javax.swing.GroupLayout.DEFAULT_SIZE, 117, Short.MAX_VALUE)
                        .addGap(17, 17, 17)))
                .addContainerGap())
        );
        addFrameLayout.setVerticalGroup(
            addFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addFrameLayout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addComponent(idl, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(addFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pn, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(52, 52, 52)
                .addGroup(addFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(qt)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(qnty, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(44, 44, 44)
                .addGroup(addFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                    .addComponent(pr))
                .addGap(26, 26, 26)
                .addGroup(addFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ab, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ab1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sb, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(addq, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("HELLO !");

        table1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "PRODUCT NAME", "QUANTITY", "PRICE"
            }
        ));
        jScrollPane1.setViewportView(table1);

        jButton1.setText("ADD");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton3.setText("DELETE");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("EDIT");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jLabel5.setText("PRODUCT NAME:");

        sflds.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                sfldsKeyReleased(evt);
            }
        });

        jButton2.setText("ADD QUANTITY");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 510, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(sflds)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(43, 43, 43)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(sflds, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(29, 29, 29)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(54, 54, 54)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(6, 6, 6)))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
this.setVisible(false);addFrame.setVisible(true);addFrame.setLocationRelativeTo(null);
pn.setEnabled(true);qt.setEnabled(true);pr.setEnabled(true);
qnty.setText("");pn.setText("");qt.setValue(0);pr.setText("");
addq.setVisible(false); sb.setVisible(false); ab.setVisible(true);
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void abActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_abActionPerformed
product_class pc = new product_class();
        
String pname = pn.getText();
int qty = (int)qt.getValue();
String pric = pr.getText();

int we = pc.addProduct(pname, qty, pric);
refresh();
if(we==1){
    JOptionPane.showMessageDialog(rootPane, "PRODUCT ADDED");
}else{
    
}
pn.setText("");
pr.setText("");
        // TODO add your handling code here:
    }//GEN-LAST:event_abActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        int selRow = table1.getSelectedRow();
        if (selRow != -1) {// meaning the row is valid
            int column = 0;  // the ID is located at the first column
            String id = table1
                    .getValueAt(selRow, column).toString();
            int ans = JOptionPane.showConfirmDialog(null,
                    "Are you sure you want to delete this product?",
                    "Delete Confirmation",
                    JOptionPane.YES_NO_OPTION);

            if (ans == JOptionPane.YES_OPTION) {    // YES
                try {
                    Class.forName("com.mysql.jdbc.Driver");// the connector
                    String conURL = "jdbc:mysql://localhost/berioreg?"
                            + "user=root&password=";
                    Connection con = DriverManager.getConnection(conURL);
                    PreparedStatement pstmt = con.prepareStatement("DELETE FROM product WHERE id = ? ");
                    pstmt.setString(1, id);
                    pstmt.executeUpdate();

                    refresh();

                } catch (ClassNotFoundException | SQLException ex) {
                    Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } else { // meaning if the row is invalid ( -1 )
            JOptionPane.showMessageDialog(null, "Please select one to be deleted",
                    "No record selected",
                    JOptionPane.WARNING_MESSAGE);
            // TODO add your handling code here:
        }                            // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
int row =table1.getSelectedRow();
if(row==-1){
    JOptionPane.showMessageDialog(table1, "PLEASE SELECT DATA ON THE TABLE","ERROR",JOptionPane.ERROR_MESSAGE);
}else{
    pn.setEnabled(true);qt.setEnabled(false);pr.setEnabled(true);
qnty.setText("");pn.setText("");qt.setValue(0);pr.setText("");
    addq.setVisible(false); sb.setVisible(true); ab.setVisible(false);
    int opti = JOptionPane.showConfirmDialog(table1, "ARE YOU SURE YOU WANT TO EDIT THIS DATA?","CONFIRMATION",JOptionPane.YES_NO_OPTION);
    if(opti==JOptionPane.YES_OPTION){
    String id = table1.getValueAt(row, 0).toString();
    String prdname = table1.getValueAt(row, 1).toString();
    String qu = table1.getValueAt(row, 2).toString();
    String popri = table1.getValueAt(row, 3).toString();
    idl.setText(id);
    pn.setText(prdname);
    qt.setToolTipText(qu);
    pr.setText(popri);
    
    
}
}addFrame.setVisible(true);this.setVisible(false);addFrame.setLocationRelativeTo(null);ab.setVisible(false);sb.setVisible(true);qt.setEnabled(false);        // TODO add your handling code here:
    }//GEN-LAST:event_jButton4ActionPerformed

    private void sbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sbActionPerformed
int id = Integer.parseInt(idl.getText());
String prdname = pn.getText();
String prqu = qt.getToolTipText();
String prci = pr.getText();

try{
    String sql = "update product set Product_Name=?, Price=? where ID=?;";
    Class.forName("com.mysql.jdbc.Driver");
    Connection conn = (Connection)DriverManager.getConnection("jdbc:mysql://localhost/berioreg?", "root", "");
    PreparedStatement pstmt = conn.prepareStatement(sql);
    
    pstmt.setString(1, prdname);
    pstmt.setString(2, prci);
    pstmt.setInt(3, id);
     if(pn.getText().equals("") || pr.getText().equals("")){
         JOptionPane.showMessageDialog(addFrame, "PLEASE FILL UP ALL FIELDS","WARNING",JOptionPane.WARNING_MESSAGE);
     }else{
         pstmt.executeUpdate();
        pn.setText("");
        pr.setText("");
        addFrame.setVisible(false);
        main mnp = new main();
        mnp.setVisible(true);  
     }
    
    
}       catch (ClassNotFoundException ex) {
            Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
        }

        // TODO add your handling code here:
    }//GEN-LAST:event_sbActionPerformed

    private void sfldsKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_sfldsKeyReleased
search();        // TODO add your handling code here:
    }//GEN-LAST:event_sfldsKeyReleased

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        pn.setEnabled(false);qt.setEnabled(true);pr.setEnabled(false);
        addq.setVisible(true); sb.setVisible(false); ab.setVisible(false);
qnty.setText("");pn.setText("");qt.setValue(0);pr.setText("");
        int c = table1.getSelectedRow();
        if (c!= -1){
            addFrame.setVisible(true);ab.setVisible(false);sb.setVisible(false);
           pn.setEnabled(false);
           pr.setEnabled(false);
           
           id=table1.getValueAt(c, 0);
           Object pron = table1.getValueAt(c, 1);
           Object proq  = table1.getValueAt(c, 2);
           Object prop = table1.getValueAt(c, 3);
           
           pn.setText(pron.toString());
           qnty.setText(proq.toString());
           pr.setText(Integer.parseInt(prop.toString())+"");
            
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void addqActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addqActionPerformed
int a = new product_class().product_addQty(Integer.parseInt(id.toString()),qt.getValue());
refresh();addFrame.setVisible(false);
// TODO add your handling code here:
    }//GEN-LAST:event_addqActionPerformed

    private void ab1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ab1ActionPerformed
addFrame.setVisible(false);this.setVisible(true);        // TODO add your handling code here:
    }//GEN-LAST:event_ab1ActionPerformed

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
            java.util.logging.Logger.getLogger(main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ab;
    private javax.swing.JButton ab1;
    private javax.swing.JFrame addFrame;
    private javax.swing.JButton addq;
    private javax.swing.JLabel idl;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField pn;
    private javax.swing.JFormattedTextField pr;
    private javax.swing.JLabel qnty;
    private javax.swing.JSpinner qt;
    private javax.swing.JButton sb;
    private javax.swing.JTextField sflds;
    private javax.swing.JTable table1;
    // End of variables declaration//GEN-END:variables
}
