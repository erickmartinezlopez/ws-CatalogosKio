/*
 * Copyright (c) 2017 IIK Technologies 
 * Todos los derechos reservados.
 * Este software contiene información confidencial propiedad de 
 * IIK Technologies
 * Por lo cual no puede ser reproducido, distribuido o 
 * alterado sin el consentimiento previo de IIK Technologies
 */
package com.mx.kio.services.dao;

import java.util.List;

import com.mx.kio.services.entity.BloqueConstruccion;
import com.mx.kio.services.entity.Modalidad;
import com.mx.kio.services.entity.Portafolio;
import com.mx.kio.services.entity.Requerimiento;
import com.mx.kio.services.entity.Servicio;
import com.mx.kio.services.utils.WSException;

/**
 * Interface que contiene los metodos para obtener los catalogos 
 * del base de datos en memoria (H2) para el alta de requerimientos 
 * dentro de KIO-Gestión de requerimientos de nube IMSS
 * */
public interface CatalogosRepository {
	
	/*Obtiene los catalogos de los portafolios de requerimientos */
	List<Portafolio> findAllPortafolios() throws WSException;
	/*Obtiene los catalogos de los requerimientos */
	List<Requerimiento> findAllRequerimientos() throws WSException;
	/*Obtiene los catalogos de servicios registrados */
	List<Servicio> findAllServicios() throws WSException;
	/*Obtiene el servicio modalidad recibiendo como parametro el nombre del servicio*/
	List<Modalidad> findServicioModalidadByName(String tipoServicio) throws WSException;
	/*Obtiene el bloque de construccion recibiendo como parametro el tipo de modalidad*/
	List<BloqueConstruccion> findBloqueByIdModalidad(String tipoModalidad) throws WSException;

}
