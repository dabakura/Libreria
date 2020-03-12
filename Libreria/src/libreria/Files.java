/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libreria;


import java.io.IOException;
import javax.swing.JOptionPane;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFileChooser;
import javax.swing.JTable;
import javax.swing.filechooser.FileNameExtensionFilter;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

/**
 *
 * @author David
 */
public class Files {
    
    public static void GUARDARDATOS(JTable jTable1){
        if (jTable1.getRowCount() > 0) {
            JFileChooser chooser = new JFileChooser();
            FileNameExtensionFilter filter = new FileNameExtensionFilter("Excel   .xls", "xls");
            chooser.setFileFilter(filter);
            chooser.setDialogTitle("Guardar archivo");
            chooser.setAcceptAllFileFilterUsed(false);
            String file="";
            List<JTable> tb = new ArrayList<>();
            List<String> nom = new ArrayList<>();
            if (chooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
                tb.add(jTable1);
                nom.add("Reportes de Tablas");
                file = chooser.getSelectedFile().toString().concat(".xls");
            }
            try {
                Exporter e = new Exporter(new File(file), tb, nom);
                if (e.export()) {
                    JOptionPane.showMessageDialog(null, "Los datos fueron exportados a excel en el directorio seleccionado", "Mensaje de Informacion", JOptionPane.INFORMATION_MESSAGE);
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Hubo un error " + e.getMessage(), " Error", JOptionPane.ERROR_MESSAGE);
            }
        }else
            JOptionPane.showMessageDialog(null, "No hay datos para exportar","Mensaje de error",JOptionPane.ERROR_MESSAGE);
    }   
    
    public static class Exporter {
        private final File file;
        private final List<JTable> TABLA;
        private final List<String> NOMFILES;

        public Exporter(File file, List<JTable> tabla, List<String> nom_files) throws Exception {
            this.file = file;
            this.TABLA = tabla;
            this.NOMFILES = nom_files;
            if (nom_files.size() != tabla.size()) {
                throw new Exception("Error");
            }
        }

        public boolean export() {
            try {
                try (DataOutputStream out = new DataOutputStream(new FileOutputStream(file))) {
                    WritableWorkbook w = Workbook.createWorkbook(out);
                    for (int index = 0; index < TABLA.size(); index++) {
                        JTable table = TABLA.get(index);
                        WritableSheet s = w.createSheet(NOMFILES.get(index), 0);
                        for (int j = 0; j < table.getColumnCount(); j++) {
                            Object object = table.getColumnName(j);
                            s.addCell(new Label(j, 0, String.valueOf(object)));
                        }
                        for (int i = 0; i < table.getColumnCount(); i++) {
                            for (int j = 1; j < table.getRowCount()+1; j++) {
                                Object object = table.getValueAt(j-1, i);
                                s.addCell(new Label(i, j, String.valueOf(object)));
                            }
                        }
                    }
                    w.write();
                    w.close();
                    out.close();
                }
                return true;
            }   catch (IOException | WriteException ex) {
                return false;
            }
        }
    }
}
