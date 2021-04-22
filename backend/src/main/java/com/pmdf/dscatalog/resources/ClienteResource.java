package com.pmdf.dscatalog.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pmdf.dscatalog.dto.ClienteDTO;
import com.pmdf.dscatalog.services.ClienteService;

@RestController
@RequestMapping(value = "/clientes")
public class ClienteResource {
	
	// Declarando dependência do Controlador para o Service
		@Autowired
		private ClienteService service;
		
		// Primeiro end point da aplicação - GET
		@GetMapping
		public ResponseEntity<List<ClienteDTO>> findAll() {
			List<ClienteDTO> list = service.findAll();
			return ResponseEntity.ok().body(list);
		}
		
		
	
	

}
