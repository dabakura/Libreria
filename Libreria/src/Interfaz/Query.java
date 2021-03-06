/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz;

import java.awt.Color;
import java.sql.*;
import java.sql.DriverManager;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import libreria.Files;
import libreria.Herramientas;

/**
 *
 * @author David
 */
public class Query extends javax.swing.JPanel {

    /**
     * Creates new form Default
     */
    public Query() {
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

        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextPane1 = new javax.swing.JTextPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtQuery = new javax.swing.JTable();
        jButton3 = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        setMaximumSize(new java.awt.Dimension(900, 579));
        setMinimumSize(new java.awt.Dimension(900, 579));
        setPreferredSize(new java.awt.Dimension(900, 579));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton1.setBackground(new java.awt.Color(204, 255, 255));
        jButton1.setText("Limpiar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 540, -1, -1));

        jButton2.setBackground(new java.awt.Color(255, 204, 204));
        jButton2.setText("ExecuteQuery");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 540, -1, -1));

        jScrollPane2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N

        jTextPane1.setBackground(new java.awt.Color(39, 40, 34));
        jTextPane1.setFont(new java.awt.Font("Lucida Sans", 0, 18)); // NOI18N
        jTextPane1.setForeground(new java.awt.Color(255, 255, 255));
        jTextPane1.setCaretColor(new java.awt.Color(255, 255, 255));
        jTextPane1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextPane1KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextPane1KeyReleased(evt);
            }
        });
        jScrollPane2.setViewportView(jTextPane1);

        add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 900, 360));

        jtQuery.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(jtQuery);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 370, 880, 160));

        jButton3.setBackground(new java.awt.Color(204, 204, 252));
        jButton3.setText("Guardar Resultados");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 540, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void jTextPane1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextPane1KeyPressed
        // TODO add your handling code here:
        if (((int) evt.getKeyChar()) == 10) {
            String texto = jTextPane1.getText();
            String[] parrafos = texto.split("\n");
            texto = "";
            for (int i = 0; i < parrafos.length; i++) {
                texto += parrafos[i].trim();
                if ((parrafos.length - 1) != i) {
                    texto += "\n";
                }
            }
            jTextPane1.setText(texto);
        }
    }//GEN-LAST:event_jTextPane1KeyPressed

    private void jTextPane1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextPane1KeyReleased
        String texto = jTextPane1.getText();
        String[] parrafos=texto.split("\n");
        int poscursor=jTextPane1.getCaretPosition();
        if(!evt.isActionKey())
            jTextPane1.setText(texto);
        int posicion =0;
        for (String parrafo : parrafos) {
            String[] palabras = parrafo.split(" ");
            for (String palabra : palabras) {
                for (String Reservada : Reservadas) {
                    if (Reservada.equals(palabra.toLowerCase())) {
                        jTextPane1.getStyledDocument().setCharacterAttributes(posicion, (posicion + Reservada.length()), atributo, false);
                        jTextPane1.getStyledDocument().setCharacterAttributes((posicion + Reservada.length()), (posicion + Reservada.length() - 1), atributo2, false);
                        break;
                    }
                }
                posicion += (palabra.length() + 1);
            }
        }
        jTextPane1.setCaretPosition(poscursor);
    }//GEN-LAST:event_jTextPane1KeyReleased

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        String verbo = jTextPane1.getSelectedText();
        if (verbo == null||verbo.equals("")) {
            Herramientas.Error("No has seleccionado el texto", "No seleccion en Texto");
        }else{
            String[] query = verbo.split("\n");
            verbo = "";
            for (String string : query) {
                verbo += string+" ";
            }
            CargarTabla(verbo);
        }
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        jTextPane1.setText("");
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        Files.GUARDARDATOS(jtQuery);
    }//GEN-LAST:event_jButton3ActionPerformed
    private void initComponent() {
        atributo = new SimpleAttributeSet();
        StyleConstants.setFontSize(atributo, 18);
        StyleConstants.setForeground(atributo, new java.awt.Color(102, 204, 255));
        StyleConstants.setBold(atributo, true);
        StyleConstants.setFontFamily(atributo, "Lucida Sans");
        atributo2 = new SimpleAttributeSet();
        StyleConstants.setFontSize(atributo2, 18);
        StyleConstants.setForeground(atributo2, Color.white);
        StyleConstants.setBold(atributo2, false);
        StyleConstants.setFontFamily(atributo2, "Lucida Sans");
    }

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextPane jTextPane1;
    private javax.swing.JTable jtQuery;
    // End of variables declaration//GEN-END:variables
    private final String[] Reservadas = new String[]{"select","sum","avg","count","from","group","by","having","max","min","where","when","between","like",
    "then","else","as","end","and", "or", "not", "xor","insert", "into", "values","order","in","update", "set","greatest","least","desc","asc"};
    private SimpleAttributeSet atributo;
    private SimpleAttributeSet atributo2;
    private static Connection con;
    private static Statement stmt;
    private static ResultSet rs;
    private static PreparedStatement psmt;
    private final static String CONNECTIONURL = "jdbc:sqlserver://localhost\\SQLEXPRESS:1433;databaseName=LibraryBase;user=LibraryAdmin;password=12345";
    
    private void CargarTabla(String query){
        try {
            // Establish the connection.
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection(CONNECTIONURL);
            stmt = con.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_UPDATABLE);
            // Create and execute an SQL statement that returns some data
            // and display it.
            DefaultTableModel modelo = new DefaultTableModel();
            rs = stmt.executeQuery(query);
            ResultSetMetaData rsMd = rs.getMetaData();
            int cantidadColumnas = rsMd.getColumnCount();
            for (int i = 1; i <= cantidadColumnas; i++) {
                modelo.addColumn(rsMd.getColumnLabel(i));
            }
            while (rs.next()) {
                Object[] fila = new Object[cantidadColumnas];
                for (int i = 0; i < cantidadColumnas; i++) {
                    fila[i]=rs.getObject(i+1);
                }
                modelo.addRow(fila);
            }
            this.jtQuery.setModel(modelo);
            rs.close();
            con.close();
        } // Handle any errors that may have occurred.
        catch (ClassNotFoundException | SQLException e) {
            System.out.println("*1");
            Herramientas.Error("Error en el Query o fallo de Conección", "Query Error");
        } finally {
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException e) {
                }
            }
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                }
            }
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                }
            }
        }
    }
}
