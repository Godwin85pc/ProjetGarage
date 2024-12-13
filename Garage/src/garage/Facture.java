/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package garage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Georgette Gabou
 */
public class Facture extends javax.swing.JFrame {
    DefaultTableModel model;

    /**
     * Creates new form Facture
     */
    public Facture() throws ClassNotFoundException {
        initComponents();
        try {
            Table();
            calculmontant();
            recupererinformations();
            recupererinformations1();
            recupererinformations2();
            //recupererinformations3();
        } catch (SQLException ex) {
            Logger.getLogger(Facture.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void Table() throws SQLException {
//        String nom1 = jTextField1.getText();
//        String mdpl = jTextField2.getText();
//        String marql = jTextField2.getText();
        //String marqul = marque1.getText();

        try {
            Connexion co = new Connexion();
            Connection con;
            try {
                con = co.connect();
                String columns[] = new String[]{"refPiece", "NomP", "Quantite", "Prixunitaire"};
                String[] data = new String[4];
                model = new DefaultTableModel(null, columns);
                String query = "SELECT * FROM piece";
                //+  AND( SELECT c.idClient from client c INNER JOIN vehicule v ON c.idClient = v.idClient WHERE Immatriculation='Immatriculation')";
                PreparedStatement stat = con.prepareStatement(query);
                ResultSet rs = stat.executeQuery();
                //int i = 0;
                while (rs.next()) {
//            int id1= rs.getInt("Id");
//            String id=String.valueOf(id1);
                    String nomu = rs.getString("refPiece");
                    String mdpu = rs.getString("NomP");
                    String marqu = rs.getString("Quantite");
                    String m = rs.getString("Prixunitaire");

                    data[0] = nomu;
                    data[1] = mdpu;
                    data[2] = marqu;
                    data[3] = m;
                    model.addRow(data);
                }
                jTable1.setModel(model);
                stat.close();
                con.close();

            } catch (ClassNotFoundException ex) {
                Logger.getLogger(getName()).log(Level.SEVERE, null, ex);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
     public void Table1() throws SQLException {
//        String nom1 = jTextField1.getText();
//        String mdpl = jTextField2.getText();
//        String marql = jTextField2.getText();
        //String marqul = marque1.getText();

        try {
            Connexion co = new Connexion();
            Connection con;
            try {
                con = co.connect();
                String columns[] = new String[]{"idRapport", "Nom", "NomClient", "Immatriculation", "typeIntervention", "Nbrepieces", "Details"};
                String[] data = new String[7];
                model = new DefaultTableModel(null, columns);
                String query = "SELECT * FROM rapport";
                //+  AND( SELECT c.idClient from client c INNER JOIN vehicule v ON c.idClient = v.idClient WHERE Immatriculation='Immatriculation')";
                PreparedStatement stat = con.prepareStatement(query);
                ResultSet rs = stat.executeQuery();
                //int i = 0;
                while (rs.next()) {
//            int id1= rs.getInt("Id");
//            String id=String.valueOf(id1);
                    String nomu = rs.getString("idRapport");
                    String mdpu = rs.getString("Nom");
                    String marqu = rs.getString("NomClient");
                    String m = rs.getString("Immatriculation");
                    String p = rs.getString("typeIntervention");
                    String v = rs.getString("Nbrepieces");
                    String cc = rs.getString("Details");

                    data[0] = nomu;
                    data[1] = mdpu;
                    data[2] = marqu;
                    data[3] = m;
                    data[4] = p;
                    data[5] = v;
                    data[6] = cc;
                    model.addRow(data);
                }
                jTable2.setModel(model);
                stat.close();
                con.close();

            } catch (ClassNotFoundException ex) {
                Logger.getLogger(getName()).log(Level.SEVERE, null, ex);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
     }
     private void calculmontant(){
         try {
             double Prixunitaire = Double.parseDouble(jTextField2.getText());
             int nombrePieces = Integer.parseInt(jTextField3.getText());
             double montantTotal = Prixunitaire * nombrePieces;
             jTextField4.setText(String.valueOf(montantTotal));
         } catch (NumberFormatException e) {
             //JOptionPane.showMessageDialog(null, "Erreur : les valeurs saisies doivent etre des nombres");
         }
     }
     private void recupererinformations() throws SQLException, ClassNotFoundException {

        try {
            Connexion co = new Connexion();
            Connection con = co.connect();



            PreparedStatement stat = con.prepareStatement("select NomClient from rapport");
            ResultSet rs = stat.executeQuery();
            while (rs.next()) {
                jComboBox1.addItem(rs.getString("NomClient"));
            }if (jComboBox1.getItemCount() > 0){
                jComboBox1.setSelectedIndex(0);
            }

        } catch (SQLException e) {
            System.out.println("ERREUR" + e.getMessage());

        }

    }
      private void recupererinformations1() throws SQLException, ClassNotFoundException {

        try {
            Connexion co = new Connexion();
            Connection con = co.connect();



            PreparedStatement stat = con.prepareStatement("select Immatriculation from rapport");
            ResultSet rs = stat.executeQuery();
            while (rs.next()) {
                jComboBox2.addItem(rs.getString("Immatriculation"));
            }if (jComboBox2.getItemCount() > 0){
                jComboBox2.setSelectedIndex(0);
            }

        } catch (SQLException e) {
            System.out.println("ERREUR" + e.getMessage());

        }

    }
       private void recupererinformations2() throws SQLException, ClassNotFoundException {

        try {
            Connexion co = new Connexion();
            Connection con = co.connect();



            PreparedStatement stat = con.prepareStatement("select typeIntervention from rapport");
            ResultSet rs = stat.executeQuery();
            while (rs.next()) {
                jComboBox3.addItem(rs.getString("typeIntervention"));
            }if (jComboBox3.getItemCount() > 0){
                jComboBox3.setSelectedIndex(0);
            }

        } catch (SQLException e) {
            System.out.println("ERREUR" + e.getMessage());

        }

    }
//        private void recupererinformations3() throws SQLException, ClassNotFoundException {
//
//        try {
//            Connexion co = new Connexion();
//            Connection con = co.connect();
//
//
//
//            PreparedStatement stat = con.prepareStatement("select Nbrepieces from rapport");
//            ResultSet rs = stat.executeQuery();
//            while (rs.next()) {
//                jComboBox4.addItem(rs.getString("Nbrepieces"));
//            }if (jComboBox4.getItemCount() > 0){
//                jComboBox4.setSelectedIndex(0);
//            }
//
//        } catch (SQLException e) {
//            System.out.println("ERREUR" + e.getMessage());
//
//        }
//
//    }
       

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jToggleButton1 = new javax.swing.JToggleButton();
        jTextField1 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jComboBox2 = new javax.swing.JComboBox<>();
        jComboBox3 = new javax.swing.JComboBox<>();
        jToggleButton2 = new javax.swing.JToggleButton();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jToggleButton3 = new javax.swing.JToggleButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jToggleButton4 = new javax.swing.JToggleButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jLabel9 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        jToggleButton5 = new javax.swing.JToggleButton();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 255, 255));

        jLabel2.setText("Numero Facture :");

        jLabel3.setText("Nom du client :");

        jLabel4.setText("Type de reparation :");

        jLabel5.setText("Nombre de pieces utilisees :");

        jLabel6.setText("Immatriculation du vehicule :");

        jLabel7.setText("Prix :");

        jLabel8.setText("Montant a payer :");

        jToggleButton1.setBackground(new java.awt.Color(255, 51, 51));
        jToggleButton1.setText("RETOUR");
        jToggleButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton1ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel1.setText("Welcome !!");

        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jComboBox3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox3ActionPerformed(evt);
            }
        });

        jToggleButton2.setBackground(new java.awt.Color(102, 255, 204));
        jToggleButton2.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jToggleButton2.setText("IMPRIMER FACTURE");
        jToggleButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton2ActionPerformed(evt);
            }
        });

