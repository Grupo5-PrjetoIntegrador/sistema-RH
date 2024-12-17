package com.grupo5.sistemarh.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.grupo5.sistemarh.model.Usuario;

public interface UsuarioRepository extends JpaRepository <Usuario, Long>{

	Optional<Usuario> findByUsuario(String usuario);

}
