/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package petadoptionconsortium;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
/**
 *
 * @author Doug
 */
public class AssignFosterSuccess extends javax.swing.JPanel {

    /**
     * Creates new form AssignFosterSuccess
     */
    public AssignFosterSuccess() {
        Connection connection = null;
        PreparedStatement pstatement = null;
        PreparedStatement pstatementPre = null;
        PreparedStatement pstatementPost = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(PetAdoptionConsortium.CONN_STRING,"root","");
            String query = "UPDATE `Pet` SET FosterName = ?, FosterPhone = ? WHERE PetID = ?;";
            pstatement = connection.prepareStatement(query);
            pstatementPre = connection.prepareStatement("SET FOREIGN_KEY_CHECKS = 0;");
            pstatementPost = connection.prepareStatement("SET FOREIGN_KEY_CHECKS = 1;");
            pstatement.setString(1,AssignFoster.fosterNameChoice);
            pstatement.setString(2,AssignFoster.fosterPhoneChoice);
            pstatement.setString(3,AssignFoster.petIDChoice);
            pstatementPre.execute();
            pstatement.executeUpdate();
            pstatementPost.execute();
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
                pstatement.close();
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
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        jLabel1.setText("Atlanta Pet Adoption Consortium");

        jButton1.setText("Return to Menu");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel2.setText("You have successfully assigned a pet to a foster home.");

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/petadoptionconsortium/imagepackage/adoption5.jpg"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel1))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(197, 197, 197)
                                .addComponent(jLabel2)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 178, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(177, 177, 177))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(50, 50, 50)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 102, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        PetAdoptionConsortium.currentScreen = PetAdoptionConsortium.EMPLOYEE_MENU;
        PetAdoptionConsortium.changeScreen = true;// TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    // End of variables declaration//GEN-END:variables
}
