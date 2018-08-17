package com.techM.slack.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Body {
	
	@JsonProperty("ok")
	private String ok;

	@JsonProperty("access_token")
	private String access_token;

	@JsonProperty("scope")
	private String scope;
	
	@JsonProperty("user_id")
	private String user_id;
	
	@JsonProperty("team_name")
	private String team_name;
	
	@JsonProperty("team_id")
	private String team_id;
	
	@JsonProperty("incoming_webhook")
	private IncomingWebhook incoming_webhook;

	
	public String getOk() {
		return ok;
	}
	public void setOk(String ok) {
		this.ok = ok;
	}
	public String getAccess_token() {
		return access_token;
	}
	public void setAccess_token(String access_token) {
		this.access_token = access_token;
	}
	public String getScope() {
		return scope;
	}
	public void setScope(String scope) {
		this.scope = scope;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getTeam_name() {
		return team_name;
	}
	public void setTeam_name(String team_name) {
		this.team_name = team_name;
	}
	public String getTeam_id() {
		return team_id;
	}
	public void setTeam_id(String team_id) {
		this.team_id = team_id;
	}
	public IncomingWebhook getIncoming_webhook() {
		return incoming_webhook;
	}
	public void setIncoming_webhook(IncomingWebhook incoming_webhook) {
		this.incoming_webhook = incoming_webhook;
	}
}
