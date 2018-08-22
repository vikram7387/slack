package com.techM.slack.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Option {

	@JsonProperty("text")
	private String text;
	
	@JsonProperty("value")
	private String value;

	@JsonProperty("style")
	private String style;
	
	@JsonProperty("type")
	private String type;
	
	@JsonProperty("name")
	private String name;
	
	public String getStyle() {
		return style;
	}

	public void setStyle(String style) {
		this.style = style;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

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
