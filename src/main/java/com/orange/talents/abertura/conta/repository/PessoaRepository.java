package com.orange.talents.abertura.conta.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.orange.talents.abertura.conta.model.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Long>{

}
