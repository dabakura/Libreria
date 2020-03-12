/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libreria;

import Interfaz.Monitor;
import java.util.LinkedList;


/**
 *
 * @author David
 */
public interface Tools {
    public final Monitor VENTANA = new Monitor();
    public final LinkedList<Autor> AUTORES = new LinkedList<>(); 
    public final LinkedList<Editorial> EDITORIALES = new LinkedList<>(); 
    public final LinkedList<Categoria> CATEGORIAS = new LinkedList<>(); 
    public final LinkedList<Tema> TEMAS = new LinkedList<>();
    public final LinkedList<Libro> LIBROS = new LinkedList<>();
    public final LinkedList<Cliente> CLIENTES = new LinkedList<>();
    public final LinkedList<Factura> FACTURAS = new LinkedList<>();
    public final LinkedList<AccionContable>  CONTABLES= new LinkedList<>();
    public final LinkedList<Stock> STOCKS = new LinkedList<>();
    public final LinkedList<Pais> PAISES = new LinkedList<>(); 
}
