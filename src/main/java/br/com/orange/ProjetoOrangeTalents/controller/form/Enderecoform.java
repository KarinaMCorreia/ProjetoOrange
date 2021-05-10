package br.com.orange.ProjetoOrangeTalents.controller.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import br.com.orange.ProjetoOrangeTalents.model.Endereco;
import br.com.orange.ProjetoOrangeTalents.model.Usuario;
import br.com.orange.ProjetoOrangeTalents.repository.UsuarioRepository;

public class Enderecoform {

	private long usuarioid;

	@NotNull
	@NotEmpty
	private String logradouro;

	@NotNull
	@NotEmpty
	private String numero;

	@NotNull
	@NotEmpty
	private String complemento;

	@NotNull
	@NotEmpty
	private String bairro;

	@NotNull
	@NotEmpty
	private String cidade;

	@NotNull
	@NotEmpty
	private String estado;

	@NotNull
	@NotEmpty
	private String cep;

	public long getUsuarioid() {
		return usuarioid;
	}

	public void setUsuarioid(long usuarioid) {
		this.usuarioid = usuarioid;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public Endereco converter(UsuarioRepository usuarioRepository) {
		Usuario usuario = usuarioRepository.findById(usuarioid);
		return new Endereco(usuario, logradouro, numero, complemento, bairro, cidade, estado, cep);
	}

}
