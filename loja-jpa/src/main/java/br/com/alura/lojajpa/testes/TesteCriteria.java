package br.com.alura.lojajpa.testes;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.EntityManager;

import br.com.alura.lojajpa.dao.CategoriaDao;
import br.com.alura.lojajpa.dao.ClienteDao;
import br.com.alura.lojajpa.dao.PedidoDao;
import br.com.alura.lojajpa.dao.ProdutoDao;
import br.com.alura.lojajpa.modelo.Categoria;
import br.com.alura.lojajpa.modelo.Cliente;
import br.com.alura.lojajpa.modelo.ItemPedido;
import br.com.alura.lojajpa.modelo.Pedido;
import br.com.alura.lojajpa.modelo.Produto;
import br.com.alura.lojajpa.util.JPAUtil;

public class TesteCriteria {

	public static void main(String[] args) {
		popularBancoDeDados();
		
		EntityManager em = JPAUtil.getEntityManager();
		ProdutoDao produtoDao = new ProdutoDao(em);
		
		produtoDao.buscarPorParametrosComCriteria("PS5", null, 
				null);
		produtoDao.buscarPorParametrosComCriteria(null, null, 
				LocalDate.now());
		
	}
	private static void popularBancoDeDados() {
	
		Categoria catCelulares = new Categoria("CELULARES");
		Categoria catVideoGames = new Categoria("VIDEOGAMES");
		Categoria catInformatica = new Categoria("INFORMATICA");
		
		Produto celular = new Produto("Xiaomi Redmi", "Muito legal", 
				new BigDecimal("800"), catCelulares );
		Produto ps5 = new Produto("PS5", "Playstation 5", 
				new BigDecimal("3000"), catVideoGames );
		Produto macBook = new Produto("Macbook", "Macbook Pro Tela Retina", 
				new BigDecimal("10000"), catInformatica );
		
		Cliente cliente = new Cliente("Luciano","11122233344");
		Cliente cliente2 = new Cliente("Karinne","55566677788");
		
		Pedido pedido = new Pedido(cliente);
		pedido.adicionarItem(new ItemPedido(10, pedido, celular));
		pedido.adicionarItem(new ItemPedido(40, pedido, ps5));
		
		Pedido pedido2 = new Pedido(cliente2);
		pedido.adicionarItem(new ItemPedido(3, pedido2, macBook));
		
		
		EntityManager em = JPAUtil.getEntityManager();
		
		ProdutoDao produtoDao = new ProdutoDao(em);
		CategoriaDao categoriaDao = new CategoriaDao(em);
		ClienteDao clienteDao = new ClienteDao(em);
		
		
		PedidoDao pedidoDao = new PedidoDao(em);
		pedidoDao.cadastrar(pedido);
		pedidoDao.cadastrar(pedido2);
		
		em.getTransaction().begin();
		
		categoriaDao.cadastrar(catCelulares);
		categoriaDao.cadastrar(catVideoGames);
		categoriaDao.cadastrar(catInformatica);
		
		produtoDao.cadastrar(celular);
		produtoDao.cadastrar(ps5);
		produtoDao.cadastrar(macBook);
		
		
		clienteDao.cadastrar(cliente);
		clienteDao.cadastrar(cliente2);
		
		em.getTransaction().commit();
		em.close();
	}

}
 