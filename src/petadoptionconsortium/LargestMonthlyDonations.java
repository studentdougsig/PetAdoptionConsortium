/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package petadoptionconsortium;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import static petadoptionconsortium.ShelterSearchResults.zipCode;

/**
 *
 * @author Doug
 */
public class LargestMonthlyDonations extends javax.swing.JPanel {
    private TableModel table;
    /**
     * Creates new form LargestMonthlyDonations
     */
    public LargestMonthlyDonations() {
        Connection connection = null;
        PreparedStatement pstatement = null;
        ResultSet resultSet = null;
        ResultSetMetaData metaData = null;
        int numberOfColumns = 0;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(PetAdoptionConsortium.CONN_STRING,"root","");
            
            String query =  "SELECT A.MonthTitle, A.Donor, A.Email, A.Phone, A.City, A.Amount "+
                            "FROM AllDonations A INNER JOIN TopDonations T ON (A.Amount = T.Top AND A.MonthNum = T.MonthNum) "+
                            "WHERE A.Shelter = ? "+
                            "ORDER BY A.MonthNum;";
            pstatement = connection.prepareStatement(query);
            pstatement.setString(1,PetAdoptionConsortium.shelterName);
            resultSet = pstatement.executeQuery();
            metaData = resultSet.getMetaData();
            numberOfColumns = metaData.getColumnCount();
            Vector columnNames = new Vector();
            for (int column = 0; column < numberOfColumns; column++) {
                columnNames.addElement(metaData.getColumnLabel(column+1));
            }
            Vector rows = new Vector();
            while (resultSet.next()) {
                Vector newRow = new Vector();
                for (int i = 1; i <= numberOfColumns; i++) {
                    newRow.addElement(resultSet.getObject(i));
                }
                //if (newRow.elementAt(3)==PetAdoptionConsortium.shelterName)
                rows.addElement(newRow);
            }
            this.table = new DefaultTableModel(rows,columnNames);
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
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        returnToMenuButton = new javax.swing.JButton();

        jLabel1.setText("Atlanta Pet Adoption Consortium");

        jLabel2.setText("Largest Monthly Donations for " + PetAdoptionConsortium.shelterName);

        jTable1.setModel(this.table);
        jScrollPane1.setViewportView(jTable1);

        jLabel3.setText(PetAdoptionConsortium.CURRENT_MONTH+" "+PetAdoptionConsortium.CURRENT_DAY+", "+PetAdoptionConsortium.CURRENT_YEAR);

        returnToMenuButton.setText("Return to Menu");
        returnToMenuButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                returnToMenuButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(returnToMenuButton))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(0, 521, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel3)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 253, Short.MAX_VALUE)
                .addComponent(returnToMenuButton)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void returnToMenuButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_returnToMenuButtonActionPerformed
        PetAdoptionConsortium.currentScreen = PetAdoptionConsortium.EMPLOYEE_MENU;
        PetAdoptionConsortium.changeScreen = true;// TODO add your handling code here:
    }//GEN-LAST:event_returnToMenuButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton returnToMenuButton;
    // End of variables declaration//GEN-END:variables
}