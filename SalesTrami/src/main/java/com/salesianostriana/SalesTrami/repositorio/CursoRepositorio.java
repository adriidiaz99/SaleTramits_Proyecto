package com.salesianostriana.SalesTrami.repositorio;

import com.salesianostriana.SalesTrami.modelo.Asignatura;
import com.salesianostriana.SalesTrami.modelo.Curso;
import com.salesianostriana.SalesTrami.modelo.Titulo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CursoRepositorio extends JpaRepository<Curso, Long> {

    @Query(value = "SELECT * FROM CURSO WHERE CURSO.ACTIVO = TRUE", nativeQuery = true)
    List<Curso> EncontrarCursosActivos();
}
