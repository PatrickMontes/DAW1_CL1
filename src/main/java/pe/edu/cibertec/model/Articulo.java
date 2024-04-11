package pe.edu.cibertec.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class Articulo {

    private int Cantidad_Articulo;
    private double Precio_Articulo;

    public Articulo() {

    }

    public int getCantidad_Articulo() {
        return Cantidad_Articulo;
    }
    public void setCantidad_Articulo(int cantidad) {
        this.Cantidad_Articulo = cantidad;
    }
    public double Precio_Articulo() {
        return Precio_Articulo;
    }
    public void setPrecio_Articulo(double precio) {
        this.Precio_Articulo = precio;
    }
}
