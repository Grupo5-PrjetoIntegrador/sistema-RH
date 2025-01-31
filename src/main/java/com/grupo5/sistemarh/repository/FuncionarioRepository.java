package com.grupo5.sistemarh.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.grupo5.sistemarh.model.Funcionario;

@Repository
public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {

	public List <Funcionario> findAllByNomeContainingIgnoreCase(@Param("nome") String nome);
}
