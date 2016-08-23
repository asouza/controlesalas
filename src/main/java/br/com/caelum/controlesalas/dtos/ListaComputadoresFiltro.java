package br.com.caelum.controlesalas.dtos;

import org.hibernate.validator.constraints.NotBlank;

public class ListaComputadoresFiltro {

    @NotBlank
    private Long salaId;

    public Long getSalaId() {
	return salaId;
    }

    public void setSalaId(Long salaId) {
	this.salaId = salaId;
    }
}
