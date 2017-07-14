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

public class CurrentYearPetAdoptions extends javax.swing.JPanel {

    /**
     * Creates new form CurrentYearPetAdoptions
     */
    private TableModel table;
    public CurrentYearPetAdoptions() {
        Connection connection = null;
        PreparedStatement pstatement = null;
        ResultSet resultSet = null;
        ResultSetMetaData metaData = null;
        int numberOfColumns = 0;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(PetAdoptionConsortium.CONN_STRING,"root","");
            String query =  "SELECT MonthName(MonthDate),C.CatsAdopted, D.DogsAdopted, ND.NewDogs, NC.NewCats, DS.DogsInShelter, CS.CatsInShelter, DF.DogsInFoster, CF.CatsInFoster \n"+
                            "FROM Months \n"+
                            "LEFT JOIN DogsAdoptedV D \n"+
                            "ON Month(Months.MonthDate)=D.Month AND  D.ShelterName = ? \n"+
                            "LEFT JOIN CatsAdoptedV C \n"+
                            "ON Month(Months.MonthDate)=C.Month AND  C.ShelterName = ? \n"+
                            "LEFT JOIN NewDogsV ND \n"+
                            "On Month(Months.MonthDate)=ND.Month AND  ND.ShelterName = ? \n"+
                            "LEFT JOIN NewCatsV NC \n"+
                            "On Month(Months.MonthDate)=NC.Month AND  NC.ShelterName = ? \n"+
                            "LEFT JOIN DogsShelterV DS \n"+
                            "ON Month(Months.MonthDate)= DS.Month AND DS.ShelterName = ? \n"+
                            "LEFT JOIN CatsShelterV CS \n"+
                            "ON Month(Months.MonthDate)= CS.Month AND  CS.ShelterName = ? \n"+
                            "LEFT JOIN DogsFosterV DF \n"+
                            "ON Month(Months.MonthDate)=DF.Month AND  DF.ShelterName = ? \n"+
                            "LEFT JOIN CatsFosterV CF \n"+
                            "ON Month(Months.MonthDate)=CF.Month AND  CF.ShelterName = ? \n"+
                            "WHERE Year(Months.MonthDate)=Year(Now()) \n"+
                            "AND Month(Months.MonthDate)<=Month(Now()) \n"+
                            "ORDER BY Months.MonthDate;";
            pstatement = connection.prepareStatement(query);
            pstatement.setString(1,PetAdoptionConsortium.shelterName);
            pstatement.setString(2,PetAdoptionConsortium.shelterName);
            pstatement.setString(3,PetAdoptionConsortium.shelterName);
            pstatement.setString(4,PetAdoptionConsortium.shelterName);
            pstatement.setString(5,PetAdoptionConsortium.shelterName);
            pstatement.setString(6,PetAdoptionConsortium.shelterName);
            pstatement.setString(7,PetAdoptionConsortium.shelterName);
            pstatement.setString(8,PetAdoptionConsortium.shelterName);
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
                    if(resultSet.getObject(i)==null) {
                        newRow.addElement("0");
                    }
                    else {
                        newRow.addElement(resultSet.getObject(i));
                    }
                }
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
        returnToMenuButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        jLabel1.setText("Atlanta Pet Adoption Consortium");

        returnToMenuButton.setText("Return to Menu");
        returnToMenuButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                returnToMenuButtonActionPerformed(evt);
            }
        });

        jTable1.setModel(this.table);
        jScrollPane1.setViewportView(jTable1);

        jLabel2.setText("Current Year Pet Adoptions Summary for Shelter "+PetAdoptionConsortium.shelterName);

        jLabel3.setText(PetAdoptionConsortium.CURRENT_MONTH+" "+PetAdoptionConsortium.CURRENT_DAY+", "+PetAdoptionConsortium.CURRENT_YEAR);

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
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 521, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 706, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel3)
                        .addGap(9, 9, 9)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(80, 80, 80)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 211, Short.MAX_VALUE)
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
