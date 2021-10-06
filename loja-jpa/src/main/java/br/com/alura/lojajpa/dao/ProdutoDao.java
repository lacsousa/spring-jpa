package br.com.alura.lojajpa.dao;

import java.math.BigDecimal;
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
	
	// Passando parâmetros
	public List<Produto> buscarPorNome(String nome) {
        String jpql = "SELECT p FROM Produto p WHERE p.nome = :nome";
        return em.createQuery(jpql, Produto.class)
                .setParameter("nome", nome)
                        .getResultList();
	}
	
	// navegando pelos objetos e relacionamentos
	public List<Produto> buscarPorNomeCategoria(String nomeCat) {
       
        return em.createNamedQuery("Produto.produtosPorCategoria", 
        		Produto.class)
                .setParameter("nome", nomeCat)
                        .getResultList();
	}
	
	//retornando apenas um atributo
	public BigDecimal buscarPrecoDoProdutoComNome(String nome) {
        String jpql = "SELECT p.preco FROM Produto p WHERE p.nome = :nome";
        return em.createQuery(jpql, BigDecimal.class)
                .setParameter("nome", nome)
                        .getSingleResult();
	}
	
}
