package com.gerenciador.controle.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gerenciador.controle.model.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long>{

}
