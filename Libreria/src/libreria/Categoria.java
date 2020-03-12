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
public class Categoria {
    private String Cod_Categoria;
    private String Nombre;

    public Categoria(String Cod_Categoria, String Nombre) {
        this.Cod_Categoria = Cod_Categoria;
        this.Nombre = Nombre;
    }

    public Categoria(Categoria c) {
        this.Cod_Categoria = c.getCod_Categoria();
        this.Nombre = c.getNombre();
    }
    
    public String getCod_Categoria() {
        return Cod_Categoria;
    }

    public void setCod_Categoria(String Cod_Categoria) {
        this.Cod_Categoria = Cod_Categoria;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }
    
}
