package br.com.caelum.controlesalas.daos;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import br.com.caelum.controlesalas.modelo.Problema;

public interface ProblemaDao extends CrudRepository<Problema, Long>{

    @Query(value="select p.* from Problema p join Computador c on p.problematico_id = c.id where p.problematico = 'computador' and c.sala_id = :salaId", nativeQuery=true)
    public List<Problema> findByComputadorSalaId(@Param("salaId") Long salaId);
    
    @Query(value="select p.* from Problema p where p.problematico = 'sala'", nativeQuery=true)
    public List<Problema> findAllProblemasDasSalas();
    
    @Query("select p from Problema p where p.problematico.class = :problematico and p.problematico.id = :id")
    public List<Problema> findByProblematicoAndId(String problematico, Long id);
}
