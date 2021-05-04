package com.pmdf.dscatalog.dto;

import java.io.Serializable;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.pmdf.dscatalog.entities.Categoria;
import com.pmdf.dscatalog.entities.Produto;

public class ProdutoDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	private String nome;
	private String descricao;
	private Double preco;
	private String imgUrl;
	private Instant date;

	// Criando a lista de categorias
	private List<CategoriaDTO> categorias = new ArrayList<>();
	

	// Construtor vazio
	public ProdutoDTO() {

	}

	// Construtor com argumentos
	public ProdutoDTO(Long id, String nome, String descricao, double preco, String imgUrl, Instant date) {
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
		this.preco = preco;
		this.imgUrl = imgUrl;
		this.date = date;
	}

	// Construtor recebendo a Entidade
	public ProdutoDTO(Produto entity) {
		this.id = entity.getId();
		this.nome = entity.getNome();
		this.descricao = entity.getDescricao();
		this.preco = entity.getPreco();
		this.imgUrl = entity.getImgUrl();
		this.date = entity.getDate();
	}
	
	

	// Construtor recebendo as categorias para instanciar o DTO que receberá a
	// entidade do construtor acima (essa é a nossa sobrecarga)
	public ProdutoDTO(Produto entity, Set<Categoria> categorias) {
		this(entity); // Está chamando a execução do entity do construtor criado acima...
		categorias.forEach(cat -> this.categorias.add(new CategoriaDTO(cat)));
		
	}
	



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	public Instant getDate() {
		return date;
	}

	public void setDate(Instant date) {
		this.date = date;
	}

	public List<CategoriaDTO> getCategorias() {
		return categorias;
	}

	public void setCategorias(List<CategoriaDTO> categorias) {
		this.categorias = categorias;
	}

	
	
	

}
