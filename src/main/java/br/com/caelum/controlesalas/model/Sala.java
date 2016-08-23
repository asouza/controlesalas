package br.com.caelum.controlesalas.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Sala {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@NotNull
	private Integer quantidadeMaquinas;
	
	@NotEmpty
	private String numero;

	@Deprecated
	public Sala(){}
	
	public Sala(String numero, Integer quantidadeMaquinas) {
		this.numero = numero;
		this.quantidadeMaquinas = quantidadeMaquinas;
	}

	public Integer getQuantidadeMaquinas() {
		return quantidadeMaquinas;
	}

	public void setQuantidadeMaquinas(Integer quantidadeMaquinas) {
		this.quantidadeMaquinas = quantidadeMaquinas;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	

}
