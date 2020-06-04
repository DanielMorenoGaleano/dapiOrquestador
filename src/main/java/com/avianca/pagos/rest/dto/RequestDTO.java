package com.avianca.pagos.rest.dto;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.sun.istack.NotNull;

/**
 * 
 * @author Assert Solutions S.A.S <info@assertsolutions.com> <br/>
 *         Date: 10/04/2018 9:04:30 a.m.
 *
 */
@JsonAutoDetect
@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class RequestDTO {

	@JsonProperty(value = "canal")
	@NotNull
	private String canal;
	@JsonProperty(value = "pais")
	@NotNull
	private String pais;
	@JsonProperty(value = "medio")
	@NotNull
	private String medio;
	@JsonProperty(value = "pnr")
	@NotNull
	private String pnr;
	@JsonProperty(value = "lastName")
	@NotNull
	private String lastName;
	@JsonProperty(value = "tc")
	@NotNull
	private String tc;
	@JsonProperty(value = "franquicia")
	@NotNull
	private String franquicia;
	@JsonProperty(value = "autorizacion")
	@NotNull
	private String autorizacion;

	public RequestDTO() {
	}

	public String getCanal() {
		return canal;
	}

	public void setCanal(String canal) {
		this.canal = canal;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public String getMedio() {
		return medio;
	}

	public void setMedio(String medio) {
		this.medio = medio;
	}

	public String getPnr() {
		return pnr;
	}

	public void setPnr(String pnr) {
		this.pnr = pnr;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getTc() {
		return tc;
	}

	public void setTc(String tc) {
		this.tc = tc;
	}

	public String getFranquicia() {
		return franquicia;
	}

	public void setFranquicia(String franquicia) {
		this.franquicia = franquicia;
	}

	public String getAutorizacion() {
		return autorizacion;
	}

	public void setAutorizacion(String autorizacion) {
		this.autorizacion = autorizacion;
	}

}
