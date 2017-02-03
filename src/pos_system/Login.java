/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pos_system;

import Back_End.admin;
import DB.DB;
import Encription_Decription.Encription_Decription;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import javax.swing.AbstractAction;
import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.JRootPane;
import javax.swing.KeyStroke;

/**
 *
 * @author Kelum
 */
public class Login extends javax.swing.JFrame {

    static String username;
    static String usertype;
    /**
     * Creates new form login
     */
    static String user;

    public Login() {
        initComponents();
        enter();
        
        System.out.println(Encription_Decription.encription("admin", 3));
        
        //expire();
    }

//    public void expire() {
//        Date date = new Date();
//        Calendar cal = Calendar.getInstance();
//        cal.setTime(date);
//        cal.add(Calendar.DATE, 0);
//
//        java.util.Date expirationDate = cal.getTime();
//        System.err.println(expirationDate);
//        if (expirationDate.equals(date) || expirationDate == date) {
//            this.dispose();
//            new expire().setVisible(true);
//        } else {
//            this.dispose();
//            new login().setVisible(true);
//        }
//    }
    public void enter() {
        JRootPane a = getRootPane();
        InputMap im = a.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
        ActionMap am = a.getActionMap();
        KeyStroke enter = KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0);
        im.put(enter, "enter");
        am.put("enter", new AbstractAction() {
            public void actionPerformed(ActionEvent e) {
                //callto  second methard
                login();
            }
        });
    }

    public void login() {
        try {
            user = jTextField1.getText();
            Connection com = DB.conect();
            char[] password = jPasswordField1.getPassword();
            String pass = Arrays.toString(password);
            String enpass = Encription_Decription.encription(pass, 3);
            String enpassf = Encription_Decription.encription(jPasswordField1.getText(), 3);
  System.out.println(enpassf);
            
            ResultSet r = com.createStatement().executeQuery("select * from login where username='" + jTextField1.getText().trim() + "'and password='" + enpassf + "'");
            boolean b = false;
            while (r.next()) {
                b = true;
                username = r.getString("username");
                usertype = r.getString("usertype");

            }
            if (b) {
                this.dispose();
                if (usertype == "admin" || usertype.equals("admin")) {
                    new admin().setVisible(true);
                } else {
                    new user().setVisible(true);
                }

            } else {
                JOptionPane.showMessageDialog(null, "wrong user");
            }
        } catch (Exception e) {
            e.printStackTrace();
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

        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jPasswordField1 = new javax.swing.JPasswordField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("LOGIN");
        setBackground(new java.awt.Color(0, 0, 255));
        setForeground(new java.awt.Color(51, 153, 255));
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(null);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setText("User Name");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(40, 40, 110, 25);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setText("Password");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(40, 130, 90, 25);

        jTextField1.setBackground(new java.awt.Color(231, 245, 255));
        getContentPane().add(jTextField1);
        jTextField1.setBounds(170, 40, 190, 30);

        jPasswordField1.setBackground(new java.awt.Color(231, 245, 255));
        getContentPane().add(jPasswordField1);
        jPasswordField1.setBounds(170, 130, 190, 30);

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton1.setText("Login");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(50, 230, 110, 30);

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton2.setText("Cancel");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(230, 230, 120, 30);

        setSize(new java.awt.Dimension(500, 400));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        login();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        int i = JOptionPane.showConfirmDialog(null, "Do You Want to Exit");
        if (i == 0) {
            System.exit(0);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {

                new Login().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
