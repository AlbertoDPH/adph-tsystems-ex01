package com.delpozo.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "partida") // en caso que la tabla sea diferente
public class Partida {

	// Atributos de entidad Partida
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // busca ultimo valor e incrementa desde id final de db
	private int id;

	@ManyToOne
	@JoinColumn(name = "videojuego_id")
	private VideoJuego videoJuego;

	// Constructores
	public Partida() {

	}

	/**
	 * @param id
	 * @param videojuego_id
	 */
	public Partida(int id, VideoJuego videoJuego) {
		this.id = id;
		this.videoJuego = videoJuego;
	}

	// Getters y Setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public VideoJuego getVideoJuego() {
		return videoJuego;
	}

	public void setVideoJuego(VideoJuego videoJuego) {
		this.videoJuego = videoJuego;
	}

	// Metodo impresion de datos por consola
	@Override
	public String toString() {
		return "Partida [id=" + id + ", videoJuego=" + videoJuego + "]";
	}

}
