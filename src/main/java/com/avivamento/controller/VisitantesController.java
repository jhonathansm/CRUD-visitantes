package com.avivamento.controller;

import java.net.URI;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.avivamento.dto.VisitantesDto;
import com.avivamento.model.Visitantes;
import com.avivamento.repository.VisitantesRepository;

@RestController
@RequestMapping("/cadastroVisitantes")
public class VisitantesController {
	
	@Autowired
	private VisitantesRepository visitantesRepository;
	
	@PostMapping
	public ResponseEntity<VisitantesDto> cadastrar(@RequestBody @Valid Visitantes visitantes, UriComponentsBuilder uriBuilder) {
		visitantesRepository.save(visitantes);
		
		URI uri = uriBuilder.path("cadastroVisitantes/{id}").buildAndExpand(visitantes.getId()).toUri();
		return ResponseEntity.created(uri).body(new VisitantesDto(visitantes));
	}
	
	@GetMapping
	public Page<VisitantesDto> listar(@RequestParam(required = false) String id, @RequestParam int pagina, @RequestParam int qtd) {
		
		Pageable paginacao = PageRequest.of(pagina, qtd);
		
		if(id == null) {
			Page<Visitantes> visitantes = visitantesRepository.findAll(paginacao);
			
			return VisitantesDto.converter(visitantes);
		} else {
			Page<Visitantes> visitantes = visitantesRepository.findById(id, paginacao);
			return VisitantesDto.converter(visitantes);

		}
	}
	
	@GetMapping("/{id}")
	@Transactional
	public ResponseEntity<VisitantesDto> listarId(@PathVariable Long id) {
		
		Optional<Visitantes> visitantes = visitantesRepository.findById(id);
		
		if(visitantes.isPresent()) {
			return ResponseEntity.ok(new VisitantesDto(visitantes.get()));
		}
		
		return ResponseEntity.notFound().build();
	}
	
	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<VisitantesDto> atualizar(@PathVariable Long id, @RequestBody @Valid VisitantesDto form){
		Optional<Visitantes> visitantes = visitantesRepository.findById(id);
		
		if(visitantes.isPresent()) {
			Visitantes visit = form.atualizar(id, visitantesRepository);
			return ResponseEntity.ok(new VisitantesDto(visit));
		}
		return ResponseEntity.notFound().build();
	}
	
	@DeleteMapping("/{id}")	
	@Transactional
	public ResponseEntity<?> deletar(@PathVariable Long id) {
		Optional<Visitantes> optional = visitantesRepository.findById(id);
		if(optional.isPresent()) {
			visitantesRepository.deleteById(id);
			return ResponseEntity.ok().build();
		}
		return ResponseEntity.notFound().build();

	}
 	
}
