package com.hackaton.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.hackaton.app.entity.Pregunta;
import com.hackaton.app.service.PreguntaService;

@RestController
@RequestMapping("/api/pregunta")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class PreguntaController {

	@Autowired private PreguntaService preguntaService;
	
	@GetMapping("/all")
	public List<Pregunta> getPreguntas(){
		return preguntaService.getPreguntas();
	}
	
	@PostMapping("/save")
	@ResponseStatus(code = HttpStatus.CREATED)
	public Pregunta savePregunta(@RequestBody Pregunta pregunta) {	
		return preguntaService.savePregunta(pregunta);
	}
	
	@GetMapping("/{id}")
	public Pregunta getPregunta(@PathVariable int id) {
		return preguntaService.getPregunta(id).get();
	}
	
	
	

}
