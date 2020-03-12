/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libreria;

import java.awt.Component;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author David
 */
public class Herramientas {
    public static boolean ValidarCampos(Component[] componentes){
        for (Component c: componentes) {
            try {
                if (c instanceof JTextField) {
                    if (((JTextField) c).getText().trim().equals("")) 
                        return false;
                } else if (c instanceof JTextArea) {
                    if (((JTextArea) c).getText().equals("")) 
                        return false;
                }
            } catch (NullPointerException e) {
                return false;
            }
        }
        return true;
    }
    
    public static void ResetCampos(Component[] componentes){
        for (Component c : componentes) {
            if (c instanceof JTextField) {
                ((JTextField) c).setText("");
            } else if (c instanceof JTextArea) {
                ((JTextArea) c).setText("");
            }
        }
    }
    
    public static String toFechaString(Date fecha){
        if(fecha==null){
            return "";
        }
        String fechaString;
        DateFormat dateformathora= new SimpleDateFormat("yyyy/MM/dd");
        fechaString = dateformathora.format(fecha);
        return fechaString;
    }
    
    public static Date toStringFecha(String fecha){
        if (fecha == null||fecha.equals("")){
            return null;
        }
        String[] f = fecha.split("/");
        Date Stringfecha = (new GregorianCalendar(Integer.parseInt(f[0]),Integer.parseInt(f[1])-1,Integer.parseInt(f[2]),0,0,1)).getTime();
        return Stringfecha;
    }
    
    public static void mensage(String m,String t){
        JOptionPane.showMessageDialog(null, m, t, JOptionPane.INFORMATION_MESSAGE);
    }
    
    public static void Error(String m,String t){
        JOptionPane.showMessageDialog(null, m, t, JOptionPane.ERROR_MESSAGE);
    }
}
