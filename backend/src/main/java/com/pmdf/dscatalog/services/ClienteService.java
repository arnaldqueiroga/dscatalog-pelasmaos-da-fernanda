package com.pmdf.dscatalog.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pmdf.dscatalog.dto.ClienteDTO;
import com.pmdf.dscatalog.entities.Cliente;
import com.pmdf.dscatalog.repositories.ClienteRepository;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository repository;
	
	// Método FindById - Para buscar todas os Clientes	
	@Transactional(readOnly = true)
	public List<ClienteDTO> findAll() {
		List<Cliente> list = repository.findAll();

		return list.stream().map(x -> new ClienteDTO(x)).collect(Collectors.toList());

	}

}
