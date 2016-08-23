package br.com.caelum.controlesalas.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.caelum.controlesalas.dao.ComputadorDao;
import br.com.caelum.controlesalas.dao.SalaDao;
import br.com.caelum.controlesalas.model.Computador;
import br.com.caelum.controlesalas.model.Sala;

@Controller
@RequestMapping("/computador")
public class ComputadorController {
	
	@Autowired
	private SalaDao salaDao;
	
	@Autowired
	private ComputadorDao computadorDao;

	@RequestMapping(value = "/form", method=RequestMethod.GET)
	public ModelAndView form(Computador computador){
		List<Sala> salas = salaDao.findAll();
		return new ModelAndView("computador/form").addObject("salas", salas);
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ModelAndView cadastra(@Valid Computador computador, BindingResult result){
		if(result.hasErrors()){
			return form(computador);
		}
		computadorDao.save(computador);
		return new ModelAndView("sucesso");
	
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView lista() {
		ModelAndView modelAndView = new ModelAndView("computador/lista");
		modelAndView.addObject("computadores", computadorDao.findAll());
		return modelAndView;
	}

}
