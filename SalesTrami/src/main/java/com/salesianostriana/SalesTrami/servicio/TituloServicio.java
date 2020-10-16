package com.salesianostriana.SalesTrami.servicio;

import com.salesianostriana.SalesTrami.modelo.Asignatura;
import com.salesianostriana.SalesTrami.modelo.Titulo;
import com.salesianostriana.SalesTrami.repositorio.AsignaturaRepositorio;
import com.salesianostriana.SalesTrami.repositorio.TituloRepositorio;
import com.salesianostriana.SalesTrami.servicio.BaseService.BaseServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class TituloServicio extends BaseServiceImpl<Titulo, Long, TituloRepositorio> {

    public TituloServicio(TituloRepositorio repo) {
        super(repo);
    }
}
