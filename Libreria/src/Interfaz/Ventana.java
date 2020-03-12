/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz;

import javax.swing.JPanel;

/**
 *
 * @author David
 */
public class Ventana extends javax.swing.JFrame {

    /**
     * Creates new form Monitor
     * @param panel
     */
    public Ventana(JPanel panel) {
        initComponents();
        CargarPanel(panel);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem4 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();

        jMenuItem4.setText("jMenuItem4");

        jMenu3.setText("jMenu3");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Libreria");
        setMaximumSize(new java.awt.Dimension(900, 600));
        setMinimumSize(new java.awt.Dimension(900, 600));
        setModalExclusionType(java.awt.Dialog.ModalExclusionType.TOOLKIT_EXCLUDE);
        setPreferredSize(new java.awt.Dimension(900, 600));
        setResizable(false);
        setType(java.awt.Window.Type.UTILITY);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuItem jMenuItem4;
    // End of variables declaration//GEN-END:variables
    private javax.swing.JPanel jPanel;
    
    private void CargarPanel(JPanel panel) {
        if (panel instanceof AgregarAutor) {
            ((AgregarAutor) panel).setV(this);
            this.setTitle("Agregar Autor");
        } else if (panel instanceof AgregarEditorial) {
            ((AgregarEditorial) panel).setV(this);
            this.setTitle("Agregar Editorial");
        }
        if (jPanel!=null) {
            this.remove(jPanel);
        }
        jPanel = panel;
        this.getContentPane().add(jPanel, java.awt.BorderLayout.CENTER); 
    }
}
