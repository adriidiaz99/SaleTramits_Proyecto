package com.salesianostriana.SalesTrami.controller;

import com.salesianostriana.SalesTrami.modelo.*;
import com.salesianostriana.SalesTrami.servicio.AsignaturaServicio;
import com.salesianostriana.SalesTrami.servicio.CalendarioServicio;
import com.salesianostriana.SalesTrami.servicio.UsuarioServicio;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/alumno/")
@RequiredArgsConstructor
public class AlumnoController {

    private final UsuarioServicio usuarioServicio;
    private final CalendarioServicio calendarioServicio;
    private final AsignaturaServicio asignaturaServicio;

    @GetMapping("/principal/")



    public String principal(Model model){
        Usuario usuario;
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UserDetails userDetail = (UserDetails) auth.getPrincipal();
        usuario = ((Alumno)this.usuarioServicio.buscarUsuarioPorUsername(userDetail.getUsername()));

        Calendario calendario = calendarioServicio.encontrarCalendarioPorCurso(((Alumno)usuarioServicio.findById(usuario.getId())).getCurso().getId());
        Calendario c2 = new Calendario();

        for(int i = 0; i < 6 ; i++){
            c2.addHorario(new Horario());
            for(int j = 0; j < 6; j++){
                c2.getSemana().get(i).addAsignatura(asignaturaServicio.encontrarPorNombre("Hora libre"));
            }
        }

        for(int i = 0; i < calendario.getSemana().size(); i++){



            for(int j = 0; j < calendario.getSemana().get(i).getListaAsignaturas().size(); j++){
                Asignatura a2 = calendario.getSemana().get(j).getListaAsignaturas().get(i);

                c2.getSemana().get(j).getListaAsignaturas().set(i, a2);

            }


        }

        model.addAttribute("alumno", usuario);
        model.addAttribute("horario", c2);

        return "./alumno/index";
    }


}
