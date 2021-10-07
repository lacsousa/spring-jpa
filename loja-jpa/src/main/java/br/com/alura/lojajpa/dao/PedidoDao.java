package br.com.alura.lojajpa.dao;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.alura.lojajpa.modelo.Pedido;
import br.com.alura.lojajpa.vo.RelatorioVendasVO;

public class PedidoDao {
	
	private EntityManager em;

	public PedidoDao(EntityManager em) {
		this.em = em;
	}
	
	public void cadastrar(Pedido pedido) {
		this.em.persist(pedido);
	}
	
	public BigDecimal valorTotalVendido() {
		String jpql = "SELECT SUM(p.valorTotal) FROM Pedido p";
		return em.createQuery(jpql, BigDecimal.class).
				getSingleResult();
	}
	
	//forma não apropriada, mas funciona
	/*public List<Object[]> relatorioVendas() {
		String jpql = 
			"SELECT produto.nome, "
			+ "SUM(item.quantidade), " 
			+ "MAX(pedido.data) "
			+ "FROM Pedido pedido "
			+ "JOIN pedido.listaItensPedidos item "
			+ "JOIN item.produto produto "
			+ "GROUP BY produto.nome "
			+ "ORDER BY item.quantidade DESC";
		
		//forma não apropriada, mas funciona
		return em.createQuery(jpql, Object[].class).getResultList();
	
	}
	*/
	
	// Queries geralmente para Relatórios
	public List<RelatorioVendasVO> relatorioVendas() {
		String jpql = 
			"SELECT new br.com.alura.lojajpa.vo.RelatorioVendasVO("
			+ "produto.nome, "
			+ "SUM(item.quantidade), " 
			+ "MAX(pedido.data)) "
			+ "FROM Pedido pedido "
			+ "JOIN pedido.listaItensPedidos item "
			+ "JOIN item.produto produto "
			+ "GROUP BY produto.nome "
			+ "ORDER BY item.quantidade DESC";
		
		//forma não apropriada, mas funciona
		return em.createQuery(jpql, RelatorioVendasVO.class)
				.getResultList();
	
	}
	
	//Criando uma consulta planejada
	public Pedido buscarPedidoComCliente(Long id) {
		return em.
				createQuery(
						"SELECT p FROM Pedido p "
						+ "JOIN FETCH p.cliente "
						+ "WHERE p.id = :id", 
						Pedido.class)
				.setParameter("id", id)
				.getSingleResult();
	}
	
}
