package br.com.caelum.controlesalas.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.caelum.controlesalas.daos.ProblemaDao;
import br.com.caelum.controlesalas.modelo.Problema;

@RequestMapping("/problema")
@Controller
public class ProblemaController {
    @Autowired
    private ProblemaDao problemaDao;

    @RequestMapping(value="/computador/{computadorId}/criar", method=RequestMethod.GET)
    public ModelAndView form(Problema problema, @PathVariable Long computadorId){
	return new ModelAndView("/problema/form");
    }
    
    @RequestMapping(value="/computador/{computadorId}/criar", method=RequestMethod.POST)
    public ModelAndView criar(@Valid Problema problema, BindingResult result, @PathVariable Long computadorId){
	if(result.hasErrors()){
	    return form(problema, computadorId);
	}
	problemaDao.save(problema);
	return new ModelAndView("/problema/form");
    }
    
}
