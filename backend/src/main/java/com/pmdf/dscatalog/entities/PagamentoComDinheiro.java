package com.pmdf.dscatalog.entities;

import java.time.Instant;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.pmdf.dscatalog.repositories.enums.EstadoPagamento;


//Incluindo a anotation do PJA
@Entity
@Table(name = "tb_pagamento_dinheiro") // anotation para definir o nome da tabela
public class PagamentoComDinheiro extends  Pagamento {
	private static final long serialVersionUID = 1L;
	
	private Instant dataPagamento;
	
	public PagamentoComDinheiro() {
		
	}

	public PagamentoComDinheiro(Long id, EstadoPagamento estado, Pedido pedido, Instant dataPagamento) {
		super(id, estado, pedido);
		this.dataPagamento = dataPagamento;
	}

	public Instant getDataPagamento() {
		return dataPagamento;
	}

	public void setDataPagamento(Instant dataPagamento) {
		this.dataPagamento = dataPagamento;
	}
	
	
	
	
	

}
