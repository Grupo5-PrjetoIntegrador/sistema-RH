package com.grupo5.sistemarh.model;

import java.util.List;

// import org.hibernate.annotations.UpdateTimestamp; // Import não está sendo utilizado

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "tb_setores")
public class Setor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	// Mudança da Anotação de @NotNull para @NotBlank, pois a convenção é usar o primeiro para valores númericos e o segundo para Strings
	@NotBlank(message = "O Atributo Nome do Setor é obrigatório")
	@Size(min = 2, max = 100, message = "O Atributo Nome do Setor deve conter no mínimo 2 e no maximo 100 caracteres")
	private String nomeSetor;
	
	// Adicão da Collection Funcionário para relação de classes
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "setor", cascade = CascadeType.REMOVE)
	@JsonIgnoreProperties("setor")
	private List<Funcionario> funcionario;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNomeSetor() {
		return nomeSetor;
	}

	public void setNomeSetor(String nomeSetor) {
		this.nomeSetor = nomeSetor;
	}

	// Getter e Setter do atributo Collection funcionário
	public List<Funcionario> getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(List<Funcionario> funcionario) {
		this.funcionario = funcionario;
	}
	
	

}