package com.pmdf.dscatalog.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

@Configuration
@EnableResourceServer // annotation processa debaixo dos panos para que esta classe implemente a funcionalidade do Resource Server do OAuth2
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {
	
	// injetando o ben token store
	@Autowired
	private JwtTokenStore tokenStore;
	
	private static final String[] PUBLIC = {"/oauth/token" };
	
	private static final String[] OPERATOR_OR_ADMIN = {"/produtos/**", "/categorias/**", "/clientes/**", "/pedidos/**", "/itens/**"  };
	
	private static final String[] ADMIN = {"/users/**" };
	
	// com este método, o resource server vai ser capaz de decodificar o token e analisar se o token confere e é válido
	@Override
	public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
		resources.tokenStore(tokenStore);
	}
	
	
	// configurando as rotas http
	@Override
	public void configure(HttpSecurity http) throws Exception {
		// configurar quem pode acessar o que...
		http.authorizeRequests()
		.antMatchers(PUBLIC).permitAll()
		.antMatchers(HttpMethod.GET, OPERATOR_OR_ADMIN).permitAll()
		.antMatchers(OPERATOR_OR_ADMIN).hasAnyRole("OPERATOR", "ADMIN")
		.antMatchers(ADMIN).hasRole("ADMIN")
		.anyRequest().authenticated();
	}
	
	

}
