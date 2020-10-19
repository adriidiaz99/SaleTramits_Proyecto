package com.salesianostriana.SalesTrami.servicio;

import com.salesianostriana.SalesTrami.modelo.Usuario;
import com.salesianostriana.SalesTrami.repositorio.UsuarioRepositorio;
import com.salesianostriana.SalesTrami.servicio.BaseService.BaseServiceImpl;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServicio extends BaseServiceImpl<Usuario, Long, UsuarioRepositorio> {


    public UsuarioServicio(UsuarioRepositorio repo) {
        super(repo);
    }

    public Optional buscarUsuarioPorUsername(String username){
        return repositorio.findFirstByUsername(username);
    }

    @Override
    public Usuario save(Usuario usuario) {
        BCryptPasswordEncoder b1 = new BCryptPasswordEncoder();

        usuario.setPassword(b1.encode(usuario.getPassword()));

        return super.save(usuario);
    }
}
