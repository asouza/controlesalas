package br.com.caelum.controlesalas.dao;

import java.util.List;

import org.springframework.data.repository.Repository;

import br.com.caelum.controlesalas.model.Sala;

@org.springframework.stereotype.Repository
public interface SalaDao  extends Repository<Sala, Integer>{
	
	<S extends Sala> Iterable<Sala> save(Iterable<Sala> entities);

	List<Sala> findAll();
	
}
