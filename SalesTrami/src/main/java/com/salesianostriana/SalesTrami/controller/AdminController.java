package com.salesianostriana.SalesTrami.controller;

import com.salesianostriana.SalesTrami.modelo.Alumno;
import com.salesianostriana.SalesTrami.modelo.Curso;
import com.salesianostriana.SalesTrami.servicio.CursoServicio;
import com.salesianostriana.SalesTrami.servicio.UsuarioServicio;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("/admin/")
public class AdminController {

    private final UsuarioServicio usuarioServicio;
    private final CursoServicio cursoServicio;

    @GetMapping("/titulos/")
    public String titulos(){
        return "./admin/index";
    }

    @GetMapping("/profesores/")
    public String profesores(){
        return "./admin/profesores";
    }

    @GetMapping("/alumnos/")
    public String alumnos(Model model){
        model.addAttribute("alumnos",usuarioServicio.buscarTodosLosAlumnos());
        return "./admin/alumnos";
    }

    @GetMapping("/cursos/")
    public String cursos(){
        return "./admin/cursos";
    }

    @GetMapping("/asignaturas/")
    public String asignaturas(){
        return "./admin/asignaturas";
    }

    @GetMapping("/convalidaciones/")
    public String convalidadas(){
        return "./admin/solicitudesConvalidada";
    }

    @GetMapping("/aumento-matriculas/")
    public String aumentoMatriculas(){
        return "./admin/solicitudesMatriculas";
    }

    @GetMapping("/anyadir-alumno/")
    public String anyadirUsuario(Model model){
        model.addAttribute("alumno", new Alumno());
        model.addAttribute("cursos", cursoServicio.findAll());
        return "./admin/anyadirAlumno";
    }

    @PostMapping("/anyadir-alumno/submit")
    public String anyadirUsuarioPost(@ModelAttribute Alumno alumno, @ModelAttribute String objeto){
        Curso c1 = cursoServicio.findById(alumno.getCurso().getId());

        c1.addAlumno(alumno);

        usuarioServicio.save(alumno);
        System.out.println(usuarioServicio.findAll());
        return "redirect:/admin/alumnos/";
    }


}
