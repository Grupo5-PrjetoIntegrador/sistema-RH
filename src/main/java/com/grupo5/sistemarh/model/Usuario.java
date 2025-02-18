package com.grupo5.sistemarh.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table (name = "tb_usuarios")
@JsonIgnoreProperties(value={"id"})
public class Usuario {

		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long id;

		@NotNull(message = "O nome é obrigatório!")
		private String nome;
		
		@Schema(example = "email@email.com.br")
		@NotNull(message = "O email de usuário é obrigatório!")
		@Email(message = "Por favor, insira um email válido!")
		private String usuario;

		@NotBlank(message = "Uma senha de acesso deve ser inserida!")
		@Size(min = 8, message = "A senha deve ter no mínimo 8 caracteres")
		private String senha;

		@Size(max = 5000, message = "O link da foto não pode ser maior do que 5000 caracteres")
		private String foto;

		@OneToMany(fetch = FetchType.LAZY, mappedBy = "usuario", cascade = CascadeType.REMOVE)
		@JsonIgnoreProperties("usuario")
		private List<Funcionario> funcionario;

		public Long getId() {
			return this.id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getNome() {
			return this.nome;
		}

		public void setNome(String nome) {
			this.nome = nome;
		}

		public String getUsuario() {
			return this.usuario;
		}

		public void setUsuario(String usuario) {
			this.usuario = usuario;
		}

		public String getSenha() {
			return this.senha;
		}

		public void setSenha(String senha) {
			this.senha = senha;
		}

		public String getFoto() {
			return this.foto;
		}

		public void setFoto(String foto) {
			this.foto = foto;
		}

		public List<Funcionario> getFuncionario() {
			return this.funcionario;
		}

		public void setFuncionario(List<Funcionario> funcionario) {
			this.funcionario = funcionario;
		}
	
}
