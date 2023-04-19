package com.delpozo.dto;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "videojuego") // en caso que la tabla sea diferente
public class VideoJuego {

	// Atributos de entidad VideoJuego
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // busca ultimo valor e incrementa desde id final de db
	private int id;
	private String nombre;
	private String genero;

	@OneToMany
	@JoinColumn(name = "videojuego")
	private List<Partida> partidas;

	// Constructores
	public VideoJuego() {

	}

	/**
	 * @param id
	 * @param nombre
	 * @param genero
	 */
	public VideoJuego(int id, String nombre, String genero) {
		this.id = id;
		this.nombre = nombre;
		this.genero = genero;
	}

	// Getters y Setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public List<Partida> getPartidas() {
		return partidas;
	}

	public void setPartidas(List<Partida> partidas) {
		this.partidas = partidas;
	}

	// Metodo impresion de datos por consola
	@Override
	public String toString() {
		return "VideoJuego [id=" + id + ", nombre=" + nombre + ", genero=" + genero + ", partidas=" + partidas + "]";
	}

}
