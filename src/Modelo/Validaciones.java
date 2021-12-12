package Modelo;
import Controlador.Conexion;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
public class Validaciones {
    Conexion con = new Conexion();
    
    public static void esNumeroEntero(java.awt.event.KeyEvent evt, javax.swing.JTextField jt) {
        char c = evt.getKeyChar();
        if ((c < '0') || (c > '9')) {
            evt.consume();
        }
    }

    public static void soloRecibeTexto(java.awt.event.KeyEvent evt, javax.swing.JTextField jt) {

        if (!Character.isLetter(evt.getKeyChar())
                && !(evt.getKeyChar() == KeyEvent.VK_SPACE)
                && !(evt.getKeyChar() == KeyEvent.VK_BACK_SPACE)) {
            evt.consume();
        }
    }

    public static boolean esNumeroNoValido(javax.swing.JTextField jt, int li, int ls, String msg) {
        int valor = Integer.parseInt(jt.getText());
        if (valor < li || valor > ls) {
            JOptionPane.showMessageDialog(null, msg);
            jt.setText(null);
            jt.requestFocus();
            return true;
        }
        return false;
    }

    //Método para validar caja vacia
    public static boolean esCajaVacia(javax.swing.JTextField cajaTexto, String msj) {
        if (cajaTexto.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, msj);
            cajaTexto.requestFocus();
            return true;
        } else {
            return false;
        }
    }

    //Revisar la longitud de un campo de texto
    public static void revisarLongitud(java.awt.event.KeyEvent evt, javax.swing.JTextField jt, int lim) {
        if (jt.getText().length() == lim) {
            evt.consume();
        }
    }

    public boolean ValidarEmail(String Correo) {
        Pattern patron2 = Pattern.compile("^[a-zA-Z0-9]{1,20}@[a-z]{5,7}.[a-z]{3}$");
        Matcher revisa = patron2.matcher(Correo);
        return revisa.find();
    }

    public boolean CantidadesMonetarias(String Monedas) {
        Pattern patron = Pattern.compile("[0-9]{1}\\,[0-9]{3}\\,[0-9]{3}\\.[0-9]{2}");
        Matcher revisa = patron.matcher(Monedas);
        return revisa.find();
    }
    
    public int ProductoExistente(String nombre) {
        Connection cn = null;
        PreparedStatement psql = null;
        ResultSet rs = null;

        String SentenciaSQL = "SELECT count(idProducto) from producto where Nombre=?";
        try {
            cn = con.Conectar();
            psql = cn.prepareStatement(SentenciaSQL);
            //psql.setInt(1,0);
            psql.setString(1, nombre);
            rs = psql.executeQuery();
            if (rs.next()) {
                return rs.getInt(1);
            }
            return 1;
        } catch (SQLException ex) {
            Logger.getLogger(Validaciones.class.getName()).log(Level.SEVERE, null, ex);
            return 1;
        }
    }
    public boolean ValidarContraseña(String Contraseña) {
        Pattern Regla8 = Pattern.compile("^[a-zA-Z0-9]{8,15}(%|&|#|@)$");
        Matcher revisa = Regla8.matcher(Contraseña);
        return revisa.find();
    }  
}

