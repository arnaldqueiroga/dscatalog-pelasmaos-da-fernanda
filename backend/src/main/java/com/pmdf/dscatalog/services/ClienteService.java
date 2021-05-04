package com.pmdf.dscatalog.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pmdf.dscatalog.dto.ClienteDTO;
import com.pmdf.dscatalog.dto.PedidoDTO;
import com.pmdf.dscatalog.entities.Cliente;
import com.pmdf.dscatalog.entities.Pedido;
import com.pmdf.dscatalog.repositories.ClienteRepository;
import com.pmdf.dscatalog.repositories.PedidoRepository;
import com.pmdf.dscatalog.services.exceptions.DatabaseException;
import com.pmdf.dscatalog.services.exceptions.ResourceNotFoundException;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository repository;

	@Autowired
	private PedidoRepository pedidoRepository;

	// Método - Para buscar todas os Clientes
	@Transactional(readOnly = true)
	public List<ClienteDTO> findAll() {
		List<Cliente> list = repository.findAll();

		return list.stream().map(x -> new ClienteDTO(x)).collect(Collectors.toList());

	}

	// Método FindById - Para buscar Clientes por Id
	@Transactional(readOnly = true)
	public ClienteDTO findbyId(Long id) {
		Optional<Cliente> obj = repository.findById(id);
		Cliente entity = obj.orElseThrow(() -> new ResourceNotFoundException("Cliente não encontrado"));
		return new ClienteDTO(entity, entity.getPedidos());
	}

	// Método Insert (inserir)
	@Transactional
	public ClienteDTO insert(ClienteDTO dto) {
		Cliente entity = new Cliente(); // convertendo o objeto ClienteDTO e converter ele para uma entidade
		copyDtoToEntity(dto, entity);
		entity.setNome(dto.getNome());
		entity.setEndereco(dto.getEndereco());
		entity.setTelefone(dto.getTelefone());
		entity.setEmail(dto.getEmail());
		entity.setCpf(dto.getCpf());
		entity = repository.save(entity);
		return new ClienteDTO(entity);

	}

	// Método update (Atualizar)
	@Transactional
	public ClienteDTO update(Long id, ClienteDTO dto) {
		try {
			Cliente entity = repository.getOne(id);
			copyDtoToEntity(dto, entity);
			entity.setNome(dto.getNome());
			entity.setEndereco(dto.getEndereco());
			entity.setTelefone(dto.getTelefone());
			entity.setEmail(dto.getEmail());
			entity.setCpf(dto.getCpf());
			entity = repository.save(entity);
			return new ClienteDTO(entity);

		} catch (ResourceNotFoundException e) {
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
	private void copyDtoToEntity(ClienteDTO dto, Cliente entity) {
		entity.setNome(dto.getNome());
		entity.setEndereco(dto.getEndereco());
		entity.setTelefone(dto.getTelefone());
		entity.setEmail(dto.getEmail());
		entity.setCpf(dto.getCpf());

		// Carregando pedidos no dto para a entidade
		entity.getPedidos().clear(); // para limpar os pedidos
		for (PedidoDTO pedDto : dto.getPedidos()) {
			Pedido pedido = pedidoRepository.getOne(pedDto.getId());
			entity.getPedidos().add(pedido);

		}

	}

}
