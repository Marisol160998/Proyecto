package Modelo;

/* @author Marisol */

import Controlador.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class ProductoDAO {
    Conexion con = new Conexion();
    PreparedStatement psql;
    ResultSet rs;

    public int GuardarProducto(int Codigo, String Nombre, String Descripcion, String Marca, double PrecioUnitario, int Existencia) {
        int resultado = 0;
        Connection cn = null;
        String SentenciaSQL = "INSERT INTO producto (Codigo, Nombre, Descripcion, Marca, PrecioUnitario, Existencia) VALUES (?,?,?,?,?,?)";
        try {
            cn = con.Conectar();
            psql = cn.prepareStatement(SentenciaSQL);
            //psql.setInt(1,0);
            psql.setInt(1, Codigo);
            psql.setString(2, Nombre);
            psql.setString(3, Descripcion);
            psql.setString(4, Marca);
            psql.setDouble(5, PrecioUnitario);
            psql.setInt(6, Existencia);
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

    public ArrayList<Producto> listProducto() {
        ArrayList listaProducto = new ArrayList();
        Producto producto;
        Connection cn = null;
        String SentenciaSQL = "SELECT * FROM producto";
        try {
            cn = con.Conectar();
            psql = cn.prepareStatement(SentenciaSQL);
            ResultSet rs = psql.executeQuery();
            while (rs.next()) {
                producto = new Producto();
                producto.setIdProducto(rs.getInt(1));
                producto.setNombre(rs.getString(2));
                producto.setPrecioUnitario(rs.getDouble(3));
                producto.setExistencia(rs.getInt(4));
                listaProducto.add(producto);
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
        return listaProducto;
    }

    public void editarProducto(int idProducto, String Nombre, double PrecioUnitario, int Cantidad) {
        int resultado = 0;
        Connection cn = null;
        String SentenciaSQL = "UPDATE producto SET Nombre=?,PrecioUnitario=?,Cantidad=? WHERE idProducto=?";

        try {
            cn = con.Conectar();
            psql = cn.prepareStatement(SentenciaSQL);
            psql.setString(1, Nombre);
            psql.setDouble(2, PrecioUnitario);
            psql.setInt(3, Cantidad);
            psql.setInt(4, idProducto);
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

    public int eliminarProducto(int idProducto) {
        int resultado = 0;
        Connection cn = null;
        String SentenciaSQL = "DELETE FROM producto WHERE idProducto=?";
        try {
            cn = con.Conectar();
            psql = cn.prepareStatement(SentenciaSQL);
            psql.setInt(1, idProducto);
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

    
/***********************************************************************************************/
// ESTE METODO SE OCUPA EN EL JFrame VENTA

    public ArrayList<Producto> listProductos(){
        ArrayList listaProducto= new ArrayList();
        Producto producto;
        
        Connection cn = null;
        String SentenciaSQL = "SELECT  idProducto, Nombre, PrecioUnitario FROM producto";

        try {
            cn = con.Conectar();
            psql = cn.prepareStatement(SentenciaSQL);
            ResultSet rs=psql.executeQuery();
            while (rs.next()){
                producto =new Producto();
                producto.setIdProducto(rs.getInt(1));               
                producto.setNombre(rs.getString(2));
                producto.setPrecioUnitario(rs.getDouble(3));
                
                listaProducto.add(producto);                
            }            
        }catch(SQLException e){
            System.err.println(e);            
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
        }
        return listaProducto;        
    }    
    
    public ArrayList<Producto> BuscarProducto(String BuscarCodigo) {
        ArrayList buscarProducto = new ArrayList();
        Producto producto;

        Connection cn = null;
        String SentenciaSQL = "SELECT * FROM producto WHERE Codigo=?";

        try {
            cn = con.Conectar();
            psql = cn.prepareStatement(SentenciaSQL);
            psql.setString(1,BuscarCodigo);
            ResultSet rs=psql.executeQuery();
            while (rs.next()) {
                producto = new Producto();
                producto.setIdProducto(rs.getInt(1));
                producto.setCodigo(rs.getInt(2));
                producto.setNombre(rs.getString(3));
                producto.setPrecioUnitario(rs.getDouble(6));

                buscarProducto.add(producto);
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
}