package br.com.caelum.controlesalas.controllers;

import java.io.IOException;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.caelum.controlesalas.dao.ProblemaDao;
import br.com.caelum.controlesalas.dao.SalaDao;
import br.com.caelum.controlesalas.model.Sala;
import br.com.caelum.controlesalas.service.CarregaSalasService;
import br.com.caelum.controlesalas.viewmodel.ProblemaForm;

@Controller
@RequestMapping("/sala")
public class SalaController {

	@Autowired
	private SalaDao salaDao;
	@Autowired
	private CarregaSalasService service;
	@Autowired
	private ProblemaDao problemaDao;
	
	@RequestMapping(method=RequestMethod.GET, value="/form")
	public String form() {
		return "sala/form";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView uploadFile(MultipartFile part, RedirectAttributes redirectAttributes) throws IOException {
		service.read(part.getInputStream());
		List<Sala> salas = service.getSalas();
		
		salaDao.save(salas);
		
		redirectAttributes.addFlashAttribute("sucesso", "Salas carregadas");
		
		return new ModelAndView("redirect:/sala");

	}
	
	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView lista() {
		ModelAndView modelAndView = new ModelAndView("sala/lista");
		modelAndView.addObject("salas", salaDao.findAll());
		
		return modelAndView;
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/{salaId}/problema/form")
	public ModelAndView problemaForm(@PathVariable Integer salaId, ProblemaForm problemaForm) {
		ModelAndView modelAndView = new ModelAndView("sala/problema");
		modelAndView.addObject("sala", salaDao.findOne(salaId));
		return modelAndView;
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/{salaId}/problema")
	public ModelAndView save(@Valid ProblemaForm problemaForm, BindingResult result, RedirectAttributes redirectAttributes){
		
		if(result.hasErrors()) {
			return problemaForm(problemaForm.getId(), problemaForm);
		}
		
		Sala sala = new Sala(problemaForm.getId());
		problemaDao.save(problemaForm.build(sala));
		redirectAttributes.addFlashAttribute("sucesso", "Problema gravado com sucesso.");
		
		ModelAndView modelAndView = new ModelAndView("redirect:/sala");
		return modelAndView;
	}

}
