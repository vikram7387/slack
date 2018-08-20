package com.techM.slack.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Attachments {
	
	@JsonProperty("text")
	private String text;
	
	@JsonProperty("id")
	private String id;
	
	@JsonProperty("fallback")
	private String fallback;
	
	@JsonProperty("color")
	private String color;
	
	@JsonProperty("attachment_type")
	private String attachment_type;
	
	@JsonProperty("callback_id")
	private String callback_id;
	
	@JsonProperty("actions")
	private List<Action> actions;
	
	public void setActions(List<Action> actions) {
		this.actions = actions;
	}
	public String getAttachment_type() {
		return attachment_type;
	}
	public String getCallback_id() {
		return callback_id;
	}
	public void setCallback_id(String callback_id) {
		this.callback_id = callback_id;
	}
	
	public void setAttachment_type(String attachment_type) {
		this.attachment_type = attachment_type;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
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
