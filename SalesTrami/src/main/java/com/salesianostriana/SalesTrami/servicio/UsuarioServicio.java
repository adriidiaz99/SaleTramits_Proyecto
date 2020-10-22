package com.salesianostriana.SalesTrami.servicio;

import com.salesianostriana.SalesTrami.modelo.Alumno;
import com.salesianostriana.SalesTrami.modelo.Profesor;
import com.salesianostriana.SalesTrami.modelo.Usuario;
import com.salesianostriana.SalesTrami.repositorio.UsuarioRepositorio;
import com.salesianostriana.SalesTrami.servicio.BaseService.BaseServiceImpl;
import com.salesianostriana.SalesTrami.utiles.RandomString;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class UsuarioServicio extends BaseServiceImpl<Usuario, Long, UsuarioRepositorio> {

    private RandomString gen = new RandomString(8, ThreadLocalRandom.current());

    public UsuarioServicio(UsuarioRepositorio repo) {
        super(repo);
    }


    public Optional buscarUsuarioPorUsername(String username){
        return repositorio.findFirstByUsername(username);
    }

    public List<Alumno> buscarTodosLosAlumnos(){ return repositorio.encontrarUsuariosAlumnos();}

    public List<Profesor> buscarTodosLosProfes(){ return repositorio.encontrarUsuariosProfesores();}

    @Override
    public Usuario save(Usuario usuario) {
        BCryptPasswordEncoder b1 = new BCryptPasswordEncoder();

        usuario.setPassword(b1.encode(usuario.getPassword()));

        return super.save(usuario);
    }

    public Usuario saveSinPassword(Usuario usuario) {
        BCryptPasswordEncoder b1 = new BCryptPasswordEncoder();
        EmailServiceImpl emailService = new EmailServiceImpl();

        String codified = gen.nextString();

        emailService.sendMail(usuario.getEmail(), "Bienvenido a SaleTramits", "Su usuario es " +usuario.getUsername() +" y su contraseña " +codified);

        usuario.setPassword(b1.encode(codified));

        return super.save(usuario);
    }
}
