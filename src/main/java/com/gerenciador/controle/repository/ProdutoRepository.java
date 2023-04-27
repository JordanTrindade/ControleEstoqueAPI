package com.gerenciador.controle.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.gerenciador.controle.model.Produto;


public interface ProdutoRepository extends JpaRepository<Produto, Long>{	
}
