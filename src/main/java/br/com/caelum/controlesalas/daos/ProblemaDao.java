package br.com.caelum.controlesalas.daos;

import org.springframework.data.repository.CrudRepository;

import br.com.caelum.controlesalas.modelo.Problema;

public interface ProblemaDao extends CrudRepository<Problema, Long>{

}
