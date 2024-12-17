package com.grupo5.sistemarh.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.grupo5.sistemarh.model.Funcionario;
import com.grupo5.sistemarh.repository.FuncionarioRepository;
import com.grupo5.sistemarh.repository.SetorRepository;
import com.grupo5.sistemarh.service.FuncionarioService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/funcionarios")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class FuncionarioController {

	@Autowired
	private FuncionarioRepository funcionarioRepository;
	
	@Autowired
	private SetorRepository setorRepository;
	
    @Autowired
    private FuncionarioService funcionarioService; 
	
 // Foram adicionados caminhos específicos a todos os métodos para fins de padronização de todo o projeto
	@GetMapping("/all")
	public ResponseEntity<List<Funcionario>> getAll(){
		return ResponseEntity.ok(funcionarioRepository.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Funcionario>getById(@PathVariable Long id){
		return funcionarioRepository.findById(id)
				.map(resposta -> ResponseEntity.ok(resposta))
				.orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
	}
	
	@GetMapping("/nome/{nome}")
	public ResponseEntity<List<Funcionario>> getByNome(@PathVariable String nome){
		return ResponseEntity.ok(funcionarioRepository.findAllByNomeContainingIgnoreCase(nome));
	}
	
	@PostMapping("/cadastrar")
	public ResponseEntity<Funcionario> post(@Valid @RequestBody Funcionario funcionario){
		if(setorRepository.existsById(funcionario.getSetor().getId()))
			return ResponseEntity.status(HttpStatus.CREATED)
				.body(funcionarioRepository.save(funcionario));
		throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Setor não existe", null);
	}
	
	@PutMapping("/atualizar")
	public ResponseEntity<Funcionario> put(@Valid @RequestBody Funcionario funcionario){
		if(funcionarioRepository.existsById(funcionario.getId())) {
			
			if(setorRepository.existsById(funcionario.getSetor().getId()))
				return ResponseEntity.status(HttpStatus.OK)
						.body(funcionarioRepository.save(funcionario));
			
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Setor não existe", null);
		}
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		
		
	}
	
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		Optional<Funcionario> funcionario = funcionarioRepository.findById(id);
		
		if(funcionario.isEmpty())
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		
		funcionarioRepository.deleteById(id);
	}
	
    @GetMapping("/{id}/salario")
    public ResponseEntity<Double> calcularSalario(@PathVariable Long id) {
        try {
            double salario = funcionarioService.calcularSalario(id);
            return ResponseEntity.ok(salario);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
	
}
