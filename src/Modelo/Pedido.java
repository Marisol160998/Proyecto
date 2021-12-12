package Modelo;

/* @author Marisol */

public class Pedido {
    private int idPedido;
    private String Fecha;
    private String NomCliente;
    private int idProducto;
    private double PrecioUnitario;
    private int Cantidad;
    private int Anticipo;
    private double Total;

    public int getIdPedido() {
        return idPedido;
    }

    public String getFecha() {
        return Fecha;
    }

    public String getNomCliente() {
        return NomCliente;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public double getPrecioUnitario() {
        return PrecioUnitario;
    }

    public int getCantidad() {
        return Cantidad;
    }

    public int getAnticipo() {
        return Anticipo;
    }

    public double getTotal() {
        return Total;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    public void setFecha(String Fecha) {
        this.Fecha = Fecha;
    }

    public void setNomCliente(String NomCliente) {
        this.NomCliente = NomCliente;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public void setPrecioUnitario(double PrecioUnitario) {
        this.PrecioUnitario = PrecioUnitario;
    }

    public void setCantidad(int Cantidad) {
        this.Cantidad = Cantidad;
    }

    public void setAnticipo(int Anticipo) {
        this.Anticipo = Anticipo;
    }

    public void setTotal(double Total) {
        this.Total = Total;
    }    
}