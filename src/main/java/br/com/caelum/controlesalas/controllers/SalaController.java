package br.com.caelum.controlesalas.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.caelum.controlesalas.dao.ProblemaDao;
import br.com.caelum.controlesalas.dao.SalaDao;
import br.com.caelum.controlesalas.dtos.ProblematicoComProblema;
import br.com.caelum.controlesalas.modelo.Problema;

@RequestMapping("/sala")
@Controller
public class SalaController {

    @Autowired
    private SalaDao salaDao;
    @Autowired
    private ProblemaDao problemaDao;
    
    @RequestMapping(method=RequestMethod.GET)
    public ModelAndView lista(){
	ModelAndView modelAndView = new ModelAndView("/sala/lista");
	modelAndView.addObject("salas", salaDao.findAll());
	List<Problema> problemas = problemaDao.findAllProblemasDasSalas();
	
	ProblematicoComProblema salasComProblema = new ProblematicoComProblema(problemas);
	modelAndView.addObject("salasComProblema", salasComProblema);
	return modelAndView ;
    }
}
