
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author laurence
 */
public class product_class {
    public int addProduct(String product_name, int quantity, String price){
        int ruela=0;
        String sql = "INSERT INTO product VALUES(null,?,?,?);";
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = (Connection)DriverManager.getConnection("jdbc:mysql://localhost/berioreg?", "root", "");
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, product_name);
            pstmt.setInt(2, quantity);
            pstmt.setString(3, price);
            ruela=pstmt.executeUpdate();
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(product_class.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(product_class.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        return ruela;
        
    }
    public int product_addQty(int id, Object qty){int y = 0;
        try{
    String sql = "update product set Quantity =Quantity+ ? where ID=?;";
    Class.forName("com.mysql.jdbc.Driver");
    Connection conn = (Connection)DriverManager.getConnection("jdbc:mysql://localhost/berioreg?", "root", "");
    PreparedStatement pstmt = conn.prepareStatement(sql);
    
    pstmt.setString(1, qty.toString());
    pstmt.setInt(2, id);
    y=pstmt.executeUpdate();
    
    
}       catch (ClassNotFoundException ex) {
            Logger.getLogger(product_class.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(product_class.class.getName()).log(Level.SEVERE, null, ex);
        }return y; 
    }   
}
