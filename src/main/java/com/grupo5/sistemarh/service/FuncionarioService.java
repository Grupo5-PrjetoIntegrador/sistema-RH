package com.grupo5.sistemarh.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grupo5.sistemarh.model.Funcionario;
import com.grupo5.sistemarh.repository.FuncionarioRepository;

@Service
public class FuncionarioService {

	@Autowired
	private FuncionarioRepository funcionarioRepository;
	
	 public double calcularSalario(Long funcionarioId) {
	        Funcionario funcionario = funcionarioRepository.findById(funcionarioId)
	                .orElseThrow(() -> new IllegalArgumentException("Funcionário não encontrado"));
	        
	        // Cálculo do salário com base nas horas trabalhadas
	        double salarioHora = funcionario.getSalarioBase() / 200;
	        double salarioCalculado = salarioHora * funcionario.getHorasTrabalhadas();

	        // Adicionando bônus
	        salarioCalculado += funcionario.getBonus();

	        // Subtraindo descontos
	        salarioCalculado -= funcionario.getDescontos();

	        return salarioCalculado;
	    }
}
