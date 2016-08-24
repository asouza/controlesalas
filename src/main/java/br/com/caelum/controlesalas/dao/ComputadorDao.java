package br.com.caelum.controlesalas.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import br.com.caelum.controlesalas.model.Computador;

public interface ComputadorDao extends CrudRepository<Computador, Integer> {

	List<Computador> findBySalaId(Integer id);
	

}
