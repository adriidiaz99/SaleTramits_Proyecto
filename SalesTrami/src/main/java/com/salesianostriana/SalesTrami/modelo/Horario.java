package com.salesianostriana.SalesTrami.modelo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

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

    @ManyToOne
    private Calendario calendario;

    private boolean activo;

}
