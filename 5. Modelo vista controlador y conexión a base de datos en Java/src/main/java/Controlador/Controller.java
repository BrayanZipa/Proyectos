package Controlador;

import Modelo.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public abstract class Controller {

    public static boolean registrarProducto(String nombre, int cantidad, String categoria, double precio) throws SQLException {
        Producto p1 = new Producto(nombre, cantidad, categoria, precio);
        CRUD.setConnection(Conexion.ConexionBD());
        String sentencia = "INSERT INTO productos(nombre,cantidad,categoria,precio) "
                + " VALUES ('" + p1.getNombre() + "','" + p1.getCantidad() + "','" + p1.getCategoria() + "','" + p1.getPrecio() + "');";
        if (CRUD.setAutoCommitBD(false)) {
            if (CRUD.insertarBD(sentencia)) {
                CRUD.commitBD();
                CRUD.cerrarConexion();
                return true;
            } else {
                CRUD.rollbackBD();
                CRUD.cerrarConexion();
                return false;
            }
        } else {
            CRUD.cerrarConexion();
            return false;
        }
    }

    public static boolean actualizarProducto(int id, String nombre, int cantidad, String categoria, double precio) {
        Producto p1 = new Producto(nombre, cantidad, categoria, precio);
        CRUD.setConnection(Conexion.ConexionBD());
        String Sentencia = "UPDATE `productos` SET nombre='" + p1.getNombre() + "',cantidad='" + p1.getCantidad() + "',categoria='" + p1.getCategoria()
                + "',precio='" + p1.getPrecio() + "' WHERE id=" + id + ";";
        if (CRUD.setAutoCommitBD(false)) {
            if (CRUD.actualizarBD(Sentencia)) {
                CRUD.commitBD();
                CRUD.cerrarConexion();
                return true;
            } else {
                CRUD.rollbackBD();
                CRUD.cerrarConexion();
                return false;
            }
        } else {
            CRUD.cerrarConexion();
            return false;
        }
    }

    public static boolean borrarProducto(int id) {
        CRUD.setConnection(Conexion.ConexionBD());
        String Sentencia = "DELETE FROM `productos` WHERE `id`='" + id + "';";
        if (CRUD.setAutoCommitBD(false)) {
            if (CRUD.borrarBD(Sentencia)) {
                CRUD.commitBD();
                CRUD.cerrarConexion();
                return true;
            } else {
                CRUD.rollbackBD();
                CRUD.cerrarConexion();
                return false;
            }
        } else {
            CRUD.cerrarConexion();
            return false;
        }
    }

    public static Producto obtenerProducto(int id) {
        CRUD.setConnection(Conexion.ConexionBD());
        String sql = "SELECT * FROM productos WHERE id=" + id + ";";
        ResultSet rs = CRUD.consultarBD(sql);
        Producto p1 = new Producto();
        try {
            if (rs.next()) {
                p1.setId(rs.getInt("id"));
                p1.setNombre(rs.getString("nombre"));
                p1.setCantidad(rs.getInt("cantidad"));
                p1.setCategoria(rs.getString("categoria"));
                p1.setPrecio(rs.getDouble("precio"));
                CRUD.cerrarConexion();
            } else {
                CRUD.cerrarConexion();
                return null;
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return null;
        }
        return p1;
    }

    public static List<Producto> listarProductos() {
        CRUD.setConnection(Conexion.ConexionBD());
        List<Producto> listaProductos = new ArrayList<>();
        try {
            String sql = "SELECT * FROM productos";

            ResultSet rs = CRUD.consultarBD(sql);

            while (rs.next()) {
                Producto p1 = new Producto();
                p1.setId(rs.getInt("id"));
                p1.setNombre(rs.getString("nombre"));
                p1.setCantidad(rs.getInt("cantidad"));
                p1.setCategoria(rs.getString("categoria"));
                p1.setPrecio(rs.getDouble("precio"));
                listaProductos.add(p1);
            }

        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            CRUD.cerrarConexion();
        }

        return listaProductos;
    }
}
