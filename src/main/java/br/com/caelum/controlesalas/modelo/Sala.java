package br.com.caelum.controlesalas.modelo;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Sala implements Problematico {

    @Id
    @GeneratedValue
    private Long id;

    private String nome;

    @OneToMany(mappedBy = "sala")
    private List<Computador> computadores;

    /**
     * @deprecated hibernate eyes only
     */
    public Sala() {

    }

    public Sala(String nome) {
	this.nome = nome;
    }

    public Long getId() {
	return id;
    }

    public String getNome() {
	return nome;
    }

    @Override
    public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((computadores == null) ? 0 : computadores.hashCode());
	result = prime * result + ((nome == null) ? 0 : nome.hashCode());
	return result;
    }

    @Override
    public boolean equals(Object obj) {
	if (this == obj)
	    return true;
	if (obj == null)
	    return false;
	if (getClass() != obj.getClass())
	    return false;
	Sala other = (Sala) obj;
	if (computadores == null) {
	    if (other.computadores != null)
		return false;
	} else if (!computadores.equals(other.computadores))
	    return false;
	if (nome == null) {
	    if (other.nome != null)
		return false;
	} else if (!nome.equals(other.nome))
	    return false;
	return true;
    }

}
