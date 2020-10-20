package com.salesianostriana.SalesTrami;

import com.salesianostriana.SalesTrami.modelo.Asignatura;
import com.salesianostriana.SalesTrami.modelo.Curso;
import com.salesianostriana.SalesTrami.modelo.Profesor;
import com.salesianostriana.SalesTrami.modelo.Titulo;
import com.salesianostriana.SalesTrami.servicio.CursoServicio;
import com.salesianostriana.SalesTrami.servicio.TituloServicio;
import com.salesianostriana.SalesTrami.servicio.UsuarioServicio;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.util.ArrayList;

@SpringBootApplication
public class SalesTramiApplication {

	public static void main(String[] args) {
		SpringApplication.run(SalesTramiApplication.class, args);
	}

	@Bean
	CommandLineRunner initData(UsuarioServicio servicioUsuario, CursoServicio curso, TituloServicio t1) {

		return args -> {

			Titulo t2 = new Titulo("EE", "OO");
			Curso c1 = new Curso("Hola", "Ei");

			t1.save(t2);
			t2.addCurso(c1);

			System.out.println(t2);
			System.out.println(c1);

			servicioUsuario.save(new Profesor("LOLO", "Lolo", "Lolo", "lolo@lolo.com", LocalDate.now(), "admin", "1234", "53672728176", "WolaWola", true, true));
			curso.save(c1);
		};
	}
}
