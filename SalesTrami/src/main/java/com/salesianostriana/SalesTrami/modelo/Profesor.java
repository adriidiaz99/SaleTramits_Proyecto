package com.salesianostriana.SalesTrami.modelo;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import javax.persistence.Entity;
import java.util.Collection;
import java.util.Collections;

@Entity
@Data
@Builder
@NoArgsConstructor
@RequiredArgsConstructor
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
