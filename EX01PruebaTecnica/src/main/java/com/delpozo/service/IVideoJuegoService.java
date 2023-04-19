package com.delpozo.service;

import java.util.List;

import com.delpozo.dto.VideoJuego;

public interface IVideoJuegoService {

	public List<VideoJuego> listarVideoJuego(); // Listar All

	public VideoJuego guardarVideoJuego(VideoJuego videoJuego); // Guarda un videoJuego CREATE

	public VideoJuego videoJuegoXID(Integer id); // Leer datos de un videoJuego READ

	public VideoJuego actualizarVideoJuego(VideoJuego videoJuego); // Actualiza datos del videoJuego UPDATE

	public void eliminarVideoJuego(Integer id);// Elimina el videoJuego DELETE

}
