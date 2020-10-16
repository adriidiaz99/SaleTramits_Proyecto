package com.salesianostriana.SalesTrami.servicio;

import com.salesianostriana.SalesTrami.modelo.Asignatura;
import com.salesianostriana.SalesTrami.modelo.Usuario;
import com.salesianostriana.SalesTrami.repositorio.AsignaturaRepositorio;
import com.salesianostriana.SalesTrami.repositorio.UsuarioRepositorio;
import com.salesianostriana.SalesTrami.servicio.BaseService.BaseServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AsignaturaServicio extends BaseServiceImpl<Asignatura, Long, AsignaturaRepositorio> {


    public AsignaturaServicio(AsignaturaRepositorio repo) {
        super(repo);
    }

    @Override
    public List<Asignatura> findAll() {
        return this.repositorio.findAll();
    }
}
