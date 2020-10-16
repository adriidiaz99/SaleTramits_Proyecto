package com.salesianostriana.SalesTrami.modelo;

import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import javax.persistence.Entity;
import java.util.Collection;
import java.util.Collections;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Profesor extends Usuario {

    private Boolean isJefeEstudios = false;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if(isJefeEstudios)
            return Collections.singleton(new SimpleGrantedAuthority("ROLE_ADMIN"));

        else
            return Collections.singleton(new SimpleGrantedAuthority("ROLE_PROFE"));

    }
}
