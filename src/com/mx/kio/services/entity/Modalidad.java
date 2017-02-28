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
 * Clase entity para mapear con Hibernate la tabla KIO_CATALOGOMODALIDAD
 * de base de datos en memoria (H2) para el alta de requerimientos 
 * dentro de KIO-Gestión de requerimientos de nube IMSS
 * */
@Entity
@Table(name = "KIO_CATALOGOMODALIDAD")
public class Modalidad implements java.io.Serializable, RowMapper<Modalidad> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 574700798572461701L;
	private Integer idModalidad;
	private String tipoModalidad;
	private String descripcionModalidad;


	

	public Integer getIdModalidad() {
		return idModalidad;
	}

	public void setIdModalidad(Integer idModalidad) {
		this.idModalidad = idModalidad;
	}

	public String getTipoModalidad() {
		return tipoModalidad;
	}

	public void setTipoModalidad(String tipoModalidad) {
		this.tipoModalidad = tipoModalidad;
	}

	
	
	public String getDescripcionModalidad() {
		return descripcionModalidad;
	}

	public void setDescripcionModalidad(String descripcionModalidad) {
		this.descripcionModalidad = descripcionModalidad;
	}

	@Override
	public Modalidad mapRow(ResultSet rs, int rowNums) throws SQLException {
		Modalidad modalidad = new Modalidad();
		modalidad.setIdModalidad(rs.getInt("idModalidad"));
		modalidad.setTipoModalidad(rs.getString("tipoModalidad"));
		modalidad.setDescripcionModalidad(rs.getString("descripcionModalidad"));
		String descripcionModalidad=modalidad.getTipoModalidad()+"-"+modalidad.getDescripcionModalidad();
		modalidad.setDescripcionModalidad(descripcionModalidad);
		
		
		return modalidad;
	}

}
