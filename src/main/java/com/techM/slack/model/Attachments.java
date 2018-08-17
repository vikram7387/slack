package com.techM.slack.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Attachments {
	
	@JsonProperty("text")
	private String text;
	
	@JsonProperty("id")
	private String id;
	
	@JsonProperty("fallback")
	private String fallback;
	
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getFallback() {
		return fallback;
	}
	public void setFallback(String fallback) {
		this.fallback = fallback;
	}

}
