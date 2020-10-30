package com.salesianostriana.SalesTrami.modelo;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Horario {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToMany(mappedBy = "horarios")
    private List <Asignatura> listaAsignaturas = new ArrayList<>();

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @ManyToOne
    private Calendario calendario;

    private boolean activo;

    public void addAsignatura(Asignatura a1){
        listaAsignaturas.add(a1);
        a1.getHorarios().add(this);

    }

    public void removeAsignatura(Asignatura a1){
        listaAsignaturas.remove(a1);
        a1.getHorarios().remove(this);

    }

}
