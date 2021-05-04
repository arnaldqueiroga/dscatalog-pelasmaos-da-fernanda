package com.pmdf.dscatalog.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pmdf.dscatalog.dto.ItemPedidoDTO;
import com.pmdf.dscatalog.entities.ItemPedido;
import com.pmdf.dscatalog.repositories.ItemPedidoRepository;
import com.pmdf.dscatalog.services.exceptions.ResourceNotFoundException;

@Service
public class ItemPedidoService {

	@Autowired
	private ItemPedidoRepository repository;


	// Método FindById - Para buscar todas as categorias por Id
	@Transactional(readOnly = true)
	public ItemPedidoDTO findbyId(Long id) {
		Optional<ItemPedido> obj = repository.findById(id);
		ItemPedido entity = obj.orElseThrow(() -> new ResourceNotFoundException("ItemPedido não encontrada"));
		return new ItemPedidoDTO(entity);
	}



}
