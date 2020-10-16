package com.salesianostriana.SalesTrami.repositorio;

import com.salesianostriana.SalesTrami.modelo.SituacionExcepcional;
import com.salesianostriana.SalesTrami.modelo.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SituacionExcepcionalRepositorio extends JpaRepository<SituacionExcepcional, Long> {
}
