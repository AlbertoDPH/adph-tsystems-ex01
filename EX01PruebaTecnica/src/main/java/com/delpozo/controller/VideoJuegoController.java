package com.delpozo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.delpozo.dto.VideoJuego;

import com.delpozo.service.VideoJuegoServiceImpl;

@RestController
@RequestMapping("/api")
public class VideoJuegoController {

	@Autowired
	VideoJuegoServiceImpl videoJuegoServiceImpl;

	@GetMapping("/videojuego")
	public List<VideoJuego> listarVideoJuego() {
		return videoJuegoServiceImpl.listarVideoJuego();
	}

	@PostMapping("/videojuego")
	public VideoJuego salvarVideoJuego(@RequestBody VideoJuego videoJuego) {
		return videoJuegoServiceImpl.guardarVideoJuego(videoJuego);
	}

	@GetMapping("/videojuego/{id}")
	public VideoJuego XID(@PathVariable(name = "id") Integer id) {

		VideoJuego videoJuego_xid = new VideoJuego();

		videoJuego_xid = videoJuegoServiceImpl.videoJuegoXID(id);

		System.out.println("VideoJuego XID: " + videoJuego_xid);

		return videoJuego_xid;
	}
	
	@PutMapping("/videojuego/{id}")
	public VideoJuego actualizarVideoJuego(@PathVariable(name="id")Integer id,@RequestBody VideoJuego videoJuego) {
		
		VideoJuego videoJuego_seleccionado= new VideoJuego();
		VideoJuego videoJuego_actualizado= new VideoJuego();
		
		videoJuego_seleccionado= videoJuegoServiceImpl.videoJuegoXID(id);
		
		videoJuego_seleccionado.setNombre(videoJuego.getNombre());
		videoJuego_seleccionado.setGenero(videoJuego.getGenero());
		videoJuego_seleccionado.setPartidas(videoJuego.getPartidas());
		
		videoJuego_actualizado = videoJuegoServiceImpl.actualizarVideoJuego(videoJuego_seleccionado);
		
		System.out.println("El videoJuego actualizado es: "+ videoJuego_actualizado);
		
		return videoJuego_actualizado;
	}
	
	@DeleteMapping("/videojuego/{id}")
	public void eliminarVideoJuego(@PathVariable(name="id")Integer id) {
		videoJuegoServiceImpl.eliminarVideoJuego(id);
	}
}
