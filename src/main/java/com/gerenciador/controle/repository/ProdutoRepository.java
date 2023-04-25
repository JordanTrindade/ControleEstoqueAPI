package com.gerenciador.controle.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gerenciador.controle.model.Produto;


@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long>{	
}
