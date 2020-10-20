package com.salesianostriana.SalesTrami.modelo;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Asignatura {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private long id;

    private String nombre;

    private String descripcion;

    //NO HELPER
    @OneToMany(cascade=CascadeType.ALL, mappedBy = "asignatura")
    private List<SolicitudAmpliacionMatricula> solicitudesMatricula;

    //NO HELPER
    @OneToMany(cascade=CascadeType.ALL, mappedBy = "asignatura")
    private List<SituacionExcepcional> situacionesExc;

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @ManyToOne
    private Curso curso;

    public Asignatura(String nombre, String descripcion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
    }
}
