package com.delpozo.dto;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "usuario") // en caso que la tabla sea diferente
public class Usuario {

	// Atributos de entidad Usuario
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // busca ultimo valor e incrementa desde id final de db
	private int id;
	private String nombre_usuario;
	private String email;
	private String password;

	@JsonIgnore //Lo usamos para que las consultas no entren en bucle infinito
	@OneToOne(mappedBy = "usuario", cascade = CascadeType.ALL)
	private PerfilUsuario perfilUsuario;

	@ManyToMany
    @JoinTable(name = "miembro_partida",
        joinColumns = @JoinColumn(name = "usuario_id"),
        inverseJoinColumns = @JoinColumn(name = "partida_id")
    )
	private List<Partida> partidas;

	// Constructores
	public Usuario() {

	}

	/**
	 * @param id
	 * @param nombre_usuario
	 * @param email
	 * @param password
	 */
	public Usuario(int id, String nombre_usuario, String email, String password) {
		this.id = id;
		this.nombre_usuario = nombre_usuario;
		this.email = email;
		this.password = password;
	}

	// Getters y Setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre_usuario() {
		return nombre_usuario;
	}

	public void setNombre_usuario(String nombre_usuario) {
		this.nombre_usuario = nombre_usuario;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public PerfilUsuario getPerfilUsuario() {
		return perfilUsuario;
	}

	public void setPerfilUsuario(PerfilUsuario perfilUsuario) {
		this.perfilUsuario = perfilUsuario;
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
		return "Usuario [id=" + id + ", nombre_usuario=" + nombre_usuario + ", email=" + email + ", password="
				+ password + "]";
	}

}
