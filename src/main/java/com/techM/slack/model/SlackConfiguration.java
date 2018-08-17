package com.techM.slack.model;

import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonProperty;

@Document(collection="slackConfiguration")
public class SlackConfiguration {
	
	@JsonProperty("app_id")
	private String app_id;
	
	@JsonProperty("workSpaceName")
	private String workSpaceName;
	
	@JsonProperty("clientId")
	private String clientId;
	
	@JsonProperty("clientSecret")
	private String clientSecret;
	

	@JsonProperty("active")
	private boolean active;

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public String getWorkSpaceName() {
		return workSpaceName;
	}

	public void setWorkSpaceName(String workSpaceName) {
		this.workSpaceName = workSpaceName;
	}

	public String getClientId() {
		return clientId;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	public String getClientSecret() {
		return clientSecret;
	}

	public void setClientSecret(String clientSecret) {
		this.clientSecret = clientSecret;
	}

	public String getApp_id() {
		return app_id;
	}

	public void setApp_id(String app_id) {
		this.app_id = app_id;
	}

}
