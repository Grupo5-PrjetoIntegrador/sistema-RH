package com.grupo5.sistemarh.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.grupo5.sistemarh.model.Setor;

public interface SetorRepository extends JpaRepository<Setor, Long> {

	public List<Setor> findAllByNomeSetorContainingIgnoreCase(@Param("nomeSetor") String nomeSetor);

}
