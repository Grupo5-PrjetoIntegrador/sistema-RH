package com.grupo5.sistemarh.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.grupo5.sistemarh.model.Setor;

@Repository
public interface SetorRepository extends JpaRepository<Setor, Long> {

	public List<Setor> findAllByNomeSetorContainingIgnoreCase(@Param("nomeSetor") String nomeSetor);

}
