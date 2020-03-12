/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectogui;
import java.io.*;
import javax.swing.*;
/**
 *
 * @author Laboratorios
 */
public class clsGestionArchivo {
    FileInputStream entrada;
    FileOutputStream salida;
    File archivo;

    public clsGestionArchivo() {
    }
    
    public String abrirTexto(File archivo){
        String contenido=null;// Variable que devuelve el texto del archivo
        try {
            entrada = new FileInputStream(archivo);
            int letra;
            while((letra =entrada.read())!=-1){
                char caracter = (char)letra;
                contenido+=caracter;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Error al abrir el archivo");
        }

        return contenido;   
    }
    public String guardarTexto(File archivo, String contenido){
        String resultado=null;
        try {
            salida = new FileOutputStream(archivo);
            byte[] bytetxt = contenido.getBytes();
            salida.write(bytetxt);
            resultado = "Archivo guardado con exito";
        } catch (IOException e) {
            resultado = "Error al guardar el archivo";
        }
        return resultado;
    }
    public byte[] abrirImagen(File archivo){
        byte[] byteImg=new byte[(int)archivo.length()];
        try {
            entrada=new FileInputStream(archivo);
            entrada.read(byteImg);
            entrada.close();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null,"Error al cargar la imagen");
        }
        return byteImg;
    }
    public String guardarImagen(File archivo, byte[] byteImg){
        String resultado = null;
        try {
            salida = new FileOutputStream(archivo);
            salida.write(byteImg);
            salida.flush();
            salida.close();
            resultado = "La imagen se guardo correctamente.";
            
        } catch (IOException e) {
            resultado = "Error al guardar la imagen.";
        }
        return resultado;
    }
    //Copia utilizando un buffer explicito
    public void copiararchivo(File archivo1, File archivo2){
        FileReader entrada = null;
        FileWriter salida = null;
        try {
            entrada = new FileReader(archivo1);
            salida = new FileWriter(archivo2);
            
            char[] buffer= new char[128];
            int caracter;
            caracter=entrada.read(buffer);
            //while ((caracter=entrada.read(buffer))!=-1){
            while (caracter !=-1){
                salida.write(buffer, 0, caracter);
                caracter=entrada.read(buffer);
            }
            entrada.close();
            salida.close();
            
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "La copia no se completo satisfactoriamente");
        }
    }
    public void copiaarchivobuf(File archivo1, File archivo2){
        BufferedReader entrada = null;
        BufferedWriter salida = null;
        try {
            entrada= new BufferedReader(new FileReader(archivo1));
            String linea;
            linea = entrada.readLine();
           // while((linea = entrada.readLine())!=null)
            while(linea != null){
                salida.write(linea, 0, linea.length());
                salida.newLine();
                linea = entrada.readLine();
            } 
            entrada.close();
            salida.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se completo la copia del archivo");
        }
        
    }    
}
