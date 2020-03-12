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
public class Tema {
    private String Cod_Tema;
    private String Nombre;

    public Tema(String Cod_Tema, String Nombre) {
        this.Cod_Tema = Cod_Tema;
        this.Nombre = Nombre;
    }
    
    public Tema(Tema t) {
        this.Cod_Tema = t.getCod_Tema();
        this.Nombre = t.getNombre();
    }

    public String getCod_Tema() {
        return Cod_Tema;
    }

    public void setCod_Tema(String Cod_Tema) {
        this.Cod_Tema = Cod_Tema;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }
    
    public String getListaIngresados(){
        return Cod_Tema+","+Nombre;
    }
}
