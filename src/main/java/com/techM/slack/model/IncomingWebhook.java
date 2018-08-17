package com.techM.slack.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class IncomingWebhook {

	@JsonProperty("channel")
	private String channel;
	
	@JsonProperty("channel_id")
	private String channel_id;
	
	@JsonProperty("configuration_url")
	private String configuration_url;
	
	@JsonProperty("url")
	private String url;
	
	public String getChannel() {
		return channel;
	}
	public void setChannel(String channel) {
		this.channel = channel;
	}
	public String getChannel_id() {
		return channel_id;
	}
	public void setChannel_id(String channel_id) {
		this.channel_id = channel_id;
	}
	public String getConfiguration_url() {
		return configuration_url;
	}
	public void setConfiguration_url(String configuration_url) {
		this.configuration_url = configuration_url;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
}
