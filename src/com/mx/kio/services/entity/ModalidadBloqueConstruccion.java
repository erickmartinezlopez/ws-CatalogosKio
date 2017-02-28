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
* Clase entity para mapear con Hibernate la tabla KIO_MODALIDAD_BLOQUE
* de base de datos en memoria (H2) para el alta de requerimientos 
* dentro de KIO-Gestión de requerimientos de nube IMSS
* */
@Entity
@Table(name = "KIO_MODALIDAD_BLOQUE")
public class ModalidadBloqueConstruccion implements RowMapper<ModalidadBloqueConstruccion>, java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1496608971091381144L;
	private Integer idModalidadBloque;
	private Integer idModalidad;
	private Integer idBloqueContruccion;

	public Integer getIdModalidadBloque() {
		return idModalidadBloque;
	}

	public void setIdModalidadBloque(Integer idModalidadBloque) {
		this.idModalidadBloque = idModalidadBloque;
	}

	public Integer getIdModalidad() {
		return idModalidad;
	}

	public void setIdModalidad(Integer idModalidad) {
		this.idModalidad = idModalidad;
	}

	public Integer getIdBloqueContruccion() {
		return idBloqueContruccion;
	}

	public void setIdBloqueContruccion(Integer idBloqueContruccion) {
		this.idBloqueContruccion = idBloqueContruccion;
	}

	@Override
	public ModalidadBloqueConstruccion mapRow(ResultSet rs, int rowNum) throws SQLException {
		ModalidadBloqueConstruccion modalidadBloque=new ModalidadBloqueConstruccion();
		modalidadBloque.setIdBloqueContruccion(idBloqueContruccion);
		modalidadBloque.setIdModalidad(idModalidad);
		modalidadBloque.setIdModalidadBloque(idModalidadBloque);
		
		return null;
	}

}
