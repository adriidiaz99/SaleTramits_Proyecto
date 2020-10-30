package com.salesianostriana.SalesTrami.repositorio;

import com.salesianostriana.SalesTrami.modelo.Asignatura;
import com.salesianostriana.SalesTrami.modelo.Calendario;
import com.salesianostriana.SalesTrami.modelo.Curso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CalendarioRepositorio extends JpaRepository<Calendario, Long> {


    Optional<Calendario> findFirstByCursoId(long id);

}
