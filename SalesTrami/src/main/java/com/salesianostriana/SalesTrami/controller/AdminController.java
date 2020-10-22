package com.salesianostriana.SalesTrami.controller;

import com.salesianostriana.SalesTrami.modelo.*;
import com.salesianostriana.SalesTrami.servicio.*;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/admin/")
public class AdminController {

    private final UsuarioServicio usuarioServicio;
    private final TituloServicio tituloServicio;
    private final CursoServicio cursoServicio;
    private final AsignaturaServicio asignaturaServicio;

    @GetMapping("/titulos/")
    public String titulos(Model model){
        model.addAttribute("titulos", tituloServicio.findAll());
        return "./admin/index";
    }

    @GetMapping("/profesores/")
    public String profesores(Model model){
        model.addAttribute("profes",usuarioServicio.buscarTodosLosProfes());
        return "./admin/profesores";
    }

    @GetMapping("/alumnos/")
    public String alumnos(Model model){
        model.addAttribute("alumnos",usuarioServicio.buscarTodosLosAlumnos());
        return "./admin/alumnos";
    }

    @GetMapping("/cursos/")
    public String cursos(Model model){
        model.addAttribute("cursos", cursoServicio.findAll());
        return "./admin/cursos";
    }

    @GetMapping("/asignaturas/")
    public String asignaturas(Model model){
        model.addAttribute("asignaturas", asignaturaServicio.findAll());
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

    @GetMapping("/anyadir-profe/")
    public String anyadirProfe(Model model){
        model.addAttribute("profe", new Profesor());
        return "./admin/anyadirProfe";
    }

    @GetMapping("/anyadir-titulo/")
    public String anyadirTitulo(Model model){
        model.addAttribute("titulo", new Titulo());
        return "./admin/anyadirTitulo";
    }

    @PostMapping("/anyadir-alumno/submit")
    public String anyadirUsuarioPost(@ModelAttribute Alumno alumno){
        Curso c1 = cursoServicio.findById(alumno.getCurso().getId());

        alumno.addCurso(c1);

        usuarioServicio.saveSinPassword(alumno);

        System.out.println(usuarioServicio.findAll());
        return "redirect:/admin/alumnos/";
    }

    @PostMapping("/anyadir-profe/submit")
    public String anyadirProfePost(@ModelAttribute Profesor profe){

        usuarioServicio.save(profe);
        return "redirect:/admin/profesores/";
    }

    @PostMapping("/anyadir-titulo/submit")
    public String anyadirTituloPost(@ModelAttribute Titulo titulo){

        tituloServicio.save(titulo);
        return "redirect:/admin/titulos/";
    }

    @GetMapping("/anyadir-curso/")
    public String anyadirCurso(Model model){
        model.addAttribute("curso", new Curso());
        model.addAttribute("titulos", tituloServicio.findAll());
        return "./admin/anyadirCurso";
    }

    @PostMapping("/anyadir-curso/submit")
    public String anyadirCursoPost(@ModelAttribute Curso c1){
        Titulo t1 = tituloServicio.findById(c1.getTitulo().getId());

        t1.addCurso(c1);

        cursoServicio.save(c1);
        return "redirect:/admin/cursos/";
    }

    @GetMapping("/anyadir-asignatura/")
    public String anyadirAsignatura(Model model){
        model.addAttribute("asignatura", new Asignatura());
        model.addAttribute("cursos", cursoServicio.findAll());
        return "./admin/anyadirAsignatura";
    }

    @PostMapping("/anyadir-asignatura/submit")
    public String anyadirAsignaturaPost(@ModelAttribute Asignatura a1){
        Curso c1 = cursoServicio.findById(a1.getCurso().getId());

        c1.addAsignatura(a1);

        asignaturaServicio.save(a1);
        return "redirect:/admin/asignaturas/";
    }

    @GetMapping("/baja-titulo/{id}")
    public String darDeBajaTitulo(@PathVariable long id){

        Titulo t1 = tituloServicio.findById(id);

        for(Curso c1 : t1.getCursosTitulo()){

            c1.setActivo(false);

        }

        tituloServicio.findById(t1.getId()).setActivo(false);

        return "redirect:/admin/titulos/";
    }

    @GetMapping("/baja-curso/{id}")
    public String darDeBajaCurso(@PathVariable long id){

        Curso c1 = cursoServicio.findById(id);

        cursoServicio.findById(c1.getId()).setActivo(false);

        return "redirect:/admin/cursos/";
    }


}
