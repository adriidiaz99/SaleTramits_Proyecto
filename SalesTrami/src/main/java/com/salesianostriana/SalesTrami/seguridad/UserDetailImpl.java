package com.salesianostriana.SalesTrami.seguridad;

import com.salesianostriana.SalesTrami.servicio.UsuarioServicio;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserDetailImpl implements UserDetailsService {

    private final UsuarioServicio usuarioServicio;

    @SneakyThrows
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return (UserDetails) usuarioServicio.buscarUsuarioPorUsername(username);
    }
}
