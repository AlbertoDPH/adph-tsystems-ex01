package com.delpozo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.delpozo.dto.Partida;

/**
 * 
 * @author Alberto
 *
 */
public interface IPartidaDAO extends JpaRepository<Partida, Integer> {

}
