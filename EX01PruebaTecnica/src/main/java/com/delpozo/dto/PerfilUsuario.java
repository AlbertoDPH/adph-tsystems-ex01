package com.delpozo.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "perfil_usuario") // en caso que la tabla sea diferente
public class PerfilUsuario {

	// Atributos de entidad PerfilUsuario
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // busca ultimo valor e incrementa desde id final de db
	private int id;
	private String nombre_jugador;

	@OneToOne
	@JoinColumn(name = "usuario_id")
	private Usuario usuario;

	// Constructores
	public PerfilUsuario() {

	}

	/**
	 * @param id
	 * @param nombre_jugador
	 * @param usuario_id
	 */
	public PerfilUsuario(int id, String nombre_jugador, Usuario usuario) {
		this.id = id;
		this.nombre_jugador = nombre_jugador;
		this.usuario = usuario;
	}

	// Getters y Setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre_jugador() {
		return nombre_jugador;
	}

	public void setNombre_jugador(String nombre_jugador) {
		this.nombre_jugador = nombre_jugador;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	// Metodo impresion de datos por consola
	@Override
	public String toString() {
		return "PerfilUsuario [id=" + id + ", nombre_jugador=" + nombre_jugador + ", usuario=" + usuario + "]";
	}

}
