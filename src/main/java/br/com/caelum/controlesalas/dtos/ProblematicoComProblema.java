package br.com.caelum.controlesalas.dtos;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.com.caelum.controlesalas.modelo.Problema;
import br.com.caelum.controlesalas.modelo.Problematico;
import br.com.caelum.controlesalas.modelo.Status;

public class ProblematicoComProblema {

    private Map<Problematico, List<Problema>> problematicos = new HashMap<>();

    public ProblematicoComProblema(Map<Problematico, List<Problema>> problematicos) {
	this.problematicos = problematicos;
    }

    public boolean temProblema(Problematico problematico) {
	if (this.problematicos.containsKey(problematico)) {

	    List<Problema> problemas = problematicos.get(problematico);
	    if (problemas.size() >= 1) {
		 return problemas.stream().anyMatch(p -> p.getStatus() == Status.ABERTO);
	    }
	}
	return false;
    }
}
