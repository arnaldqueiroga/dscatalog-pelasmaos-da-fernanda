package com.pmdf.dscatalog.dto;

import com.pmdf.dscatalog.entities.ItemPedido;
import com.pmdf.dscatalog.entities.ItemPedidoPK;

public class ItemPedidoDTO {
	
	private ItemPedidoPK id;
	private Integer quantidade;
	private Double preco;
	
	// Construtor vazio
	public ItemPedidoDTO() {
		
	}
	
	// Construtor com argumentos
	public ItemPedidoDTO(Integer quantidade, Double preco, ItemPedidoPK id ) {
		super();
		this.id = id;
		this.quantidade = quantidade;
		this.preco = preco;
	}
	
	// Construtor recebendo a Entidade
	public ItemPedidoDTO(ItemPedido entity) {
		this.id = entity.getId();
		this.quantidade = entity.getQuantidade();
		this.preco = entity.getPreco();
		
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public ItemPedidoPK getId() {
		return id;
	}

	public void setId(ItemPedidoPK id) {
		this.id = id;
	}
	
	
	
	
	

}
