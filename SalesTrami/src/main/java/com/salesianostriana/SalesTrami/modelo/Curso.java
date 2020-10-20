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

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @OneToMany(cascade=CascadeType.ALL, mappedBy = "curso")
    private List<Alumno> alumnos = new ArrayList<>();

    @OneToMany(cascade=CascadeType.ALL, mappedBy = "curso")
    private List<Asignatura> asignaturasCurso = new ArrayList<>();

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @ManyToOne
    private Titulo titulo;

    public Curso(String nombre, String descripcion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    // Métodos helper
    public void addAsignatura(Asignatura a) {
        this.asignaturasCurso.add(a);
        a.setCurso(this);
    }

    public void removeAsignatura(Asignatura a) {
        this.asignaturasCurso.remove(a);
        a.setCurso(null);
    }

    public void addAlumno(Alumno a) {
        this.alumnos.add(a);
        a.setCurso(this);
    }

    public void removeAlumno(Alumno a) {
        this.alumnos.remove(a);
        a.setCurso(null);
    }
}
