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

import com.delpozo.dto.Mensaje;

import com.delpozo.service.MensajeServiceImpl;

@RestController
@RequestMapping("/api")
public class MensajeController {

	@Autowired
	MensajeServiceImpl mensajeServiceImpl;

	@GetMapping("/mensaje")
	public List<Mensaje> listarMensaje() {
		return mensajeServiceImpl.listarMensaje();
	}

	@PostMapping("/mensaje")
	public Mensaje salvarMensaje(@RequestBody Mensaje mensaje) {
		return mensajeServiceImpl.guardarMensaje(mensaje);
	}

	@GetMapping("/mensaje/{id}")
	public Mensaje XID(@PathVariable(name = "id") Integer id) {

		Mensaje mensaje_xid = new Mensaje();

		mensaje_xid = mensajeServiceImpl.mensajeXID(id);

		System.out.println("Mensaje XID: " + mensaje_xid);

		return mensaje_xid;
	}
	
	@PutMapping("/mensaje/{id}")
	public Mensaje actualizarMensaje(@PathVariable(name="id")Integer id,@RequestBody Mensaje mensaje) {
		
		Mensaje mensaje_seleccionado= new Mensaje();
		Mensaje mensaje_actualizado= new Mensaje();
		
		mensaje_seleccionado= mensajeServiceImpl.mensajeXID(id);
		
		mensaje_seleccionado.setContenido(mensaje.getContenido());
		mensaje_seleccionado.setFecha_hora(mensaje.getFecha_hora());
		mensaje_seleccionado.setRemitente(mensaje.getRemitente());
		mensaje_seleccionado.setPartida(mensaje.getPartida());
			
		mensaje_actualizado = mensajeServiceImpl.actualizarMensaje(mensaje_seleccionado);
		
		System.out.println("El mensaje actualizado es: "+ mensaje_actualizado);
		
		return mensaje_actualizado;
	}
	
	@DeleteMapping("/mensaje/{id}")
	public void eliminarMensaje(@PathVariable(name="id")Integer id) {
		mensajeServiceImpl.eliminarMensaje(id);
	}
}
