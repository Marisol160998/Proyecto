package Modelo;

import Controlador.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/* @author Marisol */

public class UsuarioDAO {
    Conexion con = new Conexion();
    PreparedStatement psql;
    ResultSet rs;
    
    public int GuardarUsuario(String Fecha,String Nombre,String Apellidos,String Email,String TipoUsuario,String Telefono,String Contraseña) {
        int resultado = 0;
        Connection cn = null;

        String SentenciaSQL = "INSERT INTO usuario (Fecha,Nombre,Apellidos,Email,TipoUsuario,Telefono,Contraseña) VALUES (?,?,?,?,?,?,?)";

        try {
            cn = con.Conectar();
            psql = cn.prepareStatement(SentenciaSQL);
            psql.setString(1, Fecha);
            psql.setString(2, Nombre);
            psql.setString(3, Apellidos);
            psql.setString(4, Email);
            psql.setString(5, TipoUsuario);
            psql.setString(6, Telefono);
            psql.setString(7, Contraseña);
           
            resultado = psql.executeUpdate();
            if (resultado>0){ //si resultado es >0 se ejecuto la transaccion correctamente
                JOptionPane.showMessageDialog(null, "Se registró correctamente");
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
