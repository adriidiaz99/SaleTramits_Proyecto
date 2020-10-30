package com.salesianostriana.SalesTrami.modelo;

import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import javax.persistence.Entity;
import java.time.LocalDate;
import java.util.Collection;
import java.util.Collections;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
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

    public Profesor(String nombre, String apellido1, String apellido2, String email, LocalDate fechaNacimiento, String username, String password, String numeroTelefono, String direccion, Boolean cuentaNoBloqueada, Boolean isJefeEstudios) {
        super(nombre, apellido1, apellido2, email, fechaNacimiento, username, password, numeroTelefono, direccion, cuentaNoBloqueada);
        this.isJefeEstudios = isJefeEstudios;
    }

    public Profesor(String nombre, String apellido1, String apellido2, String email, LocalDate fechaNacimiento, String username, String password, String numeroTelefono, String direccion, Boolean isJefeEstudios) {
        super(nombre, apellido1, apellido2, email, fechaNacimiento, username, password, numeroTelefono, direccion);
        this.isJefeEstudios = isJefeEstudios;
    }

    @Override
    public boolean isEnabled() {
        return super.isEnabled();
    }
}
