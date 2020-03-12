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
public class Detalle {

    private int Cod_Factura;
    private final Libro libro;
    private int Unidades;
    private final int Costo_Unitario;
    private int Total;

    public Detalle(int Cod_Factura, Libro libro, int Unidades) {
        this.Cod_Factura = Cod_Factura;
        this.libro = libro;
        this.Unidades = Unidades;
        this.Costo_Unitario = libro.getPrecio();
        this.Total = (Costo_Unitario * Unidades);
    }

    public Detalle(int Cod_Factura, Libro libro, int Unidades, int Costo_Unitario, int Total) {
        this.Cod_Factura = Cod_Factura;
        this.libro = libro;
        this.Unidades = Unidades;
        this.Costo_Unitario = Costo_Unitario;
        this.Total = Total;
    }

    
    public int getCod_Factura() {
        return Cod_Factura;
    }

    public void setUnidades(int cantidad) {
        this.Unidades+=cantidad;
        this.Total = (Costo_Unitario * Unidades);
    }

    public void setCod_Factura(int Cod_Factura) {
        this.Cod_Factura = Cod_Factura;
    }

    public Libro getLibro() {
        return libro;
    }

    public int getUnidades() {
        return Unidades;
    }

    public int getCosto_Unitario() {
        return Costo_Unitario;
    }

    public int getTotal() {
        return Total;
    }
    
}
