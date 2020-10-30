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

    private Boolean activo = true;

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @OneToMany(cascade=CascadeType.ALL, mappedBy = "curso")
    private List<Alumno> alumnos = new ArrayList<>();

    @OneToMany(mappedBy = "curso")
    private List<Asignatura> asignaturasCurso = new ArrayList<>();

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @ManyToOne
    private Titulo titulo;

    public Curso(String nombre, String descripcion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public void addAsignatura(Asignatura a1){
        this.getAsignaturasCurso().add(a1);
        a1.setCurso(this);
    }

    public void removeAsignatura(Asignatura a1){
        this.getAsignaturasCurso().remove(a1);
        a1.setCurso(null);
    }

}
