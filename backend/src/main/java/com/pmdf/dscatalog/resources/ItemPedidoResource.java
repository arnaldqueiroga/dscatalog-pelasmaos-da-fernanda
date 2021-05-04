package com.pmdf.dscatalog.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pmdf.dscatalog.dto.ItemPedidoDTO;
import com.pmdf.dscatalog.services.ItemPedidoService;

@RestController
@RequestMapping(value = "/itens")
public class ItemPedidoResource {

	// Declarando dependência do Controlador para o Service
	@Autowired
	private ItemPedidoService service;


	// End-point oara buscar ItemPedido por Id - GET
	@GetMapping(value = "/{id}")
	public ResponseEntity<ItemPedidoDTO> findById(@PathVariable Long id) {

		ItemPedidoDTO dto = service.findbyId(id);
		return ResponseEntity.ok().body(dto);
	}



}











