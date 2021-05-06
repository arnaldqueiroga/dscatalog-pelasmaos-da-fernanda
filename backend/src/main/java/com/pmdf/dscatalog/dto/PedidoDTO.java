package com.pmdf.dscatalog.dto;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.pmdf.dscatalog.entities.Cliente;
import com.pmdf.dscatalog.entities.ItemPedido;
import com.pmdf.dscatalog.entities.Pagamento;
import com.pmdf.dscatalog.entities.Pedido;

public class PedidoDTO {
	
	private Long id;
	private Instant date;
	private Pagamento pagamento;
	private Cliente cliente;
	
	// Não esquecer de colocar a lista de ItemPedido
	private List<ItemPedidoDTO> itens = new ArrayList<>();
	

	// Construtor vazio
	public PedidoDTO() {
		
	}
	
	// Construtor com argumentos
	public PedidoDTO(Long id, Instant date, Pagamento pagamento, Cliente cliente) {
		super();
		this.id = id;
		this.date = date;
		this.pagamento = pagamento;
		this.cliente = cliente;
	}
	
	// Construtor recebendo a Entidade
	public PedidoDTO(Pedido entity) {
		
		this.id = entity.getId();
		this.date = entity.getDate();
		this.pagamento = entity.getPagamento();
		this.cliente = entity.getCliente();
	}
	
	// Construtor recebendo as categorias para instanciar o DTO que receberá a
	// entidade do construtor acima (essa é a nossa sobrecarga)
	public PedidoDTO(Pedido entity, Set<ItemPedido> itens) {
		//this(entity); // Está chamando a execução do entity do construtor criado acima...
		id = entity.getId();
		date = entity.getDate();
		pagamento = entity.getPagamento();
		cliente = entity.getCliente();
		itens.forEach(cat -> this.itens.add(new ItemPedidoDTO(cat)));
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
	
	public List<ItemPedidoDTO> getItens() {
		return itens;
	}

	public void setItens(List<ItemPedidoDTO> itens) {
		this.itens = itens;
	}


	
	
	

}
