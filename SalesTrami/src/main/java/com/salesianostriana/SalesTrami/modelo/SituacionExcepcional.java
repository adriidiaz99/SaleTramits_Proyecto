package com.salesianostriana.SalesTrami.modelo;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SituacionExcepcional {

    //CLAVE PRIMARIA COMPUESTA
    @EmbeddedId
    private SolicitudPk id;

    //CON ESTO HACEMOS REFERENCIA A ELLA
    @ManyToOne
    @MapsId("alumno_id")
    @JoinColumn(name="alumno_id")
    private Alumno alumno;

    //CON ESTO HACEMOS REFERENCIA A ELLA
    @ManyToOne
    @MapsId("asignatura_id")
    @JoinColumn(name="asignatura_id")
    private Asignatura asignatura;

    @DateTimeFormat(pattern = "yyyy-mm-dd")
    private LocalDate fechaSolicitud;

    private String tipo;

    private String adjunto;

    @DateTimeFormat(pattern = "yyyy-mm-dd")
    private LocalDate fechaResolucion;

    private String estado;
}
