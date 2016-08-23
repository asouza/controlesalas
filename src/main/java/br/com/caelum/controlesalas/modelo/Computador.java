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
public class Computador {
    
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

    public Computador(String numeroDeSerie, Sala sala, Modelo modelo, String configuracao, String observacoes, String numeroNaSala) {
	this.numeroDeSerie = numeroDeSerie;
	this.sala = sala;
	this.modelo = modelo;
	this.configuracao = configuracao;
	this.observacoes = observacoes;
    }
    
    /**
     * @deprecated
     */
    public Computador() {
	// TODO Auto-generated constructor stub
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

}
