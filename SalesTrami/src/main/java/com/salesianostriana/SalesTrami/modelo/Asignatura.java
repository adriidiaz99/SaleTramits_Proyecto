package com.salesianostriana.SalesTrami.modelo;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.List;

@Entity
@Data
@Builder
@NoArgsConstructor
@RequiredArgsConstructor
public class Asignatura {

    @GeneratedValue
    @Id
    private long id;

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @ManyToMany(mappedBy="asignaturas")
    private List<Alumno> alumnos;

    private String nombre;

    private String descripcion;


}
