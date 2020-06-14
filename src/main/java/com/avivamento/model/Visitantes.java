package com.avivamento.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

import com.sun.istack.NotNull;

@Entity
public class Visitantes {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotNull @NotEmpty
	private String nome;
	@NotNull @NotEmpty
	private String endereco;
	@NotNull @NotEmpty
	private Integer numero;
	@NotNull @NotEmpty
	private String bairro;
	@NotNull @NotEmpty
	private String cidade;
	@NotNull @NotEmpty
	private String estado;
	@NotNull @NotEmpty
	private Integer cep;
	@NotNull @NotEmpty
	private Date dataNascimento;
	private String telefone;
	private String email;
	@Enumerated(EnumType.STRING)
	private StatusCivil estadoCivil = StatusCivil.NAO_INFORMADO;
	private String conheceuIgreja;
	private String visita;
	private String oracao;
	
	
	public Visitantes() {
	}
	
	public Visitantes(String nome, String endereco, Integer numero, String bairro,
			String cidade, String estado, Integer cep, Date dataNascimento, String telefone, 
			String email, StatusCivil estadocivil, String conheceuIgreja, String visita, String oracao) {
	
		this.nome = nome;
		this.endereco = endereco;
		this.numero = numero;
		this.bairro = bairro;
		this.cidade = cidade;
		this.estado = estado;
		this.cep = cep;
		this.dataNascimento = dataNascimento;
		this.telefone = telefone;
		this.email = email;
		this.estadoCivil = estadocivil;
		this.conheceuIgreja = conheceuIgreja;
		this.visita = visita;
		this.oracao = oracao;
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

	public Integer getCep() {
		return cep;
	}

	public void setCep(Integer cep) {
		this.cep = cep;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
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

	public StatusCivil getEstadoCivil() {
		return estadoCivil;
	}

	public void setEstadoCivil(StatusCivil estadoCivil) {
		this.estadoCivil = estadoCivil;
	}

	public String getConheceuIgreja() {
		return conheceuIgreja;
	}

	public void setConheceuIgreja(String conheceuIgreja) {
		this.conheceuIgreja = conheceuIgreja;
	}

	public String getVisita() {
		return visita;
	}

	public void setVisita(String visita) {
		this.visita = visita;
	}

	public String getOracao() {
		return oracao;
	}

	public void setOracao(String oracao) {
		this.oracao = oracao;
	}
		
}
