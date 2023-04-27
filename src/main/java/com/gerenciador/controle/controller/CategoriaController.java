package com.gerenciador.controle.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.gerenciador.controle.model.Categoria;
import com.gerenciador.controle.service.CategoriaService;

@RestController
@RequestMapping("/categoria")
public class CategoriaController {
	
	@Autowired
	CategoriaService categoriaService;
	
	@GetMapping
	public ResponseEntity<?> buscaTodasCategorias(){		
		try {
			List<Categoria> categorias = categoriaService.buscaTodasCategorias();
			return ResponseEntity.ok(categorias);
		} catch (Exception e) {
			System.out.println("Sem categoria : " + ResponseEntity.notFound() );
			return ResponseEntity.noContent().build();
		}
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> buscaCategoriaPorId(Long id){
		try {
			Categoria categoria = categoriaService.buscaCategoriaPorId(id);
			return ResponseEntity.ok(categoria);
		} catch (Exception e) {
			System.out.println("Sem categoria : " );
			return ResponseEntity.notFound().build();
		}
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public void salvaCategoria(@RequestBody Categoria categoria){
		try {
			categoria.setDataCriacao(LocalDateTime.now());
			categoriaService.salvaCategoria(categoria);
		} catch (Exception e) {
		 throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
		}
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deletaCategoria(@RequestBody Long id) {
		
		try {
			categoriaService.deletaCategoria(id);
		} catch (Exception e) {
		 throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
		}
	}
	
	
}
