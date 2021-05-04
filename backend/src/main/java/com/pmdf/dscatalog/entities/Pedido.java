package com.pmdf.dscatalog.entities;

import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;


//Incluindo a anotation do PJA
@Entity
@Table(name = "tb_pedido") // anotation para definir o nome da tabela
public class Pedido implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private Long id;
	
	@Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
	private Instant date;
	
	
	// mapeando o pagamento
	@OneToOne(cascade=CascadeType.ALL, mappedBy="pedido") // para não dar erro de entidade transiente quando for salvar um pedido e o pagamento dele
	private Pagamento pagamento;
	
	// mapeando pedido com cliente
	@ManyToOne
	@JoinColumn(name="cliente_id") // chave estrangeira
	private Cliente cliente;
	
	// o pedido conhece os itens dos pedidos associados a ele
	@OneToMany(mappedBy="id.pedido") // Pq do outro lado eu tenho o itempedido que tem o objeto id, e o id é é um objeto auxiliar que vai ter referencia pro pedido
    Set<ItemPedido> itens = new HashSet<>();
	
	
	public Pedido() {
		
	}


	public Pedido(Long id, Instant date,  Cliente cliente) {
		super();
		this.id = id;
		this.date = date;
		this.cliente = cliente;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public Instant getDate() {
		return date;
	}


	public void setDate(Instant date) {
		this.date = date;
	}


	public Pagamento getPagamento() {
		return pagamento;
	}


	public void setPagamento(Pagamento pagamento) {
		this.pagamento = pagamento;
	}


	public Cliente getCliente() {
		return cliente;
	}


	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
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
		Pedido other = (Pedido) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}


	
	
	

}
