package br.com.alura.lojajpa.modelo;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="livros")
public class Livro extends Produto{

	
	private String autor;
	private Integer numeroDePaginas;

	
	public Livro(String autor, Integer numeroDePaginas) {
		this.autor = autor;
		this.numeroDePaginas = numeroDePaginas;
	}

	
	public Livro() {

	}

	public String getAutor() {
		return autor;
	}


	public void setAutor(String autor) {
		this.autor = autor;
	}


	public Integer getNumeroDePaginas() {
		return numeroDePaginas;
	}


	public void setNumeroDePaginas(Integer numeroDePaginas) {
		this.numeroDePaginas = numeroDePaginas;
	}
}
