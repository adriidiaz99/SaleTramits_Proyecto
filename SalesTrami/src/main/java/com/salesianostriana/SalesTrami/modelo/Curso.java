package com.salesianostriana.SalesTrami.modelo;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Builder
@NoArgsConstructor
@RequiredArgsConstructor
public class Curso {

    @GeneratedValue
    @Id
    private long id;

    private String nombre;

    private String descripcion;

    @OneToMany
    private List<Alumno> alumnos = new ArrayList<Alumno>();

    

}
