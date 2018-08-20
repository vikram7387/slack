package com.techM.slack.model.interactiveComp;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Team {
	
	@JsonProperty("id")
	private String id;
	
	@JsonProperty("domain")
	private String domain;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDomain() {
		return domain;
	}

	public void setDomain(String domain) {
		this.domain = domain;
	}

}
