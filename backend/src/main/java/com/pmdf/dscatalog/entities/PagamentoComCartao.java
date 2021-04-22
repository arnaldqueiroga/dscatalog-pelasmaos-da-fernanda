package com.pmdf.dscatalog.entities;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.pmdf.dscatalog.repositories.enums.EstadoPagamento;


//Incluindo a anotation do PJA
@Entity
@Table(name = "tb_pagamento_cartao") // anotation para definir o nome da tabela
public class PagamentoComCartao extends  Pagamento{
	private static final long serialVersionUID = 1L;
	
	private Integer numeroDeParcelas;
	
	
	public PagamentoComCartao() {
		
	}


	public PagamentoComCartao(Long id, EstadoPagamento estado, Pedido pedido, Integer numeroDeParcelas) {
		super(id, estado, pedido);
		this.numeroDeParcelas = numeroDeParcelas;
	}


	public Integer getNumeroDeParcelas() {
		return numeroDeParcelas;
	}


	public void setNumeroDeParcelas(Integer numeroDeParcelas) {
		this.numeroDeParcelas = numeroDeParcelas;
	}
	
	
	
	

}
