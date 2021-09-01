package br.com.alura.lojajpa.testes;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.alura.lojajpa.dao.CategoriaDao;
import br.com.alura.lojajpa.dao.ProdutoDao;
import br.com.alura.lojajpa.modelo.Categoria;
import br.com.alura.lojajpa.modelo.Produto;
import br.com.alura.lojajpa.util.JPAUtil;

public class CadastroDeProduto {
	
	public static void main(String[] args) {
		cadastrarProduto();
		
		EntityManager em = JPAUtil.getEntityManager();
		ProdutoDao produtoDao = new ProdutoDao(em);
		
		Produto produto = produtoDao.buscarPorId(1l);
		System.out.println(produto.getPreco());
		
		List<Produto> todosProdutos = produtoDao.buscarTodos();
		todosProdutos.forEach(prod -> System.out.println(prod.getNome()));
		
		List<Produto> prodsPorNome = 
				produtoDao.buscarPorNome("Xiaomi Redmi");
		prodsPorNome.forEach(
				prod -> System.out.println(prod.getNome()));
		
		
		List<Produto> prodsPorNomeCategoria = 
				produtoDao.buscarPorNomeCategoria("CELULARES");
		prodsPorNomeCategoria.forEach(
				prod -> System.out.println(prod.getNome()));
		
		BigDecimal precoDoProduto = 
				produtoDao.buscarPrecoDoProdutoComNome("Xiaomi Redmi");
		
		System.out.println("Preço do produto: " + precoDoProduto);
	
		
	}

	private static void cadastrarProduto() {
		Categoria celulares = new Categoria("CELULARES");
		Produto celular = new Produto("Xiaomi Redmi", "Muito legal", new BigDecimal("800"), celulares );
		
		EntityManager em = JPAUtil.getEntityManager();
		ProdutoDao produtoDao = new ProdutoDao(em);
		CategoriaDao categoriaDao = new CategoriaDao(em);
		
		em.getTransaction().begin();
		
		categoriaDao.cadastrar(celulares);
		produtoDao.cadastrar(celular);
		
		em.getTransaction().commit();
		em.close();
	}

}
