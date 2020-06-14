package com.avivamento.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.avivamento.model.Visitantes;

public interface VisitantesRepository extends JpaRepository<Visitantes, Long> {
	
	Page<Visitantes> findById(String id, Pageable paginacao);
	Page<Visitantes> findByNome(String nome, Pageable paginacao);
	Page<Visitantes> findByEmail(String email, Pageable paginacao);

}
