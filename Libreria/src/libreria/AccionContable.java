/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libreria;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author David
 */
public class AccionContable {
    //Cod_Ingreso	Fecha	Total_Bruto	Costos_Totales	Total_Ganancia
    private final int Cod_Ingreso;
    private final Date Fecha;
    private BigInteger TotalBruto;
    private BigInteger Costos_Totales;
    private BigInteger Total_Ganancia;
    private final ArrayList<Factura> Facturas;

    public AccionContable(int Cod_Ingreso, Date Fecha) {
        this.Cod_Ingreso = Cod_Ingreso;
        this.Fecha = Fecha;
        this.TotalBruto = new BigInteger("0");
        this.Costos_Totales = new BigInteger("0");
        this.Total_Ganancia = new BigInteger("0");
        this.Facturas = new ArrayList<>();
    }

    public AccionContable(int Cod_Ingreso, Date Fecha, BigInteger TotalBruto, BigInteger Costos_Totales, BigInteger Total_Ganancia) {
        this.Cod_Ingreso = Cod_Ingreso;
        this.Fecha = Fecha;
        this.TotalBruto = TotalBruto;
        this.Costos_Totales = Costos_Totales;
        this.Total_Ganancia = Total_Ganancia;
        this.Facturas = new ArrayList<>();
    }

    
    public int getCod_Ingreso() {
        return Cod_Ingreso;
    }

    public Date getFecha() {
        return Fecha;
    }

    public BigInteger getTotalBruto() {
        return TotalBruto;
    }

    public BigInteger getCostos_Totales() {
        return Costos_Totales;
    }

    public BigInteger getTotal_Ganancia() {
        return Total_Ganancia;
    }

    public ArrayList<Factura> getFacturas() {
        return Facturas;
    }
    
    public void addFacturas(Factura factura){
        Facturas.add(factura);
        TotalBruto = TotalBruto.add(new BigInteger(String.valueOf(factura.getSubtotal())));
        factura.getDetalles().forEach((detalle) -> {
            Costos_Totales = Costos_Totales.add(new BigInteger(String.valueOf((detalle.getUnidades()*detalle.getLibro().getCosto()))));
        });
        Total_Ganancia = TotalBruto.subtract(Costos_Totales);
    }
}
