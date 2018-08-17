package com.techM.slack.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SlackPostMessageRequest {

	@JsonProperty("ok")
	private Boolean ok;
	
	@JsonProperty("channel")
	private String channel;
	
	@JsonProperty("ts")
	private String ts;

	@JsonProperty("text")
	private String text;
	
	@JsonProperty("message")
	private Message message;
	
	public Boolean getOk() {
		return ok;
	}

	public void setOk(Boolean ok) {
		this.ok = ok;
	}

	public String getChannel() {
		return channel;
	}

	public void setChannel(String channel) {
		this.channel = channel;
	}

	public String getTs() {
		return ts;
	}

	public void setTs(String ts) {
		this.ts = ts;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Message getMessage() {
		return message;
	}

	public void setMessage(Message message) {
		this.message = message;
	}

}
