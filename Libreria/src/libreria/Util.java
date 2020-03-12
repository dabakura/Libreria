/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libreria;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author David
 */
public class Util implements Tools{
    public static void GuardaFactura(Factura factura){
        if (CONTABLES.isEmpty()) {
            CONTABLES.add(new AccionContable(0, new Date()));
            factura.setHacientoContable(0);
            CONTABLES.getLast().addFacturas(factura);
            BaseDatosControlador.GUARDARHACIENTOCONTABLE(CONTABLES.getLast());
            GuardarFactura(factura);
        }else{
            if (Herramientas.toFechaString(CONTABLES.getLast().getFecha()).equals(Herramientas.toFechaString(factura.getFecha()))) {
                factura.setHacientoContable(CONTABLES.getLast().getCod_Ingreso());
                CONTABLES.getLast().addFacturas(factura);
                BaseDatosControlador.ACTUALIZARHACIENTOCONTABLE(CONTABLES.getLast());
                GuardarFactura(factura);
            }else{
                int id = (CONTABLES.getLast().getCod_Ingreso()+1);
                CONTABLES.add(new AccionContable(id, new Date()));
                factura.setHacientoContable(id);
                CONTABLES.getLast().addFacturas(factura);
                BaseDatosControlador.GUARDARHACIENTOCONTABLE(CONTABLES.getLast());
                GuardarFactura(factura);
            }
        }
    }
    
    public static Factura ObtenerFactura(){
        int id = (FACTURAS.isEmpty())?0:(FACTURAS.getLast().getCod_Factura()+1);
        return  new Factura(id);
    }
    
    private static void GuardarFactura(Factura factura){
        if (CLIENTES.isEmpty() || !CLIENTES.contains(factura.getClient())) {
            CLIENTES.add(factura.getClient());
            BaseDatosControlador.GUARDARCLIENTE(CLIENTES.getLast());
        }
        ActualizaStock(factura);
        FACTURAS.add(factura);
        BaseDatosControlador.GUARDARFACTURA(FACTURAS.getLast());
    }
    
    private static void ActualizaStock(Factura factura){
        factura.getDetalles().forEach((d) -> {
            d.getLibro().getEjemplares().setVendidos(d.getUnidades());
            BaseDatosControlador.ACTUALIZARSTOCK(d.getLibro().getEjemplares());
        });
    }
    
    public static boolean EncontraLibro(String ISBN){
        return LIBROS.stream().anyMatch((libro) -> (libro.getIbsn().equals(ISBN)));
    }
    
    public static boolean GuardarLibro(Libro libro){
        if (!EncontraLibro(libro.getIbsn())) {
            STOCKS.add(libro.getEjemplares());
            LIBROS.add(libro);
            return true;
        }
        return false;
    }
    
    public static Libro getLibro(String ISBN){
        for (Libro libro : LIBROS) {
            if (libro.getIbsn().equals(ISBN)) {
                return libro;
            }
        }
        return null;
    }
    
    public static ArrayList<Libro> getLibroTodos(){
        return new ArrayList<>(LIBROS);
    }
    
    public static ArrayList<Libro> getLibroEditorial(String editorial){
        ArrayList<Libro> resultado = new ArrayList<>();
        LIBROS.forEach((l)->{if (l.getEditorial().getCod_Editorial().equals(editorial)){resultado.add(l);}});
        return resultado;
    }
    
    public static ArrayList<Libro> getLibroCategoria(String categoria){
        ArrayList<Libro> resultado = new ArrayList<>();
        LIBROS.forEach((l)->{if (l.getCategoria().getCod_Categoria().equals(categoria)){resultado.add(l);}});
        return resultado;
    }
    
    public static ArrayList<Libro> getLibroAño(int año){
        ArrayList<Libro> resultado = new ArrayList<>();
        LIBROS.forEach((l)->{if (l.getAño()==año){resultado.add(l);}});
        return resultado;
    }
    
    public static ArrayList<Libro> getLibroNombre(String titulo){
        ArrayList<Libro> resultado = new ArrayList<>();
        LIBROS.forEach((l)->{if (l.getTitulo().toLowerCase().equals(titulo.toLowerCase())){resultado.add(l);}});
        return resultado;
    }
    
    public static ArrayList<Libro> getLibroAutor(String autor){
        ArrayList<Libro> resultado = new ArrayList<>();
        LIBROS.forEach((l)->{l.getListaAutores().forEach((i)->{if (i.getCod_Autor().equals(autor)){resultado.add(l);}});});
        return resultado;
    }
    
    public static ArrayList<Libro> getLibroTema(String tema){
        ArrayList<Libro> resultado = new ArrayList<>();
        LIBROS.forEach((l)->{l.getListaTemas().forEach((i)->{if (i.getCod_Tema().equals(tema)){resultado.add(l);}});});
        return resultado;
    }
    
    public static ArrayList<Libro> getLibroISBN(String ISBN){
        ArrayList<Libro> resultado = new ArrayList<>();
        LIBROS.forEach((l)->{if (l.getIbsn().equals(ISBN)) {resultado.add(l);}});
        return resultado;
    }
    
