package com.delpozo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.delpozo.dto.Mensaje;


/**
 * 
 * @author Alberto
 *
 */
public interface IMensajeDAO extends JpaRepository<Mensaje, Integer> {

}
