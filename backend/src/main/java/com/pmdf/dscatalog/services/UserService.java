package com.pmdf.dscatalog.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pmdf.dscatalog.dto.RoleDTO;
import com.pmdf.dscatalog.dto.UserDTO;
import com.pmdf.dscatalog.dto.UserInsertDTO;
import com.pmdf.dscatalog.dto.UserUpdateDTO;
import com.pmdf.dscatalog.entities.Role;
import com.pmdf.dscatalog.entities.User;
import com.pmdf.dscatalog.repositories.RoleRepository;
import com.pmdf.dscatalog.repositories.UserRepository;
import com.pmdf.dscatalog.services.exceptions.DatabaseException;
import com.pmdf.dscatalog.services.exceptions.ResourceNotFoundException;

@Service
public class UserService implements UserDetailsService {
	
	private static Logger logger = LoggerFactory.getLogger(UserService.class);
	
	// Injetando o BCrypt que foi instanciado da classe AppConfig
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	@Autowired
	private UserRepository repository;
	
	@Autowired
	private RoleRepository roleRepository;
	


	@Transactional(readOnly = true)
	public List<UserDTO> findAll() {
		List<User> list = repository.findAll();

		return list.stream().map(x -> new UserDTO(x)).collect(Collectors.toList());

	}

	// Método FindById - Para buscar os usuários por Id
	@Transactional(readOnly = true)
	public UserDTO findbyId(Long id) {
		Optional<User> obj = repository.findById(id);
		User entity = obj.orElseThrow(() -> new ResourceNotFoundException("User não encontrada"));
		return new UserDTO(entity);
	}

	// Criando o método insert passando somente o DTO que carrega a senha do usuário
	@Transactional
	public UserDTO insert(UserInsertDTO dto) {
		User entity = new User();
		copyDtoToEntity(dto, entity);
		entity.setPassword(passwordEncoder.encode(dto.getPassword())); // Nessa linha, estamos gerando o código BCrypt para a senha do usuário
		entity = repository.save(entity);
		return new UserDTO(entity);

	}

	// Criando o método update
	@Transactional
	public UserDTO update(Long id, UserUpdateDTO dto) {
		try {
			User entity = repository.getOne(id);
			copyDtoToEntity(dto, entity);
			entity = repository.save(entity);
			return new UserDTO(entity);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(" Id não encontrado " + id);

		}

	}

	// Criando o método Delete

	public void delete(Long id) {
		try {
			repository.deleteById(id);
		}

		catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException("Id nao encontrado " + id);
		}

		catch (DataIntegrityViolationException e) {
			throw new DatabaseException("Erro de Violação de Integridade");
		}

	}

	// Método auxiliar copyDtoToEntity
	private void copyDtoToEntity(UserDTO dto, User entity) {
		entity.setFirstName(dto.getFirstName());
		entity.setLastName(dto.getLastName());
		entity.setEmail(dto.getEmail());

		// Carregando os pedidos no dto para a entidade
		entity.getRoles().clear(); // para limpar as categorias
		for (RoleDTO roleDto : dto.getRoles()) {
			Role role = roleRepository.getOne(roleDto.getId());
			entity.getRoles().add(role);

		}

	}
	
	// Foi implementado um método que dado um UserName, o que é retornado é o UserDetails
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// implementando busca por email
		User user = repository.findByEmail(username);
		if (user == null) {
			logger.error("Usuário não encontrado: " + username);
			throw new UsernameNotFoundException("Email não encontrado");
		}
		
		logger.info("Usuário encontrado:  " + username);
		return user;
	}

}
