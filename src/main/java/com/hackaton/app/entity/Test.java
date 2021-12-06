package com.hackaton.app.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;



@Entity
@Table(name = "test")
public class Test {	
	
	
	public Test(int testId, String name, String categoria, int dificultad) {
		
		this.testId = testId;
		this.name = name;
		this.categoria = categoria;
		this.dificultad = dificultad;
	}
	
	public Test() {
			
	}
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int testId;
	
	private String name;
	
	private String categoria;
	
	private int dificultad;
	
	@OneToMany(cascade = {CascadeType.PERSIST}, mappedBy = "test")
	@JsonIgnoreProperties({"test"})	
	private List<Pregunta> preguntas;
	
	
	// Getters and Setters

	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public int getDificultad() {
		return dificultad;
	}

	public void setDificultad(int dificultad) {
		this.dificultad = dificultad;
	}

	public int getTestId() {
		return testId;
	}

	public void setTestId(int testId) {
		this.testId = testId;
	}

	public List<Pregunta> getPreguntas() {
		return preguntas;
	}

	public void setPreguntas(List<Pregunta> preguntas) {
		this.preguntas = preguntas;
	}
	

	
	
	
	

}
