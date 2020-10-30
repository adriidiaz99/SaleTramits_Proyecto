package com.salesianostriana.SalesTrami.repositorio;

import com.salesianostriana.SalesTrami.modelo.Alumno;
import com.salesianostriana.SalesTrami.modelo.Profesor;
import com.salesianostriana.SalesTrami.modelo.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UsuarioRepositorio extends JpaRepository<Usuario, Long> {

    Optional<Usuario> findFirstByUsername(String username);

    @Query(value = "SELECT * FROM USUARIO JOIN ALUMNO USING (ID)", nativeQuery = true)
    List<Alumno> encontrarUsuariosAlumnos();

    @Query(value = "SELECT * FROM USUARIO JOIN PROFESOR USING (ID)", nativeQuery = true)
    List<Profesor> encontrarUsuariosProfesores();

}
