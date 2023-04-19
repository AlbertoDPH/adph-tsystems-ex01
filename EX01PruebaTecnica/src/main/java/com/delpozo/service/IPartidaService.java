package com.delpozo.service;

import java.util.List;

import com.delpozo.dto.Partida;


public interface IPartidaService {

	public List<Partida> listarPartida(); // Listar All

	public Partida guardarPartida(Partida partida); // Guarda un partida CREATE

	public Partida partidaXID(Integer id); // Leer datos de un partida READ

	public Partida actualizarPartida(Partida partida); // Actualiza datos del partida UPDATE

	public void eliminarPartida(Integer id);// Elimina el partida DELETE

}
