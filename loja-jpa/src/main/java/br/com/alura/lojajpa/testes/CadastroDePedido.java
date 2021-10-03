package br.com.alura.lojajpa.testes;

import java.math.BigDecimal;

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

public class CadastroDePedido {

	public static void main(String[] args) {
		popularBancoDeDados();
		
		EntityManager em = JPAUtil.getEntityManager();
		ProdutoDao produtoDao = new ProdutoDao(em);
		ClienteDao clienteDao = new ClienteDao(em);
		
		Produto produto = produtoDao.buscarPorId(1l);
		Cliente cliente = clienteDao.buscarPorId(1l);
		
		em.getTransaction().begin();
		
		Pedido pedido = new Pedido(cliente);
		pedido.adicionarItem(new ItemPedido(10, pedido, produto));
		PedidoDao pedidoDao = new PedidoDao(em);
		pedidoDao.cadastrar(pedido);
		
		em.getTransaction().commit();
	}
	
	private static void popularBancoDeDados() {
		Categoria catCelulares = new Categoria("CELULARES");
		
		Produto celular = new Produto("Xiaomi Redmi", "Muito legal", 
				new BigDecimal("800"), catCelulares );
		
		Cliente cliente = new Cliente("Luciano","11122233344");
		
		
		EntityManager em = JPAUtil.getEntityManager();
		ProdutoDao produtoDao = new ProdutoDao(em);
		CategoriaDao categoriaDao = new CategoriaDao(em);
		ClienteDao clienteDao = new ClienteDao(em);
		
		
		em.getTransaction().begin();
		
		categoriaDao.cadastrar(catCelulares);
		produtoDao.cadastrar(celular);
		clienteDao.cadastrar(cliente);
		
		em.getTransaction().commit();
		em.close();
	}

}
