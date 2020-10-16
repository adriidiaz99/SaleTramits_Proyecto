package com.salesianostriana.SalesTrami.servicio;

import com.salesianostriana.SalesTrami.modelo.SituacionExcepcional;
import com.salesianostriana.SalesTrami.repositorio.SituacionExcepcionalRepositorio;
import com.salesianostriana.SalesTrami.servicio.BaseService.BaseServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class SituacionExcepcionalServicio extends BaseServiceImpl<SituacionExcepcional, Long, SituacionExcepcionalRepositorio> {

    public SituacionExcepcionalServicio(SituacionExcepcionalRepositorio repo) {
        super(repo);
    }
}
