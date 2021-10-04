package br.com.alura.lojajpa.vo;

import java.time.LocalDate;

public class RelatorioVendasVO {
	
	private String nomeProduto;
	private Long quantidadeVendida;
	private LocalDate dataUltimaVenda;
	
	
	public RelatorioVendasVO(String nomeProduto, 
			Long quantidadeVendida, LocalDate dataUltimaVenda) {
		this.nomeProduto = nomeProduto;
		this.quantidadeVendida = quantidadeVendida;
		this.dataUltimaVenda = dataUltimaVenda;
	}
	
	public String getNomeProduto() {
		return nomeProduto;
	}
	
	public Long getQuantidadeVendida() {
		return quantidadeVendida;
	}
	
	public LocalDate getDataUltimaVenda() {
		return dataUltimaVenda;
	}

	@Override
	public String toString() {
		return "RelatorioVendasVO [nomeProduto=" + nomeProduto + ", quantidadeVendida=" + quantidadeVendida
				+ ", dataUltimaVenda=" + dataUltimaVenda + "]";
	}
	
	

}
