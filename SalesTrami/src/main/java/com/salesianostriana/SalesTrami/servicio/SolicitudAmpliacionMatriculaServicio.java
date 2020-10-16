package com.salesianostriana.SalesTrami.servicio;

import com.salesianostriana.SalesTrami.modelo.Asignatura;
import com.salesianostriana.SalesTrami.modelo.SolicitudAmpliacionMatricula;
import com.salesianostriana.SalesTrami.repositorio.AsignaturaRepositorio;
import com.salesianostriana.SalesTrami.repositorio.SolicitudAmpliacionMatriculaRepositorio;
import com.salesianostriana.SalesTrami.servicio.BaseService.BaseServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class SolicitudAmpliacionMatriculaServicio extends BaseServiceImpl<SolicitudAmpliacionMatricula, Long, SolicitudAmpliacionMatriculaRepositorio> {

    public SolicitudAmpliacionMatriculaServicio(SolicitudAmpliacionMatriculaRepositorio repo) {
        super(repo);
    }
}
