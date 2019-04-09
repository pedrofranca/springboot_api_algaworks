package br.com.caputo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.caputo.model.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

}
