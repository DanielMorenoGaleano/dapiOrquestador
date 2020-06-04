package com.avianca.pagos.rest.dto;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.sun.istack.NotNull;

@JsonAutoDetect
@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class RequestRemarksDTO {
	
	@JsonProperty(value = "pnr")
	@NotNull
	private String pnr;
	
	@JsonProperty(value = "lastName")
	@NotNull	
	private String lastName;
	
	@JsonProperty(value = "freetext")
	@NotNull
	private String freetext;

	
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

	public String getFreetext() {
		return freetext;
	}

	public void setFreetext(String freetext) {
		this.freetext = freetext;
	}
}
