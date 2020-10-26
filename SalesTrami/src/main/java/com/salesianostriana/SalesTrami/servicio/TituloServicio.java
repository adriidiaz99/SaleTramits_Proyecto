package com.salesianostriana.SalesTrami.servicio;

import com.salesianostriana.SalesTrami.modelo.Asignatura;
import com.salesianostriana.SalesTrami.modelo.Curso;
import com.salesianostriana.SalesTrami.modelo.Titulo;
import com.salesianostriana.SalesTrami.repositorio.AsignaturaRepositorio;
import com.salesianostriana.SalesTrami.repositorio.TituloRepositorio;
import com.salesianostriana.SalesTrami.servicio.BaseService.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TituloServicio extends BaseServiceImpl<Titulo, Long, TituloRepositorio> {

    @Autowired
    CursoServicio c1;

    public TituloServicio(TituloRepositorio repo) {
        super(repo);
    }

    public void darDeBajaTitulo(Titulo titulo) {

        Titulo titulo1 = findById(titulo.getId());

        for(Curso c2: titulo1.getCursosTitulo()){
            c1.darDeBajaCurso(c2);
        }

        titulo1.setActivo(false);

        edit(titulo1);


    }

    public void activarTitulo(Titulo titulo) {

        Titulo titulo1 = findById(titulo.getId());

        for(Curso c2: titulo1.getCursosTitulo()){
            c1.activarCurso(c2);
        }

        titulo1.setActivo(true);

        edit(titulo1);


    }

    public List<Titulo> encontrarActivos(){
        return repositorio.EncontrartitulosActivos();
    }

}
