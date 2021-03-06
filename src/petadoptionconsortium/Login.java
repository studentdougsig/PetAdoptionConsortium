/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package petadoptionconsortium;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.sql.SQLException;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.DefaultComboBoxModel;


/**
 *
 * @author Doug
 */
public class Login extends javax.swing.JPanel {
    /**
     * Creates new form Login
     */  
    private Vector shelterNames;
    private Vector validCredentials;
    private int numberOfColumns;
    private int numberOfRows;
    public Login() {
        
        Connection connection = null;
        Statement statement = null;
        java.sql.ResultSet shelterResultSet = null;
        java.sql.ResultSet credentialsResultSet = null;
        ResultSetMetaData metaData = null;
        ResultSetMetaData credentialsMetaData = null;
        this.numberOfColumns = 0;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(PetAdoptionConsortium.CONN_STRING,"root","");
            statement = connection.createStatement();
            
            
            shelterResultSet = statement.executeQuery("SELECT DISTINCT WorksAtShelterName FROM Employee");
            this.shelterNames = new Vector();
            while (shelterResultSet.next()) {
                this.shelterNames.addElement(shelterResultSet.getObject(1));
            }
            
            
            credentialsResultSet = statement.executeQuery("SELECT * FROM Employee");
            credentialsMetaData = credentialsResultSet.getMetaData();
            this.numberOfColumns = credentialsMetaData.getColumnCount();
            this.validCredentials = new Vector();
            int n = 0;
            while (credentialsResultSet.next()) {
                Vector newRow = new Vector();
                for(int i = 1; i <= this.numberOfColumns; i++) {
                    newRow.addElement(credentialsResultSet.getObject(i));
                }
                n++;
                validCredentials.addElement(newRow);
            }
            numberOfRows = n;
            
            
            
            
        }
        catch(SQLException sqlException) {
            sqlException.printStackTrace();
            System.exit(1);
        }
        catch(ClassNotFoundException classNotFound) {
            classNotFound.printStackTrace();
            System.exit(1);
        }
        finally {
            try {
                statement.close();
                connection.close();
            }
            catch(Exception exception) {
                exception.printStackTrace();
                System.exit(1);
            }
        }
        
        
        initComponents();
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        passwordTextField = new javax.swing.JPasswordField();
        empNumTextField = new javax.swing.JTextField();
        guestLoginButton = new javax.swing.JButton();
        employeeLoginButton = new javax.swing.JButton();
        shelterNameComboBox = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();

        jLabel1.setText("Atlanta Pet Adoption Consortium");

        jLabel2.setText("Guest");

        jLabel3.setText("Employee");

        jLabel5.setText("Shelter Name");

        jLabel6.setText("EmpNum");

        jLabel7.setText("Password");

        guestLoginButton.setText("Login");
        guestLoginButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guestLoginButtonActionPerformed(evt);
            }
        });

        employeeLoginButton.setText("Login");
        employeeLoginButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                employeeLoginButtonActionPerformed(evt);
            }
        });

        shelterNameComboBox.setModel(new DefaultComboBoxModel(shelterNames));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/petadoptionconsortium/imagepackage/adopt2.jpg"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(67, 67, 67)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(guestLoginButton)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(employeeLoginButton))
                                .addGap(18, 18, 18)
                                .addComponent(shelterNameComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel6))
                                .addGap(41, 41, 41)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(passwordTextField)
                                    .addComponent(empNumTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 182, Short.MAX_VALUE)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(84, 84, 84)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(guestLoginButton))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(shelterNameComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(empNumTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(passwordTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(employeeLoginButton)))
                .addContainerGap(306, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void guestLoginButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guestLoginButtonActionPerformed
       PetAdoptionConsortium.currentScreen = PetAdoptionConsortium.GUEST_MENU; // TODO add your handling code here:
       PetAdoptionConsortium.changeScreen = true;
       
    }//GEN-LAST:event_guestLoginButtonActionPerformed

    private void employeeLoginButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_employeeLoginButtonActionPerformed
        Vector credentials = new Vector();
        credentials.addElement(empNumTextField.getText());
        credentials.addElement(new String(passwordTextField.getPassword()));
        String shelt = shelterNameComboBox.getSelectedItem().toString();
        credentials.addElement(shelt);
        PetAdoptionConsortium.shelterName = shelt;
        //System.out.println(PetAdoptionConsortium.shelterName);
        //System.exit(1);
        for (int i = 0; i < numberOfRows; i++) {
            if(validCredentials.get(i).equals(credentials)) {
                PetAdoptionConsortium.currentScreen = PetAdoptionConsortium.EMPLOYEE_MENU;// TODO add your handling code here:
                PetAdoptionConsortium.changeScreen = true;
            }
        }
    }//GEN-LAST:event_employeeLoginButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField empNumTextField;
    private javax.swing.JButton employeeLoginButton;
    private javax.swing.JButton guestLoginButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPasswordField passwordTextField;
    private javax.swing.JComboBox shelterNameComboBox;
    // End of variables declaration//GEN-END:variables
}
