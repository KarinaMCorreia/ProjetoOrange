package br.com.orange.ProjetoOrangeTalents.controller.Dto;

import br.com.orange.ProjetoOrangeTalents.model.Endereco;

public class EnderecoDto {

	private long id;

	public EnderecoDto(long id) {
		this.id = id;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public EnderecoDto(Endereco endereco) {
		this.id = endereco.getId();
	}

}
