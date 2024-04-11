package pe.edu.cibertec.model;

public class Producto {
    private int cantidad;
    private double precio;

    // Constructor
    public Producto() {
    }

    // Getters y setters
    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
}
