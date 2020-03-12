/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import javax.swing.table.DefaultTableModel;
import libreria.Files;
import libreria.Libro;
import libreria.Tools;

/**
 *
 * @author David
 */
public class Estadisticas extends javax.swing.JPanel implements Tools{

    /**
     * Creates new form Default
     */
    public Estadisticas() {
        initComponents();
        initComponent();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Vendidos = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        Agotados = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        NoVendidos = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        setMaximumSize(new java.awt.Dimension(900, 579));
        setMinimumSize(new java.awt.Dimension(900, 579));
        setPreferredSize(new java.awt.Dimension(900, 579));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)), "Libros Mas Vendidos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.BELOW_TOP, new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(255, 255, 255))); // NOI18N
        jPanel1.setLayout(new java.awt.BorderLayout());

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));

        Vendidos.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        Vendidos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ISBN", "Titulo", "Editorial", "Estanteria", "Cod_Stock", "Cant. Almacenados", "Cant. Vendidos"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        Vendidos.setOpaque(false);
        jScrollPane1.setViewportView(Vendidos);

        jPanel1.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 880, 300));

        jButton1.setBackground(new java.awt.Color(204, 0, 0));
        jButton1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Guardar Informe");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 315, -1, -1));

        jPanel2.setBackground(new java.awt.Color(204, 0, 0));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)), "Libros por Agotarce", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.BELOW_TOP, new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(255, 255, 255))); // NOI18N
        jPanel2.setLayout(new java.awt.BorderLayout());

        jScrollPane2.setBackground(new java.awt.Color(255, 255, 255));

        Agotados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ISBN", "Titulo", "Cod_Stock", "Cant. Almacenada"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        Agotados.setOpaque(false);
        jScrollPane2.setViewportView(Agotados);

        jPanel2.add(jScrollPane2, java.awt.BorderLayout.CENTER);

        add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 340, 430, 220));

        jPanel3.setBackground(new java.awt.Color(204, 0, 0));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)), "Libros no Vendidos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.BELOW_TOP, new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(255, 255, 255))); // NOI18N
        jPanel3.setLayout(new java.awt.BorderLayout());

        jScrollPane3.setBackground(new java.awt.Color(255, 255, 255));

        NoVendidos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ISBN", "Titulo", "Cod_Stock", "Cant. Almacenada"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        NoVendidos.setOpaque(false);
        jScrollPane3.setViewportView(NoVendidos);

        jPanel3.add(jScrollPane3, java.awt.BorderLayout.CENTER);

        add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 340, 420, 220));

        jButton2.setBackground(new java.awt.Color(51, 51, 51));
        jButton2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Guardar Informe");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 310, -1, -1));

        jButton3.setBackground(new java.awt.Color(204, 0, 0));
        jButton3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("Guardar Informe");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 315, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        Files.GUARDARDATOS(Vendidos);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        Files.GUARDARDATOS(Agotados);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Files.GUARDARDATOS(NoVendidos);
    }//GEN-LAST:event_jButton1ActionPerformed
    private void initComponent() {
        DefaultTableModel modelo = (DefaultTableModel) Vendidos.getModel();
        DefaultTableModel modelo1 = (DefaultTableModel) NoVendidos.getModel();
        DefaultTableModel modelo2 = (DefaultTableModel) Agotados.getModel();
        ArrayList<Libro> Libros = new ArrayList<>();
        Libros.addAll(LIBROS);
        Collections.sort(Libros, new Comparator<Libro>() {
            @Override
            public int compare(Libro o1, Libro o2) {
                int r;
                if (o1.getEjemplares().getVendidos()==o2.getEjemplares().getVendidos()) {
                    r = 0;
                }else if (o1.getEjemplares().getVendidos()>o2.getEjemplares().getVendidos()) {
                    r = -1;
                }else{
                    r = 1;
                }
                return r;
            }
        });
        for (Libro libro : Libros) {
            if (libro.getEjemplares().getVendidos()!=0) {
                modelo.addRow(new String[]{libro.getIbsn(),libro.getTitulo(),
                    libro.getEditorial().getNombre(),""+libro.getNestanteria(),
                    ""+libro.getEjemplares().getCodigo_Stock(),""+libro.getEjemplares().getCantidad_Almacenada(),
                    ""+libro.getEjemplares().getVendidos()});
            }else{
                modelo1.addRow(new String[]{libro.getIbsn(),libro.getTitulo(),
                    ""+libro.getEjemplares().getCodigo_Stock(),
                    ""+libro.getEjemplares().getCantidad_Almacenada()});
            }
            if (libro.getEjemplares().getCantidad_Almacenada()<11) {
                modelo2.addRow(new String[]{libro.getIbsn(),libro.getTitulo(),
                    ""+libro.getEjemplares().getCodigo_Stock(),
                    ""+libro.getEjemplares().getCantidad_Almacenada()});
            }
        }
        Vendidos.setModel(modelo);
        NoVendidos.setModel(modelo1);
        Agotados.setModel(modelo2);
    }

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable Agotados;
    private javax.swing.JTable NoVendidos;
    private javax.swing.JTable Vendidos;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    // End of variables declaration//GEN-END:variables
}