package com.pmdf.dscatalog.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

// classe estendendo o AuthorizationServerConfigurerAdapter do próprio Spring Security
@Configuration
@EnableAuthorizationServer // essa annotation faz o processamento por baixo dos panos pra indicar que essa classe é que vai exercer o papel de Servidor de autorização
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {
	
	// injetando os objetos que vamos precisar usar
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@Autowired
	private JwtAccessTokenConverter accessTokenConverter;
	
	@Autowired
	private JwtTokenStore tokenStore;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	
	
	
	@Override
	public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
		security.tokenKeyAccess("permitAll()").checkTokenAccess("isAuthenticated()");
	}
	
	// aqui é definido como será a autenticação, e quais são as credenciais do cliente
	@Override
	public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
		clients.inMemory()
		.withClient("dspelasmaosdafernanda") // para dizer o nome da aplicação cliente
		.secret(passwordEncoder.encode("dsdspelasmaosdafernanda123")) // pra indicar qual é a senha da aplicação
		.scopes("read", "write")  // definir o nível de acesso atribuído
		.authorizedGrantTypes("password") // para dizer qual é o tipo do grant_type, que no caso é o OAuth
		.accessTokenValiditySeconds(86400); // definir o tempo de duração do token
		
	}
	
	// neste bloco, é pra indicar quem é que vai autorizar, e qual vai ser o formato do token
	@Override
	public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
		endpoints.authenticationManager(authenticationManager)
		.tokenStore(tokenStore)  // quais vão ser os objetos responsáveis por processar o token
		.accessTokenConverter(accessTokenConverter);
	}
	
	
	
 
}