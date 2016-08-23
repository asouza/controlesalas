package br.com.caelum.controlesalas.modelo;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Sala {
   
    @Id
    @GeneratedValue
    private Long id;
    
    private String nome;
    
    @OneToMany(mappedBy="sala")
    private List<Computador> computadores;
    
    public Sala(String nome) {
	this.nome = nome;
    }
    
    /**
     * @deprecated hibernate eyes only
     */
    public Sala() {
	// TODO Auto-generated constructor stub
    }


}
