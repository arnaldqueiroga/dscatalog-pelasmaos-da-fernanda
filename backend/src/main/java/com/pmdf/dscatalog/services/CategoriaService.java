package com.pmdf.dscatalog.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pmdf.dscatalog.dto.CategoriaDTO;
import com.pmdf.dscatalog.entities.Categoria;
import com.pmdf.dscatalog.repositories.CategoriaRepository;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository repository;

	@Transactional(readOnly = true)
	public List<CategoriaDTO> findAll() {
		List<Categoria> list = repository.findAll();

		return list.stream().map(x -> new CategoriaDTO(x)).collect(Collectors.toList());

	}

}
