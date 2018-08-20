package com.techM.slack.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Option {

	@JsonProperty("text")
	private String text;
	
	@JsonProperty("value")
	private String value;

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
}
