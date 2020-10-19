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
public class Titulo {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private long id;

    private String nombre;

    private String descripcion;

    @OneToMany(mappedBy="titulo", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Curso> cursosTitulo = new ArrayList<Curso>();
}
