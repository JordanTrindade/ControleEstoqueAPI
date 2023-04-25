package com.gerenciador.controle.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.gerenciador.controle.model.Produto;
import com.gerenciador.controle.service.ProdutoService;

@RestController
@RequestMapping("/produto")
public class ProdutoController {
	
	@Autowired
	private ProdutoService produtoService;
	
	@GetMapping
	public ResponseEntity<?> ListarProdutos(){
		List<Produto> produtos = produtoService.BuscaTodosProdutos();
		if(CollectionUtils.isEmpty(produtos)) {
			return ResponseEntity.notFound().build();		
		}else {			
			return ResponseEntity.ok(produtos);
		}
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?>buscaProduto(@PathVariable Long id){
		Produto produto = produtoService.buscaProduto(id);
		if(produto != null) {
			return ResponseEntity.ok(produto);
		}else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public void SalvaProduto(@RequestBody Produto produto) {
		try {
			produtoService.salvaProduto(produto);
		}catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
		}
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void DeletarProduto(@PathVariable Long id) {
		try {
			produtoService.deletaProdutoPorId(id);
		} catch (Exception e) {
			// TODO: handle exception
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
		}
	}
}
