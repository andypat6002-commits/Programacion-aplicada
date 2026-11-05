package modelo;

public class Produccion {

    private String codigoProducto;
    private int cantidad;

    public Produccion(String codigoProducto, int cantidad) {
        this.codigoProducto = codigoProducto;
        this.cantidad = cantidad;
    }

    public String getCodigoProducto() {
        return codigoProducto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCodigoProducto(String codigoProducto) {
        this.codigoProducto = codigoProducto;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
}