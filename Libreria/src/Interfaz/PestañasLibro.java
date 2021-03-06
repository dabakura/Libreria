/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz;


import java.awt.Component;
import javax.swing.JPanel;
import libreria.Herramientas;
import libreria.Libro;
import libreria.Stock;
import libreria.Util;

/**
 *
 * @author David
 */
public class PestañasLibro extends javax.swing.JPanel {

    /**
     * Creates new form PestañasLibro
     */
    public PestañasLibro() {
        initComponents();
        n = 1;
        nedicion.setValue(n);
        nestanteria.setValue(n);
        nejemplares.setValue(n);
        arrayTitulo = new javax.swing.JLabel[]{jLabel1,jLabel3,jLabel5};
        arraybarra = new javax.swing.JLabel[]{jLabel2,jLabel4,jLabel6};
        arrayPanel = new JPanel[]{jPanel2,jPanel7,jPanel8};
        nstock = Util.getCodigoStock();
        Apagado(0);
        this.estado = false;
    }
    
    public PestañasLibro(boolean estado) {
        initComponents();
        n = 1;
        nedicion.setValue(n);
        nestanteria.setValue(n);
        nejemplares.setValue(n);
        arrayTitulo = new javax.swing.JLabel[]{jLabel1,jLabel3,jLabel5};
        arraybarra = new javax.swing.JLabel[]{jLabel2,jLabel4,jLabel6};
        arrayPanel = new JPanel[]{jPanel2,jPanel7,jPanel8};
        nstock = Util.getCodigoStock();
        Apagado(0);
        this.estado = estado;
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel4 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        isbn = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        subtitulo = new javax.swing.JTextField();
        titulo = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        descripcion = new javax.swing.JTextArea();
        jPanel7 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        año = new javax.swing.JFormattedTextField();
        jLabel20 = new javax.swing.JLabel();
        npaginas = new javax.swing.JFormattedTextField();
        jLabel21 = new javax.swing.JLabel();
        nedicion = new javax.swing.JSpinner();
        jLabel19 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        caratura = new javax.swing.JComboBox<>();
        jPanel8 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        costo = new javax.swing.JFormattedTextField();
        precio = new javax.swing.JFormattedTextField();
        jLabel23 = new javax.swing.JLabel();
        nejemplares = new javax.swing.JSpinner();
        nestanteria = new javax.swing.JSpinner();
        jLabel24 = new javax.swing.JLabel();

        setMaximumSize(new java.awt.Dimension(520, 430));
        setMinimumSize(new java.awt.Dimension(520, 430));
        setPreferredSize(new java.awt.Dimension(520, 430));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel4.setBackground(new java.awt.Color(4, 42, 93));
        jPanel4.setMaximumSize(new java.awt.Dimension(520, 60));
        jPanel4.setMinimumSize(new java.awt.Dimension(520, 60));
        jPanel4.setPreferredSize(new java.awt.Dimension(520, 60));
        jPanel4.setLayout(new java.awt.GridLayout(1, 3));

        jPanel6.setBackground(new java.awt.Color(6, 63, 142));
        jPanel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel6MousePressed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Información");

        jLabel2.setBackground(new java.awt.Color(0, 255, 0));
        jLabel2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(6, 63, 142), 1, true));
        jLabel2.setOpaque(true);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 153, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 8, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel4.add(jPanel6);

        jPanel5.setBackground(new java.awt.Color(5, 52, 117));
        jPanel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel5MousePressed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(153, 153, 153));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Especificación");

        jLabel4.setBackground(new java.awt.Color(102, 102, 102));
        jLabel4.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(5, 52, 117), 1, true));
        jLabel4.setOpaque(true);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 153, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 8, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel4.add(jPanel5);

        jPanel3.setBackground(new java.awt.Color(4, 42, 93));
        jPanel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel3MousePressed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(153, 153, 153));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Costos");

        jLabel6.setBackground(new java.awt.Color(102, 102, 102));
        jLabel6.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(4, 42, 93), 1, true));
        jLabel6.setOpaque(true);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 153, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 8, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel4.add(jPanel3);

        add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 520, 50));

        jPanel2.setBackground(new java.awt.Color(6, 63, 142));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel7.setBackground(new java.awt.Color(0, 0, 51));
        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Numero de ISBN");
        jLabel7.setOpaque(true);
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 11, 480, -1));

        isbn.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        isbn.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                isbnFocusLost(evt);
            }
        });
        jPanel1.add(isbn, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 56, 480, 28));

        jLabel8.setBackground(new java.awt.Color(0, 0, 51));
        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Titulo");
        jLabel8.setOpaque(true);
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 114, 216, -1));

        jLabel9.setBackground(new java.awt.Color(0, 0, 51));
        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Subtitulo");
        jLabel9.setOpaque(true);
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(274, 114, 216, -1));

        subtitulo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jPanel1.add(subtitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(274, 164, 216, 28));

        titulo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jPanel1.add(titulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 164, 216, 28));

        jLabel10.setBackground(new java.awt.Color(0, 0, 51));
        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("Descripcion");
        jLabel10.setOpaque(true);
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 210, 480, -1));

        descripcion.setColumns(20);
        descripcion.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        descripcion.setRows(80);
        jScrollPane1.setViewportView(descripcion);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 247, 480, 100));

        jPanel2.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 11, 500, 360));

        add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, -1, -1));

        jPanel7.setBackground(new java.awt.Color(5, 52, 117));
        jPanel7.setMaximumSize(new java.awt.Dimension(520, 380));
        jPanel7.setMinimumSize(new java.awt.Dimension(520, 380));
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));
        jPanel9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        try {
            año.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        año.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        año.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jPanel9.add(año, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 104, 216, 28));

        jLabel20.setBackground(new java.awt.Color(0, 0, 51));
        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel20.setText("Numero de Paginas");
        jLabel20.setOpaque(true);
        jPanel9.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 53, 216, -1));

        try {
            npaginas.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        npaginas.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        npaginas.setFocusLostBehavior(javax.swing.JFormattedTextField.COMMIT);
        npaginas.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jPanel9.add(npaginas, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 104, 216, 28));

        jLabel21.setBackground(new java.awt.Color(0, 0, 51));
        jLabel21.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel21.setText("Numero de Edición");
        jLabel21.setOpaque(true);
        jPanel9.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 202, 216, -1));

        nedicion.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        nedicion.setModel(new javax.swing.SpinnerNumberModel(1, 1, null, 1));
        jPanel9.add(nedicion, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 246, 216, 28));

        jLabel19.setBackground(new java.awt.Color(0, 0, 51));
        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel19.setText("Fecha Emicion");
        jLabel19.setOpaque(true);
        jPanel9.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 53, 216, -1));

        jLabel22.setBackground(new java.awt.Color(0, 0, 51));
        jLabel22.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel22.setText("Tipo de Caratura");
        jLabel22.setOpaque(true);
        jPanel9.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 202, 216, -1));

        caratura.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        caratura.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Dura", "Suave" }));
        jPanel9.add(caratura, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 246, 216, 28));

        jPanel7.add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 11, 500, 360));

        add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, -1, -1));

        jPanel8.setBackground(new java.awt.Color(4, 42, 93));
        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel10.setBackground(new java.awt.Color(255, 255, 255));

        jLabel11.setBackground(new java.awt.Color(0, 0, 51));
        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("Costo");
        jLabel11.setOpaque(true);

        jLabel12.setBackground(new java.awt.Color(0, 0, 51));
        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("Precio Venta");
        jLabel12.setOpaque(true);

        try {
            costo.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#######")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        costo.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        costo.setFocusLostBehavior(javax.swing.JFormattedTextField.COMMIT);
        costo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        try {
            precio.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#######")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        precio.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        precio.setFocusLostBehavior(javax.swing.JFormattedTextField.COMMIT);
        precio.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        jLabel23.setBackground(new java.awt.Color(0, 0, 51));
        jLabel23.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(255, 255, 255));
        jLabel23.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel23.setText("Numero de Ejemplares");
        jLabel23.setOpaque(true);

        nejemplares.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        nejemplares.setModel(new javax.swing.SpinnerNumberModel(1, 1, null, 1));

        nestanteria.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        nestanteria.setModel(new javax.swing.SpinnerNumberModel(1, 1, null, 1));

        jLabel24.setBackground(new java.awt.Color(0, 0, 51));
        jLabel24.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(255, 255, 255));
        jLabel24.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel24.setText("Numero de Estanteria");
        jLabel24.setOpaque(true);

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, 216, Short.MAX_VALUE)
                    .addComponent(costo, javax.swing.GroupLayout.DEFAULT_SIZE, 216, Short.MAX_VALUE)
                    .addComponent(jLabel24, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(nestanteria))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(precio)
                    .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel23, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 216, Short.MAX_VALUE)
                    .addComponent(nejemplares, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 216, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(nejemplares, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(nestanteria, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel23)
                        .addComponent(jLabel24)))
                .addGap(68, 68, 68)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addGap(30, 30, 30)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(precio, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(costo, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel11))
                .addContainerGap(73, Short.MAX_VALUE))
        );

        jPanel8.add(jPanel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 11, 500, 360));

        add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, -1, 380));
    }// </editor-fold>//GEN-END:initComponents

    private void jPanel6MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel6MousePressed
        Apagado(0);
    }//GEN-LAST:event_jPanel6MousePressed

    private void jPanel5MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel5MousePressed
        Apagado(1);
    }//GEN-LAST:event_jPanel5MousePressed

    private void jPanel3MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel3MousePressed
        Apagado(2);
    }//GEN-LAST:event_jPanel3MousePressed

    private void isbnFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_isbnFocusLost
        if (!isbn.getText().equals("")&&!estado) {
            if (Util.EncontraLibro(isbn.getText())) {
                Herramientas.Error("Este libro ya esta registado", "El libro ya existe");
            }
        }
    }//GEN-LAST:event_isbnFocusLost

    private void Apagado(int n){
        for (int i=0; i<arrayTitulo.length;i++) {
            if (i!=n) {
                arrayTitulo[i].setForeground(new java.awt.Color(153, 153, 153));
                arraybarra[i].setBackground(new java.awt.Color(102, 102, 102));
                arrayPanel[i].setVisible(false);
            }else {
                arrayTitulo[i].setForeground(new java.awt.Color(255, 255, 255));
                arraybarra[i].setBackground(new java.awt.Color(0, 255, 0));
                this.setBackground(arrayPanel[i].getBackground());
                arrayPanel[i].setVisible(true);
            }
        }
    }
    
    public void Reset(){
        Herramientas.ResetCampos(new Component[] {titulo,subtitulo,isbn,descripcion,año,npaginas,costo,precio});
        caratura.setSelectedIndex(0);
        nejemplares.setValue(n);
        nedicion.setValue(n);
        nestanteria.setValue(n);
    }
    
    public void Cargardatos(Libro l){
        isbn.setText(l.getIbsn());
        isbn.setEditable(false);
        descripcion.setText(l.getDescripcion());
        año.setText(""+l.getAño());
        npaginas.setText(""+l.getNpaginas());
        titulo.setText(l.getTitulo());
        costo.setText(""+l.getCosto());
        precio.setText(""+l.getPrecio());
        subtitulo.setText(l.getTitulo());
        caratura.setSelectedItem(l.getCaratura());
        nejemplares.setValue(l.getEjemplares().getCantidad_Almacenada());
        nejemplares.setEnabled(false);
        nedicion.setValue(l.getNedicion());
        nestanteria.setValue(l.getNestanteria());
    }
    
    public Libro getLibro(){
        Libro l;
        if (Herramientas.ValidarCampos(new Component[] {titulo,subtitulo,isbn,descripcion,año,npaginas,costo,precio})) {
            if (!estado && Util.EncontraLibro(isbn.getText())) {
                Herramientas.Error("Este libro ya esta registado", "El libro ya existe");
            }else{
                l = new Libro(isbn.getText(), titulo.getText(), subtitulo.getText(), descripcion.getText(),
                    Integer.valueOf(año.getText().trim()), Integer.valueOf(npaginas.getText().trim()),
                    Integer.valueOf(nedicion.getValue().toString()), caratura.getItemAt(caratura.getSelectedIndex()),
                    Integer.valueOf(nestanteria.getValue().toString()),new Stock(nstock,Integer.valueOf(nejemplares.getValue().toString())), 
                    Integer.valueOf(costo.getText().trim()), Integer.valueOf(precio.getText().trim()));
                return l;
            }
        } else {
            Herramientas.Error("No has llenado todos los campos\nAsegurate de llenar bien la información", "Campos Vacios");
        }
        return null;
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JFormattedTextField año;
    private javax.swing.JComboBox<String> caratura;
    private javax.swing.JFormattedTextField costo;
    private javax.swing.JTextArea descripcion;
    private javax.swing.JTextField isbn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSpinner nedicion;
    private javax.swing.JSpinner nejemplares;
    private javax.swing.JSpinner nestanteria;
    private javax.swing.JFormattedTextField npaginas;
    private javax.swing.JFormattedTextField precio;
    private javax.swing.JTextField subtitulo;
    private javax.swing.JTextField titulo;
    // End of variables declaration//GEN-END:variables
    private final javax.swing.JLabel[] arrayTitulo;
    private final javax.swing.JLabel[] arraybarra;
    private final JPanel[] arrayPanel;
    private final Number n;
    private final int nstock;
    private final boolean estado;
}
