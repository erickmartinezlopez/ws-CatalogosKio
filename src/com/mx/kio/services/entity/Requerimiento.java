/*
 * Copyright (c) 2017 IIK Technologies 
 * Todos los derechos reservados.
 * Este software contiene información confidencial propiedad de 
 * IIK Technologies
 * Por lo cual no puede ser reproducido, distribuido o 
 * alterado sin el consentimiento previo de IIK Technologies
 */
package com.mx.kio.services.entity;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.springframework.jdbc.core.RowMapper;

/**
 * Clase entity para mapear con Hibernate la tabla KIO_CATALOGOREQUERIMIENTOS
 * de base de datos en memoria (H2) para el alta de requerimientos 
 * dentro de KIO-Gestión de requerimientos de nube IMSS
 * */
@Entity
@Table(name="KIO_CATALOGOREQUERIMIENTOS")
public class Requerimiento implements Serializable,RowMapper<Requerimiento>{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7454994602265038825L;
	
	private Integer id;
	private String nombreRequerimiento;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNombreRequerimiento() {
		return nombreRequerimiento;
	}
	public void setNombreRequerimiento(String nombreRequerimiento) {
		this.nombreRequerimiento = nombreRequerimiento;
	}
	
	/*Mappers*/
	 
	@Override
		public Requerimiento mapRow(ResultSet rs, int rowNum) throws SQLException {
			Requerimiento requerimiento = new Requerimiento();
			requerimiento.setId(rs.getInt("id"));
			requerimiento.setNombreRequerimiento(rs.getString("nombreRequerimiento"));
			return requerimiento;
		}
	

}
