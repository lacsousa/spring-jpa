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

}