        jToggleButton3.setBackground(new java.awt.Color(102, 255, 204));
        jToggleButton3.setText("Voir les informations sur pieces");
        jToggleButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton3ActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "referencePiece", "NomP", "Quantite", "Prixunitaire"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jToggleButton4.setBackground(new java.awt.Color(102, 255, 204));
        jToggleButton4.setText("Voir les rapports ");
        jToggleButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton4ActionPerformed(evt);
            }
        });

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "idRapport", "Nom", "NomClient", "Immatriculation", "typeIntervention", "NbrePieces", "Details"
            }
        ));
        jScrollPane2.setViewportView(jTable2);

        jLabel9.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel9.setText("Pour etablir une facture il faut voir les differents rapports");

        jLabel10.setText("Date :");

        jTextField5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField5ActionPerformed(evt);
            }
        });

        jToggleButton5.setText("Cacul montant");
        jToggleButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton5ActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel11.setText("FCFA");

        jLabel12.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel12.setText("FCFA");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 709, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jToggleButton1)
                        .addGap(112, 112, 112)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 610, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(jToggleButton2)
                        .addGap(159, 159, 159)
                        .addComponent(jToggleButton4)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jTextField5)
                                    .addComponent(jTextField3)
                                    .addComponent(jTextField2)
                                    .addComponent(jComboBox3, 0, 210, Short.MAX_VALUE)
                                    .addComponent(jComboBox2, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, 61, Short.MAX_VALUE)
                                .addGap(12, 12, 12)
                                .addComponent(jToggleButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextField1)
                            .addComponent(jComboBox1, 0, 213, Short.MAX_VALUE)))
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 423, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(45, 45, 45))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jToggleButton3)
                        .addGap(110, 110, 110))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jToggleButton1)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(22, 22, 22)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(20, 20, 20)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jToggleButton5)
                                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(23, 23, 23)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jToggleButton4)
                            .addComponent(jToggleButton2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(145, 145, 145))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(jToggleButton3)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBox3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox3ActionPerformed

    private void jToggleButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton4ActionPerformed
        try {
            // TODO add your handling code here:
            Table1();
        } catch (SQLException ex) {
            Logger.getLogger(Facture.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jToggleButton4ActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jToggleButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton3ActionPerformed
        try {
            // TODO add your handling code here:
            Table();
        } catch (SQLException ex) {
            Logger.getLogger(Facture.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jToggleButton3ActionPerformed

    private void jToggleButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton1ActionPerformed
        // TODO add your handling code here:
        Accueil1 n = new Accueil1();
        n.setVisible(true);
        dispose();
    }//GEN-LAST:event_jToggleButton1ActionPerformed

    private void jToggleButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton2ActionPerformed
        // TODO add your handling code here:
    String identifiant = jTextField1.getText();
    String nombrePieces = jTextField2.getText();
    String prix = jTextField3.getText();
    String montant = jTextField4.getText();
    String da = jTextField5.getText();
    //String details = jTextArea1.getText();
    String client = (String) jComboBox1.getSelectedItem();
    String vehicule = (String) jComboBox2.getSelectedItem();
    //String mecanicien = (String) jComboBox3.getSelectedItem();
    String intervention = (String) jComboBox3.getSelectedItem();
    
    javax.swing.JFileChooser fileChooser = new javax.swing.JFileChooser();
    fileChooser.setDialogTitle("Choisir l'emplacement pour enregistrer le rapport");
    fileChooser.setFileSelectionMode(javax.swing.JFileChooser.FILES_ONLY);

    // Ajouter une extension par défaut au fichier
    fileChooser.setSelectedFile(new java.io.File("Facture du client.pdf"));

    int userSelection = fileChooser.showSaveDialog(this);

    if (userSelection == javax.swing.JFileChooser.APPROVE_OPTION) {
        java.io.File fileToSave = fileChooser.getSelectedFile();
        String pdfFilePath = fileToSave.getAbsolutePath();
        
        // Ajouter l'extension ".pdf" si l'utilisateur ne l'a pas incluse
        if (!pdfFilePath.endsWith(".pdf")) {
            pdfFilePath += ".pdf";
        }

        // Générer le PDF
        com.itextpdf.text.Document document = new com.itextpdf.text.Document();
        try {
            // Création du fichier PDF
            com.itextpdf.text.pdf.PdfWriter.getInstance(document, new java.io.FileOutputStream(pdfFilePath));
            document.open();

            // Ajouter un titre au document
            com.itextpdf.text.Font titleFont = new com.itextpdf.text.Font(com.itextpdf.text.Font.FontFamily.TIMES_ROMAN, 18, com.itextpdf.text.Font.BOLD);
            com.itextpdf.text.Paragraph title = new com.itextpdf.text.Paragraph("Facture de Réparation", titleFont);
            title.setAlignment(com.itextpdf.text.Element.ALIGN_CENTER);
            document.add(title);
            document.add(new com.itextpdf.text.Paragraph("\n")); // Ligne vide

            // Ajouter les informations au PDF
            com.itextpdf.text.Font contentFont = new com.itextpdf.text.Font(com.itextpdf.text.Font.FontFamily.TIMES_ROMAN, 12);
            document.add(new com.itextpdf.text.Paragraph("Numero Facture: " + identifiant, contentFont));
            document.add(new com.itextpdf.text.Paragraph("Nom du client : " + client, contentFont));
            document.add(new com.itextpdf.text.Paragraph("Immatriculation du Véhicule : " + vehicule, contentFont));
            //document.add(new com.itextpdf.text.Paragraph("Immatriculation du Véhicule : " + vehicule, contentFont));
            document.add(new com.itextpdf.text.Paragraph("Type d'Intervention : " + intervention, contentFont));
            document.add(new com.itextpdf.text.Paragraph("Nombre de Pièces Utilisées : " + nombrePieces, contentFont));
            document.add(new com.itextpdf.text.Paragraph("prix de la piece : " + prix, contentFont));
            document.add(new com.itextpdf.text.Paragraph("Montant a payer : " + montant, contentFont));
            document.add(new com.itextpdf.text.Paragraph("Date : " + da, contentFont));
            //document.add(new com.itextpdf.text.Paragraph("\nDétails de la Réparation : ", contentFont));
            //document.add(new com.itextpdf.text.Paragraph(details, contentFont));

            // Ligne de fin
            document.add(new com.itextpdf.text.Paragraph("\n------------------------------", contentFont));
            //document.add(new com.itextpdf.text.Paragraph("Fin du Rapport", contentFont));

            // Message de confirmation
            javax.swing.JOptionPane.showMessageDialog(this, "Facture PDF généré avec succès : " + pdfFilePath);
        } catch (com.itextpdf.text.DocumentException | java.io.IOException e) {
            javax.swing.JOptionPane.showMessageDialog(this, "Erreur lors de la génération du PDF : " + e.getMessage());
        } finally {
            document.close();
        }

        
    }else{
        javax.swing.JOptionPane.showMessageDialog(this, "Enregistrement annulé.");
    }

    }//GEN-LAST:event_jToggleButton2ActionPerformed

    private void jTextField5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField5ActionPerformed

    private void jToggleButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton5ActionPerformed
        // TODO add your handling code here:
        calculmontant();
        
    }//GEN-LAST:event_jToggleButton5ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
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
            java.util.logging.Logger.getLogger(Facture.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Facture.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Facture.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Facture.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new Facture().setVisible(true);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(Facture.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JToggleButton jToggleButton2;
    private javax.swing.JToggleButton jToggleButton3;
    private javax.swing.JToggleButton jToggleButton4;
    private javax.swing.JToggleButton jToggleButton5;
    // End of variables declaration//GEN-END:variables
}
