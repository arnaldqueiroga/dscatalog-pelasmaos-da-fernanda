package com.pmdf.dscatalog.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.pmdf.dscatalog.entities.Cliente;
import com.pmdf.dscatalog.entities.Pedido;

public class ClienteDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	private String nome;
	private String endereco;
	private String telefone;
	private String email;
	private String cpf;

	// Criando a lista de categorias
	private List<PedidoDTO> pedidos = new ArrayList<>();

	public ClienteDTO() {

	}

	// Construtor com argumentos
	public ClienteDTO(Long id, String nome, String endereco, String telefone, String email, String cpf) {
		this.id = id;
		this.nome = nome;
		this.endereco = endereco;
		this.telefone = telefone;
		this.email = email;
		this.cpf = cpf;

	}

	// Construtor recebendo a Entidade
	public ClienteDTO(Cliente entity) {
		this.id = entity.getId();
		this.nome = entity.getNome();
		this.endereco = entity.getEndereco();
		this.telefone = entity.getTelefone();
		this.email = entity.getEmail();
		this.cpf = entity.getCpf();

	}

	// Construtor recebendo as pedidos para instanciar o DTO que receberá a
	// entidade do construtor acima (essa é a nossa sobrecarga)
	public ClienteDTO(Cliente entity, Set<Pedido> pedidos) {
		this(entity);
		pedidos.forEach(ped -> this.pedidos.add(new PedidoDTO(ped)));
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpfOuCnpj(String cpf) {
		this.cpf = cpf;
	}

	public List<PedidoDTO> getPedidos() {
		return pedidos;
	}

	public void setPedidos(List<PedidoDTO> pedidos) {
		this.pedidos = pedidos;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

}
