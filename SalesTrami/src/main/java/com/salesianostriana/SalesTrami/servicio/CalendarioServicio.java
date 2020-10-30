package com.salesianostriana.SalesTrami.servicio;

import com.salesianostriana.SalesTrami.modelo.Asignatura;
import com.salesianostriana.SalesTrami.modelo.Calendario;
import com.salesianostriana.SalesTrami.modelo.Curso;
import com.salesianostriana.SalesTrami.repositorio.CalendarioRepositorio;
import com.salesianostriana.SalesTrami.repositorio.CursoRepositorio;
import com.salesianostriana.SalesTrami.servicio.BaseService.BaseServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CalendarioServicio extends BaseServiceImpl<Calendario, Long, CalendarioRepositorio> {

    public CalendarioServicio(CalendarioRepositorio repo) {
        super(repo);
    }

    public Calendario encontrarCalendarioPorCurso(Long id){
        return repositorio.findFirstByCursoId(id).orElseThrow(() -> new NullPointerException());
    }

}
