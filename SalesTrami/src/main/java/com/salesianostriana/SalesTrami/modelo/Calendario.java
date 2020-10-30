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

    private boolean activo = true;

    //Helper

    public void addHorario(Horario horario){
        semana.add(horario);
        horario.setCalendario(this);
    }

    public void removeHorario(Horario horario){
        semana.remove(horario);
        horario.setCalendario(null);
    }

}
