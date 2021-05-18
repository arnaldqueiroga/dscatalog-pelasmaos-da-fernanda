package com.pmdf.dscatalog.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

@Configuration
public class AppConfig {
	
	@Bean // Com o Bean, estamos dizendo que essa instância vai ser um componente
	// gerenciado pelo SpringBoot, e podemos enjetar ele em outras componentes
	public BCryptPasswordEncoder passwordEnconder() { // passwordEncoder é o nome dado ao nosso método. E este método me retorna uma instância
		return new BCryptPasswordEncoder();
	}
	
	
	// os dois últimos beans são objetos que acessam o token JWT, ou seja, ler, decodificar, e criar um token
	// eles serão injetados na classe que vai ser o Servidor de Autorização (AuthorizarionServer)
	@Bean
	public JwtAccessTokenConverter accessTokenConverter() { // esse precisamente registra a assinatura do Token, o token é embaralhado...
		JwtAccessTokenConverter tokenConverter = new JwtAccessTokenConverter();
		tokenConverter.setSigningKey("MY-JWT-SECRET");
		return tokenConverter;
	}

	@Bean
	public JwtTokenStore tokenStore() { // bean pra acessar o token, instanciando o tokenStore simplesmente intanciando o accessTokenConverter
		return new JwtTokenStore(accessTokenConverter());
	}

}
