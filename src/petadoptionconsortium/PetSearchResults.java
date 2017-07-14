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
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.util.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import static petadoptionconsortium.ShelterSearchResults.zipCode;

/**
 *
 * @author Doug
 */
public class PetSearchResults extends javax.swing.JPanel {

    /**
     * Creates new form PetSearchResults
     */
    private TableModel queryTable;
    private TableModel resultsTable;
    public PetSearchResults() {
        
            Connection connection = null;
            PreparedStatement pstatement = null;
            ResultSet resultSet = null;
            ResultSetMetaData metaData = null;
            String query;
            query =     "SELECT P.CatBreed, P.DogBreed, P.ShelterName, S.StreetCityState, S.Zipcode, S.Phone, P.PetID, P.Petname " +
                        "FROM Pet P INNER JOIN Shelter S ON P.ShelterName = S.Name " +
                        "WHERE (IF(? <> ?, ? = S.Zipcode, 1) AND " +
                        "(IF(? <> ?, ? = P.Catbreed,1) OR IF(? <> ?, ? = P.Dogbreed,1)) AND " +
                        "IF(? <> ?, ? = P.Gender,1) AND " +
                        "IF(? <> ?, P.Age >= ?,1) AND " +
                        "IF(? <> ?, P.Age <= ?,1)) " +
                        "ORDER BY P.ShelterName, P.PetID";
            int numberOfColumns = 0;
            try {
                Class.forName("com.mysql.jdbc.Driver");
                connection = DriverManager.getConnection(PetAdoptionConsortium.CONN_STRING,"root","");
                connection.setAutoCommit(false);
                pstatement = connection.prepareStatement(query);
                pstatement.setString(1, PetSearch.zipcodeChoice);
                pstatement.setString(2, new String());
                pstatement.setString(3, PetSearch.zipcodeChoice);
                pstatement.setString(4, PetSearch.breedChoice);
                pstatement.setString(5, new String());
                pstatement.setString(6, PetSearch.breedChoice);
                pstatement.setString(7, PetSearch.breedChoice);
                pstatement.setString(8, new String());
                pstatement.setString(9, PetSearch.breedChoice);
                pstatement.setString(10, PetSearch.genderChoice);
                pstatement.setString(11, new String());
                pstatement.setString(12, PetSearch.genderChoice);
                pstatement.setString(13, PetSearch.fromAgeChoice);
                pstatement.setString(14, new String());
                pstatement.setString(15, PetSearch.fromAgeChoice);
                pstatement.setString(16, PetSearch.toAgeChoice);
                pstatement.setString(17, new String());
                pstatement.setString(18, PetSearch.toAgeChoice);
                
                resultSet = pstatement.executeQuery();
                
                metaData = resultSet.getMetaData();
                numberOfColumns = metaData.getColumnCount();
                Vector columnNames = new Vector();
                for (int column = 2; column < numberOfColumns; column++) {
                    columnNames.addElement(metaData.getColumnLabel(column+1));
                }
                Vector rows = new Vector();
                while (resultSet.next()) {
                    Vector newRow = new Vector();
                    for (int i = 1; i <= numberOfColumns; i++) {
                        newRow.addElement(resultSet.getObject(i));
                    }
                    if(PetSearchDogOrCat.dogOrCat.equals("Dog")) {
                        if(newRow.elementAt(1) != null && !newRow.elementAt(1).equals("")) {
                            Vector temp = new Vector();
                            for(int q = 2; q < 8; q++) {
                                temp.addElement(newRow.elementAt(q));
                            }
                            rows.addElement(temp);
                        }
                    }
                    else if(PetSearchDogOrCat.dogOrCat.equals("Cat")) {
                        if(newRow.elementAt(0) != null && !newRow.elementAt(0).equals("")) {
                            Vector temp = new Vector();
                            for(int q = 2; q < 8; q++) {
                                temp.addElement(newRow.elementAt(q));
                            }
                            rows.addElement(temp);
                            System.out.println("\nSuccessCat");
                        }
                    }
                    else {
                        Vector temp = new Vector();
                        for(int q = 2; q < 8; q++) {
                            temp.addElement(newRow.elementAt(q));
                        }
                        rows.addElement(temp);
                        System.out.println("\nSuccessBoth");
                    }    

                }
                resultsTable = new DefaultTableModel(rows,columnNames);

                Vector queryVectorPre = new Vector();
                Vector queryVector = new Vector();
                queryVectorPre.addElement(PetSearch.zipcodeChoice);
                queryVectorPre.addElement(PetSearch.typeChoice);
                queryVectorPre.addElement(PetSearch.breedChoice);
                queryVectorPre.addElement(PetSearch.genderChoice);
                queryVectorPre.addElement(PetSearch.fromAgeChoice);
                queryVectorPre.addElement(PetSearch.toAgeChoice);
                queryVector.addElement(queryVectorPre);

                Vector queryNames = new Vector();
                queryNames.addElement("Zipcode");
                queryNames.addElement("Type");
                queryNames.addElement("Breed");
                queryNames.addElement("Gender");
                queryNames.addElement("From Age");
                queryNames.addElement("To Age");
                this.queryTable = new DefaultTableModel(queryVector,queryNames);
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
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        returnToMenuButton = new javax.swing.JButton();

        jLabel1.setText("Atlanta Pet Adoption Consortium");

        jLabel2.setText("Pet Search Results For");

        jTable1.setModel(queryTable);
        jScrollPane1.setViewportView(jTable1);

        jTable2.setModel(resultsTable);
        jScrollPane2.setViewportView(jTable2);

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
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(returnToMenuButton))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 706, Short.MAX_VALUE)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(41, 41, 41)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(56, 56, 56)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 132, Short.MAX_VALUE)
                .addComponent(returnToMenuButton)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void returnToMenuButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_returnToMenuButtonActionPerformed
        PetAdoptionConsortium.currentScreen = PetAdoptionConsortium.GUEST_MENU;// TODO add your handling code here:
        PetAdoptionConsortium.changeScreen = true;// TODO add your handling code here:
    }//GEN-LAST:event_returnToMenuButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JButton returnToMenuButton;
    // End of variables declaration//GEN-END:variables
}
