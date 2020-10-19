package com.salesianostriana.SalesTrami;

import com.salesianostriana.SalesTrami.modelo.Profesor;
import com.salesianostriana.SalesTrami.servicio.UsuarioServicio;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;

@SpringBootApplication
public class SalesTramiApplication {

	public static void main(String[] args) {
		SpringApplication.run(SalesTramiApplication.class, args);
	}

	@Bean
	CommandLineRunner initData(UsuarioServicio servicioUsuario) {

		return args -> {

			servicioUsuario.save(new Profesor("LOLO", "Lolo", "Lolo", "lolo@lolo.com", LocalDate.now(), "admin", "1234", "53672728176", "WolaWola", true, true));

		};
	}
}
