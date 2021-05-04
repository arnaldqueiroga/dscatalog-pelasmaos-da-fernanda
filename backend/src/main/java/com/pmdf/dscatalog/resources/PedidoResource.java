package com.pmdf.dscatalog.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pmdf.dscatalog.dto.PedidoDTO;
import com.pmdf.dscatalog.services.PedidoService;

@RestController
@RequestMapping(value = "/pedidos")
public class PedidoResource {

	// Declarando dependência do Controlador para o Service
	@Autowired
	private PedidoService service;
	
	
	
	

	// Primeiro end point da aplicação - GET
	@GetMapping
	public ResponseEntity<List<PedidoDTO>> findAll() {
		List<PedidoDTO> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}

	// End-point oara buscar Pedido por Id - GET
	@GetMapping(value = "/{id}")
	public ResponseEntity<PedidoDTO> findById(@PathVariable Long id) {

		PedidoDTO dto = service.findbyId(id);
		return ResponseEntity.ok().body(dto);
	}




}
