package com.salesianostriana.SalesTrami.servicio;

import com.salesianostriana.SalesTrami.modelo.Alumno;
import com.salesianostriana.SalesTrami.modelo.Asignatura;
import com.salesianostriana.SalesTrami.modelo.Curso;
import com.salesianostriana.SalesTrami.modelo.Usuario;
import com.salesianostriana.SalesTrami.repositorio.AsignaturaRepositorio;
import com.salesianostriana.SalesTrami.repositorio.UsuarioRepositorio;
import com.salesianostriana.SalesTrami.servicio.BaseService.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
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

    public void darBajaAsignatura(Asignatura a1){

        a1.setActivo(false);

        edit(a1);
    }

    public void activarAsignatura(Asignatura a1){

        a1.setActivo(true);

        edit(a1);
    }

    public Asignatura encontrarPorNombre(String nombre){
        return repositorio.findFirstByNombre(nombre).orElseThrow(() -> new NullPointerException());
    }
}
