package com.salesianostriana.SalesTrami.modelo;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import java.io.Serializable;


//CLASE DE PK COMPUESTA PARA SOLICITUDAMPL y SITUACIONEXCEPCIONAL
@Data
@NoArgsConstructor
@Embeddable
public class SolicitudPk implements Serializable {

        private long alumno_id;
        private long asignatura_id;

}
