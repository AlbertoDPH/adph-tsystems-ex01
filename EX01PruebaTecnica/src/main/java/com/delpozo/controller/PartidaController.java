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

import com.delpozo.dto.Partida;

import com.delpozo.service.PartidaServiceImpl;

@RestController
@RequestMapping("/api")
public class PartidaController {

	@Autowired
	PartidaServiceImpl partidaServiceImpl;

	@GetMapping("/partida")
	public List<Partida> listarPartida() {
		return partidaServiceImpl.listarPartida();
	}

	@PostMapping("/partida")
	public Partida salvarPartida(@RequestBody Partida partida) {
		return partidaServiceImpl.guardarPartida(partida);
	}

	@GetMapping("/partida/{id}")
	public Partida XID(@PathVariable(name = "id") Integer id) {

		Partida partida_xid = new Partida();

		partida_xid = partidaServiceImpl.partidaXID(id);

		System.out.println("Partida XID: " + partida_xid);

		return partida_xid;
	}
	
	@PutMapping("/partida/{id}")
	public Partida actualizarPartida(@PathVariable(name="id")Integer id,@RequestBody Partida partida) {
		
		Partida partida_seleccionado= new Partida();
		Partida partida_actualizado= new Partida();
		
		partida_seleccionado= partidaServiceImpl.partidaXID(id);
		
		partida_seleccionado.setVideoJuego(partida.getVideoJuego());
			
		partida_actualizado = partidaServiceImpl.actualizarPartida(partida_seleccionado);
		
		System.out.println("El partida actualizado es: "+ partida_actualizado);
		
		return partida_actualizado;
	}
	
	@DeleteMapping("/partida/{id}")
	public void eliminarPartida(@PathVariable(name="id")Integer id) {
		partidaServiceImpl.eliminarPartida(id);
	}
}
