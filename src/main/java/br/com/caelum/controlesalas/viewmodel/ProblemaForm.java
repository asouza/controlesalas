package br.com.caelum.controlesalas.viewmodel;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

import br.com.caelum.controlesalas.model.Problema;
import br.com.caelum.controlesalas.model.Problematico;

public class ProblemaForm {

	@NotBlank
	private String titulo;
	@NotBlank
	private String descricao;
	@NotNull
	private Integer id;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Problema build(Problematico problematico) {
		return new Problema(titulo, descricao, problematico);
	}

}
