package com.curso.jsf.enums;

public enum TipoEmpresa {

	MEI(1, "Microempreendedor Individual"),
	EIRELI(2, "Empresa Individual de Responsabilidade Limitada"),
	LTDA(3, "Sociedade Limitada"),
	SA(4, "Sociedade Anônima");

	private Integer code;
	private String descricao;

	TipoEmpresa(Integer code, String descricao) {
		this.code = code;
		this.descricao = descricao;
	}

	public Integer getCode() {
		return code;
	}

	public String getDescricao() {
		return descricao;
	}

}
