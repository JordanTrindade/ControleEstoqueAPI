package com.gerenciador.controle.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
public class Produto implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name = "NOME", nullable = false)
	@Size(min = 1, max = 255, message = "Nome vazio ou com mais de 255 caracteres")
	@NotBlank
	private String nome;
	
	@Column(name = "DESCRICAO", nullable = true)
	@Size(min = 1, max = 255, message = "Descricao com mais de 255 caracteres")
	private String descricao;
	
	@Column(name = "PRECO")
	private Double preco;
	
	@Column(name = "QUANTIDADE")
	private Integer quantidade;
	
	//Depois voltar a categoria como nullable = false
	@ManyToOne
	@Size(min = 1, max = 255, message = "Descricao com mais de 255 caracteres")
	private Categoria categoria;

	public Produto() {
		super();
	}
	

	public Produto(
			@Size(min = 1, max = 255, message = "Nome vazio ou com mais de 255 caracteres") @NotBlank String nome,
			@Size(min = 1, max = 255, message = "Descricao com mais de 255 caracteres") String descricao, Double preco,
			Integer quantidade) {
		super();
		this.nome = nome;
		this.descricao = descricao;
		this.preco = preco;
		this.quantidade = quantidade;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	@Override
	public int hashCode() {
		return Objects.hash(categoria, descricao, id, nome, preco, quantidade);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Produto other = (Produto) obj;
		return Objects.equals(categoria, other.categoria) && Objects.equals(descricao, other.descricao)
				&& Objects.equals(id, other.id) && Objects.equals(nome, other.nome)
				&& Objects.equals(preco, other.preco) && Objects.equals(quantidade, other.quantidade);
	}

	@Override
	public String toString() {
		return "Produto [id=" + id + ", nome=" + nome + ", descricao=" + descricao + ", categoria=" + categoria
				+ ", preco=" + preco + ", quantidade=" + quantidade + "]";
	}
	
	
}
