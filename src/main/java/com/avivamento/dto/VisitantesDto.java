package com.avivamento.dto;

import org.springframework.data.domain.Page;

import com.avivamento.model.Visitantes;
import com.avivamento.repository.VisitantesRepository;


public class VisitantesDto {
	
	private Long id;
	private String nome;
	private String endereco;
	
	public VisitantesDto(Visitantes visitantes) {
		this.id = visitantes.getId();
		this.nome = visitantes.getNome();
		this.endereco = visitantes.getEndereco();
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
	
	public static Page<VisitantesDto> converter(Page<Visitantes> visitantes) {
		return visitantes.map(VisitantesDto::new);
	}
	
	
	/** Verificar este metodo, pois pode ser criado uma classe a parte para atualizar mais dados importantes **/
	public Visitantes atualizar(Long id, VisitantesRepository visitantesRepository) {
		Visitantes visitantes = visitantesRepository.getOne(id);
		visitantes.setNome(this.nome);
		visitantes.setEndereco(this.endereco);
		return visitantes;
		
	}
}
