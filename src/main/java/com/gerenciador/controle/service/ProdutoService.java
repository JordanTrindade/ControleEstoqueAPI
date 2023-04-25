package com.gerenciador.controle.service;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import org.hibernate.ObjectNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.gerenciador.controle.model.Produto;
import com.gerenciador.controle.repository.ProdutoRepository;

@Service
public class ProdutoService {
	
	private final ProdutoRepository produtoRepository;

    ProdutoService(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }
	
	public void salvaProduto(Produto produto) {
		produtoRepository.save(produto);
	}

	public void deletaProdutoPorId(Long id) {
		produtoRepository.deleteById(id);
	}
	
	public Produto buscaProduto(Long id) {
		Optional<Produto> produto = produtoRepository.findById(id);
		
		return produto.orElseThrow( ()-> new ObjectNotFoundException(id, "Produto não encontrado") );
	}
	
	public List<Produto> BuscaTodosProdutos() {
		List<Produto> produtos = produtoRepository.findAll();
		
		if(CollectionUtils.isEmpty(produtos)) {
			throw new ObjectNotFoundException((Serializable) produtos, "Objetos não encotrados");
		}
		return produtos;
	}
}
