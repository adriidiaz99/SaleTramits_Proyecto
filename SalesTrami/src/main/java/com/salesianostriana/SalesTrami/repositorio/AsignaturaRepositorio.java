package com.salesianostriana.SalesTrami.repositorio;

import com.salesianostriana.SalesTrami.modelo.Asignatura;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AsignaturaRepositorio extends JpaRepository<Asignatura, Long> {

    Optional<Asignatura> findFirstByNombre(String nombre);
}
