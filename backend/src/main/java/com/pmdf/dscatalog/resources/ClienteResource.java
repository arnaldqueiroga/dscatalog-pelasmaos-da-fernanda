package com.pmdf.dscatalog.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

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
		
		// End-point para buscar CLIENTE por Id - GET
		@GetMapping(value = "/{id}")
		public ResponseEntity<ClienteDTO> findById(@PathVariable Long id) {

			ClienteDTO dto = service.findbyId(id);
			return ResponseEntity.ok().body(dto);
		}
		
		
		// Criando End Point para inserir um novo Cliente - POST
		@PostMapping
		public ResponseEntity<ClienteDTO> insert(@RequestBody ClienteDTO dto){
			dto = service.insert(dto);
			
			URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
					.buildAndExpand(dto.getId()).toUri();		
			return ResponseEntity.created(uri).body(dto);
			
		}
		
		// Criando End Point para atualizar Cliente - PUT
		@PutMapping(value = "/{id}")
		public ResponseEntity<ClienteDTO> update(@PathVariable Long id, @RequestBody ClienteDTO dto) {
			dto = service.update(id, dto);
			return ResponseEntity.ok().body(dto);
		}
		
		// Criando End Point para deletar Cliente - DELET
		@DeleteMapping(value = "/{id}")
		public ResponseEntity<Void> delete(@PathVariable Long id){
			service.delete(id);
			return ResponseEntity.noContent().build();
					
		}
		
		
	
	

}
