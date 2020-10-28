package com.salesianostriana.SalesTrami.servicio;

import com.salesianostriana.SalesTrami.modelo.Horario;
import com.salesianostriana.SalesTrami.modelo.SituacionExcepcional;
import com.salesianostriana.SalesTrami.repositorio.HorarioRepositorio;
import com.salesianostriana.SalesTrami.repositorio.SituacionExcepcionalRepositorio;
import com.salesianostriana.SalesTrami.servicio.BaseService.BaseServiceImpl;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

@Service
public class HorarioServicio extends BaseServiceImpl<Horario, Long, HorarioRepositorio> {

    public HorarioServicio(HorarioRepositorio repo) {
        super(repo);
    }

}
