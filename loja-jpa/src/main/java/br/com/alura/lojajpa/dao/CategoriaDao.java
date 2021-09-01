package br.com.alura.lojajpa.dao;

import javax.persistence.EntityManager;

import br.com.alura.lojajpa.modelo.Categoria;

public class CategoriaDao {
	
	private EntityManager em;

	public CategoriaDao(EntityManager em) {
		this.em = em;
	}
	
	public void cadastrar(Categoria categoria) {
		this.em.persist(categoria);
	}
	
	public void atualizar(Categoria categoria) {
		this.em.merge(categoria);
	}
	

	public void remover(Categoria categoria) {
		categoria = em.merge(categoria); 
		// precisa reatribuir pq a entidade que retorna é que se trasformou 
		// em managed
		// A anterior ainda continua detached
		
		this.em.remove(categoria);
	}
}







