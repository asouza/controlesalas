package br.com.caelum.controlesalas.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Any;
import org.hibernate.annotations.AnyMetaDef;
import org.hibernate.annotations.MetaValue;
import org.hibernate.validator.constraints.NotBlank;

@Entity
public class Problema {

    @Id
    @GeneratedValue
    private Long id;
    
    @NotBlank
    private String titulo;
    @NotBlank
    private String descricao;
    
    @NotNull
    @Any(metaColumn = @Column(name = "problematico"))
    @AnyMetaDef(idType = "long", metaType = "string", metaValues = {
	    @MetaValue(value = "computador", targetEntity = Computador.class),
	    @MetaValue(value = "sala", targetEntity = Sala.class) })
    @JoinColumn(name = "problematicoId")
    private Problematico problematico;
    
    @Enumerated(EnumType.STRING)
    private Status status;

    /**
     * @deprecated hibernate eyes only
     */
    public Problema(){
	
    }
    
    public Problema(String titulo, String descricao, Problematico problematico) {
	this.titulo = titulo;
	this.descricao = descricao;
	this.problematico = problematico;
	this.status = Status.ABERTO;
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

    public Problematico getProblematico() {
	return problematico;
    }

    public void setProblematico(Problematico problematico) {
	this.problematico = problematico;
    }
    
    public Status getStatus() {
	return status;
    }
}
