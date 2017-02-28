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
 * Clase entity para mapear con Hibernate la tabla KIO_CATALOGOPORTAFOLIO
 * de base de datos en memoria (H2) para el alta de requerimientos 
 * dentro de KIO-Gestión de requerimientos de nube IMSS
 * */
@Entity
@Table(name="KIO_CATALOGOPORTAFOLIO")
public class Portafolio implements Serializable,RowMapper<Portafolio>{
	
	
	private static final long serialVersionUID = -2309973883552484298L;
	
	private Integer id;
	private String nombreProyecto;
	private String responsableProyecto;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNombreProyecto() {
		return nombreProyecto;
	}
	public void setNombreProyecto(String nombreProyecto) {
		this.nombreProyecto = nombreProyecto;
	}
	public String getResponsableProyecto() {
		return responsableProyecto;
	}
	public void setResponsableProyecto(String responsableProyecto) {
		this.responsableProyecto = responsableProyecto;
	}
	
	/*Mappers*/
	 
	@Override
		public Portafolio mapRow(ResultSet rs, int rowNum) throws SQLException {
			Portafolio portafolio = new Portafolio();
			portafolio.setId(rs.getInt("id"));
			portafolio.setNombreProyecto(rs.getString("nombreProyecto"));
			portafolio.setResponsableProyecto(rs.getString("responsableProyecto"));

			return portafolio;
		}

	
	 
	
	

}
