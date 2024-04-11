package pe.edu.cibertec.controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import pe.edu.cibertec.model.Producto;

@Controller
public class ProductoController {

    @GetMapping("/calcularDescuento")
    public String mostrarFormulario(Model model) {
        model.addAttribute("producto", new Producto());
        return "producto";
    }

    @PostMapping("/calcularDescuento")
    public String calcularDescuento(@ModelAttribute("producto") Producto producto, Model model) {
        double total = producto.getPrecio() * producto.getCantidad();
        if (total > 200) {
            double descuento = total * 0.20;
            total -= descuento;
        }
        model.addAttribute("total", total);
        return "producto";
    }
}