package com.pmdf.dscatalog.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
public class AppConfig {
	
	@Bean // Com o Bean, estamos dizendo que essa instância vai ser um componente
	// gerenciado pelo SpringBoot, e podemos enjetar ele em outras componentes
	public BCryptPasswordEncoder passwordEnconder() { // passwordEncoder é o nome dado ao nosso método. E este método me retorna uma instância
		return new BCryptPasswordEncoder();
	}

}
