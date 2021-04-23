package com.pmdf.dscatalog.entities;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

// construindo classe de associação ItemPedido
// E o que a identifica, é a classe produto e pedido. Pois ela não possui um Id
// para isso foi criada uma chave composta. Daí originou-se a ideia de criar uma outra classe, chamada ItemPedidoPK

//Incluindo a anotation do PJA
@Entity
@Table(name = "tb_item_pedido") // anotation para definir o nome da tabela
public class ItemPedido  implements Serializable {
	private static final long serialVersionUID = 1L;
	
	// essa classe vai ter como Id, um objeto do tipo ItemPedidoPK já instanciado. 
	// Esse Id é do tipo composto
	@EmbeddedId // notação pra dizer que este é um Id embutido em um tiop auxiliar
	private ItemPedidoPK id = new ItemPedidoPK();
	
	private Integer quantidade;
	private Double preco;
	
	public ItemPedido() {
		
	}
	
	// para atribuir o pedido e o produto dentro de Id
	public ItemPedido(Pedido pedido, Produto produto, Integer quantidade, Double preco) {
		super();
		// para atribuir o pedido e o produto dentro de Id
		id.setPedido(pedido);
		// para atribuir o pedido e o produto dentro de Id
		id.setProduto(produto);
		this.quantidade = quantidade;
		this.preco = preco;
	}
	
	// para ter acesso ao pedido fora da classe	ItemPedido, pois isso faz mais sentido do que ter que acessar
	// primeiro o Id, e depois dentro do Id acessar o produto e o pedido
	public Pedido getPedido() {
		return id.getPedido();

	}
	
	// para ter acesso ao produto fora da classe	ItemPedido
	public Produto getProduto() {
		return id.getProduto();

	}

	public ItemPedidoPK getId() {
		return id;
	}

	public void setId(ItemPedidoPK id) {
		this.id = id;
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
		ItemPedido other = (ItemPedido) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	
	

}
