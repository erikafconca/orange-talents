package com.orange.talents.abertura.conta.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.orange.talents.abertura.conta.model.Pessoa;
import com.orange.talents.abertura.conta.service.PessoaService;

@RestController
@RequestMapping("/pessoas")
public class PessoaController {

	@Autowired
	private PessoaService pessoaService;

	@GetMapping
	public ResponseEntity<List<Pessoa>>  BuscarTodos() {
		return ResponseEntity.ok(pessoaService.buscarTodos());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Optional<Pessoa>> BuscarPeloId(@PathVariable Long id) {
		Optional<Pessoa> pessoa = pessoaService.buscarPeloId(id);
		return pessoa.isPresent() ? ResponseEntity.ok(pessoa) : ResponseEntity.notFound().build();
				
	}

	@PostMapping
	public ResponseEntity<Pessoa> Criar(@RequestBody Pessoa pessoa) {
		try {
			return ResponseEntity.ok(pessoaService.criar(pessoa));
		} catch (Exception e) {
			var headers = new HttpHeaders();
	        headers.add("message", e.getMessage());
			return ResponseEntity.badRequest().headers(headers).body(null);
		}
	}

	@DeleteMapping("/{id}")
	public void deletar(@PathVariable Long id) {
		pessoaService.delete(id);
	}

}
