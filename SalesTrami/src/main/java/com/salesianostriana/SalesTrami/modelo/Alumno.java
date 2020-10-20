package com.salesianostriana.SalesTrami.modelo;

import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.*;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class Alumno extends Usuario{

    @ManyToOne
    private Curso curso;

    //NO HELPER
    @OneToMany(cascade=CascadeType.ALL, mappedBy = "alumno")
    private List<SolicitudAmpliacionMatricula> solicitudesMatricula = new ArrayList<SolicitudAmpliacionMatricula>();

    //NO HELPER
    @OneToMany(cascade=CascadeType.ALL, mappedBy = "alumno")
    private List<SituacionExcepcional> situacionesExc = new ArrayList<SituacionExcepcional>();

    public Alumno(String nombre, String apellido1, String apellido2, String email, LocalDate fechaNacimiento, String username, String password, String numeroTelefono, String direccion, Boolean cuentaNoBloqueada) {
        super(nombre, apellido1, apellido2, email, fechaNacimiento, username, password, numeroTelefono, direccion, cuentaNoBloqueada);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singletonList(new SimpleGrantedAuthority("ROLE_ALUMNO"));
    }

}
