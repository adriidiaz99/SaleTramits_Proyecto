package com.salesianostriana.SalesTrami.modelo;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Collection;
import java.util.Collections;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Usuario implements UserDetails {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private long id;
    private String nombre;

    private String apellido1;

    private String apellido2;

    @Column(unique = true)
    private String email;

    @Column(unique = true)
    private String username;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate fechaNacimiento;

    private String password;

    private String numeroTelefono;

    private String direccion;

    //IsAccountNonBloqued
    private Boolean cuentaNoBloqueada = false;

    public Usuario(String nombre, String apellido1, String apellido2, String email, LocalDate fechaNacimiento, String username, String password, String numeroTelefono, String direccion, Boolean cuentaNoBloqueada) {
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.email = email;
        this.fechaNacimiento = fechaNacimiento;
        this.username = username;
        this.password = password;
        this.numeroTelefono = numeroTelefono;
        this.direccion = direccion;
        this.cuentaNoBloqueada = cuentaNoBloqueada;
    }

    public Usuario(String nombre, String apellido1, String apellido2, String email, LocalDate fechaNacimiento, String username, String password, String numeroTelefono, String direccion) {
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.email = email;
        this.fechaNacimiento = fechaNacimiento;
        this.username = username;
        this.password = password;
        this.numeroTelefono = numeroTelefono;
        this.direccion = direccion;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
