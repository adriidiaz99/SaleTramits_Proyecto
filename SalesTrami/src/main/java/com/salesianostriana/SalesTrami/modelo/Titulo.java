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

    @OneToMany(mappedBy="titulo", cascade = CascadeType.ALL)
    private List<Curso> cursosTitulo = new ArrayList<>();

    public Titulo(String nombre, String descripcion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public void addCurso(Curso a) {
        this.cursosTitulo.add(a);
        a.setTitulo(this);
    }

    public void removeCurso(Curso a) {
        this.cursosTitulo.remove(a);
        a.setTitulo(null);
    }
}
