package com.delpozo.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.delpozo.dao.IVideoJuegoDAO;
import com.delpozo.dto.VideoJuego;

@Service
public class VideoJuegoServiceImpl implements IVideoJuegoService {
	
	@Autowired
	IVideoJuegoDAO iVideoJuegoDAO;

	@Override
	public List<VideoJuego> listarVideoJuego() {
		
		return iVideoJuegoDAO.findAll();
	}

	@Override
	public VideoJuego guardarVideoJuego(VideoJuego videoJuego) {
		
		return iVideoJuegoDAO.save(videoJuego);
	}

	@Override
	public VideoJuego videoJuegoXID(Integer id) {
		
		return iVideoJuegoDAO.findById(id).get();
	}

	@Override
	public VideoJuego actualizarVideoJuego(VideoJuego videoJuego) {
		
		return iVideoJuegoDAO.save(videoJuego);
	}

	@Override
	public void eliminarVideoJuego(Integer id) {
		
		iVideoJuegoDAO.deleteById(id);
	}


}
