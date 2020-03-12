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
public class Editorial {
    private String Cod_Editorial;
    private String Nombre;
    private int Telefono;
    private Pais Pais;
    private String Ciudad;
    private String Direccion;

    public Editorial(String Cod_Editorial, String Nombre, int Telefono, Pais Pais, String Ciudad, String Direccion) {
        this.Cod_Editorial = Cod_Editorial;
        this.Nombre = Nombre;
        this.Telefono = Telefono;
        this.Pais = Pais;
        this.Ciudad = Ciudad;
        this.Direccion = Direccion;
    }

    public Editorial(Editorial e) {
        this.Cod_Editorial = e.getCod_Editorial();
        this.Nombre = e.getNombre();
        this.Telefono = e.getTelefono();
        this.Pais = e.getPais();
        this.Ciudad = e.getCiudad();
        this.Direccion = e.getDireccion();
    }
    
    public String getCod_Editorial() {
        return Cod_Editorial;
    }

    public void setCod_Editorial(String Cod_Editorial) {
        this.Cod_Editorial = Cod_Editorial;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public int getTelefono() {
        return Telefono;
    }

    public void setTelefono(int Telefono) {
        this.Telefono = Telefono;
    }

    public Pais getPais() {
        return Pais;
    }

    public void setPais(Pais Pais) {
        this.Pais = Pais;
    }

    public String getCiudad() {
        return Ciudad;
    }

    public void setCiudad(String Ciudad) {
        this.Ciudad = Ciudad;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String Direccion) {
        this.Direccion = Direccion;
    }
    
    
}
