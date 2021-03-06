package com.pmdf.dscatalog.entities;

import java.io.Serializable;
import java.time.Instant;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

//Incluindo a anotation do PJA
@Entity
@Table(name = "tb_produto") // anotation para definir o nome da tabela
public class Produto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	
	//mapear no BD como text, e não como varchar	
	@Column(columnDefinition = "TEXT")
	private String descricao;
	private Double preco;
	private String imgUrl;

	// Instrui o banco de dados a armazenar a data em UTC
	@Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
	private Instant date;

	// Mapeamento da criação da tabela de associação entre Produto e Categoria	
	@ManyToMany
	@JoinTable(name = "tb_produto_categoria", 
		joinColumns = @JoinColumn(name = "produto_id"),
		inverseJoinColumns  = @JoinColumn(name = "categoria_id"))	
	Set<Categoria> categorias = new HashSet<>();
	
	
	//@JsonIgnore// mandar igonar a lista de itens associados ao produto
	// o produto conhece os itens dos pedidos associados a ele
	@OneToMany(mappedBy="id.produto") // mapeado por id.produto com base ao que já foi feito na classe pedido
	private Set<ItemPedido> itens = new HashSet<>();

	public Produto() {

	}

	public Produto(Long id, String nome, String descricao, Double preco, String imgUrl, Instant date) {
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
		this.preco = preco;
		this.imgUrl = imgUrl;
		this.date = date;
	}
	

	
	// Um produto conhece os pedidos dele, dessa forma, é necessário ter um GetPedidos varrendo os itens de pedido
	// montar uma lista de pedidos associados aos itens
	@JsonIgnore
	public List<Pedido> getPedidos(){
		// iniciando lista de pedidos
		List<Pedido> lista = new ArrayList<>();
		// percorrendo a lista de itens já existente aqui na classe
		for (ItemPedido x : itens ) {
			lista.add(x.getPedido());
		}
		return lista;
		
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

	public Set<Categoria> getCategorias() {
		return categorias;
	}
	
	public Set<ItemPedido> getItens() {
		return itens;
	}

	public void setItens(Set<ItemPedido> itens) {
		this.itens = itens;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Produto other = (Produto) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	



}
