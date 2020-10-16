package com.salesianostriana.SalesTrami.modelo;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
@Data
@Builder
@NoArgsConstructor
@RequiredArgsConstructor
public class SituacionExcepcional {

    @GeneratedValue
    @Id
    private long id;

    @DateTimeFormat(pattern = "yyyy-mm-dd")
    private LocalDate fechaSolicitud;

    private String tipo;

    private String adjunto;

    @DateTimeFormat(pattern = "yyyy-mm-dd")
    private LocalDate fechaResolucion;

    private String estado;
}
