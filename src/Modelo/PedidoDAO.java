package Modelo;
/* @author Marisol */

import Controlador.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class PedidoDAO {
    
    Conexion con = new Conexion();
    PreparedStatement psql;
    ResultSet rs;
    
    public int GuardarPedido(String Fecha, String NomCliente, int idProducto, double PrecioUnitario, int Cantidad, int Anticipo, double Total) {
        int resultado = 0;
        Connection cn = null;

        String SentenciaSQL = "INSERT INTO pedido (Fecha, NomCliente, idProducto, PrecioUnitario, Cantidad, Anticipo, Total)"
                + " VALUES (?,?,?,?,?,?,?)";

        try {
            cn = con.Conectar();
            psql = cn.prepareStatement(SentenciaSQL);
            //psql.setInt(1,0);
            psql.setString(1, Fecha);
            psql.setString(2, NomCliente);
            psql.setInt(3, idProducto);
            psql.setDouble(4, PrecioUnitario);
            psql.setInt(5, Cantidad);
            psql.setInt(6, Anticipo);
            psql.setDouble(7, Total);

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

    public ArrayList<Pedido> listPedido() {
        ArrayList listaPedido = new ArrayList();
        Pedido pedido;

        Connection cn = null;
        String SentenciaSQL = "SELECT * FROM pedido";

        try {
            cn = con.Conectar();
            psql = cn.prepareStatement(SentenciaSQL);
            ResultSet rs = psql.executeQuery();
            while (rs.next()) {
                pedido = new Pedido();
                pedido.setIdPedido(rs.getInt(1));
                pedido.setFecha(rs.getString(2));
                pedido.setNomCliente(rs.getString(3));
                pedido.setIdProducto(rs.getInt(4));
                pedido.setPrecioUnitario(rs.getDouble(5));
                pedido.setCantidad(rs.getInt(6));
                pedido.setAnticipo(rs.getInt(7));
                pedido.setTotal(rs.getDouble(8));

                listaPedido.add(pedido);
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
        return listaPedido;
    }

    public void editarPedido(int idPedido, String Fecha, String NomCliente, int idProducto, double PrecioUnitario, int Cantidad, int Anticipo, double Total) {
        int resultado = 0;
        Connection cn = null;
        String SentenciaSQL = "UPDATE pedido SET Fecha=?,NomCliente=?,idProducto=?,PrecioUnitario=?,Cantidad=?,Anticipo=?,Total=? WHERE idPedido=?";

        try {
            cn = con.Conectar();
            psql = cn.prepareStatement(SentenciaSQL);
            psql.setString(1, Fecha);
            psql.setString(2, NomCliente);
            psql.setInt(3, idProducto);
            psql.setDouble(4, PrecioUnitario);
            psql.setInt(5, Cantidad);
            psql.setInt(6, Anticipo);
            psql.setDouble(7, Total);
            psql.setInt(8, idPedido);
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

    public int eliminarPedido(int idPedido) {
        int resultado = 0;
        Connection cn = null;
        String SentenciaSQL = "DELETE FROM pedido WHERE idPedido=?";
        try {
            cn = con.Conectar();
            psql = cn.prepareStatement(SentenciaSQL);
            psql.setInt(1, idPedido);

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
