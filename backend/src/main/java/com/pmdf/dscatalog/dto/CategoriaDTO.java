package com.pmdf.dscatalog.dto;

import java.io.Serializable;

import com.pmdf.dscatalog.entities.Categoria;

public class CategoriaDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	
	private Long id;
	private String nome;
	
	public CategoriaDTO() {
		
	}

	public CategoriaDTO(Long id, String nome) {
		this.id = id;
		this.nome = nome;
	}
	
	// Construtor que recebe a entidade - Dessa forma, já podemos ter um construtor que vai 
	//povoar o CategoriaDTO simplesmente com o fato de passarmos a entidade como argumento
	public CategoriaDTO(Categoria entity) {
		this.id = entity.getId();
		this.nome = entity.getNome();
		
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
	
	
	

}
