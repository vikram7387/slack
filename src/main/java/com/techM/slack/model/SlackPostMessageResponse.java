package com.techM.slack.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SlackPostMessageResponse {

	@JsonProperty("ok")
	private boolean ok;
	 
	@JsonProperty("channel")
	private String channel;
	
	@JsonProperty("ts")
	private String ts;

	@JsonProperty("message")
	private Message message;
	
	@JsonProperty("warning")
	private String warning;
	
	@JsonProperty("response_metadata")
	private ResponseMetadata response_metadata;

	public Message getMessage() {
		return message;
	}

	public void setMessage(Message message) {
		this.message = message;
	}

	public String getWarning() {
		return warning;
	}

	public void setWarning(String warning) {
		this.warning = warning;
	}

	public ResponseMetadata getResponse_metadata() {
		return response_metadata;
	}

	public void setResponse_metadata(ResponseMetadata response_metadata) {
		this.response_metadata = response_metadata;
	}
	
	public boolean isOk() {
		return ok;
	}

	public void setOk(boolean ok) {
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
}
