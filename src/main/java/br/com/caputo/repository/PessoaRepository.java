package br.com.caputo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.caputo.model.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {

}