    public static String[] getCategorias(){
        String[] categorias = new String[CATEGORIAS.size()+1];
        categorias[0]="Seleccione";
        for (int j = 1; j <= CATEGORIAS.size(); j++) {
            categorias[j]=CATEGORIAS.get(j-1).getNombre();
        }
        return categorias;
    }
    
    public static String[] getAutores(){
        String[] autores = new String[AUTORES.size()+1];
        autores[0]="Seleccione";
        for (int j = 1; j <= AUTORES.size(); j++) {
            autores[j]=(AUTORES.get(j-1).getNombre()+" "+AUTORES.get(j-1).getApellido());
        }
        return autores;
    }
    
    public static String[] getTemas(){
        String[] temas = new String[TEMAS.size()+1];
        temas[0]="Seleccione";
        for (int j = 1; j <= TEMAS.size(); j++) {
            temas[j]=TEMAS.get(j-1).getNombre();
        }
        return temas;
    }
    
    public static String[] getEditoriales(){
        String[] editoriales = new String[EDITORIALES.size()+1];
        editoriales[0]="Seleccione";
        for (int j = 1; j <= EDITORIALES.size(); j++) {
            editoriales[j]=EDITORIALES.get(j-1).getNombre();
        }
        return editoriales;
    }
    
    public static String[] getPaises(){
        String[] paises = new String[PAISES.size()];
        int i = 0;
        for (Pais pais : PAISES) {
            paises[i]=pais.getNombre();
            i++;
        }
        return paises;
    }
    
    public static ArrayList<Libro> getFiltro(boolean[] busquedas,int[]pocicion,String[] string){
        boolean primero = false;
        ArrayList<Libro> resultado = new ArrayList<>();
        for (int i = 0; i < busquedas.length; i++) {
            if (busquedas[i]) {
                if (primero) {
                    switch (i) {
                        case 0:
                            resultado.removeIf((res)->{return !getLibroAutor(AUTORES.get(pocicion[0]).getCod_Autor()).contains(res);});
                            break;
                        case 1:
                            resultado.removeIf((res)->{return !getLibroEditorial(EDITORIALES.get(pocicion[1]).getCod_Editorial()).contains(res);});
                            break;
                        case 2:
                            resultado.removeIf((res)->{return !getLibroTema(TEMAS.get(pocicion[2]).getCod_Tema()).contains(res);});
                            break;
                        case 3:
                            resultado.removeIf((res)->{return !getLibroCategoria(CATEGORIAS.get(pocicion[3]).getCod_Categoria()).contains(res);});
                            break;
                        case 4:
                            resultado.removeIf((res)->{return !getLibroNombre(string[0]).contains(res);});
                            break;
                        case 5:
                            resultado.removeIf((res)->{return !getLibroAño(Integer.valueOf(string[1])).contains(res);});
                            break;
                    }
                }else{
                    switch (i) {
                        case 0:
                            resultado.addAll(getLibroAutor(AUTORES.get(pocicion[0]).getCod_Autor()));
                            break;
                        case 1:
                            resultado.addAll(getLibroEditorial(EDITORIALES.get(pocicion[1]).getCod_Editorial()));
                            break;
                        case 2:
                            resultado.addAll(getLibroTema(TEMAS.get(pocicion[2]).getCod_Tema()));
                            break;
                        case 3:
                            resultado.addAll(getLibroCategoria(CATEGORIAS.get(pocicion[3]).getCod_Categoria()));
                            break;
                        case 4:
                            resultado.addAll(getLibroNombre(string[0]));
                            break;
                        case 5:
                            resultado.addAll(getLibroAño(Integer.valueOf(string[1])));
                            break;
                    }
                    primero = true;
                }
            }
            
        }
        return resultado;
    }
    
    public static Pais getPais(int index){
        return PAISES.get(index);
    }
    
    public static int getCodigoStock(){
        if (STOCKS.isEmpty()) {
            return 0;
        }
        return STOCKS.getLast().getCodigo_Stock()+1;
    }
    
    public static Cliente getClienteDefault(){
        for (Cliente cliente : CLIENTES) {
            if (cliente.getCedula().equals("000000000")){return cliente;}
        }
        return null;
    }
    
    public static boolean EliminarLibro(Libro l){
        if (!FACTURAS.stream().noneMatch((factura) -> (!factura.getDetalles().stream().noneMatch((detalle) -> (l == detalle.getLibro()))))) {
            return false;
        }
        BaseDatosControlador.ELIMINARLIBRO(l);
        STOCKS.remove(l.getEjemplares());
        String ruta = "/src/Image/"+l.getIbsn()+".png";
        File file = new File("./" + ruta);
        file.delete();
        return LIBROS.remove(l);
    }
    
    public static void ActualizaLibro(Libro l){
        for (Libro libro : LIBROS) {
            if (libro.getIbsn().equals(l.getIbsn())) {
                BaseDatosControlador.MODIFICARLIBRO(l);
                libro.ActualizaLibro(l);
                break;
            }
        }
    }
    
    public static boolean ActualizarStock(String ISBN,int Cantidad){
        Libro l = getLibro(ISBN);
        if (l!=null) {
            l.getEjemplares().addStock(Cantidad);
            BaseDatosControlador.ACTUALIZARSTOCK(l.getEjemplares());
            return true;
        }
        return false;
    }
}
