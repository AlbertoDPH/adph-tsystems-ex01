package com.delpozo.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.delpozo.dao.IPartidaDAO;
import com.delpozo.dto.Partida;

@Service
public class PartidaServiceImpl implements IPartidaService {
	
	@Autowired
	IPartidaDAO iPartidaDAO;

	@Override
	public List<Partida> listarPartida() {
		
		return iPartidaDAO.findAll();
	}

	@Override
	public Partida guardarPartida(Partida perfilUsuario) {
		
		return iPartidaDAO.save(perfilUsuario);
	}

	@Override
	public Partida partidaXID(Integer id) {
		
		return iPartidaDAO.findById(id).get();
	}

	@Override
	public Partida actualizarPartida(Partida perfilUsuario) {
		
		return iPartidaDAO.save(perfilUsuario);
	}

	@Override
	public void eliminarPartida(Integer id) {
		
		iPartidaDAO.deleteById(id);
	}


}
