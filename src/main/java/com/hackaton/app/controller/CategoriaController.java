package com.hackaton.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.hackaton.app.entity.Categoria;
import com.hackaton.app.service.CategoriaService;

@RestController
@RequestMapping("/api/categoria")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class CategoriaController {
	
	@Autowired private CategoriaService categoriaService;
	
	@GetMapping("/all")
	public List<Categoria> getCategorias(){
		return categoriaService.getCategorias();
	}
	
	@PostMapping("/save")
	@ResponseStatus(code = HttpStatus.CREATED)
	public Categoria saveCategoria(@RequestBody Categoria categoria) {
		return categoriaService.saveCategoria(categoria);
	}
	
	@DeleteMapping("/{id}")
	public void deleteCategoria(@PathVariable int id) {
		categoriaService.deleteCategoria(id);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
