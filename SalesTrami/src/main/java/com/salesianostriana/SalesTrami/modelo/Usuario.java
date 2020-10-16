package com.salesianostriana.SalesTrami.modelo;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@Builder
@NoArgsConstructor
@RequiredArgsConstructor
public class Usuario {

    @GeneratedValue
    @Id
    private long id;
    private String nombre;

    private String apellido1;

    private String apellido2;

    @Column(unique = true)
    private String email;

    @Column(unique = true)
    private String username;

    @DateTimeFormat(pattern = "yyyy-mm-dd")
    private LocalDate fechaNacimiento;

    private String password;

    private String numeroTelefono;

    private String direccion;

    //IsAccountNonBloqued
    private Boolean cuentaNoBloqueada;

    public Usuario(long id, String nombre, String apellido1, String apellido2, String email, LocalDate fechaNacimiento, String username, String numeroTelefono, String direccion) {
        this.id = id;
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.email = email;
        this.fechaNacimiento = fechaNacimiento;
        this.username = username;
        this.numeroTelefono = numeroTelefono;
        this.direccion = direccion;
    }
}
