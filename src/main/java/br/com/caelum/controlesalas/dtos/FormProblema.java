package br.com.caelum.controlesalas.dtos;

import org.hibernate.validator.constraints.NotBlank;

import br.com.caelum.controlesalas.modelo.Computador;
import br.com.caelum.controlesalas.modelo.Problema;
import br.com.caelum.controlesalas.modelo.Problematico;

public class FormProblema {

    @NotBlank
    private String descricao;
    @NotBlank
    private String titulo;

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
    
    public Problema getProblemaPara(Problematico problematico){
	return new Problema(titulo, descricao, problematico);
    }

}
