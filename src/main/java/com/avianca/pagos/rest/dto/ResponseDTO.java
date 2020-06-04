package com.avianca.pagos.rest.dto;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonAutoDetect
public class ResponseDTO {
	@JsonProperty(value = "code")
	public String code;
	@JsonProperty(value = "message")
	public String message;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
//		if (message !=null){
//			System.out.println("este es el message: "+ message);
//			message = message.replaceAll("\\\\", "");
//		} 
		this.message = message;
	}
	
	
}
