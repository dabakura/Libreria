/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libreria;

import java.util.ArrayList;
import javax.swing.ImageIcon;

/**
 *
 * @author David
 */
public class Libro {
    private String Ibsn;
    private String Titulo;
    private String Subtitulo;
    private String Descripcion;
    private int Año;
    private int Npaginas;
    private int Nedicion;
    private String Caratura;
    private int Nestanteria;
    private int Costo;
    private int Precio;
    private ArrayList<Autor> ListaAutores;
    private ArrayList<Tema> ListaTemas;
    private Categoria Categoria;
    private Editorial Editorial;
    private final Stock Ejemplares;
    private ImageIcon Imagen;

    public Libro(String Ibsn, String Titulo, String Subtitulo, String Descripcion, int Año, int Npaginas, int Nedicion, String Caratura, int Nestanteria, Stock Ejemplares, int Costo, int Precio) {
        this.Ibsn = Ibsn;
        this.Titulo = Titulo;
        this.Subtitulo = Subtitulo;
        this.Descripcion = Descripcion;
        this.Año = Año;
        this.Npaginas = Npaginas;
        this.Nedicion = Nedicion;
        this.Caratura = Caratura;
        this.Nestanteria = Nestanteria;
        this.Costo = Costo;
        this.Precio = Precio;
        this.ListaAutores = new ArrayList<>();
        this.ListaTemas = new ArrayList<>();
        this.Ejemplares = Ejemplares;
    }

    public void ActualizaLibro(Libro l) {
        this.Titulo = l.getTitulo();
        this.Subtitulo = l.getSubtitulo();
        this.Descripcion = l.getDescripcion();
        this.Año = l.getAño();
        this.Npaginas = l.getNpaginas();
        this.Nedicion = l.getNedicion();
        this.Caratura = l.getCaratura();
        this.Nestanteria = l.getNestanteria();
        this.Costo = l.getCosto();
        this.Precio = l.getPrecio();
        this.ListaAutores = l.ListaAutores;
        this.ListaTemas = l.getListaTemas();
        this.Categoria = l.Categoria;
        this.Editorial = l.getEditorial();
        this.Imagen = l.getImagen();
    }
    

    public String getIbsn() {
        return Ibsn;
    }

    public void setIbsn(String Ibsn) {
        this.Ibsn = Ibsn;
    }

    public String getTitulo() {
        return Titulo;
    }

    public void setTitulo(String Titulo) {
        this.Titulo = Titulo;
    }

    public String getSubtitulo() {
        return Subtitulo;
    }

    public void setSubtitulo(String Subtitulo) {
        this.Subtitulo = Subtitulo;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    public int getAño() {
        return Año;
    }

    public void setAño(int Año) {
        this.Año = Año;
    }

    public int getNpaginas() {
        return Npaginas;
    }

    public void setNpaginas(int Npaginas) {
        this.Npaginas = Npaginas;
    }

    public int getNestanteria() {
        return Nestanteria;
    }

    public void setNestanteria(int Nestanteria) {
        this.Nestanteria = Nestanteria;
    }

    public int getCosto() {
        return Costo;
    }

    public void setCosto(int Costo) {
        this.Costo = Costo;
    }

    public int getPrecio() {
        return Precio;
    }

    public void setPrecio(int Precio) {
        this.Precio = Precio;
    }

    public String getCaratura() {
        return Caratura;
    }

    public void setCaratura(String Caratura) {
        this.Caratura = Caratura;
    }

    public int getNedicion() {
        return Nedicion;
    }

    public void setNedicion(int Nedicion) {
        this.Nedicion = Nedicion;
    }

    public ArrayList<Autor> getListaAutores() {
        return ListaAutores;
    }

    public void setListaAutores(ArrayList<Autor> ListaAutores) {
        this.ListaAutores = ListaAutores;
    }

    public ArrayList<Tema> getListaTemas() {
        return ListaTemas;
    }

    public void setListaTemas(ArrayList<Tema> ListaTemas) {
        this.ListaTemas = ListaTemas;
    }

    public Categoria getCategoria() {
        return Categoria;
    }

    public void setCategoria(Categoria Categoria) {
        this.Categoria = Categoria;
    }

    public Editorial getEditorial() {
        return Editorial;
    }

    public void setEditorial(Editorial Editorial) {
        this.Editorial = Editorial;
    }

    public Stock getEjemplares() {
        return Ejemplares;
    }

    public ImageIcon getImagen() {
        return Imagen;
    }

    public void setImagen(ImageIcon Imagen) {
        this.Imagen = Imagen;
    }
    
}
