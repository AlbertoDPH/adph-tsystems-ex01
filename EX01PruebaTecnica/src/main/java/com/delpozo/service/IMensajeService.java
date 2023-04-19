package com.delpozo.service;

import java.util.List;

import com.delpozo.dto.Mensaje;

public interface IMensajeService{

	public List<Mensaje> listarMensaje(); // Listar All

	public Mensaje guardarMensaje(Mensaje mensaje); // Guarda un mensaje CREATE

	public Mensaje mensajeXID(Integer id); // Leer datos de un mensaje READ

	public Mensaje actualizarMensaje(Mensaje mensaje); // Actualiza datos del mensaje UPDATE

	public void eliminarMensaje(Integer id);// Elimina el mensaje DELETE

}
