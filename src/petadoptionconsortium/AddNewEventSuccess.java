/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package petadoptionconsortium;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import static petadoptionconsortium.AddNewPet.ageChoice;
import static petadoptionconsortium.AddNewPet.breedChoice;
import static petadoptionconsortium.AddNewPet.genderChoice;
import static petadoptionconsortium.AddNewPet.nameChoice;
import static petadoptionconsortium.AddNewPet.petID;
import static petadoptionconsortium.AddNewPet.typeChoice;

/**
 *
 * @author Doug
 */
public class AddNewEventSuccess extends javax.swing.JPanel {

    /**
     * Creates new form AddNewEventSuccess
     */
    private String[][] choices = AddNewEvent.choices;
    public AddNewEventSuccess() {        
        Connection connection = null;
        PreparedStatement pstatement1 = null;
        PreparedStatement[] pstatement2 = new PreparedStatement[4];
        PreparedStatement pstatement3 = null;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(PetAdoptionConsortium.CONN_STRING,"root","");
            String insertQuery = new String();
            String prefixQuery = "SET FOREIGN_KEY_CHECKS = 0; \n";

            insertQuery = "INSERT INTO `Event` (`EventDate`, `Location`, `SponsoredShelterName`, `Type`, `Description`) "
                    + "Values (?,?,?,?,?); \n";
            String suffixQuery = "SET FOREIGN_KEY_CHECKS = 1; \n";
            pstatement1 = connection.prepareStatement(prefixQuery);
            pstatement3 = connection.prepareStatement(suffixQuery);
            pstatement1.execute();
            for(int i = 0; i < 4; i++) {
                if (!choices[i][0].equals("")) {
                    pstatement2[i] = connection.prepareStatement(insertQuery);
                    pstatement2[i].setString(1, choices[i][2]);
                    pstatement2[i].setString(2, choices[i][1]);
                    pstatement2[i].setString(3,PetAdoptionConsortium.shelterName);
                    pstatement2[i].setString(4, choices[i][0]);
                    pstatement2[i].setString(5, choices[i][3]);
                    pstatement2[i].executeUpdate();
                }
            }
            pstatement3.execute();
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
                pstatement1.close();
                pstatement3.close();
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
        jButton1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(730, 630));

        jLabel1.setText("Atlanta Pet Adoption Consortium");

        jButton1.setText("Return to Menu");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel3.setText("You have successfully added a new event.");

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/petadoptionconsortium/imagepackage/adopt4.jpg"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton1))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel1))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(198, 198, 198)
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel2))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(231, 231, 231)
                                .addComponent(jLabel3)))
                        .addGap(0, 199, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(83, 83, 83)
                .addComponent(jLabel3)
                .addGap(28, 28, 28)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
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
    private javax.swing.JLabel jLabel4;
    // End of variables declaration//GEN-END:variables
}
