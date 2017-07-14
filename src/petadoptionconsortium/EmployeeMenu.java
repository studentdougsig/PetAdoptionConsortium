/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package petadoptionconsortium;

/**
 *
 * @author Doug
 */
public class EmployeeMenu extends javax.swing.JPanel {

    /**
     * Creates new form EmployeeMenu
     */
    public static boolean buttonPressed = false;
    public EmployeeMenu() {
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

        menuSelectionComboBox = new javax.swing.JComboBox();
        goButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        menuSelectionComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Add New Pet", "Add New Event", "Largest Monthly Donations", "Adoptions Information", "Assign Pet to Foster Home", "Current Year Pet Adoptions Report", "Quarterly Report" }));
        menuSelectionComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuSelectionComboBoxActionPerformed(evt);
            }
        });

        goButton.setText("Go");
        goButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                goButtonActionPerformed(evt);
            }
        });

        jLabel1.setText("Atlanta Pet Adoption Consortium");

        jLabel2.setText("Employee Menu");

        jButton2.setText("Logout");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/petadoptionconsortium/imagepackage/adopt6.jpg"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton2))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(menuSelectionComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(goButton))
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addContainerGap(335, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addGap(47, 47, 47)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(goButton)
                    .addComponent(menuSelectionComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 142, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void menuSelectionComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuSelectionComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_menuSelectionComboBoxActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        PetAdoptionConsortium.currentScreen = 0;// TODO add your handling code here:
        PetAdoptionConsortium.changeScreen = true;
    }//GEN-LAST:event_jButton2ActionPerformed

    private void goButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_goButtonActionPerformed
        buttonPressed = true;
        String selection = menuSelectionComboBox.getSelectedItem().toString();        // TODO add your handling code here:
        if (selection.equals("Add New Pet")) {
            PetAdoptionConsortium.currentScreen = PetAdoptionConsortium.ADD_NEW_DOG_OR_CAT;
            PetAdoptionConsortium.changeScreen = true;
        }
        else if (selection.equals("Add New Event")) {
            PetAdoptionConsortium.currentScreen = PetAdoptionConsortium.ADD_NEW_EVENT;
            PetAdoptionConsortium.changeScreen = true;
        }
        else if (selection.equals("Largest Monthly Donations")) {
            PetAdoptionConsortium.currentScreen = PetAdoptionConsortium.LARGEST_MONTHLY_DONATIONS;
            PetAdoptionConsortium.changeScreen = true;
        }
        else if (selection.equals("Adoptions Information")) {
            PetAdoptionConsortium.currentScreen = PetAdoptionConsortium.ADOPTIONS_INFORMATION_DATE;
            PetAdoptionConsortium.changeScreen = true;
        }
        else if (selection.equals("Assign Pet to Foster Home")) {
            PetAdoptionConsortium.currentScreen = PetAdoptionConsortium.ASSIGN_FOSTER;
            PetAdoptionConsortium.changeScreen = true;
        }
        else if (selection.equals("Current Year Pet Adoptions Report")) {
            PetAdoptionConsortium.currentScreen = PetAdoptionConsortium.CURRENT_YEAR_PET_ADOPTIONS;
            PetAdoptionConsortium.changeScreen = true;
        }
        else if (selection.equals("Quarterly Report")) {
            PetAdoptionConsortium.currentScreen = PetAdoptionConsortium.QUARTERLY_REPORT;
            PetAdoptionConsortium.changeScreen = true;
        }    
    }//GEN-LAST:event_goButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton goButton;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JComboBox menuSelectionComboBox;
    // End of variables declaration//GEN-END:variables
}