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

import com.pmdf.dscatalog.dto.CategoriaDTO;
import com.pmdf.dscatalog.services.CategoriaService;

@RestController
@RequestMapping(value = "/categorias")
public class CategoriaResource {

	// Declarando dependência do Controlador para o Service
	@Autowired
	private CategoriaService service;

	// Primeiro end point da aplicação - GET
	@GetMapping
	public ResponseEntity<List<CategoriaDTO>> findAll() {
		List<CategoriaDTO> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}

	// End-point oara buscar Categoria por Id - GET
	@GetMapping(value = "/{id}")
	public ResponseEntity<CategoriaDTO> findById(@PathVariable Long id) {

		CategoriaDTO dto = service.findbyId(id);
		return ResponseEntity.ok().body(dto);
	}

	// Criando End Point para inserir uma nova categoria - POST

	@PostMapping
	public ResponseEntity<CategoriaDTO> insert(@RequestBody CategoriaDTO dto) {
		dto = service.insert(dto);

		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getId()).toUri();

		return ResponseEntity.created(uri).body(dto);

	}
	
	// Criando End Point para atualizar Categoria - PUT
	@PutMapping(value = "/{id}")
	public ResponseEntity<CategoriaDTO> update(@PathVariable Long id, @RequestBody CategoriaDTO dto){
		dto = service.update(id, dto);
		return ResponseEntity.ok().body(dto);
				
	}
	
	// Criando End Point para deletar Categoria - DELET
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		service.delete(id);
		return ResponseEntity.noContent().build();
				
	}

}











