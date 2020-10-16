package com.salesianostriana.SalesTrami.modelo;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Asignatura {

    @GeneratedValue
    @Id
    private long id;

    private String nombre;

    private String descripcion;

    //NO HELPER
    @OneToMany
    private List<SolicitudAmpliacionMatricula> solicitudesMatricula;

    //NO HELPER
    @OneToMany
    private List<SituacionExcepcional> situacionesExc;

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @ManyToMany(mappedBy="asignaturas")
    private List<Alumno> alumnos;


}
