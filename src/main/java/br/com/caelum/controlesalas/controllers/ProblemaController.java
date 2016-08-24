package br.com.caelum.controlesalas.controllers;

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
import br.com.caelum.controlesalas.model.Computador;
import br.com.caelum.controlesalas.viewmodel.ProblemaForm;

@Controller
@RequestMapping("/problema")
public class ProblemaController {

	@Autowired
	private ComputadorDao computadorDao;
	
	@Autowired
	private ProblemaDao problemaDao;

	@RequestMapping(method=RequestMethod.GET, value="/{idComputador}/form")
	public ModelAndView form(@PathVariable Integer idComputador, ProblemaForm problemaForm) {
		Computador computador = computadorDao.findOne(idComputador);
		
		ModelAndView modelAndView = new ModelAndView("problema/form");
		modelAndView.addObject("computador", computador);
		return modelAndView;
	}
	
	
	@RequestMapping(method=RequestMethod.POST)
	public ModelAndView save(@Valid ProblemaForm problemaForm, BindingResult result, RedirectAttributes redirectAttributes){
		
		if(result.hasErrors()) {
			return form(problemaForm.getId(), problemaForm);
		}
		
		Computador computador = new Computador(problemaForm.getId());
		problemaDao.save(problemaForm.build(computador));
		redirectAttributes.addFlashAttribute("sucesso", "Problema gravado com sucesso.");
		
		ModelAndView modelAndView = new ModelAndView("redirect:computador");
		return modelAndView;
	}
}
