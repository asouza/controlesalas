package br.com.caelum.controlesalas.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Computador {
    
    @Id
    @GeneratedValue
    private Long id;
    
    @NotEmpty
    private String configuracao;
    
    @NotEmpty
    @Column(unique = true)
    private String numeroDeSerie;
    
    private String observacoes;
    
    @ManyToOne
    private Sala sala;

    @NotEmpty
    private String modelo;

    public Computador(String numeroDeSerie, Sala sala, String modelo, String configuracao, String observacoes) {
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

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

}
