/*
 * Copyright (c) 2017 IIK Technologies 
 * Todos los derechos reservados.
 * Este software contiene información confidencial propiedad de 
 * IIK Technologies
 * Por lo cual no puede ser reproducido, distribuido o 
 * alterado sin el consentimiento previo de IIK Technologies
 */
package com.mx.kio.services.business;

import com.mx.kio.services.utils.WSException;

/**
 * Interface que contiene las operaciones para obtener los catalogos
 * para el alta de requerimientos dentro de KIO-Gestión de requerimientos de nube IMSS
 * */
public interface CatalogoService {
	
	/*Obtiene el catalogo de portafolios*/
	String getAllPortafolios() throws WSException;
	
	/*Obtiene el catalogo de requerimientos*/
	String getAllRequerimientos() throws WSException;
	
	/*Obtiene el catalogo de Servicios*/
	String getAllServicios() throws WSException;
	
	/*Obtiene las modalidades asignadas a cada servicio*/
	String getServicioModalidadByName(String tipoServicio) throws WSException;
	
	/*Obtiene los bloques de construccion*/
	String getBloqueConstruccionByName(String tipoModadlidad) throws WSException;
}
