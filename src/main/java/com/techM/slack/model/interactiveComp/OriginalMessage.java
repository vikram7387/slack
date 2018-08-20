package com.techM.slack.model.interactiveComp;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.techM.slack.model.Attachments;

public class OriginalMessage {

	@JsonProperty("text")
	private String text;

	@JsonProperty("username")
	private String username;
	
	@JsonProperty("bot_id")
	private String bot_id;
	
	@JsonProperty("type")
	private String type;
	
	@JsonProperty("subtype")
	private String subtype;
	
	@JsonProperty("ts")
	private String ts;
	
	@JsonProperty("attachments")
	List<Attachments> attachments;

	
	
	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

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
}
