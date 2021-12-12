package Modelo;

import Controlador.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/* @author Marisol */

public class CompraDAO {
    Conexion con = new Conexion();
    PreparedStatement psql;
    ResultSet rs;
    
    public int GuardarCompra(String Fecha, int IdProveedor, String NomProducto, String Marca, double PrecioCompra, double PrecioVenta, int Cantidad) {
        int resultado = 0;
        Connection cn = null;
        String SentenciaSQL = "INSERT INTO compra (Fecha, IdProveedor, NomProducto, Marca, PrecioCompra, PrecioVenta, Cantidad)"
                + " VALUES (?,?,?,?,?,?,?)";
        try {
            cn = con.Conectar();
            psql = cn.prepareStatement(SentenciaSQL);
            //psql.setInt(1,0);
            psql.setString(1, Fecha);
            psql.setInt(2, IdProveedor);
            psql.setString(3, NomProducto);
            psql.setString(4, Marca);
            psql.setDouble(5, PrecioCompra);
            psql.setDouble(6, PrecioVenta);
            psql.setInt(7, Cantidad);

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
    
    public ArrayList<Compra> listCompra() {
        ArrayList listaCompra = new ArrayList();
        Compra compra;

        Connection cn = null;
        String SentenciaSQL = "SELECT * FROM compra";

        try {
            cn = con.Conectar();
            psql = cn.prepareStatement(SentenciaSQL);
            ResultSet rs = psql.executeQuery();
            while (rs.next()) {
                compra = new Compra();
                compra.setIdCompra(rs.getInt(1));
                compra.setFecha(rs.getString(2));
                compra.setIdProveedor(rs.getInt(3));
                compra.setNomProducto(rs.getString(4));
                compra.setMarca(rs.getString(5));
                compra.setPrecioCompra(rs.getDouble(6));
                compra.setPrecioVenta(rs.getDouble(7));
                compra.setCantidad(rs.getInt(8));

                listaCompra.add(compra);
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
        return listaCompra;
    }
    
    public ArrayList<Compra> BuscarProducto(String BuscarProducto) {
        ArrayList buscarProducto = new ArrayList();
        Compra compra;

        Connection cn = null;
        String SentenciaSQL = "SELECT * FROM compra WHERE NomProducto=?";

        try {
            cn = con.Conectar();
            psql = cn.prepareStatement(SentenciaSQL);
            psql.setString(1,BuscarProducto);
            ResultSet rs=psql.executeQuery();
            while (rs.next()) {
                compra = new Compra();
                compra.setNomProducto(rs.getString(4));
                compra.setMarca(rs.getString(5));
                compra.setPrecioVenta(rs.getDouble(7));
                compra.setCantidad(rs.getInt(8));

                buscarProducto.add(compra);
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
        return buscarProducto;
        }
    }
    
    public void editarCompra(int idCompra, String Fecha, int IdProveedor, String NomProducto, String Marca, double PrecioCompra, double PrecioVenta, int Cantidad) {
        int resultado = 0;
        Connection cn = null;
        String SentenciaSQL = "UPDATE compra SET Fecha=?,IdProveedor=?,NomProducto=?,Marca=?,PrecioCompra=?,PrecioVenta=?,Cantidad=? WHERE idCompra=?";

        try {
            cn = con.Conectar();
            psql = cn.prepareStatement(SentenciaSQL);
            psql.setString(1, Fecha);
            psql.setInt(2, IdProveedor);
            psql.setString(3, NomProducto);
            psql.setString(4, Marca);
            psql.setDouble(5, PrecioCompra);
            psql.setDouble(6, PrecioVenta);
            psql.setInt(7, Cantidad);
            psql.setInt(8, idCompra);
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
    
    public int eliminarCompra(int idCompra) {
        int resultado = 0;
        Connection cn = null;
        String SentenciaSQL = "DELETE FROM compra WHERE idCompra=?";
        try {
            cn = con.Conectar();
            psql = cn.prepareStatement(SentenciaSQL);
            psql.setInt(1, idCompra);

            resultado = psql.executeUpdate();
            if (resultado > 0) { //si resultado es >0 se ejecuto la transaccion correctamente
                JOptionPane.showMessageDialog(null, "El registro se eliminó correctamente");
            } else {
                JOptionPane.showMessageDialog(null, "No se pudo eliminar el registro");
            }
            psql.close();
        } catch (SQLException e) {
            System.err.println(e);
        }
        return resultado;
    }    
}        
 