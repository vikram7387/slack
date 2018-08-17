package com.techM.slack.model;

import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
@Document(collection = "authResponse")
@JsonIgnoreProperties(ignoreUnknown = true)
public class AuthResponse {

	@JsonProperty("statusCode")
	private String statusCode;

	@JsonProperty("body")
	private Body body;
	
	public String getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}

	public Body getBody() {
		return body;
	}

	public void setBody(Body body) {
		this.body = body;
	}

}
