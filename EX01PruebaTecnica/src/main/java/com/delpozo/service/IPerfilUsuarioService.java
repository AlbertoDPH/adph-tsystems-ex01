package com.delpozo.service;

import java.util.List;

import com.delpozo.dto.PerfilUsuario;


public interface IPerfilUsuarioService {

	public List<PerfilUsuario> listarPerfilUsuario(); // Listar All

	public PerfilUsuario guardarPerfilUsuario(PerfilUsuario perfilUsuario); // Guarda un perfilUsuario CREATE

	public PerfilUsuario perfilUsuarioXID(Integer id); // Leer datos de un perfilUsuario READ

	public PerfilUsuario actualizarPerfilUsuario(PerfilUsuario perfilUsuario); // Actualiza datos del perfilUsuario UPDATE

	public void eliminarPerfilUsuario(Integer id);// Elimina el perfilUsuario DELETE

}
