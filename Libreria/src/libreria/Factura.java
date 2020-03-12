/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libreria;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author David
 */
public class Factura {
    private int Cod_Factura;
    private Date Fecha;
    private int Subtotal;
    private int IV;
    private int Total;
    private Cliente Client;
    private final ArrayList<Detalle> Detalles;
    private int HacientoContable;

    public Factura(int Cod_Factura, Date Fecha, int Subtotal, int IV, int Total, Cliente Client) {
        this.Cod_Factura = Cod_Factura;
        this.Fecha = Fecha;
        this.Subtotal = Subtotal;
        this.IV = IV;
        this.Total = Total;
        this.Client = Client;
        this.Detalles = new ArrayList<>();
    }
    
    public Factura(int Cod_Factura) {
        this.Cod_Factura = Cod_Factura;
        this.Fecha = null;
        this.Subtotal = 0;
        this.IV = 0;
        this.Total = 0;
        this.Client = null;
        this.Detalles = new ArrayList<>();
    }

    public int getCod_Factura() {
        return Cod_Factura;
    }

    public void setCod_Factura(int Cod_Factura) {
        this.Cod_Factura = Cod_Factura;
    }

    public Date getFecha() {
        if (Fecha == null) {
            setFecha(new Date());
        }
        return Fecha;
    }

    public void setFecha(Date Fecha) {
        this.Fecha = Fecha;
    }

    public int getSubtotal() {
        return Subtotal;
    }

    public int getIV() {
        return IV;
    }

    public int getTotal() {
        return Total;
    }

    public Cliente getClient() {
        return Client;
    }

    public void setClient(Cliente Client) {
        this.Client = Client;
    }

    public ArrayList<Detalle> getDetalles() {
        return Detalles;
    }

    public void addDetalle(Detalle Detalle) {
        boolean estado = true;
        for (Detalle detalle : Detalles) {
            if(Detalle.getLibro().getIbsn().equals(detalle.getLibro().getIbsn())){
                detalle.setUnidades(Detalle.getUnidades());
                estado = false;
            }
        }
        if (estado) {
            this.Detalles.add(Detalle);
        }
        CalcularPrecios();
    }
    
    public void removeDetalle(int posicion) {
        this.Detalles.remove(posicion);
        CalcularPrecios();
    }
    
    private void CalcularPrecios(){
        Subtotal = 0;
        Detalles.forEach((Detall) -> {
            Subtotal += Detall.getTotal();
        });
        IV = ((int)(((double)Subtotal) * 0.13));
        Total = Subtotal + IV;
    }

    public int getHacientoContable() {
        return HacientoContable;
    }

    public void setHacientoContable(int HacientoContable) {
        this.HacientoContable = HacientoContable;
    }
}
