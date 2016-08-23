package br.com.caelum.controlesalas.dao;

import org.springframework.data.repository.Repository;

import br.com.caelum.controlesalas.model.Problema;

@org.springframework.stereotype.Repository
public interface ProblemaDao extends Repository<Problema, Integer>{

	Problema save(Problema problema);
}
