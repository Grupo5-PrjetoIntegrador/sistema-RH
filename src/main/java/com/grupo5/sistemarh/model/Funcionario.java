package com.grupo5.sistemarh.model;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "tb_funcionarios")
public class Funcionario {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message = "O atributo nome é obrigatório!")
	@Size(min = 5, max = 100, message = "O atributo nome deve conter no mínimo 05 e no máximo 100 caracteres.")
	private String nome;
	
	@NotBlank(message = "O atributo cargo é obrigatório!")
	@Size(min = 4, max = 100, message = "O atributo cargo deve conter no mínimo 04 e no máximo 100 caracteres.")
	private String cargo;
	
	@NotNull(message = "O atributo idade é obrigatório!")
	private double salarioBase;
	
	@NotNull(message = "O atributo horas trabalhadas é obrigatório!")
    private double horasTrabalhadas; 

    @NotNull(message = "O atributo bonus é obrigatório!")
    private double bonus;

    @NotNull(message = "O atributo descontos é obrigatório!")
    private double descontos; 

	@NotNull(message = "O atributo com data de entrada na empresa é obrigatório!")
	private LocalDate aniversarioEmpresa;

	@ManyToOne
	@JsonIgnoreProperties("funcionario")
	private Setor setor;
	
	@ManyToOne
	@JsonIgnoreProperties("funcionario")
	private Usuario usuario;
	
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

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public double getSalarioBase() {
		return salarioBase;
	}

	public void setSalarioBase(double salarioBase) {
		this.salarioBase = salarioBase;
	}

	public double getHorasTrabalhadas() {
		return horasTrabalhadas;
	}

	public void setHorasTrabalhadas(double horasTrabalhadas) {
		this.horasTrabalhadas = horasTrabalhadas;
	}

	public double getBonus() {
		return bonus;
	}

	public void setBonus(double bonus) {
		this.bonus = bonus;
	}

	public double getDescontos() {
		return descontos;
	}

	public void setDescontos(double descontos) {
		this.descontos = descontos;
	}

	public LocalDate getAniversarioEmpresa() {
		return aniversarioEmpresa;
	}

	public void setAniversarioEmpresa(LocalDate aniversarioEmpresa) {
		this.aniversarioEmpresa = aniversarioEmpresa;
	}

	public Setor getSetor() {
		return setor;
	}

	public void setSetor(Setor setor) {
		this.setor = setor;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	
}
