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

/**
 *
 * @author Doug
 */
public class QuarterlyReport extends javax.swing.JPanel {
    private String[] currentQuarter;
    private TableModel[] table = {new DefaultTableModel(),new DefaultTableModel(),new DefaultTableModel()};
    public QuarterlyReport() {
        String[][] quarters =    {
                                {"January","February","March"},
                                {"April","May","June"},
                                {"July","August","September"},
                                {"October","November","December"}
                                };
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 3; j++) {
                if (PetAdoptionConsortium.CURRENT_MONTH.equals(quarters[i][j])) {
                    this.currentQuarter = quarters[i];
                }
            }
        }
        Connection connection = null;
        PreparedStatement[] pstatement = {null,null,null};
        ResultSet resultSet[] = {null,null,null};
        ResultSetMetaData metaData[] = {null,null,null};
        int numberOfColumns = 0;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(PetAdoptionConsortium.CONN_STRING,"root","");
            String query =  "SELECT MonthName(Months.MonthDate) as `Month`, SH.`Name`, S.Num AS NumberSponsoredEvents, TD.Donations, TA.Adoptions, TP.PetsReceived \n"+
                            "FROM (Months,Shelter SH) \n"+
                            "LEFT JOIN SponsoredEvents S \n"+
                            "ON SH.`Name`=S.Shelter AND S.MonthTitle = MonthName(Months.MonthDate) \n"+
                            "LEFT JOIN TotalDonations TD \n"+
                            "ON SH.`Name`=TD.Shelter AND TD.MonthTitle = MonthName(Months.MonthDate) \n"+
                            "LEFT JOIN TotalAdoptions TA \n"+
                            "ON SH.`Name` = TA.Shelter AND TA.MonthTitle = MonthName(Months.MonthDate) \n"+
                            "LEFT JOIN TotalPetsReceived TP \n"+
                            "ON SH.`Name` = TP.Shelter AND TP.MonthTitle = MonthName(Months.MonthDate) \n"+
                            "WHERE MonthName(Months.MonthDate) = ? \n"+
                            "ORDER BY Months.MonthDate;";
            if(EmployeeMenu.buttonPressed == true) {
                for(int i = 0; i < 3; i++) {
                    String month = currentQuarter[i];
                    pstatement[i] = connection.prepareStatement(query);
                    pstatement[i].setString(1,month);
                    resultSet[i] = pstatement[i].executeQuery();
                    metaData[i] = resultSet[i].getMetaData();
                    numberOfColumns = metaData[i].getColumnCount();
                    Vector[] columnNames = {new Vector(),new Vector(), new Vector()};
                    for (int column = 2; column <= numberOfColumns; column++) {
                        columnNames[i].addElement(metaData[i].getColumnLabel(column));
                    }
                    Vector[] rows = {new Vector(),new Vector(),new Vector()};
                    while (resultSet[i].next()) {
                        Vector newRow = new Vector();
                        for (int j = 2; j <= numberOfColumns; j++) {
                            if(resultSet[i].getObject(j)==null) {
                                newRow.addElement("0");
                            }
                            else {
                                newRow.addElement(resultSet[i].getObject(j));
                            }
                        }
                        rows[i].addElement(newRow);
                    }
                    this.table[i] = new DefaultTableModel(rows[i],columnNames[i]);
                }
            }
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
                //pstatement[0].close();
                //pstatement[1].close();
                //pstatement[2].close();
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
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        jLabel1.setText("Atlanta Pet Adoption Consortium");

        jTable1.setModel(this.table[0]);
        jScrollPane1.setViewportView(jTable1);

        jTable2.setModel(this.table[1]);
        jScrollPane2.setViewportView(jTable2);

        jTable3.setModel(this.table[2]);
        jScrollPane3.setViewportView(jTable3);

        jLabel2.setText("Current Quarterly Report");

        jLabel3.setText(this.currentQuarter[0] + ", " + PetAdoptionConsortium.CURRENT_YEAR);

        jLabel4.setText(currentQuarter[1] + ", " + PetAdoptionConsortium.CURRENT_YEAR);

        jLabel5.setText(currentQuarter[2]+", "+PetAdoptionConsortium.CURRENT_YEAR);

        jButton1.setText("jButton1");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 706, Short.MAX_VALUE)
                    .addComponent(jScrollPane2)
                    .addComponent(jScrollPane3)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton1)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(8, 8, 8)
                .addComponent(jLabel2)
                .addGap(36, 36, 36)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
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
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable3;
    // End of variables declaration//GEN-END:variables
}
