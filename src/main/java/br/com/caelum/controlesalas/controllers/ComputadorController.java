package br.com.caelum.controlesalas.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.caelum.controlesalas.dao.ComputadorDao;
import br.com.caelum.controlesalas.dao.ProblemaDao;
import br.com.caelum.controlesalas.dao.SalaDao;
import br.com.caelum.controlesalas.model.Computador;
import br.com.caelum.controlesalas.model.Sala;
import br.com.caelum.controlesalas.viewmodel.FiltroComputadores;
import br.com.caelum.controlesalas.viewmodel.ProblemaForm;

@Controller
@RequestMapping("/computador")
public class ComputadorController {
	
	@Autowired
	private SalaDao salaDao;
	
	@Autowired
	private ComputadorDao computadorDao;

	@Autowired
	private ProblemaDao problemaDao;

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
	public ModelAndView lista(FiltroComputadores filtro) {
		ModelAndView modelAndView = new ModelAndView("computador/lista");
		List<Sala> salas = salaDao.findAll();
		FiltroComputadores filtroComputadores = new FiltroComputadores(salas);				
		modelAndView.addObject("viewModel", filtroComputadores);
		return modelAndView;
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/filtraComputadores")
	public ModelAndView listaComputadores(@Valid FiltroComputadores filtro, BindingResult result) {
		
		if (result.hasErrors()) {
			lista(filtro);
		}
		
		ModelAndView modelAndView = new ModelAndView("computador/lista");
		
		List<Computador> computadores = computadorDao.findBySalaId(filtro.getSalaId());
		List<Sala> salas = salaDao.findAll();
		FiltroComputadores filtroComputadores = new FiltroComputadores(salas, computadores);
		modelAndView.addObject("viewModel", filtroComputadores);
		
		return modelAndView;
	}

	@RequestMapping(method=RequestMethod.GET, value="/{idComputador}/problema/form")
	public ModelAndView form(@PathVariable Integer idComputador, ProblemaForm problemaForm) {
		Computador computador = computadorDao.findOne(idComputador);
		
		ModelAndView modelAndView = new ModelAndView("computador/problema");
		modelAndView.addObject("computador", computador);
		return modelAndView;
	}
	
	
	@RequestMapping(method=RequestMethod.POST, value="/{idComputador}/problema")
	public ModelAndView save(@Valid ProblemaForm problemaForm, BindingResult result, RedirectAttributes redirectAttributes){
		
		if(result.hasErrors()) {
			return form(problemaForm.getId(), problemaForm);
		}
		
		Computador computador = new Computador(problemaForm.getId());
		problemaDao.save(problemaForm.build(computador));
		redirectAttributes.addFlashAttribute("sucesso", "Problema gravado com sucesso.");
		
		ModelAndView modelAndView = new ModelAndView("redirect:/computador");
		return modelAndView;
	}
}
