package br.com.caelum.controlesalas.controllers;

import java.io.InputStream;
import java.util.Scanner;
import java.util.StringTokenizer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.caelum.controlesalas.dao.ComputadorDao;
import br.com.caelum.controlesalas.dao.SalaDao;
import br.com.caelum.controlesalas.modelo.Computador;
import br.com.caelum.controlesalas.modelo.Modelo;
import br.com.caelum.controlesalas.modelo.Sala;

@Controller
public class HomeController {

    @Autowired
    private SalaDao salaDao;
    @Autowired
    private ComputadorDao computadorDao;
    
    @RequestMapping("/")
    public String index() {
	return "home/index";
    }
    
    @RequestMapping("/importaSalas")
    public String importaSalas(){
	InputStream salas = this.getClass().getResourceAsStream("/salas.csv");
	System.out.println("Salas: " + salas);
	try(Scanner scanner = new Scanner(salas)) {
	    while(scanner.hasNextLine()){
		String nomeDaSala = scanner.nextLine();
		Sala sala = new Sala(nomeDaSala);
		salaDao.save(sala);
	    }
	}
	return "sucesso";
    }

    @RequestMapping("/importaComputadores")
    public String importaComputadores(){
	InputStream computadores = this.getClass().getResourceAsStream("/computadores.csv");
	try(Scanner scanner = new Scanner(computadores)) {
	    while(scanner.hasNextLine()){
		StringTokenizer stringTokenizer = new StringTokenizer(scanner.nextLine(),",");
		String numeroNaSala = stringTokenizer.nextToken();
		String numeroDeSerie = stringTokenizer.nextToken();
		String nomeDaSala = stringTokenizer.nextToken();
		Sala sala = salaDao.findByNome(nomeDaSala);
		Modelo modelo = Modelo.valueOf(stringTokenizer.nextToken().toUpperCase());
		String configuracao = stringTokenizer.nextToken();
		String observacao = stringTokenizer.nextToken();
		Computador computador = new Computador(numeroDeSerie, sala, modelo, configuracao, observacao, numeroNaSala);
		computadorDao.save(computador);
	    }
	}
	return null;
    }
    
}
