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

import com.delpozo.dto.Usuario;
import com.delpozo.service.UsuarioServiceImpl;

@RestController
@RequestMapping("/api")
public class UsuarioController {

	@Autowired
	UsuarioServiceImpl usuarioServiceImpl;

	@GetMapping("/usuario")
	public List<Usuario> listarUsuario() {
		return usuarioServiceImpl.listarUsuario();
	}

	@PostMapping("/usuario")
	public Usuario salvarUsuario(@RequestBody Usuario usuario) {
		return usuarioServiceImpl.guardarUsuario(usuario);
	}

	@GetMapping("/usuario/{id}")
	public Usuario XID(@PathVariable(name = "id") Integer id) {

		Usuario usuario_xid = new Usuario();

		usuario_xid = usuarioServiceImpl.usuarioXID(id);

		System.out.println("Usuario XID: " + usuario_xid);

		return usuario_xid;
	}
	
	@PutMapping("/usuario/{id}")
	public Usuario actualizarUsuario(@PathVariable(name="id")Integer id,@RequestBody Usuario usuario) {
		
		Usuario usuario_seleccionado= new Usuario();
		Usuario usuario_actualizado= new Usuario();
		
		usuario_seleccionado= usuarioServiceImpl.usuarioXID(id);
		
		usuario_seleccionado.setNombre_usuario(usuario.getNombre_usuario());
		usuario_seleccionado.setEmail(usuario.getEmail());
		usuario_seleccionado.setPassword(usuario.getPassword());
			
		usuario_actualizado = usuarioServiceImpl.actualizarUsuario(usuario_seleccionado);
		
		System.out.println("El usuario actualizado es: "+ usuario_actualizado);
		
		return usuario_actualizado;
	}
	
	@DeleteMapping("/usuario/{id}")
	public void eliminarUsuario(@PathVariable(name="id")Integer id) {
		usuarioServiceImpl.eliminarUsuario(id);
	}
}
