package br.com.caelum.controlesalas.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Any;
import org.hibernate.annotations.AnyMetaDef;
import org.hibernate.annotations.MetaValue;
import org.hibernate.validator.constraints.NotBlank;

@Entity
public class Problema 	 {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@NotNull
	@Any(metaColumn = @Column(name = "problematico_tipo"))
	@AnyMetaDef(idType = "int", metaType = "string", metaValues = {
			@MetaValue(value = "Computador", targetEntity = Computador.class),
			@MetaValue(value = "Sala", targetEntity = Sala.class) })
	@JoinColumn(name = "problematico_id")
	private Problematico problematico;
	
	@NotBlank
	@Column(columnDefinition="text")
	private String descricao;
	
	@NotBlank	
	private String titulo;

	@Deprecated
	public Problema() {
	}
	
	public Problema(String titulo, String descricao, Problematico problematico) {
		this.titulo = titulo;
		this.descricao = descricao;
		this.problematico = problematico;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Problematico getProblematico() {
		return problematico;
	}

	public void setProblematico(Problematico problematico) {
		this.problematico = problematico;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
	

}
