package com.salesianostriana.SalesTrami.modelo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Calendario {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @OneToOne
    private Curso curso;

    @OneToMany(mappedBy = "calendario")
    private List<Horario> semana = new ArrayList<>();

    //Helper

    public void addCurso(Curso curso){
        setCurso(curso);
        curso.setCalendario(this);
    }

    public void removeCurso(Curso curso){
        setCurso(null);
        curso.setCalendario(null);
    }

}
