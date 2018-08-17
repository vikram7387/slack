package com.techM.slack.model;

import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonProperty;

@Document
public class Message {

	@JsonProperty("username")
	private String username;
	
	@JsonProperty("bot_id")
	private String bot_id;
	
	@JsonProperty("type")
	private String type;
	
	@JsonProperty("sub_type")
	private String subtype;
	
	@JsonProperty("ts")
	private String ts;
	
	@JsonProperty("attachments")
	private List<Attachments> attachments;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getBot_id() {
		return bot_id;
	}
	public void setBot_id(String bot_id) {
		this.bot_id = bot_id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getSubtype() {
		return subtype;
	}
	public void setSubtype(String subtype) {
		this.subtype = subtype;
	}
	public String getTs() {
		return ts;
	}
	public void setTs(String ts) {
		this.ts = ts;
	}
	public List<Attachments> getAttachments() {
		return attachments;
	}
	public void setAttachments(List<Attachments> attachments) {
		this.attachments = attachments;
	}
	
}
