/*
 * Copyright (c) 2017 IIK Technologies 
 * Todos los derechos reservados.
 * Este software contiene información confidencial propiedad de 
 * IIK Technologies
 * Por lo cual no puede ser reproducido, distribuido o 
 * alterado sin el consentimiento previo de IIK Technologies
 */
package com.mx.kio.services.ws;



import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import com.mx.kio.services.business.CatalogoService;
import com.mx.kio.services.utils.Constantes;
import com.mx.kio.services.utils.WSException;

/**
 *Clase principal que contirne las distintas operaciones del servicio rest 
 *dentro del sistema KIO-Gestión de requerimientos de nube IMSS
 **/

@Path("/catalogos")
@Produces({ Constantes.PRODUCES_XML,Constantes.JSON_TYPE })
@Consumes({ Constantes.JSON_TYPE, Constantes.JSON_TYPE })
public class ObtenerCatalogoService extends SpringBeanAutowiringSupport{

	
	@Autowired
	private CatalogoService catalogoService;
	
	/*Obtiene el portafolio de proyectos*/
	@GET
	@Path(Constantes.URL_GET_PORTAFOLIOS)
	@Produces(Constantes.JSON_UTF8)
	public String getCatalogoPortafolioProyectos() {
		String returnCatalogos = null;
		try {
			returnCatalogos=catalogoService.getAllPortafolios();
		} catch (WSException e) {
			returnCatalogos=e.getCausaError();
			e.printStackTrace();
		}
	    return returnCatalogos;
	}
	
	/*Obtiene el catalogo de requerimientos*/
	@GET
	@Path(Constantes.URL_GET_REQUERIMIENTOS)
	@Produces(Constantes.JSON_UTF8)
	public String getCatalogoRequerimientos() {
		String returnRequerimientos = null;
		try {
			returnRequerimientos=catalogoService.getAllRequerimientos();
		} catch (WSException e) {
			returnRequerimientos=e.getMensajeError();
			e.printStackTrace();
		}
	    return returnRequerimientos;
	}
	
	/*Obtiene el catalogo de servicios*/
	@GET
	@Path(Constantes.URL_GET_SERVICIOS)
	@Produces(Constantes.JSON_UTF8)
	public String getCatalogoServicios() {
		String returnServicios = null;
		try {
			returnServicios=catalogoService.getAllServicios();
		} catch (WSException e) {
			returnServicios=e.getMensajeError();
			e.printStackTrace();
		}
	    return returnServicios;
	}
	
	/*Obtiene el catalogo de modalidadaes por servicios*/
	@GET
	@Path(Constantes.URL_GET_SERVICIO_MODALIDAD)
	@Produces(Constantes.JSON_UTF8)
	public String getServicioModalidad(@PathParam(Constantes.TIPO_SERVICIO_PARAM) String tipoServicio) {
		String returnServicios = null;
		try {
			returnServicios=catalogoService.getServicioModalidadByName(tipoServicio);
		} catch (WSException e) {
			returnServicios=e.getMensajeError();
			e.printStackTrace();
		}
	    return returnServicios;
	}
	
	/*Obtiene los bloques de construccion por modadlidad*/
	@GET
	@Path(Constantes.URL_GET_MODALIDAD_BLOQUE)
	@Produces(Constantes.JSON_UTF8)
	public String getBloqueConstruccion(@PathParam(Constantes.TIPO_MODALIDAD_PARAM) String tipoModalidad) {
		String returnBloqueConstruccion = null;
		try {
			returnBloqueConstruccion=catalogoService.getBloqueConstruccionByName(tipoModalidad);
		} catch (WSException e) {
			returnBloqueConstruccion=e.getMensajeError();
			e.printStackTrace();
		}
	    return returnBloqueConstruccion;
	}
}
