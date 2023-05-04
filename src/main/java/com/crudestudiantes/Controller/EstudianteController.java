package com.crudestudiantes.Controller;

import com.crudestudiantes.Entity.Estudiante;
import com.crudestudiantes.Service.EstudianteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping({"/estudiante", "/"})
public class EstudianteController {

    @Autowired
    EstudianteService eService;

    @GetMapping("")
    public String index(ModelMap model){
        List<Estudiante> estudiantes = eService.listarEstudiantes();
        model.addAttribute("estudiantes", estudiantes);
        return "estudiantes";
    }

    @GetMapping("/crear")
    public String crearEstudiante(ModelMap model){
        Estudiante estudiante = new Estudiante();
        model.addAttribute("estudiante", estudiante);
        return "crearEstudiante";
    }

    @PostMapping("")
    public String guardarEstudiante(@ModelAttribute("estudiante") Estudiante estudiante){
        eService.guardarEstudiante(estudiante);
        return "redirect:/estudiante";
    }

    @GetMapping("/editar/{id}")
    public String mostrarFormularioEditar(@PathVariable Long id, ModelMap model){
        Estudiante e = eService.buscarEstudianteId(id);
        model.addAttribute("estudiante", e);
        return "editar-estudiante";
    }

    @PostMapping("/{id}")
    public String editarEstudiante(@PathVariable Long id, @ModelAttribute("estudiante") Estudiante estudiante, ModelMap model){
        Estudiante estudianteSinEditar = eService.buscarEstudianteId(id);

        System.out.println(estudianteSinEditar);

        estudianteSinEditar.setId_estudiante(id);
        estudianteSinEditar.setNombre(estudiante.getNombre());
        estudianteSinEditar.setApellido(estudiante.getApellido());
        estudianteSinEditar.setEmail(estudiante.getEmail());

        eService.actualizarEstudiante(estudianteSinEditar);

        return "redirect:/estudiante";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarEstudiante(@PathVariable Long id){
        eService.eliminarEstudiante(id);
        return "redirect:/estudiante";
    }
}
