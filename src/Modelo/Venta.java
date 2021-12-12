package Modelo;

/* @author Marisol */

public class Venta {
    private int idVenta;
    private String Fecha;
    private int idProducto;
    private int Cantidad;
    private int Total;

    public int getIdVenta() {
        return idVenta;
    }

    public String getFecha() {
        return Fecha;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public int getCantidad() {
        return Cantidad;
    }

    public int getTotal() {
        return Total;
    }

    public void setIdVenta(int idVenta) {
        this.idVenta = idVenta;
    }

    public void setFecha(String Fecha) {
        this.Fecha = Fecha;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public void setCantidad(int Cantidad) {
        this.Cantidad = Cantidad;
    }

    public void setTotal(int Total) {
        this.Total = Total;
    }
}