package com.techM.slack.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SlackResponse {

	@JsonProperty("challenge")
	private String challenge;
	
	@JsonProperty("sStatus")
	private String status;
	

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getChallenge() {
		return challenge;
	}

	public void setChallenge(String challenge) {
		this.challenge = challenge;
	}
}
