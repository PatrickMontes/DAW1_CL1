package pe.edu.cibertec.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pe.edu.cibertec.model.Calificaciones;

@Controller
public class CalificacionesController {

    //localhost:8080/calificaciones
    @GetMapping("/calificaciones")
    public String inicioCalificaciones(Model model){
        model.addAttribute("calificacionesModel", new Calificaciones());
        model.addAttribute("mostrarResultado", false);

        return "calificaciones";
    }


    @PostMapping("/calificaciones")
    public String calculadoraPromedio(@ModelAttribute("calificacionesModel") Calificaciones calificacionesModel, Model model){
        double promedio = (calificacionesModel.getNota1() + calificacionesModel.getNota2() + calificacionesModel.getNota3()) / 3.0;
        String resultado;

        resultado = (promedio >= 70) ? "aprobado" : "reprobado";

        model.addAttribute("mostrarResultado", true);
        model.addAttribute("respuesta", "Su promedio es: "+String.format("%.2f", promedio)+ "usted se encuentra "+ resultado);
        return "calificaciones";
    }
}

