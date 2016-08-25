package br.com.caelum.controlesalas.dtos;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import br.com.caelum.controlesalas.modelo.Problema;
import br.com.caelum.controlesalas.modelo.Problematico;
import br.com.caelum.controlesalas.modelo.Status;

public class ProblematicoComProblema {

    private Map<Problematico, List<Problema>> problematicos = new HashMap<>();

    public ProblematicoComProblema(List<Problema> problemas) {
	this.problematicos = problemas.stream().collect(Collectors.groupingBy(p -> p.getProblematico()));
    }

    public boolean temProblema(Problematico problematico) {
	
	//this.problematicos.keySet().stream().filter(p -> p.equals(problematico)).flatMap(k -> problematicos.get(k).stream());
	if (this.problematicos.containsKey(problematico)) {

	    List<Problema> problemas = problematicos.get(problematico);
	    if (problemas.size() >= 1) {
		 return problemas.stream().anyMatch(p -> p.getStatus() == Status.ABERTO);
	    }
	}
	return false;
    }
}
