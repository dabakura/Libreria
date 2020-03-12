/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libreria;

/**
 *
 * @author David
 */
public class Autor {
    private String Cod_Autor;
    private String Nombre;
    private String Apellido;
    private Pais PaisNacimiento;
    private int Año_Nacimiento;
    private String Observaciones;

    public Autor(String Cod_Autor, String Nombre, String Apellido, Pais PaisNacimiento, int Año_Nacimiento, String Observaciones) {
        this.Cod_Autor = Cod_Autor;
        this.Nombre = Nombre;
        this.Apellido = Apellido;
        this.PaisNacimiento = PaisNacimiento;
        this.Año_Nacimiento = Año_Nacimiento;
        this.Observaciones = Observaciones;
    }
    
    public Autor(Autor a) {
        this.Cod_Autor = a.getCod_Autor();
        this.Nombre = a.getNombre();
        this.Apellido = a.getApellido();
        this.PaisNacimiento = a.getPaisNacimiento();
        this.Año_Nacimiento = a.getAño_Nacimiento();
        this.Observaciones = a.getObservaciones();
    }
    /*
    public Autor() {
        this.Cod_Autor = null;
        this.Nombre = null;
        this.Apellido = null;
        this.PaisNacimiento = null;
        this.Año_Nacimiento = 0;
        this.Observaciones = null;
    }*/
    public String getLista(){
        return Nombre+", "+Apellido;
    }
    
    public String getListaIngresados(){
        return Nombre+","+Apellido+","+PaisNacimiento+","+Año_Nacimiento;
    }
    
    public String getCod_Autor() {
        return Cod_Autor;
    }

    public void setCod_Autor(String Cod_Autor) {
        this.Cod_Autor = Cod_Autor;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String Apellido) {
        this.Apellido = Apellido;
    }

    public Pais getPaisNacimiento() {
        return PaisNacimiento;
    }

    public void setPaisNacimiento(Pais PaisNacimiento) {
        this.PaisNacimiento = PaisNacimiento;
    }

    public int getAño_Nacimiento() {
        return Año_Nacimiento;
    }

    public void setAño_Nacimiento(int Año_Nacimiento) {
        this.Año_Nacimiento = Año_Nacimiento;
    }

    public String getObservaciones() {
        return Observaciones;
    }

    public void setObservaciones(String Observaciones) {
        this.Observaciones = Observaciones;
    }
    
}
