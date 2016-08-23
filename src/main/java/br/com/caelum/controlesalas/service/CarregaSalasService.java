package br.com.caelum.controlesalas.service;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

import org.springframework.stereotype.Service;

import br.com.caelum.controlesalas.model.Sala;

@Service
public class CarregaSalasService {

	private List<Sala> salas = new ArrayList<>();

	public void read(InputStream inputStream){
		try (Scanner scanner = new Scanner(inputStream)) {

			while (scanner.hasNext()) {
				String line = scanner.nextLine();
				StringTokenizer tokenizer = new StringTokenizer(line, ";");

				String numeroSala = tokenizer.nextToken();
				Integer qtdMaquinas = Integer.parseInt(tokenizer.nextToken());

				Sala sala = new Sala(numeroSala, qtdMaquinas);
				salas .add(sala);
			}						
		}
	}
	
	
	public List<Sala> getSalas() {
		return Collections.unmodifiableList(salas);
	}
	
}
