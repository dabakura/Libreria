/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libreria;

import java.math.BigDecimal;
import java.sql.*;
import java.math.BigInteger;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;

/**
 *
 * @author David
 */

public class BaseDatosControlador implements Tools{
    private final static String CONNECTIONURL = "jdbc:sqlserver://localhost\\SQLEXPRESS:1433;databaseName=LibraryBase;user=LibraryAdmin;password=12345";
        // Declare the JDBC objects.
    private static Connection con;
    private static Statement stmt;
    private static ResultSet rs;
    private static PreparedStatement psmt;
    
    public static void Iniciar() {
        try {
            // Establish the connection.
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection(CONNECTIONURL);
            stmt = con.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_UPDATABLE);
            // Create and execute an SQL statement that returns some data
            // and display it.
            CARGATEMAS();
            CARGACLASIFICACIONES();
            CARGAPAISES();
            CARGAEDITORIALES();
            CARGAAUTORES();
            CARGASTOCKS();
            CARGALIBROS();
            LIBROS.forEach((libro) -> {
                CARGAAUTORES(libro);
                CARGATEMAS(libro);
            });
            CARGACLIENTES();
            CARGAHACIENTOSCONTABLES();  
            CARGAFACTURAS();
            FACTURAS.forEach((factura)->{CARGADETALLES(factura);});
            CARGAFACTURASHACIENTOS();
        } // Handle any errors that may have occurred.
        catch (ClassNotFoundException | SQLException e) {
            System.out.println("1");
        } finally {
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException e) {
                }
            }

            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                }
            }
        }
    }

    private static void CARGATEMAS() {
        try {
            String SQL = "SELECT * FROM TB_TEMA";
            rs = stmt.executeQuery(SQL);
            TEMAS.clear();
            while (rs.next()) {
                String id = rs.getString(1);
                String nombre = rs.getString(2);
                TEMAS.add(new Tema(id, nombre));
            }
            rs.close();
        } catch (SQLException e) {
            System.out.println("2");
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                }
            }
        }
    }

    private static void CARGACLASIFICACIONES() {
        try {
            String SQL = "SELECT * FROM TB_CLASIFICACION";
            rs = stmt.executeQuery(SQL);
            CATEGORIAS.clear();
            while (rs.next()) {
                String id = rs.getString(1);
                String nombre = rs.getString(2);
                CATEGORIAS.add(new Categoria(id, nombre));
            }
            rs.close();
        } catch (SQLException e) {
            System.out.println("3");
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                }
            }
        }
    }

    private static void CARGAPAISES() {
        try {
            String SQL = "SELECT * FROM TB_PAIS ORDER BY COD_PAIS ASC";
            rs = stmt.executeQuery(SQL);
            PAISES.clear();
            while (rs.next()) {
                int id = rs.getInt(1);
                String nombre = rs.getString(2);
                PAISES.add(new Pais(id, nombre));
            }
            rs.close();
        } catch (SQLException e) {
            System.out.println("4");
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                }
            }
        }
    }

    private static void CARGAEDITORIALES() {
        try {
            String SQL = "SELECT * FROM TB_EDITORIAL";
            rs = stmt.executeQuery(SQL);
            EDITORIALES.clear();
            while (rs.next()) {
                String id = rs.getString(1);
                String nombre = rs.getString(2);
                int telefono = rs.getInt(3);
                String direccion = rs.getString(4);
                int p = rs.getInt(5);
                Pais pais=null;
                for (Pais pa : PAISES) {
                    if (pa.getCod_Pais()==p){pais=pa;break;}
                }
                String ciudad = rs.getString(6);
                EDITORIALES.add(new Editorial(id, nombre,telefono,pais,ciudad,direccion));
            }
            rs.close();
        } catch (SQLException e) {
            System.out.println("5");
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                }
            }
        }
    }

    private static void CARGAAUTORES() {
        try {
            String SQL = "SELECT * FROM TB_AUTOR";
            rs = stmt.executeQuery(SQL);
            AUTORES.clear();
            while (rs.next()) {
                String id = rs.getString(1);
                String nombre = rs.getString(2);
                String apellido = rs.getString(3);
                int p = rs.getInt(4);
                Pais pais=null;
                for (Pais pa : PAISES) {
                    if (pa.getCod_Pais()==p){pais=pa;break;}
                }
                int año = rs.getInt(5);
                String observacion = rs.getString(6);
                AUTORES.add(new Autor(id, nombre,apellido,pais,año,observacion));
            }
            rs.close();
        } catch (SQLException e) {
            System.out.println("6");
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                }
            }
        }
    }

    private static void CARGASTOCKS() {
        try {
            String SQL = "SELECT * FROM TB_STOCK ORDER BY COD_STOCK ASC";
            rs = stmt.executeQuery(SQL);
            STOCKS.clear();
            while (rs.next()) {
                int id = rs.getInt(1);
                int cantidad_almacenada = rs.getInt(2);
                int unidades_compradas = rs.getInt(3);
                int unidades_vendidas = rs.getInt(4);
                STOCKS.add(new Stock(id, cantidad_almacenada,unidades_compradas,unidades_vendidas));
            }
            rs.close();
        } catch (SQLException e) {
            System.out.println("7");
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                }
            }
        }
    }

    private static void CARGALIBROS() {
        //'973-54-1546-9','Intro a la Mate','Matematicas Basicas','Introducción a la Matematica',1988,320,1,'Dura',2,1,2500,5400,'CIE','ALF'
        try {
            String SQL = "SELECT * FROM TB_LIBRO";
            rs = stmt.executeQuery(SQL);
            LIBROS.clear();
            while (rs.next()) {
                String isbn = rs.getString(1);
                String titulo = rs.getString(2);
                String subtitulo = rs.getString(3);
                String descripcion = rs.getString(4);
                int año = rs.getInt(5);
                int n_paginas = rs.getInt(6);
                int n_edicion = rs.getInt(7);
                String tipo_caratura = rs.getString(8);
                int n_estanteria = rs.getInt(9);
                int s = rs.getInt(10);
                Stock stock = null;
                for (Stock st : STOCKS) {
                    if (st.getCodigo_Stock()==s){stock=st;break;}
                }
                int costo = rs.getInt(11);
                int precio = rs.getInt(12);
                String c = rs.getString(13);
                Categoria categoria = null;
                for (Categoria ca : CATEGORIAS) {
                    if (ca.getCod_Categoria().equals(c)){categoria=ca;break;}
                }
                String e = rs.getString(14);
                Editorial editorial = null;
                for (Editorial ed : EDITORIALES) {
                    if (ed.getCod_Editorial().equals(e)){editorial=ed;break;}
                }
                BaseDatosControlador BDC = new BaseDatosControlador();
                String imagennombre = isbn+".png";
                ImageIcon imagen = new javax.swing.ImageIcon(BDC.getClass().getResource("/Image/"+imagennombre));
                Libro libro = new Libro(isbn,titulo,subtitulo,descripcion,año,n_paginas,n_edicion,tipo_caratura,n_estanteria,stock,costo,precio);
                libro.setCategoria(categoria);
                libro.setEditorial(editorial);
                libro.setImagen(imagen);
                LIBROS.add(libro);
            }
            rs.close();
            
        } catch (SQLException e) {
            System.out.println("8");
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                }
            }
        }
    }

    private static void CARGAAUTORES(Libro libro) {
        try {
            libro.getListaAutores().clear();
            String SQL = "SELECT * FROM TB_AUTOR_LIBRO WHERE ISBN='"+libro.getIbsn()+"'";
            rs = stmt.executeQuery(SQL);
            while (rs.next()) {
                String id = rs.getString(2);
                for (Autor autor : AUTORES) {
                    if (id.equals(autor.getCod_Autor())){libro.getListaAutores().add(autor);break;}
                }
            }
            rs.close();
        } catch (SQLException e) {
            System.out.println("9");
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                }
            }
        }
    }

    private static void CARGATEMAS(Libro libro) {
        try {
            libro.getListaTemas().clear();
            String SQL = "SELECT * FROM TB_TEMA_LIBRO WHERE ISBN='"+libro.getIbsn()+"'";
            rs = stmt.executeQuery(SQL);
            while (rs.next()) {
                String id = rs.getString(2);
                for (Tema tema : TEMAS) {
                    if (id.equals(tema.getCod_Tema())){libro.getListaTemas().add(tema);break;}
                }
            }
            rs.close();
        } catch (SQLException e) {
            System.out.println("10");
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                }
            }
        }
    }

    private static void CARGACLIENTES() {
        try {
            String SQL = "SELECT * FROM TB_CLIENTE";
            rs = stmt.executeQuery(SQL);
            CLIENTES.clear();
            while (rs.next()) {
                String id = rs.getString(1);
                String nombre = rs.getString(2);
                String apellido1 = rs.getString(3);
                String apellido2 = rs.getString(4);
                int telefono = rs.getInt(5);
                CLIENTES.add(new Cliente(id, nombre,apellido1,apellido2,telefono));
            }
            rs.close();
        } catch (SQLException e) {
            System.out.println("11");
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                }
            }
        }
    }

    private static void CARGAHACIENTOSCONTABLES() {
        try {
            String SQL = "SELECT * FROM TB_HACIENTO_CONTABLE ORDER BY COD_HACIENTO ASC";
            rs = stmt.executeQuery(SQL);
            CONTABLES.clear();
            while (rs.next()) {
                int id = rs.getInt(1);
                Date fecha = rs.getDate(2);
                BigInteger total_bruto = rs.getBigDecimal(3).toBigInteger();
                BigInteger total_costo = rs.getBigDecimal(4).toBigInteger();
                BigInteger total_ganancia = rs.getBigDecimal(5).toBigInteger();
                CONTABLES.add(new AccionContable(id, fecha, total_bruto, total_costo, total_ganancia));
            }
            rs.close();
        } catch (SQLException e) {
            System.out.println("12");
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                }
            }
        }
    }

    private static void CARGAFACTURASHACIENTOS(){
        CONTABLES.forEach((accionContable) -> {
            accionContable.getFacturas().clear();
            FACTURAS.forEach((factura) -> {
                if (factura.getHacientoContable() == accionContable.getCod_Ingreso()) {
                    accionContable.getFacturas().add(factura);
                }
            });
        });
    }

    private static void CARGAFACTURAS() {
        try {
            String SQL = "SELECT * FROM TB_ENCABEZADO ORDER BY COD_FACTURA ASC";
            rs = stmt.executeQuery(SQL);
            FACTURAS.clear();
            while (rs.next()) {
                int id = rs.getInt(1); 
                Date fecha = rs.getDate(2);
                int subtotal = rs.getInt(3);
                int impuesto = rs.getInt(4);
                int total = rs.getInt(5);
                String c = rs.getString(6);
                Cliente cliente = null;
                for (Cliente cli : CLIENTES) {
                    if (cli.getCedula().equals(c)){cliente=cli;break;}
                }
                int haciento = rs.getInt(7);
                Factura factura = new Factura(id, fecha, subtotal, impuesto, total, cliente);
                factura.setHacientoContable(haciento);
                FACTURAS.add(factura);
            }
            rs.close();
        } catch (SQLException e) {
            System.out.println("13");
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                }
            }
        }
    }
    
    private static void CARGADETALLES(Factura factura) {
        try {
            factura.getDetalles().clear();
            String SQL = "SELECT * FROM TB_DETALLE WHERE COD_FACTURA="+factura.getCod_Factura();
            rs = stmt.executeQuery(SQL);
            while (rs.next()) { 
                int idfactura = rs.getInt(1);
                String idlibro = rs.getString(2);
                int unidades = rs.getInt(3);
                int costo = rs.getInt(4);
                int total = rs.getInt(5);
                Libro libro = null;
                for (Libro lib : LIBROS) {
                    if (idlibro.equals(lib.getIbsn())){libro=lib;break;}
                }
                factura.getDetalles().add(new Detalle(idfactura, libro, unidades, costo, total));
            }
            rs.close();
        } catch (SQLException e) {
            System.out.println("14");
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                }
            }
        }
    }
    
    public static void GUARDARTEMAS(Tema tema) {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection(CONNECTIONURL);
            String SQL = "INSERT INTO TB_TEMA" + " (COD_TEMA, NOMBRE) VALUES (?, ?)";
            psmt = con.prepareStatement(SQL);
            psmt.setString(1, tema.getCod_Tema());
            psmt.setString(2, tema.getNombre());
            psmt.execute();
            psmt.close();
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println("15");
        }finally {
            if (psmt != null) {
                try {
                    psmt.close();
                } catch (SQLException e) {
                }
            }
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                }
            }
        }
    }
    
    public static void GUARDARCLASIFICACION(Categoria categoria) {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection(CONNECTIONURL);
            String SQL = "INSERT INTO TB_CLASIFICACION" + " (COD_CLASI, NOMBRE) VALUES (?, ?)";
            psmt = con.prepareStatement(SQL);
            psmt.setString(1, categoria.getCod_Categoria());
            psmt.setString(2, categoria.getNombre());
            psmt.execute();
            psmt.close();
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println("16");
        }finally {
            if (psmt != null) {
                try {
                    psmt.close();
                } catch (SQLException e) {
                }
            }
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                }
            }
        }
    }
    
    public static void GUARDARPAIS(Pais pais) {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection(CONNECTIONURL);
            String SQL = "INSERT INTO TB_PAIS" + " (COD_PAIS, NOMBRE) VALUES (?, ?)";
            psmt = con.prepareStatement(SQL);
            psmt.setInt(1, pais.getCod_Pais());
            psmt.setString(2, pais.getNombre());
            psmt.execute();
            psmt.close();
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println("17");
        }finally {
            if (psmt != null) {
                try {
                    psmt.close();
                } catch (SQLException e) {
                }
            }
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                }
            }
        }
    }
    
    public static void GUARDAREDITORIAL(Editorial editorial) {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection(CONNECTIONURL);
            String SQL = "INSERT INTO TB_EDITORIAL" + " (ID_EDITORIAL, NOMBRE, TELEFONO, DIRECCION, COD_PAIS, CIUDAD) VALUES (?, ?, ?, ?, ?, ?)";
            psmt = con.prepareStatement(SQL);
            psmt.setString(1, editorial.getCod_Editorial());
            psmt.setString(2, editorial.getNombre());
            psmt.setInt(3, editorial.getTelefono());
            psmt.setString(4, editorial.getDireccion());
            psmt.setInt(5, editorial.getPais().getCod_Pais());
            psmt.setString(6, editorial.getCiudad());
            psmt.execute();
            psmt.close();
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println("18");
        }finally {
            if (psmt != null) {
                try {
                    psmt.close();
                } catch (SQLException e) {
                }
            }
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                }
            }
        }
    }
    
    public static void GUARDARAUTORES(Autor  autor) {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection(CONNECTIONURL);
            String SQL = "INSERT INTO TB_AUTOR" + " (ID_AUTOR , NOMBRE, APELLIDO, COD_PAIS, AÑO_NACI, OBSERVACION) VALUES (?, ?, ?, ?, ?, ?)";
            psmt = con.prepareStatement(SQL);
            psmt.setString(1, autor.getCod_Autor());
            psmt.setString(2, autor.getNombre());
            psmt.setString(3, autor.getApellido());
            psmt.setInt(4, autor.getPaisNacimiento().getCod_Pais());
            psmt.setInt(5, autor.getAño_Nacimiento());
            psmt.setString(6, autor.getObservaciones());
            psmt.execute();
            psmt.close();
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println("19");
        }finally {
            if (psmt != null) {
                try {
                    psmt.close();
                } catch (SQLException e) {
                }
            }
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                }
            }
        }
    }
    
    public static void GUARDARSTOCK(Stock stock) {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection(CONNECTIONURL);
            String SQL = "INSERT INTO TB_STOCK" + " (COD_STOCK , CATIDAD_ALMACENADA, UNIDADES_COMPRADAS, UNIDADES_VENDIDAS) VALUES (?, ?, ?, ?)";
            psmt = con.prepareStatement(SQL);
            psmt.setInt(1, stock.getCodigo_Stock());
            psmt.setInt(2, stock.getCantidad_Almacenada());
            psmt.setInt(3, stock.getComprados());
            psmt.setInt(4, stock.getVendidos());
            psmt.execute();
            psmt.close();
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println("20");
        }finally {
            if (psmt != null) {
                try {
                    psmt.close();
                } catch (SQLException e) {
                }
            }
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                }
            }
        }
    }
    
    public static void GUARDARLIBRO(Libro libro) {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection(CONNECTIONURL);
            String SQL = "INSERT INTO TB_LIBRO" + " (ISBN , TITULO, SUBTITULO, DESCRIPCION, "
                    + "AÑO_EMICION, NUMERO_PAG, NUMERO_EDICION, TIPO_CARATURA, NUMERO_ESTANTERIA, "
                    + "COD_STOCK, COSTO, PRECIO, COD_CLASI, ID_EDITORIAL) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            psmt = con.prepareStatement(SQL);
            psmt.setString(1, libro.getIbsn());
            psmt.setString(2, libro.getTitulo());
            psmt.setString(3, libro.getSubtitulo());
            psmt.setString(4, libro.getDescripcion());
            psmt.setInt(5, libro.getAño());
            psmt.setInt(6, libro.getNpaginas());
            psmt.setInt(7, libro.getNedicion());
            psmt.setString(8, libro.getCaratura());
            psmt.setInt(9, libro.getNestanteria());
            psmt.setInt(10, libro.getEjemplares().getCodigo_Stock());
            psmt.setInt(11, libro.getCosto());
            psmt.setInt(12, libro.getPrecio());
            psmt.setString(13, libro.getCategoria().getCod_Categoria());
            psmt.setString(14, libro.getEditorial().getCod_Editorial());
            psmt.execute();
            psmt.close();
            GUARDARTEMASLIBRO(libro);
            GUARDARAUTORESLIBRO(libro);
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println("21");
        }finally {
            if (psmt != null) {
                try {
                    psmt.close();
                } catch (SQLException e) {
                }
            }
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                }
            }
        }
    }
    
    private static void GUARDARTEMASLIBRO(Libro libro) {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection(CONNECTIONURL);
            for (Tema listaTema : libro.getListaTemas()) {
                String SQL = "INSERT INTO TB_TEMA_LIBRO" + " (ISBN, COD_TEMA) VALUES (?, ?)";
                psmt = con.prepareStatement(SQL);
                psmt.setString(1, libro.getIbsn());
                psmt.setString(2, listaTema.getCod_Tema());
                psmt.execute();
                psmt.close();
            }
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println("22");
        }finally {
            if (psmt != null) {
                try {
                    psmt.close();
                } catch (SQLException e) {
                }
            }
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                }
            }
        }
    }
    
    private static void GUARDARAUTORESLIBRO(Libro libro) {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection(CONNECTIONURL);
            for (Autor autor : libro.getListaAutores()) {
                String SQL = "INSERT INTO TB_AUTOR_LIBRO" + " (ISBN, ID_AUTOR) VALUES (?, ?)";
                psmt = con.prepareStatement(SQL);
                psmt.setString(1, libro.getIbsn());
                psmt.setString(2, autor.getCod_Autor());
                psmt.execute();
                psmt.close();
            }
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println("23");
        }finally {
            if (psmt != null) {
                try {
                    psmt.close();
                } catch (SQLException e) {
                }
            }
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                }
            }
        }
    }
    
    public static void GUARDARCLIENTE(Cliente cliente) {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection(CONNECTIONURL);
            String SQL = "INSERT INTO TB_CLIENTE" + " (CEDULA , NOMBRE, APELLIDO1, APELLIDO2, TELEFONO) VALUES (?, ?, ?, ?, ?)";
            psmt = con.prepareStatement(SQL);
            psmt.setString(1, cliente.getCedula());
            psmt.setString(2, cliente.getNombre());
            psmt.setString(3, cliente.getApellido1());
            psmt.setString(4, cliente.getApellido2());
            psmt.setInt(5, cliente.getTelefono());
            psmt.execute();
            psmt.close();
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println("24");
        }finally {
            if (psmt != null) {
                try {
                    psmt.close();
                } catch (SQLException e) {
                }
            }
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                }
            }
        }
    }
    
    public static void GUARDARHACIENTOCONTABLE(AccionContable accion) {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection(CONNECTIONURL);
            String SQL = "INSERT INTO TB_HACIENTO_CONTABLE" + " (COD_HACIENTO , FECHA, TOTAL_BRUTO, COSTOS_TOTALES, TOTAL_GANANCIA) VALUES (?, ?, ?, ?, ?)";
            psmt = con.prepareStatement(SQL);
            psmt.setInt(1, accion.getCod_Ingreso());
            psmt.setDate(2, new Date(accion.getFecha().getYear(), accion.getFecha().getMonth(), accion.getFecha().getDate()));
            psmt.setBigDecimal(3, new BigDecimal(accion.getTotalBruto()));
            psmt.setBigDecimal(4, new BigDecimal(accion.getCostos_Totales()));
            psmt.setBigDecimal(5, new BigDecimal(accion.getTotal_Ganancia()));
            psmt.execute();
            psmt.close();
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println("25");
        }finally {
            if (psmt != null) {
                try {
                    psmt.close();
                } catch (SQLException e) {
                }
            }
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                }
            }
        }
    }
    
    public static void GUARDARFACTURA(Factura factura) {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection(CONNECTIONURL);
            String SQL = "INSERT INTO TB_ENCABEZADO" + " (COD_FACTURA , FECHA, SUBTOTAL, IMPUESTO_VENTAS, TOTAL, CEDULA, COD_HACIENTO) VALUES (?, ?, ?, ?, ?, ?, ?)";
            psmt = con.prepareStatement(SQL);
            psmt.setInt(1, factura.getCod_Factura());
            psmt.setDate(2, new Date(factura.getFecha().getYear(), factura.getFecha().getMonth(), factura.getFecha().getDate()));
            psmt.setInt(3, factura.getSubtotal());
            psmt.setInt(4, factura.getIV());
            psmt.setInt(5, factura.getTotal());
            psmt.setString(6, factura.getClient().getCedula());
            psmt.setInt(7, factura.getHacientoContable());
            psmt.execute();
            psmt.close();
            GUARDARDETALLESFACTURA(factura);
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println("26");
        }finally {
            if (psmt != null) {
                try {
                    psmt.close();
                } catch (SQLException e) {
                }
            }
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                }
            }
        }
    }
    
    private static void GUARDARDETALLESFACTURA(Factura factura) {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection(CONNECTIONURL);
            for (Detalle detalle : factura.getDetalles()) {
                String SQL = "INSERT INTO TB_DETALLE" + " (COD_FACTURA, ISBN, UNIDADES, COSTO_UNITARIO, TOTAL) VALUES (?, ?, ?, ?, ?)";
                psmt = con.prepareStatement(SQL);
                psmt.setInt(1, factura.getCod_Factura());
                psmt.setString(2, detalle.getLibro().getIbsn());
                psmt.setInt(3, detalle.getUnidades());
                psmt.setInt(4, detalle.getCosto_Unitario());
                psmt.setInt(5, detalle.getTotal());
                psmt.execute();
                psmt.close();
            }
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println("27");
        }finally {
            if (psmt != null) {
                try {
                    psmt.close();
                } catch (SQLException e) {
                }
            }
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                }
            }
        }
    }
    
    public static void ACTUALIZARHACIENTOCONTABLE(AccionContable accion) {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection(CONNECTIONURL);
            String SQL = "SELECT * FROM TB_HACIENTO_CONTABLE WHERE COD_HACIENTO ="+accion.getCod_Ingreso()+";";
            stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            rs = stmt.executeQuery(SQL);
            rs.first();
            rs.updateBigDecimal(3, new BigDecimal(accion.getTotalBruto()));
            rs.updateBigDecimal(4, new BigDecimal(accion.getCostos_Totales()));
            rs.updateBigDecimal(5, new BigDecimal(accion.getTotal_Ganancia()));
            rs.updateRow();
            rs.close();
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println("28");
        }finally {
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException e) {
                }
            }
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                }
            }
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                }
            }
        }
    }
    
    public static void ACTUALIZARSTOCK(Stock stock) {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection(CONNECTIONURL);
            String SQL = "SELECT * FROM TB_STOCK WHERE COD_STOCK ="+stock.getCodigo_Stock()+";";
            stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            rs = stmt.executeQuery(SQL);
            rs.first();
            rs.updateInt(2, stock.getCantidad_Almacenada());
            rs.updateInt(3, stock.getComprados());
            rs.updateInt(4, stock.getVendidos());
            rs.updateRow();
            rs.close();
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println("29");
        }finally {
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException e) {
                }
            }
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                }
            }
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                }
            }
        }
    }
    
    public static boolean ELIMINARLIBRO(Libro l){
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection(CONNECTIONURL);
            String SQL = "DELETE FROM TB_STOCK WHERE COD_STOCK=?";
            psmt = con.prepareStatement(SQL);
            psmt.setInt(1, l.getEjemplares().getCodigo_Stock());
            if (!psmt.execute()) {
                SQL = "DELETE FROM TB_TEMA_LIBRO WHERE ISBN=?";
                psmt = con.prepareStatement(SQL);
                psmt.setString(1, l.getIbsn());
                psmt.execute();
                SQL = "DELETE FROM TB_AUTOR_LIBRO WHERE ISBN=?";
                psmt = con.prepareStatement(SQL);
                psmt.setString(1, l.getIbsn());
                psmt.execute();
                SQL = "DELETE FROM TB_LIBRO WHERE ISBN=?";
                psmt = con.prepareStatement(SQL);
                psmt.setString(1, l.getIbsn());
                return !psmt.execute();
            }
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("30");
        }finally {
            if (psmt != null) {
                try {
                    psmt.close();
                } catch (SQLException e) {
                }
            }
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                }
            }
        }
        return false;
    }
    
    public static void MODIFICARLIBRO(Libro l){
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection(CONNECTIONURL);
            String SQL = "DELETE FROM TB_TEMA_LIBRO WHERE ISBN=?";
            psmt = con.prepareStatement(SQL);
            psmt.setString(1, l.getIbsn());
            psmt.execute();
            SQL = "DELETE FROM TB_AUTOR_LIBRO WHERE ISBN=?";
            psmt = con.prepareStatement(SQL);
            psmt.setString(1, l.getIbsn());
            psmt.execute();
            GUARDARTEMASLIBRO(l);
            GUARDARAUTORESLIBRO(l);
            con = DriverManager.getConnection(CONNECTIONURL);
            SQL = "SELECT * FROM TB_LIBRO WHERE ISBN='"+l.getIbsn()+"';";
            stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            rs = stmt.executeQuery(SQL);
            rs.first();
            rs.updateString(2, l.getTitulo());
            rs.updateString(3, l.getSubtitulo());
            rs.updateString(4, l.getDescripcion());
            rs.updateInt(5, l.getAño());
            rs.updateInt(6, l.getNpaginas());
            rs.updateInt(7, l.getNedicion());
            rs.updateString(8, l.getCaratura());
            rs.updateInt(9, l.getNestanteria());
            rs.updateInt(11, l.getCosto());
            rs.updateInt(12, l.getPrecio());
            rs.updateString(13, l.getCategoria().getCod_Categoria());
            rs.updateString(14, l.getEditorial().getCod_Editorial());
            rs.updateRow();
            rs.close();
        } catch (ClassNotFoundException | SQLException ex) {
            
                    System.out.println(ex.getMessage());
            System.out.println("31");
        }finally {
            if (psmt != null) {
                try {
                    psmt.close();
                } catch (SQLException e) {
                }
            }
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                }
            }
        }
    }
}
