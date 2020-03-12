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
public class Pais {
    private int Cod_Pais;
    private String Nombre;

    public Pais(int Cod_Pais, String Nombre) {
        this.Cod_Pais = Cod_Pais;
        this.Nombre = Nombre;
    }

    
    public int getCod_Pais() {
        return Cod_Pais;
    }

    public void setCod_Pais(int Cod_Pais) {
        this.Cod_Pais = Cod_Pais;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }
    
}
