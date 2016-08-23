package br.com.caelum.controlesalas.modelo;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

@Entity
public class Problema {

    @Id
    @GeneratedValue
    private Long id;
    
    @NotBlank
    private String titulo;
    @NotBlank
    private String descricao;
    
    @NotNull
    @ManyToOne
    private Computador computador;
    
    @Enumerated(EnumType.STRING)
    private Status status;
}
