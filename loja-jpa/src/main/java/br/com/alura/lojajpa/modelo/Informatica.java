package br.com.alura.lojajpa.modelo;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="produtos_informatica")
public class Informatica extends Produto{

	
	private String marca;
	private Integer modelo;

	
	public Informatica(String marca, Integer modelo) {
		this.marca = marca;
		this.modelo = modelo;
	}


	public Informatica() {

	}


	public String getMarca() {
		return marca;
	}


	public void setMarca(String marca) {
		this.marca = marca;
	}


	public Integer getModelo() {
		return modelo;
	}


	public void setModelo(Integer modelo) {
		this.modelo = modelo;
	}


}
