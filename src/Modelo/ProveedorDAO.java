package Modelo;

/* @author Marisol */

import Controlador.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class ProveedorDAO {
    Conexion con = new Conexion();
    PreparedStatement psql;
    ResultSet rs;
    
    public int GuardarProveedor(String Nombre, String Direccion, String Ciudad, String Telefono) {
        int resultado = 0;
        Connection cn = null;

        String SentenciaSQL = "INSERT INTO proveedor (Nombre, Dirección, Ciudad, Telefono)"
                + " VALUES (?,?,?,?)";
        try {
            cn = con.Conectar();
            psql = cn.prepareStatement(SentenciaSQL);
            //psql.setInt(1,0);
            psql.setString(1, Nombre);
            psql.setString(2, Direccion);
            psql.setString(3, Ciudad);
            psql.setString(4, Telefono);
            resultado = psql.executeUpdate();
            if (resultado > 0) { //si resultado es >0 se ejecuto la transaccion correctamente
                JOptionPane.showMessageDialog(null, "Se guardo correctamente el registro");
            } else {
                JOptionPane.showMessageDialog(null, "No se pudo guardar el registro");
            }
            psql.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al intentar almacenar guardar un registro:\n"
                    + e, "Error en la operación", JOptionPane.ERROR_MESSAGE);
            System.out.println(e);
        } finally {
            try {
                if (cn != null) {
                    con.cerrar();
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Error al intentar cerrar la conexión:\n"
                        + ex, "Error en la operación", JOptionPane.ERROR_MESSAGE);
            }
        }
        return resultado;
    }

    public ArrayList<Proveedor> listProveedor() {
        ArrayList listaProveedor = new ArrayList();
        Proveedor proveedor;

        Connection cn = null;
        String SentenciaSQL = "SELECT * FROM proveedor";

        try {
            cn = con.Conectar();
            psql = cn.prepareStatement(SentenciaSQL);
            ResultSet rs = psql.executeQuery();
            while (rs.next()) {
                proveedor = new Proveedor();
                proveedor.setIdProveedor(rs.getInt(1));
                proveedor.setNombre(rs.getString(2));
                proveedor.setTelefono(rs.getString(3));

                listaProveedor.add(proveedor);
            }
        } catch (SQLException e) {
            System.err.println(e);
        } finally {
            try {
                if (cn != null) {
                    con.cerrar();
                }
            } catch (SQLException ex) {

                JOptionPane.showMessageDialog(null, "Error al intentar cerrar la conexión:\n"
                        + ex, "Error en la operación", JOptionPane.ERROR_MESSAGE);
            }
        }
        return listaProveedor;
    }

    public void editarProveedor(int idProveedor, String Nombre, String Telefono) {
        int resultado = 0;
        Connection cn = null;
        String SentenciaSQL = "UPDATE proveedor SET Nombre=?,Telefono=? WHERE idProveedor=?";

        try {
            cn = con.Conectar();
            psql = cn.prepareStatement(SentenciaSQL);
            psql.setString(1, Nombre);
            psql.setString(2, Telefono);
            psql.setInt(3, idProveedor);
            resultado = psql.executeUpdate();
            System.out.println("resultdo edit=" + resultado);
            if (resultado > 0) { //si resultado es >0 se ejecuto la transaccion correctamente
                JOptionPane.showMessageDialog(null, "El registro se actualizó correctamente");
            } else {
                JOptionPane.showMessageDialog(null, "No se pudo actualizar el registro");
            }
            psql.close();
        } catch (SQLException e) {
            System.err.println(e);
        }
        //return resultado;
    }

    public int eliminarProveedor(int idProveedor){
        int resultado=0;
        Connection cn = null;
        String SentenciaSQL = "DELETE FROM proveedor WHERE idProveedor=?";      
        try {
            cn = con.Conectar();
            psql = cn.prepareStatement(SentenciaSQL);
            psql.setInt(1,idProveedor);
            
            resultado = psql.executeUpdate();
            if (resultado>0){ //si resultado es >0 se ejecuto la transaccion correctamente
                JOptionPane.showMessageDialog(null, "El registro se eliminó correctamente");
            }else{
                JOptionPane.showMessageDialog(null, "No se pudo eliminar el registro");
            }
            psql.close();
        } catch (SQLException e){
            System.err.println(e);
        } 
        return resultado;
    }
    
    
    public ArrayList<Proveedor> BuscarProveedor(String Nombre) {
        ArrayList listaProveedor = new ArrayList();
        Proveedor proveedor;

        Connection cn = null;
        String SentenciaSQL = "SELECT * FROM proveedor WHERE Nombre=?";

        try {
            cn = con.Conectar();
            psql = cn.prepareStatement(SentenciaSQL);
            psql.setString(1,Nombre);
            ResultSet rs=psql.executeQuery();
            while (rs.next()) {
                proveedor = new Proveedor();
                proveedor.setIdProveedor(rs.getInt(1));
                proveedor.setNombre(rs.getString(2));

                listaProveedor.add(proveedor);
            }
            } catch (SQLException ex) {
                System.err.println(ex);  
            }
        finally {
            try {
                if (cn != null) {
                    con.cerrar();
                }
            } catch (SQLException ex) {

                JOptionPane.showMessageDialog(null, "Error al intentar cerrar la conexión:\n"
                        + ex, "Error en la operación", JOptionPane.ERROR_MESSAGE);
            }
        return listaProveedor;
        }
    }
}