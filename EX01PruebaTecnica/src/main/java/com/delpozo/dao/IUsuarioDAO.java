package com.delpozo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.delpozo.dto.Usuario;

/**
 * 
 * @author Alberto
 *
 */
public interface IUsuarioDAO extends JpaRepository<Usuario, Integer> {

}
