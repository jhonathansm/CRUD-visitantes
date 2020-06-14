package com.avivamento.dto.form;

import javax.validation.constraints.NotEmpty;

import com.avivamento.model.Visitantes;
import com.avivamento.repository.VisitantesRepository;
import com.sun.istack.NotNull;

public class VisitantesForm {
	
	@NotNull @NotEmpty
	private String endereco;
	@NotNull @NotEmpty
	private Integer numero;
	@NotNull @NotEmpty
	private String bairro;
	@NotNull @NotEmpty
	private Integer cep;
	@NotNull @NotEmpty
	private String telefone;
	@NotNull @NotEmpty
	private String email;
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public Integer getNumero() {
		return numero;
	}
	public void setNumero(Integer numero) {
		this.numero = numero;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public Integer getCep() {
		return cep;
	}
	public void setCep(Integer cep) {
		this.cep = cep;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	
	/** Atualiza dados **/
	public Visitantes atualizar(Long id, VisitantesRepository visitantesRepository) {
		Visitantes visitantes = visitantesRepository.getOne(id);
		visitantes.setEndereco(this.endereco);
		visitantes.setNumero(this.numero);
		visitantes.setBairro(this.bairro);
		visitantes.setCep(this.cep);
		visitantes.setTelefone(this.telefone);
		visitantes.setEmail(this.email);
		return visitantes;
		
	}
	
}
