package com.hackaton.app.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "respuesta")
public class Respuesta {
	
		
	public Respuesta(int respuestaId, String texto, boolean correcta) {
		
		this.respuestaId = respuestaId;
		this.texto = texto;
		this.correcta = correcta;
	}
	
	public Respuesta() {		
		
	}
	
	// Columnas

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int respuestaId;
	
	private String texto;
	
	private boolean correcta = false;
	
	@ManyToOne()
	@JoinColumn(name = "preguntaId")
	@JsonIgnoreProperties({"test","respuestas"})
	private Pregunta pregunta;
	
	
	//Getters and Setters
	

	public int getRespuestaId() {
		return respuestaId;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public Pregunta getPregunta() {
		return pregunta;
	}

	public void setPregunta(Pregunta pregunta) {
		this.pregunta = pregunta;
	}

	public void setRespuestaId(int respuestaId) {
		this.respuestaId = respuestaId;
	}

	public boolean isCorrecta() {
		return correcta;
	}

	public void setCorrecta(boolean correcta) {
		this.correcta = correcta;
	}
	
	
	
	

}
