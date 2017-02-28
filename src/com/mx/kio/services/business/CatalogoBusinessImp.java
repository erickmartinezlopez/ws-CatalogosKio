/*
 * Copyright (c) 2017 IIK Technologies 
 * Todos los derechos reservados.
 * Este software contiene información confidencial propiedad de 
 * IIK Technologies
 * Por lo cual no puede ser reproducido, distribuido o 
 * alterado sin el consentimiento previo de IIK Technologies
 */

/**
 * @author erick.ml
 * */
package com.mx.kio.services.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mx.kio.services.dao.CatalogosRepository;
import com.mx.kio.services.entity.BloqueConstruccion;
import com.mx.kio.services.entity.Modalidad;
import com.mx.kio.services.entity.Portafolio;
import com.mx.kio.services.entity.Requerimiento;
import com.mx.kio.services.entity.Servicio;
import com.mx.kio.services.utils.Constantes;
import com.mx.kio.services.utils.WSException;

/***
 * Clase de negocio encargada de obtener los catalogos para la alta de
 * requerimientos dentro de la aplicacion de KIO-Gestión de requerimientos de nube IMSS
 */

@Service("catalogoService")
public class CatalogoBusinessImp implements CatalogoService {

	@Autowired
	private CatalogosRepository catalogosDAO;

	private List<Portafolio> listCatalogoPortafolio;

	private List<Requerimiento> listRequerimientos;

	private List<Servicio> listServicio;

	private List<Modalidad> listModalidad;

	private List<BloqueConstruccion> listBloqueConstruccion;

	/**
	 * Metodo que obtiene el catalogo de portafolios
	 * @return JSON catalogoPortafolio
	 **/
	@Override
	public String getAllPortafolios() throws WSException {
		String catalogoPortafolio = null;
		try {
			listCatalogoPortafolio = catalogosDAO.findAllPortafolios();
			if (!listCatalogoPortafolio.isEmpty()) {
				ObjectMapper mapper = new ObjectMapper();
				catalogoPortafolio = mapper.writeValueAsString(listCatalogoPortafolio);
			}
		} catch (JsonProcessingException e) {
			e.printStackTrace();
			throw new WSException(Constantes.SIN_REGISTROS, e.getCause());
		}
		return catalogoPortafolio;
	}

	/**
	 * Metodo que obtiene el catalogo de requerimientos
	 * @return JSON catalogoRequerimientos
	 **/
	@Override
	public String getAllRequerimientos() throws WSException {
		String catalogoRequerimientos = Constantes.SIN_REGISTROS;
		try {
			listRequerimientos = catalogosDAO.findAllRequerimientos();
			/* Obt */
			ObjectMapper mapper = new ObjectMapper();
			if (!listRequerimientos.isEmpty()) {
				catalogoRequerimientos = mapper.writeValueAsString(listRequerimientos);
			}
		} catch (JsonProcessingException e) {
			e.printStackTrace();
			throw new WSException(Constantes.SIN_REGISTROS, e.getCause());
		}
		return catalogoRequerimientos;
	}

	/**
	 * Metodo que obtiene el catalogo de servicios
	 * @return JSON catalogoServicios
	 **/
	@Override
	public String getAllServicios() throws WSException {
		String catalogoServicios = Constantes.SIN_REGISTROS;
		try {
			listServicio = catalogosDAO.findAllServicios();
			if (!listServicio.isEmpty()) {
				ObjectMapper mapper = new ObjectMapper();
				catalogoServicios = mapper.writeValueAsString(listServicio);
			}

		} catch (JsonProcessingException e) {
			e.printStackTrace();
			throw new WSException(Constantes.SIN_REGISTROS, e.getCause());
		}

		return catalogoServicios;
	}

	/**
	 * Metodo que obtiene las modalidades por servicio registrado
	 * @param String tipoServicio
	 * @return JSON servicioModalidad
	 **/
	@Override
	public String getServicioModalidadByName(String tipoServicio) throws WSException {
		String servicioModalidad = Constantes.SIN_REGISTROS;
		try {
			listModalidad = catalogosDAO.findServicioModalidadByName(tipoServicio);
			if (!listModalidad.isEmpty()) {
				ObjectMapper mapper = new ObjectMapper();
				servicioModalidad = mapper.writeValueAsString(listModalidad);
			}
		} catch (JsonProcessingException e) {
			e.printStackTrace();
			throw new WSException(Constantes.SIN_REGISTROS, e.getCause());
		}

		return servicioModalidad;
	}

	/**
	 * Metodo que obtiene los bloques de construcción por modalidad registrada
	 * @param String tipoModadlidad
	 * @return JSON bloqueConstruccion
	 **/
	@Override
	public String getBloqueConstruccionByName(String tipoModadlidad) throws WSException {
		String bloqueConstruccion = Constantes.SIN_REGISTROS;
		try {
			listBloqueConstruccion = catalogosDAO.findBloqueByIdModalidad(tipoModadlidad);
			if (!listBloqueConstruccion.isEmpty()) {
				ObjectMapper mapper = new ObjectMapper();
				bloqueConstruccion = mapper.writeValueAsString(listBloqueConstruccion);
			}
		} catch (JsonProcessingException e) {
			e.printStackTrace();
			throw new WSException(Constantes.SIN_REGISTROS, e.getCause());
		}

		return bloqueConstruccion;
	}

}
