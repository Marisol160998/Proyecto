package Modelo;

import Controlador.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/* @author Marisol */

public class VentaDAO {
    Conexion con = new Conexion();
    PreparedStatement psql;
    ResultSet rs;
    
public int GuardarVenta(String Fecha, int IdProducto, int Codigo, double Precio, int Cantidad, double Total) {

        int resultado = 0;
        Connection cn = null;

        String SentenciaSQL = "INSERT INTO venta (Fecha, idProducto, Codigo, Precio, Cantidad_vendida, Total)"
                + " VALUES (?,?,?,?,?,?)";

        try {
            cn = con.Conectar();
            psql = cn.prepareStatement(SentenciaSQL);
            //psql.setInt(1,0);
            psql.setString(1, Fecha);
            psql.setInt(2, IdProducto);
            psql.setInt(3, Codigo);
            psql.setDouble(4, Precio);
            psql.setInt(5, Cantidad);
            psql.setDouble(6, Total);
            
            resultado = psql.executeUpdate();
            if (resultado>0){ //si resultado es >0 se ejecuto la transaccion correctamente
               // JOptionPane.showMessageDialog(null, "GRACIAS POR SU VISITA :)");
            }else{
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
}
