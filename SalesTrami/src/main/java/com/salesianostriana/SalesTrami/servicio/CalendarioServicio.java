package com.salesianostriana.SalesTrami.servicio;

import com.salesianostriana.SalesTrami.modelo.Calendario;
import com.salesianostriana.SalesTrami.modelo.Curso;
import com.salesianostriana.SalesTrami.repositorio.CalendarioRepositorio;
import com.salesianostriana.SalesTrami.repositorio.CursoRepositorio;
import com.salesianostriana.SalesTrami.servicio.BaseService.BaseServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class CalendarioServicio extends BaseServiceImpl<Calendario, Long, CalendarioRepositorio> {

    public CalendarioServicio(CalendarioRepositorio repo) {
        super(repo);
    }

}
