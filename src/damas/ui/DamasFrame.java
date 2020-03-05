package damas.ui;


import damas.entity.Moviments;
import damas.entity.MovimentsId;
import damas.entity.Partida;
import java.util.List;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Alumne
 */
public class DamasFrame extends javax.swing.JFrame {
    
    int numeroDeX = 0;
    int numeroDeO = 0;
    boolean juegaX = true;
    boolean juegaO = false;
    int filaOrigen = -1;
    int columnaOrigen = -1;
    int numMoviments = 0;
    String quiHaGuanyat = "";
    Moviments m;
    Partida p = new Partida(new Date(), numMoviments, quiHaGuanyat);
    String tablero;
    List<Moviments> moviments = new ArrayList<>();
    private static final String Query_moviments = "select p.numeroMoviments from Partida p where p.numeroPartida = '";
    private static final String Query_tablero = "select m.tablerojuego from Moviments m where m.partida = ";
    
    public DamasFrame() {
        initComponents();
        Session session = (Session) damas.util.HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(p);
        session.getTransaction().commit();
        session.close();
    }
   

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"X", null, "X", null, "X", null, "X", null},
                {null, "X", null, "X", null, "X", null, "X"},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {"O", null, "O", null, "O", null, "O", null},
                {null, "O", null, "O", null, "O", null, "O"}
            },
            new String [] {
                "Columna1", "Columna2", "Columna3", "Columna4", "Columna5", "Columna6", "Columna7", "Columna8"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabla.setCellSelectionEnabled(true);
        tabla.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabla);

        jButton1.setText("Sortir");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jLabel1.setText("IdPartida:");

        jButton2.setText("Cargar partida");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 333, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addGap(56, 56, 56)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton2)))))
                .addContainerGap(32, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tablaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaMouseClicked

         int fila = obtenirFilaClicada();
         int columna = obtenirColumnaClicada();
           
         if(noHiHaOrigen()){
             if(juegaX && EsX(fila, columna, tabla)){
                 actualitzaNouOrigen(fila, columna);
             }else if(juegaO && EsO(fila, columna, tabla)){
                 actualitzaNouOrigen(fila, columna);
             }else{
                 mostrarError();
             }
         }else{
              if(ocupatPropi(fila, columna)){
                 actualitzaNouOrigen(fila, columna);
                 } else if(movimentValid(fila, columna)){
                 if(esBuit(fila, columna) || ocupatContrari(fila, columna)){
                     mou(fila, columna);
                 }
             }else{
                     mostrarError();
                 }
         }
    }//GEN-LAST:event_tablaMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
        if(numeroDeX > numeroDeO){
            quiHaGuanyat += "Guanya X";
        }else if(numeroDeX > numeroDeO){
             quiHaGuanyat += "Guanya O";
        }else{
             quiHaGuanyat += "Empat";
        }
        p.setQuiHaGuanyat(quiHaGuanyat);
        Session session = (Session) damas.util.HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();       
        session.update(p);
        session.getTransaction().commit();       
        for (int i = 0; i < moviments.size(); i++) {
           session.beginTransaction();
           session.save(moviments.get(i));
           session.getTransaction().commit();
        }
        session.close();
        this.setVisible(false);
        new menu().setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        
        //jTextField1.setText(runQueryDeMoviments()+"");
        String tablero = runQueryTablero();
        String[][] tablaString = new String[8][8];
        int indiceCharArray = 0;
        int contador = 0;
        for (int i = 0; i < 8; i++) {
                    for (int j = 0; j < 8; j++) { 
                        tablaString[i][j] = String.valueOf(tablero.charAt(contador));
                        tabla.setValueAt(tablaString[i][j], i, j);
                        contador++;               
                    }   
                } 
    }//GEN-LAST:event_jButton2ActionPerformed
    
    private int runQueryDeMoviments(){
        Session session = (Session) damas.util.HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();  
        Query query = session.createQuery(Query_moviments+jTextField1.getText()+"'");
        List resultList = query.list();
        return(int) resultList.get(0);
    }
    
    private String runQueryTablero(){
        Session session = (Session) damas.util.HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();  
        Query query = session.createQuery(Query_tablero+jTextField1.getText());
        List resultList = query.list();
        return(String) resultList.get(0);
    }
    
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
            java.util.logging.Logger.getLogger(DamasFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DamasFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DamasFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DamasFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
         
                 
                new DamasFrame().setVisible(true);
            }
        });
    }
    
    public void actualitzaNouOrigen(int fila, int columna){
        filaOrigen = fila;
        columnaOrigen = columna;
    }
    
     public boolean movimentValid(int fila, int columna){
        if(juegaX){
            if(fila - 1 == filaOrigen && columna -1 == columnaOrigen){
                return true;
            }else if(fila - 1 == filaOrigen && columna +1 == columnaOrigen){
                return true;
            }
        }else{
             if(fila + 1 == filaOrigen && columna +1 == columnaOrigen){
                return true;
            }else if(fila + 1 == filaOrigen && columna -1 == columnaOrigen){
                return true;
            }
        }
        return false;
    }
    
    
    public boolean noHiHaOrigen(){
        if (filaOrigen == -1 && columnaOrigen == -1){
            return true;
        }
        return false;
    }
    
   
    public static int obtenirFilaClicada(){
        return tabla.getSelectedRow();
    }
     public static int obtenirColumnaClicada(){
        return tabla.getSelectedColumn();
    }
     public static boolean EsX(int fila, int columna, JTable tabla){
        if((String)tabla.getValueAt(fila, columna) == "X"){
            return true;
        }
        return false;
     }
     
     public static boolean EsO(int fila, int columna, JTable tabla){
        if((String)tabla.getValueAt(fila, columna) == "O"){
            return true;
        }
        return false;
     }
     
     
     
     public boolean esBuit(int fila, int columna){
         if (tabla.getValueAt(fila, columna) == null){
             return true;
         }
         return false;
     }
     
     public boolean ocupatContrari(int fila, int columna){
         if(juegaX){
             if ((String)tabla.getValueAt(fila, columna) == "O"){
                 return true;
             }   
         }else if(juegaO){
              if ((String)tabla.getValueAt(fila, columna) == "X"){
                   return true;
              }
         }
         return false; 
     }
     
     public void mou (int fila, int columna){
         tablero = new String();
         if(juegaX){
             tabla.setValueAt("X", fila, columna);
             tabla.setValueAt(null, filaOrigen, columnaOrigen);
             filaOrigen = -1;
             columnaOrigen = -1;
             juegaX = false;
             juegaO = true;
             numMoviments++;
         }else{
             tabla.setValueAt("O", fila, columna);
             tabla.setValueAt(null, filaOrigen, columnaOrigen);
             filaOrigen = -1;
             columnaOrigen = -1;
             juegaX = true;
             juegaO = false;
         }
         
         for (int i = 0; i < 8; i++) {
                    for (int j = 0; j < 8; j++) {
                        String temporal = (tabla.getValueAt(i, j)==null)?" ":(String) tabla.getValueAt(i, j);
                        //String temporal = (String) tabla.getValueAt(i, j);
                        if(temporal.equals("X")){
                            tablero += temporal;
                            numeroDeX++;
                        }else if(temporal.equals("O")){
                            tablero += temporal;
                            numeroDeO++;
                        }else{
                            tablero += " ";
                        }
                    }
                    
                } 
         
         numMoviments++;
         MovimentsId mid = new MovimentsId(p.getNumeroPartida(),numMoviments);
         m = new Moviments(mid,p,tablero);
         moviments.add(m);     
         p.setNumeroMoviments(numMoviments);
        
         
     }
     
     public boolean ocupatPropi(int fila, int columna){
         if(juegaX){
             if(tabla.getValueAt(fila, columna) == "X"){
                 return true;
             }
         }else{
             if(tabla.getValueAt(fila, columna) == "O"){
                 return true;
             }
         }
         return false;
     }
     
     public void mostrarError(){
          JOptionPane.showMessageDialog(null, "Moviment no valid!", "Error!", JOptionPane.INFORMATION_MESSAGE);
     }
     
     
     

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private static javax.swing.JTable tabla;
    // End of variables declaration//GEN-END:variables
}
