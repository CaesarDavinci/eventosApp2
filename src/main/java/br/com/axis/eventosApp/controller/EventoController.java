package br.com.axis.eventosApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.axis.eventosApp.models.Convidado;
import br.com.axis.eventosApp.models.Evento;
import br.com.axis.eventosApp.repository.ConvidadoRepository;
import br.com.axis.eventosApp.repository.EventoRepository;

@Controller
public class EventoController {
	
	@Autowired
	private EventoRepository er;
	
	@Autowired
	private ConvidadoRepository cr;
	
	@RequestMapping(value="/cadastrarEvento", method=RequestMethod.GET)
	public String form() {
		return "evento/formEvento";
	}
	
	@RequestMapping(value="/cadastrarEvento", method=RequestMethod.POST)
	public String form(Evento evento) {
		
		er.save(evento);
		
		return "redirect:/cadastrarEvento";
	}
	
	/*procura de eventos*/
	@RequestMapping("/eventos")
	public ModelAndView listaEventos() {
		ModelAndView mv = new ModelAndView("index");
		Iterable<Evento> eventos = er.findAll();        //busca todos os eventos
		mv.addObject("eventos", eventos);
		return mv;
	}
	
	/*detalhes de eventos*/
	@RequestMapping(value="/{codigo}", method=RequestMethod.GET)
	public ModelAndView detalhesEvento(@PathVariable("codigo") long codigo) {
		Evento evento = er.findByCodigo(codigo);                              //busca um evento específico
		ModelAndView mv = new ModelAndView("evento/detalhesEvento");
		mv.addObject("evento", evento);
		
		Iterable<Convidado> convidados = cr.findByEvento(evento);
		mv.addObject("convidados", convidados);
		
		return mv;
		
	}
	
	@RequestMapping(value="/{codigo}", method=RequestMethod.POST )
	public String detalhesEventoPost(@PathVariable("codigo") long codigo, Convidado convidado) {
		Evento evento = er.findByCodigo(codigo);
		convidado.setEvento(evento);
		cr.save(convidado);
		return "redirect:/{codigo}";
	}
	
	
}
