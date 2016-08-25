package br.com.caelum.controlesalas.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.caelum.controlesalas.dao.ComputadorDao;
import br.com.caelum.controlesalas.dao.ProblemaDao;
import br.com.caelum.controlesalas.dao.SalaDao;
import br.com.caelum.controlesalas.dtos.ListaComputadoresFiltro;
import br.com.caelum.controlesalas.dtos.ProblematicoComProblema;
import br.com.caelum.controlesalas.modelo.Problema;

@Controller
@RequestMapping("/computador")
public class ComputadorController {

    @Autowired
    private SalaDao salaDao;
    @Autowired
    private ProblemaDao problemaDao;
    @Autowired
    private ComputadorDao computadorDao;
    

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView lista(ListaComputadoresFiltro infoSala) {
	ModelAndView model = new ModelAndView("computador/lista");
	if(infoSala != null){
	    List<Problema> problemas = problemaDao.findByComputadorSalaId(infoSala.getSalaId());
	    
	    ProblematicoComProblema computadoresComProblema = new ProblematicoComProblema(problemas);
	    
	    model.addObject("computadores", computadorDao.findBySalaId(infoSala.getSalaId()));
	    model.addObject("computadoresComProblema", computadoresComProblema);
	}

	model.addObject("salas", salaDao.findAll());
	return model;
    }

}
