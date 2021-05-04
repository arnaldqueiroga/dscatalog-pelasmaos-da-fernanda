package com.pmdf.dscatalog.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.pmdf.dscatalog.repositories.enums.EstadoPagamento;

//Incluindo a anotation do PJA
@Entity
@Table(name = "tb_pagamento") // anotation para definir o nome da tabela
@Inheritance(strategy=InheritanceType.JOINED) // para mapear herança passando qual a estratégia para gerar tabela no banco
public abstract class Pagamento implements Serializable {  // abstrata para garantir que não consiga instanciar objetos do tipo pagamento
	private static final long serialVersionUID = 1L;
	
	
	@Id
	private Long id;
	private Integer estado;
	
	
	@JsonIgnore
	// notação pra concilicar o mesmo id para pagamento e pedido
	@OneToOne
	@JoinColumn(name="pedido_id") // coluna correspondente ao Id do Pedido
	// pra garantir que o id do do pagamento seja o mesmo do pedido
	@MapsId
	private Pedido pedido;
	
	public Pagamento() {
		
	}

	public Pagamento(Long id, EstadoPagamento estado, Pedido pedido) {
		super();
		this.id = id;
		this.estado = estado.getCod();
		this.pedido = pedido;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public EstadoPagamento getEstado() {
		return EstadoPagamento.toEnum(estado);
	}
	
	public void setEstado(EstadoPagamento estado) {
		// pra armazenar o número inteiro lá no banco
		this.estado = estado.getCod();
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
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
		Pagamento other = (Pagamento) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	
	
	
	
	

}
