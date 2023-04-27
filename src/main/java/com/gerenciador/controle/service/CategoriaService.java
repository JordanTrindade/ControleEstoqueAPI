package com.gerenciador.controle.service;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.gerenciador.controle.model.Categoria;
import com.gerenciador.controle.repository.CategoriaRepository;

@Service
public class CategoriaService {
	
	@Autowired
	CategoriaRepository categoriaRepository;
	
	public List<Categoria> buscaTodasCategorias(){
		List<Categoria> categorias = categoriaRepository.findAll();
		
		if(CollectionUtils.isEmpty(categorias)) {
			throw new ObjectNotFoundException((Serializable) categorias,"Categorias não encontradas");
		}else {
			return categorias;
		}
	}
	
	public Categoria buscaCategoriaPorId(Long id) {
		Optional<Categoria> categoria = categoriaRepository.findById(id);
	
		return categoria.orElseThrow( ()-> new ObjectNotFoundException(id, "Produto não encontrado") );
	}
	
	public void salvaCategoria(Categoria categoria) {
		try {
			categoriaRepository.save(categoria);
		} catch (Exception e) {
			e.getMessage();
		}
	}
	
	public void deletaCategoria(Long id) {
		try {
			categoriaRepository.deleteById(id);
		}catch (Exception e) {
			System.out.println("Não foi possivel deletar");
			e.getMessage();
		}
	}
}
