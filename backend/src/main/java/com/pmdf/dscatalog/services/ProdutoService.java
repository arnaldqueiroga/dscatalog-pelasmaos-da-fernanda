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
import com.pmdf.dscatalog.dto.ProdutoDTO;
import com.pmdf.dscatalog.entities.Categoria;
import com.pmdf.dscatalog.entities.Produto;
import com.pmdf.dscatalog.repositories.CategoriaRepository;
import com.pmdf.dscatalog.repositories.ProdutoRepository;
import com.pmdf.dscatalog.services.exceptions.DatabaseException;
import com.pmdf.dscatalog.services.exceptions.ResourceNotFoundException;

@Service
public class ProdutoService {

	@Autowired
	private ProdutoRepository repository;

	@Autowired
	private CategoriaRepository categoriaRepository;

	@Transactional(readOnly = true)
	public List<ProdutoDTO> findAll() {
		List<Produto> list = repository.findAll();

		return list.stream().map(x -> new ProdutoDTO(x)).collect(Collectors.toList());

	}

	// Método FindById - Para buscar as categorias por Id
	@Transactional(readOnly = true)
	public ProdutoDTO findbyId(Long id) {
		Optional<Produto> obj = repository.findById(id);
		Produto entity = obj.orElseThrow(() -> new ResourceNotFoundException("Produto não encontrado"));
		return new ProdutoDTO(entity, entity.getCategorias());
	}

	// Criando o método insert
	@Transactional
	public ProdutoDTO insert(ProdutoDTO dto) {
		Produto entity = new Produto();
		copyDtoToEntity(dto, entity);
		entity = repository.save(entity);
		return new ProdutoDTO(entity);

	}

	// Criando o método update
	@Transactional
	public ProdutoDTO update(Long id, ProdutoDTO dto) {
		try {
			Produto entity = repository.getOne(id);
			copyDtoToEntity(dto, entity);
			entity = repository.save(entity);
			return new ProdutoDTO(entity);
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

	// Método auxiliar copyDtoToEntity
	private void copyDtoToEntity(ProdutoDTO dto, Produto entity) {
		entity.setNome(dto.getNome());
		entity.setDescricao(dto.getDescricao());
		entity.setDate(dto.getDate());
		entity.setImgUrl(dto.getImgUrl());
		entity.setPreco(dto.getPreco());

		// Carregando os pedidos no dto para a entidade
		entity.getCategorias().clear(); // para limpar as categorias
		for (CategoriaDTO catDto : dto.getCategorias()) {
			Categoria categoria = categoriaRepository.getOne(catDto.getId());
			entity.getCategorias().add(categoria);

		}

	}

}
