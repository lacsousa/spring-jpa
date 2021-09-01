package br.com.alura.lojajpa.dao;

import java.util.List;

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

	public Produto buscarPorId(Long id) {
		return em.find(Produto.class, id);
	}
	
	public List<Produto> buscarTodos(){
		String jpql = "SELECT p FROM Produto p";
		return em.createQuery(jpql,
				Produto.class).getResultList();
	}
}
