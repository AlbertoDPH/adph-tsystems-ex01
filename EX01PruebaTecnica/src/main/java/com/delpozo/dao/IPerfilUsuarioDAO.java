package com.delpozo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.delpozo.dto.PerfilUsuario;


/**
 * 
 * @author Alberto
 *
 */
public interface IPerfilUsuarioDAO extends JpaRepository<PerfilUsuario, Integer> {

}
