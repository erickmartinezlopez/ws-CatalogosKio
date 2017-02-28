/*
 * Copyright (c) 2017 IIK Technologies 
 * Todos los derechos reservados.
 * Este software contiene información confidencial propiedad de 
 * IIK Technologies
 * Por lo cual no puede ser reproducido, distribuido o 
 * alterado sin el consentimiento previo de IIK Technologies
 */
package com.mx.kio.services.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.mx.kio.services.entity.BloqueConstruccion;
import com.mx.kio.services.entity.Modalidad;
import com.mx.kio.services.entity.Portafolio;
import com.mx.kio.services.entity.Requerimiento;
import com.mx.kio.services.entity.Servicio;
import com.mx.kio.services.utils.Constantes;

/**
 *Clase encargada de obtener la información de la base de datos
 *configurada en memoria (H2) para el alta de requerimientos 
 *dentro de KIO-Gestión de requerimientos de nube IMSS
 **/
@Repository("catalogosDAO")
public class CatalogosRepositoryImpl implements CatalogosRepository {
	
	
	/*Instancia de clase que realizara la inyeccion para el driver de la base de datos en memoria*/
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	@Autowired
	public void setNamedParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
		this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
	}

	/**
	 **Metodo para obtener el catalogo de portafolios de la tabla KIO_CATALOGOPORTAFOLIO
	 *@author erick.ml
	 *@return List<Portafolio>
	 **/
	@Override
	public List<Portafolio> findAllPortafolios() {
		Map<String, Object> params = new HashMap<String, Object>();
		String sql = Constantes.SQLPORTAFILIO;
		List<Portafolio> result = namedParameterJdbcTemplate.query(sql, params, new Portafolio());
		return result;
	}


	/**
	 **Metodo para obtener el catalogo de requerimientos de la tabla KIO_CATALOGOREQUERIMIENTOS
	 *@author erick.ml
	 *@return List<Requerimiento>
	 **/
	@Override
	public List<Requerimiento> findAllRequerimientos() {
		Map<String, Object> params = new HashMap<String, Object>();
		String sql = Constantes.SQLREQUERIMIENTO;
		List<Requerimiento> result = namedParameterJdbcTemplate.query(sql, params, new Requerimiento());
		return result;
	}
	
	/**
	 **Metodo para obtener el catalogo de servicios de la tabla KIO_CATALOGOSERVICIOS
	 *@author erick.ml
	 *@return List<Servicio>
	 **/
	@Override
	public List<Servicio> findAllServicios() {
		Map<String, Object> params = new HashMap<String, Object>();
		String sql = Constantes.SQLSERVICIOS;
		List<Servicio> result = namedParameterJdbcTemplate.query(sql, params, new Servicio());
		return result;
	}

	/**
	 **Metodo para obtener el catalogo entre el cruce de las tablas KIO_CATALOGOSERVICIOS,KIO_SERVICIO_MODALIDAD y KIO_CATALOGOSERVICIOS
	 *@author erick.ml
	 *@return List<Modalidad>
	 **/
	@Override
	public List<Modalidad> findServicioModalidadByName(String tipoServicio) {
		Map<String, Object> params = new HashMap<String, Object>();
		String sql = Constantes.SQLServicioModalidadByName;
		params.put(Constantes.TIPOSERVICIO, tipoServicio);
		List<Modalidad> result = namedParameterJdbcTemplate.query(sql, params, new Modalidad());
		return result;
	}

	/**
	 **Metodo para obtener el catalogo entre el cruce de las tablas KIO_CATALOGOBLOQUECONSTRUCCION, KIO_CATALOGOMODALIDAD y KIO_MODALIDAD_BLOQUE
	 *@author erick.ml
	 *@return List<BloqueConstruccion>
	 **/
	@Override
	public List<BloqueConstruccion> findBloqueByIdModalidad(String tipoModalidad) {
		Map<String, Object> params = new HashMap<String, Object>();
		String sql = Constantes.SQLBloqueConstruccionByName;
		params.put(Constantes.TIPOMODALIDAD, tipoModalidad);
		List<BloqueConstruccion> result = namedParameterJdbcTemplate.query(sql, params, new BloqueConstruccion());
		return result;
	}

	

}
