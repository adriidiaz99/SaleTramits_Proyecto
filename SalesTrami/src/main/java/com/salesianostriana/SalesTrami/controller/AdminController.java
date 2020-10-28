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
    private final CalendarioServicio calendarioServicio;

    @GetMapping("/titulos/")
    public String titulos(Model model){
        model.addAttribute("titulos", tituloServicio.findAll());
        return "./admin/index";
    }

    @GetMapping("/horarios/")
    public String horarios(Model model){
        model.addAttribute("horarios", calendarioServicio.findAll());
        return "./admin/horarios";
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
        model.addAttribute("cursos", cursoServicio.encontrarActivos());
        return "./admin/anyadirAlumno";
    }

    @GetMapping("/anyadir-horario/")
    public String anyadirHorario(Model model){
        model.addAttribute("cursos", cursoServicio.encontrarActivos());
        model.addAttribute("calendario", new Calendario());
        return "./admin/anyadirHorario";
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

    @PostMapping("/anyadir-horario/submit")
    public String anyadirHorarioPost(@ModelAttribute Calendario calendario){

        calendario.addCurso(calendario.getCurso());

        calendarioServicio.save(calendario);

        cursoServicio.edit(calendario.getCurso());

        return "redirect:/admin/completar-horario/";
    }

    @GetMapping("/completar-horario/")
    public String completarHorario(Model model){
        model.addAttribute("cursos", cursoServicio.encontrarActivos());
        model.addAttribute("calendario", new Calendario());
        return "./admin/anyadirHorario";
    }

    @PostMapping("/anyadir-profe/submit")
    public String anyadirProfePost(@ModelAttribute Profesor profe){

        usuarioServicio.saveSinPassword(profe);
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
        model.addAttribute("titulos", tituloServicio.encontrarActivos());
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
        model.addAttribute("cursos", cursoServicio.encontrarActivos());
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

        tituloServicio.darDeBajaTitulo(tituloServicio.findById(id));

        return "redirect:/admin/titulos/";
    }

    @GetMapping("/baja-curso/{id}")
    public String darDeBajaCurso(@PathVariable long id){

        cursoServicio.darDeBajaCurso(cursoServicio.findById(id));

        return "redirect:/admin/cursos/";
    }

    @GetMapping("/editar-titulo/{id}")
    public String editarTitulo(@PathVariable long id, Model model){

        model.addAttribute(tituloServicio.findById(id));

        return "./admin/anyadirTitulo";
    }

    @PostMapping("/editar-titulo/submit")
    public String editarTituloPost(@ModelAttribute Titulo titulo){

        tituloServicio.edit(titulo);

        return "redirect:/admin/titulos/";
    }

    @GetMapping("/editar-curso/{id}")
    public String editarCurso(@PathVariable long id, Model model){

        model.addAttribute(cursoServicio.findById(id));
        model.addAttribute("titulos", tituloServicio.encontrarActivos());

        return "./admin/anyadirCurso";
    }

    @PostMapping("/editar-curso/submit")
    public String editarCursoPost(@ModelAttribute Curso curso){

        cursoServicio.edit(curso);

        return "redirect:/admin/cursos/";
    }

    @GetMapping("/editar-asignatura/{id}")
    public String editarAsignatura(@PathVariable long id, Model model){

        model.addAttribute("asignatura", asignaturaServicio.findById(id));
        model.addAttribute("cursos", cursoServicio.encontrarActivos());

        return "./admin/anyadirAsignatura";
    }

    @PostMapping("/editar-asignatura/submit")
    public String editarAsignaturaPost(@ModelAttribute Asignatura asignatura){

        asignaturaServicio.edit(asignatura);

        return "redirect:/admin/asignaturas/";
    }

    @GetMapping("/baja-asignatura/{id}")
    public String darDeBajaAsignatura(@PathVariable long id){

        asignaturaServicio.darBajaAsignatura(asignaturaServicio.findById(id));

        return "redirect:/admin/asignaturas/";
    }

    @GetMapping("/activar-titulo/{id}")
    public String activarTitulo(@PathVariable long id){

        tituloServicio.activarTitulo(tituloServicio.findById(id));

        return "redirect:/admin/titulos/";
    }

    @GetMapping("/activar-curso/{id}")
    public String activarCurso(@PathVariable long id){

        cursoServicio.activarCurso(cursoServicio.findById(id));

        return "redirect:/admin/cursos/";
    }

    @GetMapping("/activar-asignatura/{id}")
    public String activarAsignatura(@PathVariable long id){

        asignaturaServicio.activarAsignatura(asignaturaServicio.findById(id));

        return "redirect:/admin/asignaturas/";
    }

    @PostMapping("/editar-profesor/submit")
    public String editarProfesorPost(@ModelAttribute Profesor profe){

        usuarioServicio.edit(profe);

        return "redirect:/admin/profesores/";
    }

    @GetMapping("/editar-profesor/{id}")
    public String editarProfe(@PathVariable long id, Model model){

        model.addAttribute("profe", usuarioServicio.findById(id));

        return "./admin/anyadirProfe";
    }

}
