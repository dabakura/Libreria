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
public class Stock {
    private final int Codigo_Stock;
    private int Cantidad_Almacenada;
    private int Comprados;
    private int Vendidos;

    public Stock(int Codigo_Stock, int Cantidad) {
        this.Codigo_Stock = Codigo_Stock;
        this.Cantidad_Almacenada = Cantidad;
        this.Comprados = Cantidad;
        this.Vendidos = 0;
    }

    public Stock(int Codigo_Stock, int Cantidad_Almacenada, int Comprados, int Vendidos) {
        this.Codigo_Stock = Codigo_Stock;
        this.Cantidad_Almacenada = Cantidad_Almacenada;
        this.Comprados = Comprados;
        this.Vendidos = Vendidos;
    }
    
    public int getCodigo_Stock() {
        return Codigo_Stock;
    }

    public int getCantidad_Almacenada() {
        return Cantidad_Almacenada;
    }

    public void addStock(int Cantidad) {
        this.Comprados += Cantidad;
        this.Cantidad_Almacenada = (this.Comprados-this.Vendidos);
    }

    public int getVendidos() {
        return Vendidos;
    }

    public int getComprados() {
        return Comprados;
    }

    public void setVendidos(int Vendidos) {
        this.Vendidos += Vendidos;
        this.Cantidad_Almacenada = (this.Comprados-this.Vendidos);
    }

    public void setCantidad_Almacenada(int Cantidad_Almacenada) {
        this.Cantidad_Almacenada = Cantidad_Almacenada;
    }
    
    public boolean facturable(int cantidad){
        return ((this.Cantidad_Almacenada-cantidad)>=0);
    }
}
