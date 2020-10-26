package com.salesianostriana.SalesTrami.repositorio;

import com.salesianostriana.SalesTrami.modelo.Asignatura;
import com.salesianostriana.SalesTrami.modelo.Titulo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TituloRepositorio extends JpaRepository<Titulo, Long> {

    @Query(value = "SELECT * FROM TITULO WHERE TITULO.ACTIVO = TRUE", nativeQuery = true)
    List<Titulo> EncontrartitulosActivos();
}
