/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Interfaces;

/**
 *@Description: interfaz para crear y eliminar documentos en la simulación
 * @author Catalina Matheus 
 * @version: 12/11/2023
 */
public class CrearEliminarDoc extends javax.swing.JFrame {

    /**
     * Creates new form CrearEliminarDoc
     */
    public CrearEliminarDoc() {
        initComponents();
        transpareciaButton(); 
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        CrearDoc = new javax.swing.JToggleButton();
        EliminarDoc = new javax.swing.JToggleButton();
        jToggleButton1 = new javax.swing.JToggleButton();
        Imagen = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        CrearDoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CrearDocActionPerformed(evt);
            }
        });
        getContentPane().add(CrearDoc, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 290, 340, 50));

        EliminarDoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EliminarDocActionPerformed(evt);
            }
        });
        getContentPane().add(EliminarDoc, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 290, 390, 50));

        jToggleButton1.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        jToggleButton1.setText("ATRÁS");
        jToggleButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jToggleButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 530, 130, -1));

        Imagen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/CrearEliminarDOC.jpg"))); // NOI18N
        getContentPane().add(Imagen, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jToggleButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton1ActionPerformed
        this.setVisible(false); 
        MainInterface i = new MainInterface(); 
        i.setVisible(true); 
    }//GEN-LAST:event_jToggleButton1ActionPerformed

    private void CrearDocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CrearDocActionPerformed
       this.setVisible(false);
       CrearDocumento i = new CrearDocumento(); 
       i.setVisible(true); 
    }//GEN-LAST:event_CrearDocActionPerformed

    private void EliminarDocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EliminarDocActionPerformed
        this.setVisible(false); 
        EliminarDocumento i = new EliminarDocumento(); 
        i.setVisible(true); 
    }//GEN-LAST:event_EliminarDocActionPerformed

    /**
     * @Description: método que hace que todos los botones de la interfaz sean transparentes 
     * @author: Catalina Matheus 
     * @version: 12/11/2023
     */
    public void transpareciaButton(){
       EliminarDoc.setOpaque(false);
       EliminarDoc.setContentAreaFilled(false);
       EliminarDoc.setBorderPainted(false); 

       CrearDoc.setOpaque(false);
       CrearDoc.setContentAreaFilled(false);
       CrearDoc.setBorderPainted(false); 

       
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
            java.util.logging.Logger.getLogger(CrearEliminarDoc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CrearEliminarDoc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CrearEliminarDoc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CrearEliminarDoc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CrearEliminarDoc().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton CrearDoc;
    private javax.swing.JToggleButton EliminarDoc;
    private javax.swing.JLabel Imagen;
    private javax.swing.JToggleButton jToggleButton1;
    // End of variables declaration//GEN-END:variables
}
