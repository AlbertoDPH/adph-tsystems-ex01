package com.delpozo.dto;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "mensaje") // en caso que la tabla sea diferente
public class Mensaje {

	// Atributos de entidad Mensaje
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // busca ultimo valor e incrementa desde id final de db
	private int id;
	private String contenido;
	private LocalDateTime fecha_hora;

	@ManyToOne
	@JoinColumn(name = "usuario_id")
	private Usuario remitente;

	@ManyToOne
	@JoinColumn(name = "partida_id")
	private Partida partida;

	// Constructores
	public Mensaje() {

	}

	/**
	 * @param id
	 * @param contenido
	 * @param fecha_hora
	 * @param usuario_id
	 * @param partida_id
	 */
	public Mensaje(int id, String contenido, LocalDateTime fecha_hora, Usuario remitente, Partida partida) {
		this.id = id;
		this.contenido = contenido;
		this.fecha_hora = fecha_hora;
		this.remitente = remitente;
		this.partida = partida;
	}

	// Getters y Setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getContenido() {
		return contenido;
	}

	public void setContenido(String contenido) {
		this.contenido = contenido;
	}

	public LocalDateTime getFecha_hora() {
		return fecha_hora;
	}

	public void setFecha_hora(LocalDateTime fecha_hora) {
		this.fecha_hora = fecha_hora;
	}

	public Usuario getRemitente() {
		return remitente;
	}

	public void setRemitente(Usuario remitente) {
		this.remitente = remitente;
	}

	public Partida getPartida() {
		return partida;
	}

	public void setPartida(Partida partida) {
		this.partida = partida;
	}

	// Metodo impresion de datos por consola
	@Override
	public String toString() {
		return "Mensaje [id=" + id + ", contenido=" + contenido + ", fecha_hora=" + fecha_hora + ", remitente="
				+ remitente + ", partida=" + partida + "]";
	}

}
