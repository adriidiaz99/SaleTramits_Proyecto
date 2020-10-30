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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class UsuarioServicio extends BaseServiceImpl<Usuario, Long, UsuarioRepositorio> {

    @Autowired
    EmailServiceImpl emailService;

    private RandomString gen = new RandomString(8, ThreadLocalRandom.current());

    public UsuarioServicio(UsuarioRepositorio repo) {
        super(repo);
    }

    public Usuario buscarUsuarioPorUsername(String username){
        return repositorio.findFirstByUsername(username).orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado"));
    }

    public List<Alumno> buscarTodosLosAlumnos(){ return repositorio.encontrarUsuariosAlumnos();}

    public List<Profesor> buscarTodosLosProfes(){ return repositorio.encontrarUsuariosProfesores();}

    @Override
    public Usuario save(Usuario usuario) {
        BCryptPasswordEncoder b1 = new BCryptPasswordEncoder();

        usuario.setPassword(b1.encode(usuario.getPassword()));

        return super.save(usuario);
    }

    public String generarPasswRandom(){

        int leftLimit = 97; // letter 'a'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = 9;
        Random random = new Random();

        String generatedString = random.ints(leftLimit, rightLimit + 1)
                .limit(targetStringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();

        return generatedString;
    }

    public Usuario saveSinPassword(Usuario usuario) {
        BCryptPasswordEncoder b1 = new BCryptPasswordEncoder();

        String codified = generarPasswRandom();

        usuario.setPassword(codified);

        System.out.println(codified);
        /*emailService.sendMail(usuario.getEmail(), "Bienvenido a SaleTramits", "Su usuario es " +usuario.getUsername() +" y su contraseña " +codified);*/

        usuario.setPassword(b1.encode(usuario.getPassword()));

        return super.save(usuario);
    }

    public void activarUsuario(Usuario usuario){
        usuario.setCuentaNoBloqueada(true);
        edit(usuario);
    }
}
