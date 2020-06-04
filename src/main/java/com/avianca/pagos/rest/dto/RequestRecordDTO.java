package com.avianca.pagos.rest.dto;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.sun.istack.NotNull;

import net.minidev.json.JSONObject;

@JsonAutoDetect
@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class RequestRecordDTO {
	
	@JsonProperty(value = "pnr")
	@NotNull
	private String pnr;
	
	@JsonProperty(value = "lastName")
	@NotNull
	private String lastName;
	
	@JsonProperty(value = "body")
	@NotNull
	private JSONObject body;

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

	public Object getBody() {
		return body;
	}

	public void setBody(JSONObject body) {
		this.body = body;
	}


//	public String getBody() {
//		return body;
//	}
//
//	public void setBody(String body) {
//		this.body = body;
//	}
	
	
}
