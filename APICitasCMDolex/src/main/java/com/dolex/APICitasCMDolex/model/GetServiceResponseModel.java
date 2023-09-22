package com.dolex.APICitasCMDolex.model;

public class GetServiceResponseModel {
	
	public boolean valid;
	public String message;
	public Object response;
	
	public GetServiceResponseModel() {}

	public boolean isValid() {
		return valid;
	}
	
	public void setValid(boolean valid) {
		this.valid = valid;
	}
	
	public String getMessage() {
		return message;
	}
	
	public void setMessage(String message) {
		this.message = message;
	}

	public Object getResponse() {
		return response;
	}

	public void setResponse(Object response) {
		this.response = response;
	}
	
}
