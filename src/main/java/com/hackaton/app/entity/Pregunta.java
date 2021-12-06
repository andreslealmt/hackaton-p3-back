package com.hackaton.app.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "pregunta")
public class Pregunta {	
	
	
	public Pregunta(int preguntaId, String texto, String tipo) {
		
		this.texto = texto;
		this.preguntaId = preguntaId;
		this.tipo = tipo;
	}
	
	public Pregunta() {		
		
	}
	
	// Variables

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int preguntaId;
	
	private String texto;
	
	private String tipo;
	
	@ManyToOne
	@JoinColumn(name = "testId")
	@JsonIgnoreProperties("preguntas")
	private Test test;
	
	@OneToMany(cascade = {CascadeType.PERSIST}, mappedBy = "pregunta")
	@JsonIgnoreProperties("pregunta")
	private List<Respuesta> respuestas;
	
	
	// Getters and Setters
	
	
	

	public int getPreguntaId() {
		return preguntaId;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public List<Respuesta> getRespuestas() {
		return respuestas;
	}

	public void setRespuestas(List<Respuesta> respuestas) {
		this.respuestas = respuestas;
	}

	public void setPreguntaId(int preguntaId) {
		this.preguntaId = preguntaId;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Test getTest() {
		return test;
	}

	public void setTest(Test test) {
		this.test = test;
	}
	
	
	

}
