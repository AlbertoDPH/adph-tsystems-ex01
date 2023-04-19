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

import com.delpozo.dto.PerfilUsuario;

import com.delpozo.service.PerfilUsuarioServiceImpl;

@RestController
@RequestMapping("/api")
public class PerfilUsuarioController {

	@Autowired
	PerfilUsuarioServiceImpl perfilUsuarioServiceImpl;

	@GetMapping("/perfil_usuario")
	public List<PerfilUsuario> listarPerfilUsuario() {
		return perfilUsuarioServiceImpl.listarPerfilUsuario();
	}

	@PostMapping("/perfil_usuario")
	public PerfilUsuario salvarPerfilUsuario(@RequestBody PerfilUsuario perfil_usuario) {
		return perfilUsuarioServiceImpl.guardarPerfilUsuario(perfil_usuario);
	}

	@GetMapping("/perfil_usuario/{id}")
	public PerfilUsuario XID(@PathVariable(name = "id") Integer id) {

		PerfilUsuario perfilUsuario_xid = new PerfilUsuario();

		perfilUsuario_xid = perfilUsuarioServiceImpl.perfilUsuarioXID(id);

		System.out.println("PerfilUsuario XID: " + perfilUsuario_xid);

		return perfilUsuario_xid;
	}
	
	@PutMapping("/perfil_usuario/{id}")
	public PerfilUsuario actualizarPerfilUsuario(@PathVariable(name="id")Integer id,@RequestBody PerfilUsuario perfil_usuario) {
		
		PerfilUsuario perfilUsuario_seleccionado= new PerfilUsuario();
		PerfilUsuario perfilUsuario_actualizado= new PerfilUsuario();
		
		perfilUsuario_seleccionado= perfilUsuarioServiceImpl.perfilUsuarioXID(id);
		
		perfilUsuario_seleccionado.setNombre_jugador(perfil_usuario.getNombre_jugador());
		perfilUsuario_seleccionado.setUsuario(perfil_usuario.getUsuario());
			
		perfilUsuario_actualizado = perfilUsuarioServiceImpl.actualizarPerfilUsuario(perfilUsuario_seleccionado);
		
		System.out.println("El Perfil Usuario actualizado es: "+ perfilUsuario_actualizado);
		
		return perfilUsuario_actualizado;
	}
	
	@DeleteMapping("/perfil_usuario/{id}")
	public void eliminarPerfilUsuario(@PathVariable(name="id")Integer id) {
		perfilUsuarioServiceImpl.eliminarPerfilUsuario(id);
	}
}
