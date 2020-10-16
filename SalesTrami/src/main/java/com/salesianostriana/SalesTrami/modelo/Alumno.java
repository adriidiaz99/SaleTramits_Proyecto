package com.salesianostriana.SalesTrami.modelo;

import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import javax.persistence.*;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Alumno extends Usuario{

    @ManyToOne
    private Curso curso;

    //NO HELPER
    @OneToMany
    private List<SolicitudAmpliacionMatricula> solicitudesMatricula;

    //NO HELPER
    @OneToMany
    private List<SituacionExcepcional> situacionesExc;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singletonList(new SimpleGrantedAuthority("ROLE_ALUMNO"));
    }
}
