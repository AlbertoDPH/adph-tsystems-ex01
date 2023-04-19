package com.delpozo.service;

import java.util.List;

import com.delpozo.dto.Usuario;

public interface IUsuarioService {

	public List<Usuario> listarUsuario(); // Listar All

	public Usuario guardarUsuario(Usuario usuario); // Guarda un usuario CREATE

	public Usuario usuarioXID(Integer id); // Leer datos de un usuario READ

	public Usuario actualizarUsuario(Usuario articulo); // Actualiza datos del usuario UPDATE

	public void eliminarUsuario(Integer id);// Elimina el usuario DELETE

}
