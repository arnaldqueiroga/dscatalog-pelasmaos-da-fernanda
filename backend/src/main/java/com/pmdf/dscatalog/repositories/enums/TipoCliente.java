package com.pmdf.dscatalog.repositories.enums;

public enum TipoCliente {
	PESSOAFISICA(1, "Pessoa Física"), PESSOAJURIDICA(2, "Pessoa Jurídica");

	// criando construtor pra atribuir os valores para o tipo enumerado

	private int cod;
	private String descricao;

	private TipoCliente(int cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;
	}

	public int getCod() {
		return cod;
	}

	public String getDescricao() {
		return descricao;
	}
	
	// Operação para receber um cógdigo e retorna um objeto do tipo Cliente já instanciado
	
	// método estático para rodarmos o objeto mesmo sem ele estar estanciado
	public static TipoCliente toEnum(Integer cod) {
		if (cod == null) {
			return null;
		}
		
		for (TipoCliente x : TipoCliente.values()) {
			if(cod.equals(x.getCod())) {
				return x;
			}
		}
		
		throw new IllegalArgumentException("Id inválido: " + cod);
		
		
	}

}
