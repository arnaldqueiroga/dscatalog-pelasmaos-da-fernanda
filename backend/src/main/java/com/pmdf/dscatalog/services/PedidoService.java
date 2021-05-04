package com.pmdf.dscatalog.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pmdf.dscatalog.dto.PedidoDTO;
import com.pmdf.dscatalog.entities.Pedido;
import com.pmdf.dscatalog.repositories.PedidoRepository;
import com.pmdf.dscatalog.services.exceptions.ResourceNotFoundException;

@Service
public class PedidoService {

	@Autowired
	private PedidoRepository repository;
	
	

	@Transactional(readOnly = true)
	public List<PedidoDTO> findAll() {
		List<Pedido> list = repository.findAll();

		return list.stream().map(x -> new PedidoDTO(x)).collect(Collectors.toList());

	}

	// Método FindById - Para buscar todas as categorias por Id
	@Transactional(readOnly = true)
	public PedidoDTO findbyId(Long id) {
		Optional<Pedido> obj = repository.findById(id);
		Pedido entity = obj.orElseThrow(() -> new ResourceNotFoundException("Pedido não encontrado"));
		return new PedidoDTO(entity);
	}
	
	
	



}
