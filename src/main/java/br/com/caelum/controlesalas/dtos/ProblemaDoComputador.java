package br.com.caelum.controlesalas.dtos;

import br.com.caelum.controlesalas.modelo.Computador;
import br.com.caelum.controlesalas.modelo.Problema;

public class ProblemaDoComputador {
    
    private Computador computador;
    private Problema problema;
    
    public ProblemaDoComputador(Computador computador, Problema problema) {
	this.computador = computador;
	this.problema = problema;
    }

    public Computador getComputador() {
        return computador;
    }
    
    public Problema getProblema() {
	return problema;
    }
}
