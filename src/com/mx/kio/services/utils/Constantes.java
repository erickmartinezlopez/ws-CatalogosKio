/*
 * Copyright (c) 2017 IIK Technologies 
 * Todos los derechos reservados.
 * Este software contiene información confidencial propiedad de 
 * IIK Technologies
 * Por lo cual no puede ser reproducido, distribuido o 
 * alterado sin el consentimiento previo de IIK Technologies
 */
package com.mx.kio.services.utils;

/**
 *Clase que contiene constantes del servicio web para distintas operaciones dentro del sistema KIO-Gestión de requerimientos de nube IMSS
 **/
public class Constantes {
	
	
	/*Constantes para las URL's del servicio REST*/
	public static final String PRODUCES_XML="application/xml";
	
	public static final String JSON_TYPE="application/json";
	
	public static final String JSON_UTF8="application/json;charset=UTF-8";
	
	public static final String URL_GET_PORTAFOLIOS="/getPortafolioProyectos";
	
	public static final String URL_GET_REQUERIMIENTOS="/getRequerimientos";
	
	public static final String URL_GET_SERVICIOS="/getServicios";
	
	public static final String URL_GET_SERVICIO_MODALIDAD="/getServicioModalidad/{tipoServicio}";
	
	public static final String URL_GET_MODALIDAD_BLOQUE="/getBloqueContruccion/{tipoModalidad}";
	
	public static final String TIPO_SERVICIO_PARAM="tipoServicio";
	
	public static final String TIPO_MODALIDAD_PARAM="tipoModalidad";
	
	

	/*Constantes para mensajes respuesta*/
	public static final String SIN_REGISTROS="No hay registros para mostrar";
	
	/*Consultas para obtener los catalogos*/
	
	public static final String SQLPORTAFILIO="SELECT * FROM KIO_CATALOGOPORTAFOLIO ORDER BY NOMBREPROYECTO ASC";
	public static final String SQLREQUERIMIENTO="SELECT * FROM KIO_CATALOGOREQUERIMIENTOS ORDER BY NOMBREREQUERIMIENTO ASC";
	public static final String SQLSERVICIOS="SELECT * FROM KIO_CATALOGOSERVICIOS ORDER BY TIPOSERVICIO ASC";
	
	public static final String SQLServicioModalidadByName= " SELECT * FROM KIO_CATALOGOMODALIDAD cm, KIO_CATALOGOSERVICIOS cs, KIO_SERVICIO_MODALIDAD sm"+
															" WHERE sm.idServicio =cs. idServicio" +
															" AND   sm. idModalidad=cm.idModalidad" +
															" AND cs. tipoServicio= :TIPOSERVICIO";
	
	public static final String SQLBloqueConstruccionByName=" SELECT * FROM KIO_CATALOGOBLOQUECONSTRUCCION cb, KIO_CATALOGOMODALIDAD cm, KIO_MODALIDAD_BLOQUE mb"+
															" WHERE mb.idModalidad=cm.idModalidad" +
															" AND mb.idBloqueContruccion=cb.idBloqueContruccion" +
															" AND cm.tipoModalidad = :TIPOMODALIDAD";
	
	/*Constantes para consultas a la base de datos*/
	public static final String TIPOSERVICIO="TIPOSERVICIO";
	public static final String TIPOMODALIDAD="TIPOMODALIDAD";
}
