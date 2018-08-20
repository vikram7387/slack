package com.techM.slack.model.interactiveComp;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.techM.slack.model.Action;

@JsonIgnoreProperties(ignoreUnknown=true)
public class SelectInteractiveRequest {
	
	@JsonProperty("type")
	private String type;
	
	@JsonProperty("callback_id")
	private String callback_id;
	
	@JsonProperty("action_ts")
	private String action_ts;
	
	@JsonProperty("message_ts")
	private String message_ts;
	
	@JsonProperty("attachment_id")
	private String attachment_id;
	
	@JsonProperty("token")
	private String token;
	
	@JsonProperty("is_app_unfurl")
	private String is_app_unfurl;
	
	@JsonProperty("response_url")
	private String response_url;
	
	@JsonProperty("trigger_id")
	private String trigger_id;
	
	@JsonProperty("original_message")
	private OriginalMessage original_message;
	
	@JsonProperty("user")
	private User user; 
	
	@JsonProperty("team")
	private Team team;
	
	@JsonProperty("actions")
	private List<Action> actions;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getCallback_id() {
		return callback_id;
	}

	public void setCallback_id(String callback_id) {
		this.callback_id = callback_id;
	}

	public String getAction_ts() {
		return action_ts;
	}

	public void setAction_ts(String action_ts) {
		this.action_ts = action_ts;
	}

	public String getMessage_ts() {
		return message_ts;
	}

	public void setMessage_ts(String message_ts) {
		this.message_ts = message_ts;
	}

	public String getAttachment_id() {
		return attachment_id;
	}

	public void setAttachment_id(String attachment_id) {
		this.attachment_id = attachment_id;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getIs_app_unfurl() {
		return is_app_unfurl;
	}

	public void setIs_app_unfurl(String is_app_unfurl) {
		this.is_app_unfurl = is_app_unfurl;
	}

	public String getResponse_url() {
		return response_url;
	}

	public void setResponse_url(String response_url) {
		this.response_url = response_url;
	}

	public String getTrigger_id() {
		return trigger_id;
	}

	public void setTrigger_id(String trigger_id) {
		this.trigger_id = trigger_id;
	}

	public OriginalMessage getOriginal_message() {
		return original_message;
	}

	public void setOriginal_message(OriginalMessage original_message) {
		this.original_message = original_message;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Team getTeam() {
		return team;
	}

	public void setTeam(Team team) {
		this.team = team;
	}

	public List<Action> getActions() {
		return actions;
	}

	public void setActions(List<Action> actions) {
		this.actions = actions;
	}
	
}
