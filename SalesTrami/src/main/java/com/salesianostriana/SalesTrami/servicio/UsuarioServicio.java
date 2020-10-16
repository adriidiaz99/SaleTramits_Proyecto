package com.salesianostriana.SalesTrami.servicio;

import com.salesianostriana.SalesTrami.modelo.Usuario;
import com.salesianostriana.SalesTrami.repositorio.UsuarioRepositorio;
import com.salesianostriana.SalesTrami.servicio.BaseService.BaseServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioServicio extends BaseServiceImpl<Usuario, Long, UsuarioRepositorio> {


    public UsuarioServicio(UsuarioRepositorio repo) {
        super(repo);
    }

    @Override
    public List<Usuario> findAll() {
        return this.repositorio.findAll();
    }
}
