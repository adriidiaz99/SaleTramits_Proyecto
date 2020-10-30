package com.salesianostriana.SalesTrami.controller;

import com.salesianostriana.SalesTrami.servicio.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/profesor/")
@RequiredArgsConstructor
public class ProfeController {

    private final UsuarioServicio usuarioServicio;
    private final TituloServicio tituloServicio;
    private final CursoServicio cursoServicio;
    private final AsignaturaServicio asignaturaServicio;
    private final CalendarioServicio calendarioServicio;
    private final HorarioServicio horarioServicio;

    @GetMapping("/cursos/")
    public String alumnos(Model model){
        model.addAttribute("alumnos",usuarioServicio.buscarTodosLosAlumnos());
        return "./profe/cursos";
    }


}
