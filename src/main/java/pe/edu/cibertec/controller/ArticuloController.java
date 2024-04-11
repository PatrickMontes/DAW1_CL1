package pe.edu.cibertec.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import pe.edu.cibertec.model.Articulo;

@Controller
public class ArticuloController {
    @GetMapping("/articulo")
    public String mostrarForm(Model model) {
        model.addAttribute("articulo", new Articulo());
        return "articulo";
    }

    @PostMapping("/calcularPrecio")
    public String calcularPrecio(@ModelAttribute("articulo") Articulo articulo, Model model) {
        double precio_total = articulo.getPrecio_Articulo();
        double descuento;
        if(articulo.getCantidad_Articulo() >= 1 && articulo.getCantidad_Articulo() <= 10) {
            precio_total = articulo.Precio_Articulo() * articulo.getCantidad_Articulo();
        }
        else {
            if(articulo.getCantidad_Articulo() > 10 && articulo.getCantidad_Articulo() <= 20) {
                precio_total = articulo.getPrecio_Articulo() * articulo.getCantidad_Articulo();
                descuento = precio_total * 0.05;
                precio_total = precio_total - descuento;
            }
            else {
                precio_total = articulo.getPrecio_Articulo() * articulo.getCantidad_Articulo();
                descuento = precio_total * 0.1;
                precio_total = precio_total - descuento;
            }
        }
        model.addAttribute("precio_total", precio_total);
        return "articulo";
    }
}
