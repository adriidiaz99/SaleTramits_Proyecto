package com.salesianostriana.SalesTrami.modelo;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Curso {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private long id;

    private String nombre;

    private String descripcion;

    @OneToMany
    private List<Alumno> alumnos = new ArrayList<Alumno>();

    @OneToMany
    private List<Asignatura> asignaturasCurso = new ArrayList<Asignatura>();

    @ManyToOne
    private Titulo titulo;

}
