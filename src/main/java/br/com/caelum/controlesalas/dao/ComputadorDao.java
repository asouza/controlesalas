package br.com.caelum.controlesalas.dao;

import org.springframework.data.repository.CrudRepository;

import br.com.caelum.controlesalas.model.Computador;

public interface ComputadorDao extends CrudRepository<Computador, Integer> {
	

}
