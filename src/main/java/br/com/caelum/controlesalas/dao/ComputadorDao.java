package br.com.caelum.controlesalas.dao;

import org.springframework.data.repository.Repository;

import br.com.caelum.controlesalas.modelo.Computador;

@org.springframework.stereotype.Repository
public interface ComputadorDao extends Repository<Computador, Integer> {

    Computador save(Computador computador);
}
