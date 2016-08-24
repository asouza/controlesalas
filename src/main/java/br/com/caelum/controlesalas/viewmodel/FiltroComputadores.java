package br.com.caelum.controlesalas.viewmodel;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotNull;

import br.com.caelum.controlesalas.model.Computador;
import br.com.caelum.controlesalas.model.Sala;

public class FiltroComputadores {

	
	@NotNull
	private Integer salaId;
	
	
	private List<Sala> salas = new ArrayList<>();
	private List<Computador> computadores = new ArrayList<>();
	
	@Deprecated
	public FiltroComputadores() {
	}
	
	public FiltroComputadores(List<Sala> salas, List<Computador> computadores) {
		this(salas);
		this.computadores = computadores;
	}

	
	
	public FiltroComputadores(List<Sala> salas) {
		this.salas = salas;
	}

	public List<Sala> getSalas() {
		return salas;
	}



	public void setSalas(List<Sala> salas) {
		this.salas = salas;
	}



	public List<Computador> getComputadores() {
		return computadores;
	}



	public void setComputadores(List<Computador> computadores) {
		this.computadores = computadores;
	}



	public Integer getSalaId() {
		return salaId;
	}

	public void setSalaId(Integer salaId) {
		this.salaId = salaId;
	}
	
	
}
