package com.delpozo.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.delpozo.dao.IPerfilUsuarioDAO;
import com.delpozo.dto.PerfilUsuario;

@Service
public class PerfilUsuarioServiceImpl implements IPerfilUsuarioService {
	
	@Autowired
	IPerfilUsuarioDAO iPerfilUsuarioDAO;

	@Override
	public List<PerfilUsuario> listarPerfilUsuario() {
		
		return iPerfilUsuarioDAO.findAll();
	}

	@Override
	public PerfilUsuario guardarPerfilUsuario(PerfilUsuario perfilUsuario) {
		
		return iPerfilUsuarioDAO.save(perfilUsuario);
	}

	@Override
	public PerfilUsuario perfilUsuarioXID(Integer id) {
		
		return iPerfilUsuarioDAO.findById(id).get();
	}

	@Override
	public PerfilUsuario actualizarPerfilUsuario(PerfilUsuario perfilUsuario) {
		
		return iPerfilUsuarioDAO.save(perfilUsuario);
	}

	@Override
	public void eliminarPerfilUsuario(Integer id) {
		
		iPerfilUsuarioDAO.deleteById(id);
	}

}
