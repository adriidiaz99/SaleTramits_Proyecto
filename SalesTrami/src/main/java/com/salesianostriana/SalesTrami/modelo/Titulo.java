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

    private Boolean activo = true;

    @OneToMany(mappedBy="titulo")
    private List<Curso> cursosTitulo = new ArrayList<>();

    public Titulo(String nombre, String descripcion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public void addCurso(Curso c){
        this.getCursosTitulo().add(c);
        c.setTitulo(this);
    }

    public void removeCurso(Curso c){
        this.getCursosTitulo().remove(c);
        c.setTitulo(null);
    }
}
