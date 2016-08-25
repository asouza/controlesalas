package br.com.caelum.controlesalas.dtos;

import org.hibernate.validator.constraints.NotBlank;

public class InfoSolucao {

    @NotBlank
    private String comentario;
    
    public String getComentario() {
	return comentario;
    }
    
    public void setComentario(String comentario) {
	this.comentario = comentario;
    }
}
