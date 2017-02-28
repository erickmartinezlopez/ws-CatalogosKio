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
 * Clase entity para mapear con Hibernate la tabla KIO_SERVICIO_MODALIDAD
 * de base de datos en memoria (H2) para el alta de requerimientos 
 * dentro de KIO-Gestión de requerimientos de nube IMSS
 * */
@Entity
@Table(name = "KIO_SERVICIO_MODALIDAD")
public class ServicioModalidad  implements  RowMapper<ServicioModalidad>,java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1496608971091381144L;
	private Integer idServicioModalidad;
	private Integer idServicio;
	private Integer idModalidad;
	

	public Integer getIdServicioModalidad() {
		return idServicioModalidad;
	}

	public void setIdServicioModalidad(Integer idServicioModalidad) {
		this.idServicioModalidad = idServicioModalidad;
	}

	public Integer getIdServicio() {
		return idServicio;
	}

	public void setIdServicio(Integer idServicio) {
		this.idServicio = idServicio;
	}

	public Integer getIdModalidad() {
		return idModalidad;
	}

	public void setIdModalidad(Integer idModalidad) {
		this.idModalidad = idModalidad;
	}

	@Override
	public ServicioModalidad mapRow(ResultSet rs, int rownum) throws SQLException {
		ServicioModalidad servicioModalidad = new ServicioModalidad();
		servicioModalidad.setIdServicioModalidad(rs.getInt("idServicioModalidad"));
		servicioModalidad.setIdServicio(rs.getInt("idServicio"));
		servicioModalidad.setIdServicioModalidad(rs.getInt("idModalidad"));

		return servicioModalidad;
	}

}
