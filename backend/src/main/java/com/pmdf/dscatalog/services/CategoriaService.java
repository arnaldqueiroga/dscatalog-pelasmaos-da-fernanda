package com.pmdf.dscatalog.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pmdf.dscatalog.dto.CategoriaDTO;
import com.pmdf.dscatalog.entities.Categoria;
import com.pmdf.dscatalog.repositories.CategoriaRepository;
import com.pmdf.dscatalog.services.exceptions.DatabaseException;
import com.pmdf.dscatalog.services.exceptions.ResourceNotFoundException;

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
		Categoria entity = obj.orElseThrow(() -> new ResourceNotFoundException("Categoria não encontrada"));
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

	// Criando o método update
	@Transactional
	public CategoriaDTO update(Long id, CategoriaDTO dto) {
		try {
			Categoria entity = repository.getOne(id);
			entity.setNome(dto.getNome());
			entity = repository.save(entity);
			return new CategoriaDTO(entity);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(" Id não encontrado " + id);

		}

	}

	// Criando o método Delete

	public void delete(Long id) {
		try {
			repository.deleteById(id);
		}

		catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException("Id nao encontrado " + id);
		}

		catch (DataIntegrityViolationException e) {
			throw new DatabaseException("Erro de Violação de Integridade");
		}

	}

}
