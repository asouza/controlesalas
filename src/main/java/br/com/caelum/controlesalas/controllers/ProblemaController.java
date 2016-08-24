package br.com.caelum.controlesalas.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.caelum.controlesalas.dao.ComputadorDao;
import br.com.caelum.controlesalas.dao.SalaDao;
import br.com.caelum.controlesalas.daos.ProblemaDao;
import br.com.caelum.controlesalas.dtos.FormProblema;
import br.com.caelum.controlesalas.modelo.Problema;

@RequestMapping("/problema")
@Controller
public class ProblemaController {
    
    @Autowired
    private ProblemaDao problemaDao;
    @Autowired
    private ComputadorDao computadorDao;
    @Autowired
    private SalaDao salaDao;

    @RequestMapping(value="/{tipo}/{id}/detalhes", method=RequestMethod.GET)
    public ModelAndView detalhes(@PathVariable Long id, @PathVariable String tipo){
	return new ModelAndView("/problema/detalhes");
    }
    
    @RequestMapping(value="/{tipo}/{id}/criar", method=RequestMethod.GET)
    public ModelAndView form(FormProblema problema, @PathVariable Long id, @PathVariable String tipo){
	return new ModelAndView("/problema/form");
    }
    
    @RequestMapping(value="/computador/{computadorId}/criar", method=RequestMethod.POST)
    public ModelAndView criarProblemaComputador(@Valid FormProblema form, BindingResult result, @PathVariable Long computadorId){
	if(result.hasErrors()){
	    return form(form, computadorId, "computador");
	}
	Problema problema = form.getProblemaPara(computadorDao.findOne(computadorId));
	problemaDao.save(problema);
	return new ModelAndView("sucesso");
    }
    
    @RequestMapping(value="/sala/{salaId}/criar", method=RequestMethod.POST)
    public ModelAndView criarProblemaSala(@Valid FormProblema form, BindingResult result, @PathVariable Long salaId){
	if(result.hasErrors()){
	    return form(form, salaId, "sala");
	}
	Problema problema = form.getProblemaPara(salaDao.findOne(salaId));
	problemaDao.save(problema);
	return new ModelAndView("sucesso");
    }
    
}
