package br.com.caelum.controlesalas.dao;

import java.util.List;

import org.springframework.data.repository.Repository;

import br.com.caelum.controlesalas.modelo.Computador;

@org.springframework.stereotype.Repository
public interface ComputadorDao extends Repository<Computador, Long> {

    Computador save(Computador computador);

    List<Computador> findBySalaId(Long salaId);
}
