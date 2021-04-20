package com.pmdf.dscatalog.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pmdf.dscatalog.dto.CategoriaDTO;
import com.pmdf.dscatalog.entities.Categoria;
import com.pmdf.dscatalog.repositories.CategoriaRepository;
import com.pmdf.dscatalog.services.exceptions.EntityNotFoundException;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository repository;

	@Transactional(readOnly = true)
	public List<CategoriaDTO> findAll() {
		List<Categoria> list = repository.findAll();

		return list.stream().map(x -> new CategoriaDTO(x)).collect(Collectors.toList());

	}

	// Método FindById - Para buscar todas as categorias por Id
	@Transactional(readOnly = true)
	public CategoriaDTO findbyId(Long id) {
		Optional<Categoria> obj = repository.findById(id);
		Categoria entity = obj.orElseThrow(() -> new EntityNotFoundException("Categoria não encontrada"));
		return new CategoriaDTO(entity);
	}

	// Criando o método insert
	@Transactional
	public CategoriaDTO insert(CategoriaDTO dto) {
		Categoria entity = new Categoria();
		entity.setNome(dto.getNome());
		entity = repository.save(entity);
		return new CategoriaDTO(entity);

	}

}
