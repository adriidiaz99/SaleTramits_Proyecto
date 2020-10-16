package com.salesianostriana.SalesTrami.modelo;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
@Builder
@NoArgsConstructor
@RequiredArgsConstructor
public class Curso {

    @GeneratedValue
    @Id
    private long id;

    private String nombre;

    private String descripcion;

}
