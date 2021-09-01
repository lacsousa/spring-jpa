package br.com.alura.lojajpa.dao;

import javax.persistence.EntityManager;

import br.com.alura.lojajpa.modelo.Produto;

public class ProdutoDao {
	
	private EntityManager em;

	public ProdutoDao(EntityManager em) {
		this.em = em;
	}
	
	public void cadastrar(Produto produto) {
		this.em.persist(produto);
	}

}
