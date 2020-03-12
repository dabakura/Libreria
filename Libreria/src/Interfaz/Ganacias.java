/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import javax.swing.table.DefaultTableModel;
import libreria.AccionContable;
import libreria.Files;
import libreria.Herramientas;
import libreria.Tools;

/**
 *
 * @author David
 */
public class Ganacias extends javax.swing.JPanel implements Tools{

    /**
     * Creates new form Default
     */
    public Ganacias() {
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

        jScrollPane1 = new javax.swing.JScrollPane();
        tablaFacturas = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaGanancias = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        TTGanancias = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        TTCostos = new javax.swing.JLabel();

        setBackground(new java.awt.Color(51, 51, 51));
        setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        setMaximumSize(new java.awt.Dimension(900, 579));
        setMinimumSize(new java.awt.Dimension(900, 579));
        setPreferredSize(new java.awt.Dimension(900, 579));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));

        tablaFacturas.setBackground(new java.awt.Color(198, 219, 239));
        tablaFacturas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Cod_Factura", "Fecha", "Subtotal", "I.V", "Total", "Client.Cedula", "Cod_Haciento"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaFacturas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tablaFacturasMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(tablaFacturas);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 370, 840, 150));

        jScrollPane2.setBackground(new java.awt.Color(255, 255, 255));

        tablaGanancias.setBackground(new java.awt.Color(198, 219, 239));
        tablaGanancias.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Cod_Ingreso", "Fecha", "Total Bruto", "Costos Totales", "Total Ganancias"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaGanancias.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tablaGananciasMousePressed(evt);
            }
        });
        jScrollPane2.setViewportView(tablaGanancias);

        add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, 840, 200));

        jButton1.setText("Guardar Ganancias");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 320, 180, -1));

        jButton2.setText("Guardar Facturas");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 540, 180, -1));

        jPanel1.setBackground(new java.awt.Color(219, 239, 219));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Total de Ganancias"));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Monto: ");

        TTGanancias.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        TTGanancias.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(35, 35, 35)
                .addComponent(TTGanancias, javax.swing.GroupLayout.DEFAULT_SIZE, 249, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
            .addComponent(TTGanancias, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 20, 350, 60));

        jPanel2.setBackground(new java.awt.Color(255, 229, 229));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Total de Costos"));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Monto: ");

        TTCostos.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        TTCostos.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel2)
                .addGap(35, 35, 35)
                .addComponent(TTCostos, javax.swing.GroupLayout.DEFAULT_SIZE, 249, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
            .addComponent(TTCostos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void tablaFacturasMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaFacturasMousePressed

    }//GEN-LAST:event_tablaFacturasMousePressed

    private void tablaGananciasMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaGananciasMousePressed
        int index = tablaGanancias.getSelectedRow();
        if(index!=-1&&index<Contables.size()){
            CargarDetalles(Contables.get(index));
        }
    }//GEN-LAST:event_tablaGananciasMousePressed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Files.GUARDARDATOS(tablaGanancias);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        Files.GUARDARDATOS(tablaFacturas);
    }//GEN-LAST:event_jButton2ActionPerformed
    private void initComponent() {
        LimpiarTablas();
        BigInteger g= new BigInteger("0");
        BigInteger c= new BigInteger("0");
        DefaultTableModel modelo = (DefaultTableModel) tablaGanancias.getModel();
        Contables = new ArrayList<>();
        Contables.addAll(CONTABLES);
        Collections.sort(Contables, (AccionContable o1, AccionContable o2) -> (-1*(o1.getFecha().compareTo(o2.getFecha()))));
        Contables.forEach((factura) -> {
            modelo.addRow(new Object[]{""+factura.getCod_Ingreso(),Herramientas.toFechaString(factura.getFecha()),factura.getTotalBruto().toString(),
                factura.getCostos_Totales().toString(),factura.getTotal_Ganancia().toString()});
        });
        for (AccionContable facturas : Contables) {
            g = g.add(facturas.getTotal_Ganancia());
            c = c.add(facturas.getCostos_Totales());
        }
        TTCostos.setText(c.toString());
        TTGanancias.setText(g.toString());
        tablaGanancias.setModel(modelo);
    }
    
    private void CargarDetalles(AccionContable f) {
        DefaultTableModel modelo = (DefaultTableModel) tablaFacturas.getModel();
        int Rows = modelo.getRowCount();
        for (int i = 0; i < Rows; i++) {
            modelo.removeRow(0);
        }
        tablaFacturas.setModel(modelo);
        f.getFacturas().forEach((detalle) -> {
            modelo.addRow(new Object[]{detalle.getCod_Factura(),Herramientas.toFechaString(detalle.getFecha()),""+detalle.getSubtotal(),
                ""+detalle.getIV(),detalle.getTotal(),detalle.getClient().getCedula(),""+detalle.getHacientoContable()});
        });
        tablaFacturas.setModel(modelo);
    }
    
    private void LimpiarTablas(){
        DefaultTableModel modelo = (DefaultTableModel) tablaFacturas.getModel();
        int Rows = modelo.getRowCount();
        for (int i = 0; i < Rows; i++) {
            modelo.removeRow(0);
        }
        tablaFacturas.setModel(modelo);
        modelo = (DefaultTableModel) tablaGanancias.getModel();
        Rows = modelo.getRowCount();
        for (int i = 0; i < Rows; i++) {
            modelo.removeRow(0);
        }
        tablaGanancias.setModel(modelo);
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel TTCostos;
    private javax.swing.JLabel TTGanancias;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tablaFacturas;
    private javax.swing.JTable tablaGanancias;
    // End of variables declaration//GEN-END:variables
    private ArrayList<AccionContable> Contables;
}
