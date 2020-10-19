package com.salesianostriana.SalesTrami.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/")
public class AdminController {

    @GetMapping("/")
    public String titulos(){
        return "./admin/index";
    }

    @GetMapping("/profesores/")
    public String profesores(){
        return "./admin/profesores";
    }

    @GetMapping("/alumnos/")
    public String alumnos(){
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
        return "./admin/solicitudesConvalidadas";
    }

    @GetMapping("/aumento-matriculas/")
    public String aumentoMatriculas(){
        return "./admin/solicitudesMatriculas";
    }


}
