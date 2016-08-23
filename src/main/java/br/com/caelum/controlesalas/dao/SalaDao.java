package br.com.caelum.controlesalas.dao;

import org.springframework.data.repository.CrudRepository;

import br.com.caelum.controlesalas.modelo.Sala;

public interface SalaDao extends CrudRepository<Sala, Long>{
    public Sala findByNome(String nome);

}
