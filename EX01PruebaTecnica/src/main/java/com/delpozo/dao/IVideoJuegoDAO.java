package com.delpozo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.delpozo.dto.VideoJuego;


/**
 * 
 * @author Alberto
 *
 */
public interface IVideoJuegoDAO extends JpaRepository<VideoJuego, Integer> {

}
