/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package garage;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Georgette Gabou
 */
public class Mecanicien extends javax.swing.JFrame {
    DefaultTableModel model;

    /**
     * Creates new form Mecanicien
     */
    public Mecanicien() throws ClassNotFoundException {
        initComponents();
        
        try {
            //Table1();
            Table();
            recupererinformations();
            
        } catch (SQLException ex) {
            Logger.getLogger(Mecanicien.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void Table1() throws SQLException{
        try{
    Connexion co = new Connexion();
        Connection con;
        try{
    con= co.connect();
    String columns[]= new String[] {"idIntervention", "Date", "typeIntervention",  "Description", "Immatriculation", "Nom"};
        String[] data= new String[6];
        model= new DefaultTableModel(null,columns);
        String query5= "SELECT * FROM intervention"; //WHERE ( idMecanicien= ?);
        PreparedStatement stat = con.prepareStatement(query5) ;
        
        //stat.setString(1,c);
        //stat.setString(2,a);
        ResultSet rs = stat.executeQuery() ;
        int i=0;
        while(rs.next()){
            String nom=rs.getString("idIntervention");
            String prenom= rs.getString("Date");
            String d = rs.getString("typeIntervention");
          
            String pp=rs.getString("Description");
            String m=rs.getString("Immatriculation");
            String m22=rs.getString("Nom");
//            
           
            data[0]=nom;
            data[1]=prenom;
            data[2]=d;  
                       
            data[3]=pp;
            data[4]=m;
            data[5]=m22; 
          
            model.addRow(data);
        }
        jTable2.setModel(model);
        stat.close();
        con.close();
        }catch (ClassNotFoundException ex) {
                Logger.getLogger(getName()).log(Level.SEVERE, null, ex);
        }
    }catch(SQLException e){
            e.printStackTrace();
    }
//        if (jComboBox1.getSelectedItem() != null) {
//            
//        
//        String c = jComboBox1.getSelectedItem().toString();
//        //a= jcb3.getSelectedItem().toString();
//    try{
//    Connexion co = new Connexion();
//        Connection con;
//        try{
//    con= co.connect();
//    String columns[]= new String[] {"idIntervention", "Date", "typeIntervention", "Description", "Immatriculation","Nom"}; // "Description", "Immatriculation"
//        String[] data= new String[6];
//        model= new DefaultTableModel(null,columns);
//        String query= "SELECT * FROM intervention ";
//        PreparedStatement stat = null ;
//        stat = con.prepareStatement(query) ;
////        stat.setString(1,c);
//        //stat.setString(2,a);
//        ResultSet rs = stat.executeQuery() ;
//        int i=0;
//        while(rs.next()){
//            String nom=rs.getString("idIntervention");
//            String prenom= rs.getString("Date");
//            String d = rs.getString("typeIntervention");
//           
//          String m2=rs.getString("Description");
//           String m=rs.getString("Immatriculation");
//            String m22=rs.getString("Nom");
////            
//           
//            data[0]=nom;
//            data[1]=prenom;
//            data[2]=d;  
//                     
//            data[4]=m2;
//            data[5]=m;
//            data[3]=m22;   
//          
//            model.addRow(data);
//        }
//        jTable2.setModel(model);
//        stat.close();
//        con.close();
//        }catch (ClassNotFoundException ex) {
//                Logger.getLogger(getName()).log(Level.SEVERE, null, ex);
//        }
//    }catch(SQLException e){
//            e.printStackTrace();
//    }
//    }else{
//            System.out.println("Aucun élément sélectionné dans la liste déroulante");
//        }
    }
    
    
    public void Table() throws SQLException {
        String nom1 = jTextField1.getText();
        String mdpl = jTextField2.getText();
        String marql = jTextField2.getText();
        //String marqul = marque1.getText();

        try {
            Connexion co = new Connexion();
            Connection con;
            try {
                con = co.connect();
                String columns[] = new String[]{"idMecanicien", "Nom", "Telephone"};
                String[] data = new String[3];
                model = new DefaultTableModel(null, columns);
                String query = "SELECT * FROM mecanicien";
                //+  AND( SELECT c.idClient from client c INNER JOIN vehicule v ON c.idClient = v.idClient WHERE Immatriculation='Immatriculation')";
                PreparedStatement stat = con.prepareStatement(query);
                ResultSet rs = stat.executeQuery();
                int i = 0;
                while (rs.next()) {
//            int id1= rs.getInt("Id");
//            String id=String.valueOf(id1);
                    String nomu = rs.getString("idMecanicien");
                    String mdpu = rs.getString("Nom");
                    String marqu = rs.getString("Telephone");
                    //String m = rs.getString("idClient");

                    data[0] = nomu;
                    data[1] = mdpu;
                    data[2] = marqu;
                    //data[3] = m;
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
    
     private void recupererinformations() throws SQLException, ClassNotFoundException {

        try {
            Connexion co = new Connexion();
            Connection con = co.connect();

//            try {
//                con = co.connect();
//            } catch (ClassNotFoundException ex) {
//                Logger.getLogger(getName()).log(Level.SEVERE, null, ex);
//            }

            PreparedStatement stat = con.prepareStatement("select Nom from mecanicien");
            ResultSet rs = stat.executeQuery();
            while (rs.next()) {
                jComboBox1.addItem(rs.getString("Nom"));
            }if (jComboBox1.getItemCount() > 0){
                jComboBox1.setSelectedIndex(0);
            }

        } catch (SQLException e) {
            System.out.println("ERREUR" + e.getMessage());

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

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jToggleButton1 = new javax.swing.JToggleButton();
        jToggleButton2 = new javax.swing.JToggleButton();
        jToggleButton3 = new javax.swing.JToggleButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jToggleButton4 = new javax.swing.JToggleButton();
        jLabel5 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Script MT Bold", 3, 24)); // NOI18N
        jLabel1.setText("BIENVENUE SUR L'INTERFACE DE GESTION DES MECANICIENS");

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel2.setText("Matricule du mecanicien");

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel3.setText("Nom du mecanicien");

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel4.setText("Contact du mecanicien");

        jToggleButton1.setText("AJOUTER");
        jToggleButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton1ActionPerformed(evt);
            }
        });

        jToggleButton2.setText("SUPPRIMER");
        jToggleButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton2ActionPerformed(evt);
            }
        });

        jToggleButton3.setText("RETOUR");
        jToggleButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton3ActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "idMecanicien", "Nom", "Telephone"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jToggleButton4.setText("Visualiser les taches d'un mecanicien ?");
        jToggleButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton4ActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel5.setText("Choisir le matricule du mecanicien");

        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "idIntervention", "Date", "typeIntervention", "idMecanicien", "Description", "Immatriculation"
            }
        ));
        jTable2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable2MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTable2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 871, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 154, Short.MAX_VALUE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(47, 47, 47)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jTextField2)
                                    .addComponent(jTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, 198, Short.MAX_VALUE)
                                    .addComponent(jTextField3))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 417, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(17, 17, 17))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(76, 76, 76)
                                .addComponent(jToggleButton4))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jToggleButton1)
                                        .addGap(63, 63, 63)
                                        .addComponent(jToggleButton2)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(72, 72, 72)
                                        .addComponent(jToggleButton3))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 839, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jToggleButton1)
                    .addComponent(jToggleButton3)
                    .addComponent(jToggleButton2))
                .addGap(29, 29, 29)
                .addComponent(jToggleButton4)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jToggleButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton3ActionPerformed
        // TODO add your handling code here:
         Accueil1 n = new Accueil1();
        n.setVisible(true);
        dispose();
    }//GEN-LAST:event_jToggleButton3ActionPerformed

    private void jToggleButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton1ActionPerformed
        // TODO add your handling code here:
         String nom = jTextField1.getText();
        String mdp = jTextField2.getText();
        String marq = jTextField3.getText();
        
        if (nom.equals("") && mdp.equals("") && marq.equals("")) {
            JOptionPane.showMessageDialog(null, "Veuillez entrer les informations du mecanicien!!!", "Informations incorrectes", JOptionPane.ERROR_MESSAGE);
        } else {
            try {

                Connexion co = new Connexion();
                Connection con = null;
                try {
                    con = co.connect();
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(getName()).log(Level.SEVERE, null, ex);
                }

                String query2 = "INSERT INTO mecanicien (idMecanicien, Nom, Telephone) VALUES (?,?,?)";
                PreparedStatement pst = con.prepareStatement(query2);
                pst.setString(1, nom);
                pst.setString(2, mdp);
                pst.setString(3, marq);
                //pst.setString(4, marq1);
                pst.executeUpdate();
                JOptionPane.showMessageDialog(null, "Mecanicien a ete ajouté");

            } catch (SQLException ex) {
                Logger.getLogger(getName()).log(Level.SEVERE, null, ex);
            }
        }
        try {
            Table();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    
    }//GEN-LAST:event_jToggleButton1ActionPerformed

    private void jToggleButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton2ActionPerformed
        // TODO add your handling code here:
        String noms = jTextField1.getText();
        String mdps = jTextField2.getText();
        String marqs = jTextField3.getText();
        //String marq1 = marque1.getText();

        if (noms.equals("")) {
            JOptionPane.showMessageDialog(null, "Veuillez selectionner le mecanicien a supprimmer !!!", "Informations incorrectes", JOptionPane.ERROR_MESSAGE);
        } else {
            try {

                Connexion co = new Connexion();
                Connection con;
                con = co.connect();
                String query3 = "DELETE FROM mecanicien WHERE idMecanicien= ? AND Nom=? AND Telephone=?";
                PreparedStatement stat = null;
                stat = con.prepareStatement(query3);
                PreparedStatement pst = con.prepareStatement(query3);
                pst.setString(1, noms);
                pst.setString(2, mdps);
                pst.setString(3, marqs);
                //pst.setString(4, marq1);

                pst.executeUpdate();

                Table();

                JOptionPane.showMessageDialog(null, "Mecanicien supprime avec succes");
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(getName()).log(Level.SEVERE, null, ex);
            }
        }

    }//GEN-LAST:event_jToggleButton2ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        int ligne = jTable1.getSelectedRow();
        List<String> liste = new ArrayList<>();
        for (int i = 0; i < jTable1.getColumnCount(); i++) {
            liste.add("" + jTable1.getValueAt(ligne, i));
        }
        jTextField1.setText(liste.get(0));
        jTextField2.setText(liste.get(1));
        jTextField3.setText(liste.get(2));
    }//GEN-LAST:event_jTable1MouseClicked

    private void jToggleButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton4ActionPerformed
        try {
            // TODO add your handling code here:
            Table1();
        } catch (SQLException ex) {
            //Logger.getLogger(Mecanicien.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
        }
    }//GEN-LAST:event_jToggleButton4ActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jTable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jTable2MouseClicked

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
            java.util.logging.Logger.getLogger(Mecanicien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Mecanicien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Mecanicien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Mecanicien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new Mecanicien().setVisible(true);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(Mecanicien.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
//    
//    public void initialize() throws ClassNotFoundException, SQLException {
//        Connexion co = new Connexion();
//            Connection conn = null;
//        try {
//            conn = co.connect();
//        } catch (ClassNotFoundException ex) {
//            Logger.getLogger(getName()).log(Level.SEVERE, null, ex);
//        } catch (SQLException ex) {
//            Logger.getLogger(getName()).log(Level.SEVERE, null, ex);
//        }
//            PreparedStatement stat ;
//            ResultSet rs ;
//            String query1 = "SELECT idMecanicien FROM mecanicien;" ;
//            try {
//                stat = conn.prepareStatement(query1);// preparation de la requete à la machine
//                rs = stat.executeQuery(query1);//excuter la requete 
//                while (rs.next()) {
//                    String result = rs.getString("Classe");
//                    jComboBox1.addItem(result);
//                }
//            } catch(SQLException e) {
//            }
//            
//    
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JToggleButton jToggleButton2;
    private javax.swing.JToggleButton jToggleButton3;
    private javax.swing.JToggleButton jToggleButton4;
    // End of variables declaration//GEN-END:variables
}
