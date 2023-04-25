package com.gerenciador.controle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.gerenciador.controle.model.Produto;
import com.gerenciador.controle.repository.ProdutoRepository;

@SpringBootApplication
public class ControleApplication implements CommandLineRunner{


	@Autowired
	ProdutoRepository produtoRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(ControleApplication.class, args);
	}

	
	@Override
	public void run(String... args) throws Exception {
		
//		Adicionando produtos no banco
		Produto p1 = new Produto("Computador", "", 2000.00, 3);
		Produto p2 = new Produto("Impressora","",800.00,4);
		Produto p3 = new Produto("Mouse","",20.00,2);
		
		
		
		produtoRepository.save(p1);
		produtoRepository.save(p2);
		produtoRepository.save(p3);
		
		
	}
}
