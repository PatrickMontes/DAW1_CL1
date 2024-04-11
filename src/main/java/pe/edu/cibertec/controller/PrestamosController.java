package pe.edu.cibertec.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pe.edu.cibertec.model.Prestamos;

@Controller
public class PrestamosController {

    //localhost:8080/prestamos
    @GetMapping("/prestamos")
    public String inicioPrestamos(Model model){
        model.addAttribute("prestamos", new Prestamos());
        model.addAttribute("mostrarMensaje", false);
        return "prestamos";
    }

    @PostMapping("/calcularPrestamo")
    public String calcularPrestamo(@ModelAttribute("prestamos") Prestamos prestamos, Model model) {

        double prestamo = prestamos.getPrestamo();
        int num_cuotas;
        double monto_cuota;

        double interes;
        if (prestamo < 4000) {
            interes = 0.12;  // 12%
        } else {
            interes = 0.10;  // 10%
        }

        double monto_total = prestamo * (1 + interes);
        if (prestamo > 5000) {
            num_cuotas = 3;
        } else if (prestamo < 1000) {
            num_cuotas = 1;
        } else if (prestamo >= 2000 && prestamo <= 3000) {
            num_cuotas = 2;
        } else {
            num_cuotas = 5;
        }

        monto_cuota = monto_total / num_cuotas;
        model.addAttribute("mostrarMensaje", true);
        model.addAttribute("resultado", "Debe pagar el préstamo en " + num_cuotas + " cuotas de $" + String.format("%.2f", monto_cuota) + " cada una.");
        return "prestamos";
    }
}