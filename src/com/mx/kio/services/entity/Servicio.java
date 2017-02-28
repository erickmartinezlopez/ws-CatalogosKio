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
 * Clase entity para mapear con Hibernate la tabla KIO_CATALOGOSERVICIOS
 * de base de datos en memoria (H2) para el alta de requerimientos 
 * dentro de KIO-Gestión de requerimientos de nube IMSS
 * */
@Entity
@Table(name = "KIO_CATALOGOSERVICIOS")
public class Servicio implements java.io.Serializable, RowMapper<Servicio> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3148674546997454773L;
	private Integer idServicio;
	private String tipoServicio;
	private String descripcionServicio;

	public Integer getIdServicio() {
		return idServicio;
	}

	public void setIdServicio(Integer idServicio) {
		this.idServicio = idServicio;
	}

	public String getTipoServicio() {
		return tipoServicio;
	}

	public void setTipoServicio(String tipoServicio) {
		this.tipoServicio = tipoServicio;
	}

	public String getDescripcionServicio() {
		return descripcionServicio;
	}

	public void setDescripcionServicio(String descripcionServicio) {
		this.descripcionServicio = descripcionServicio;
	}

	@Override
	public Servicio mapRow(ResultSet rs, int rowNum) throws SQLException {
		Servicio servicio = new Servicio();
		servicio.setIdServicio(rs.getInt("idServicio"));
		servicio.setTipoServicio(rs.getString("tipoServicio"));
		String descripcionServicio=servicio.getTipoServicio()+"-"+rs.getString("descripcionServicio");
		servicio.setDescripcionServicio(descripcionServicio);
		return servicio;
	}

}
