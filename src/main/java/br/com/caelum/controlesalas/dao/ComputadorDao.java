package br.com.caelum.controlesalas.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import br.com.caelum.controlesalas.modelo.Computador;

@org.springframework.stereotype.Repository
public interface ComputadorDao extends CrudRepository<Computador, Long> {

    List<Computador> findBySalaId(Long salaId);

}
