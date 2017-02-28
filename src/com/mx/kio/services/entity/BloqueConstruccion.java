/*
 * Copyright (c) 2017 IIK Technologies 
 * Todos los derechos reservados.
 * Este software contiene información confidencial propiedad de 
 * IIK Technologies
 * Por lo cual no puede ser reproducido, distribuido o 
 * alterado sin el consentimiento previo de IIK Technologies
 */
package com.mx.kio.services.entity;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.springframework.jdbc.core.RowMapper;

/**
 * Clase entity para mapear con Hibernate la tabla KIO_CATALOGOBLOQUECONSTRUCCION
 * de base de datos en memoria (H2) para el alta de requerimientos 
 * dentro de KIO-Gestión de requerimientos de nube IMSS
 * */
@Entity
@Table(name="KIO_CATALOGOBLOQUECONSTRUCCION")
public class BloqueConstruccion implements java.io.Serializable, RowMapper<BloqueConstruccion> {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1103396006007969819L;
	private Integer idBloqueContruccion;
	private String nombreBloque;
	private String descripcionBloque;
	
	
	public Integer getIdBloqueContruccion() {
		return idBloqueContruccion;
	}
	public void setIdBloqueContruccion(Integer idBloqueContruccion) {
		this.idBloqueContruccion = idBloqueContruccion;
	}
	public String getNombreBloque() {
		return nombreBloque;
	}
	public void setNombreBloque(String nombreBloque) {
		this.nombreBloque = nombreBloque;
	}
	
	public String getDescripcionBloque() {
		return descripcionBloque;
	}
	public void setDescripcionBloque(String descripcionBloque) {
		this.descripcionBloque = descripcionBloque;
	}
	@Override
	public BloqueConstruccion mapRow(ResultSet rs, int rowNum) throws SQLException {
		BloqueConstruccion bloqueConstruccion= new BloqueConstruccion();
		bloqueConstruccion.setIdBloqueContruccion(rs.getInt("idBloqueContruccion"));
		bloqueConstruccion.setNombreBloque(rs.getString("nombreBloque"));
		bloqueConstruccion.setDescripcionBloque(rs.getString("descripcionBloque"));
		return bloqueConstruccion;
	}
	
	
	
	
	

}
