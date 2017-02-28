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
 *Clase personalizada para el manejo de excepciones dentro del sistema KIO-Gestión de requerimientos de nube IMSS
 **/
public class WSException extends Throwable {

	
	private static final long serialVersionUID = 8704940885455552431L;
	private String mensajeError;
	private String causaError;

	/*
	 * Constructor.
	 * 
	 * @param mensaje Mensaje de la exception.
	 * 
	 * @param causa Exception original.
	 */

	/**
	 * Constructor.
	 * 
	 * @param causa
	 *            Exception original.
	 */
	public WSException(Throwable mensajeError) {
		super(mensajeError);

	}

	

	public WSException(String mensajeError, String causaError) {
		this.causaError = mensajeError;
		this.mensajeError = mensajeError;
	}

	public WSException(String mensajeError, Throwable causa) {
		super(mensajeError, causa);
		this.causaError = mensajeError;
		this.mensajeError = mensajeError;
	}

	

	public String getCausaError() {
		return causaError;
	}

	public void setCausaError(String causaError) {
		this.causaError = causaError;
	}

	public String getMensajeError() {
		return mensajeError;
	}

	public void setMensajeError(String mensajeError) {
		this.mensajeError = mensajeError;
	}

}
