package com.pmdf.dscatalog.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pmdf.dscatalog.dto.CategoriaDTO;
import com.pmdf.dscatalog.services.CategoriaService;

@RestController
@RequestMapping(value = "/categorias")
public class CategoriaResource {

	// Declarando dependência do Controlador para o Service
	@Autowired
	private CategoriaService service;

	// Primeiro end point da aplicação
	@GetMapping
	public ResponseEntity<List<CategoriaDTO>> findAll() {
		List<CategoriaDTO> list = service.findAll();

		return ResponseEntity.ok().body(list);
	}

}
