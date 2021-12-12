package Modelo;

/** @author Marisol */

public class Compra {
    private int idCompra;
    private String Fecha;
    private int IdProveedor;
    private String NomProducto;
    private String Marca;
    private double PrecioCompra;
    private double PrecioVenta;
    private int Cantidad;

//-----------------------------------------------------------------
    //METODOS GETTER    
    
    public int getIdCompra() {
        return idCompra;
    }

    public String getFecha() {
        return Fecha;
    }

    public int getIdProveedor() {
        return IdProveedor;
    }

    public String getNomProducto() {
        return NomProducto;
    }

    public String getMarca() {
        return Marca;
    }

    public double getPrecioCompra() {
        return PrecioCompra;
    }

    public double getPrecioVenta() {
        return PrecioVenta;
    }

    public int getCantidad() {
        return Cantidad;
    }
    
//-----------------------------------------------------------------
    //METODOS SETTER
    
    public void setIdCompra(int idCompra) {
        this.idCompra = idCompra;
    }

    public void setFecha(String Fecha) {
        this.Fecha = Fecha;
    }

    public void setIdProveedor(int IdProveedor) {
        this.IdProveedor = IdProveedor;
    }

    public void setNomProducto(String NomProducto) {
        this.NomProducto = NomProducto;
    }

    public void setMarca(String Marca) {
        this.Marca = Marca;
    }

    public void setPrecioCompra(double PrecioCompra) {
        this.PrecioCompra = PrecioCompra;
    }

    public void setPrecioVenta(double PrecioVenta) {
        this.PrecioVenta = PrecioVenta;
    }

    public void setCantidad(int Cantidad) {
        this.Cantidad = Cantidad;
    }        
}
