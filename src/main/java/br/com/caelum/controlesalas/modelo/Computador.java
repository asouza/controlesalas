package br.com.caelum.controlesalas.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

@Entity
public class Computador implements Problematico {

    @Id
    @GeneratedValue
    private Long id;

    @NotBlank
    private String configuracao;

    @NotBlank
    @Column(unique = true)
    private String numeroDeSerie;

    private String observacoes;

    @NotNull
    @ManyToOne
    private Sala sala;

    @NotNull
    @Enumerated(EnumType.STRING)
    private Modelo modelo;

    private int numeroNaSala;

    /**
     * @deprecated
     */
    public Computador() {
    }

    public Computador(String numeroDeSerie, Sala sala, Modelo modelo, String configuracao, String observacoes, String numeroNaSala) {
	this.numeroDeSerie = numeroDeSerie;
	this.sala = sala;
	this.modelo = modelo;
	this.configuracao = configuracao;
	this.observacoes = observacoes;
    }

    public Long getId() {
	return id;
    }

    public void setId(Long id) {
	this.id = id;
    }

    public String getConfiguracao() {
	return configuracao;
    }

    public void setConfiguracao(String configuracao) {
	this.configuracao = configuracao;
    }

    public String getNumeroDeSerie() {
	return numeroDeSerie;
    }

    public void setNumeroDeSerie(String numeroDeSerie) {
	this.numeroDeSerie = numeroDeSerie;
    }

    public String getObservacoes() {
	return observacoes;
    }

    public void setObservacoes(String observacoes) {
	this.observacoes = observacoes;
    }

    public Sala getSala() {
	return sala;
    }

    public void setSala(Sala sala) {
	this.sala = sala;
    }

    public Modelo getModelo() {
	return modelo;
    }

    public void setModelo(Modelo modelo) {
	this.modelo = modelo;
    }

    public int getNumeroNaSala() {
	return numeroNaSala;
    }

    public void setNumeroNaSala(int numeroNaSala) {
	this.numeroNaSala = numeroNaSala;
    }

    @Override
    public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((configuracao == null) ? 0 : configuracao.hashCode());
	result = prime * result + ((modelo == null) ? 0 : modelo.hashCode());
	result = prime * result + ((numeroDeSerie == null) ? 0 : numeroDeSerie.hashCode());
	result = prime * result + numeroNaSala;
	result = prime * result + ((observacoes == null) ? 0 : observacoes.hashCode());
	result = prime * result + ((sala == null) ? 0 : sala.hashCode());
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
	Computador other = (Computador) obj;
	if (configuracao == null) {
	    if (other.configuracao != null)
		return false;
	} else if (!configuracao.equals(other.configuracao))
	    return false;
	if (modelo != other.modelo)
	    return false;
	if (numeroDeSerie == null) {
	    if (other.numeroDeSerie != null)
		return false;
	} else if (!numeroDeSerie.equals(other.numeroDeSerie))
	    return false;
	if (numeroNaSala != other.numeroNaSala)
	    return false;
	if (observacoes == null) {
	    if (other.observacoes != null)
		return false;
	} else if (!observacoes.equals(other.observacoes))
	    return false;
	if (sala == null) {
	    if (other.sala != null)
		return false;
	} else if (!sala.equals(other.sala))
	    return false;
	return true;
    }

}
