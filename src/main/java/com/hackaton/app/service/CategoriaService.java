package com.hackaton.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hackaton.app.entity.Categoria;
import com.hackaton.app.repository.CategoriaRepository;

@Service
public class CategoriaService {
	
	@Autowired private CategoriaRepository categoriaRepository;
	
	public List<Categoria> getCategorias() {
		return categoriaRepository.findAll();
	} 
	
	public Categoria saveCategoria(Categoria categoria) {
		return categoriaRepository.save(categoria);
	}
	
	public void deleteCategoria(int id) {
		categoriaRepository.deleteById(id);
	}
	
	
	
	
	
	
	
	
	
	
	

}
