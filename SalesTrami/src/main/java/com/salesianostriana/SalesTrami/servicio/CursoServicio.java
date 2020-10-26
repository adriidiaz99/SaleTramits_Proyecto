package com.salesianostriana.SalesTrami.servicio;

import com.salesianostriana.SalesTrami.modelo.Alumno;
import com.salesianostriana.SalesTrami.modelo.Asignatura;
import com.salesianostriana.SalesTrami.modelo.Curso;
import com.salesianostriana.SalesTrami.modelo.Titulo;
import com.salesianostriana.SalesTrami.repositorio.AsignaturaRepositorio;
import com.salesianostriana.SalesTrami.repositorio.CursoRepositorio;
import com.salesianostriana.SalesTrami.servicio.BaseService.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CursoServicio extends BaseServiceImpl<Curso, Long, CursoRepositorio> {

    @Autowired
    AsignaturaServicio as;

    @Autowired
    UsuarioServicio us;

    public CursoServicio(CursoRepositorio repo) {
        super(repo);
    }

    public void darDeBajaCurso(Curso curso) {

        Curso curso2 = findById(curso.getId());

        for(Alumno a1 : curso2.getAlumnos()){
            a1.removeCurso(null);

            us.edit(a1);
        }

        for(Asignatura a1 : curso2.getAsignaturasCurso()){
            a1.setActivo(false);

            as.edit(a1);

        }

        curso2.setActivo(false);

        edit(curso2);


    }

    public void activarCurso(Curso curso) {

        Curso curso2 = findById(curso.getId());

        for(Asignatura a1 : curso2.getAsignaturasCurso()){
            a1.setActivo(true);

            as.edit(a1);

        }

        curso2.setActivo(true);

        edit(curso2);

    }

    public List<Curso> encontrarActivos(){
        return repositorio.EncontrarCursosActivos();
    }



}
