package com.techM.slack.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SlackRequest {

	@JsonProperty("token")
	private String token;
	
	@JsonProperty("challenge")
	private String challenge;
	
	@JsonProperty("type")
	private String type;
	
	@JsonProperty("team_id")
	private String team_id;
	
	@JsonProperty("api_app_id")
	private String api_app_id;
	
	@JsonProperty("event_id")
	private String event_id;
	
	@JsonProperty("event_time")
	private String event_time;
	
	@JsonProperty("event")
	private Event event;
	
	@JsonProperty("authed_teams")
	private List<String> authed_teams;
	
	@JsonProperty("authed_users")
	private List<String> authed_users;
	
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public String getTeam_id() {
		return team_id;
	}
	public void setTeam_id(String team_id) {
		this.team_id = team_id;
	}
	public String getApi_app_id() {
		return api_app_id;
	}
	public void setApi_app_id(String api_app_id) {
		this.api_app_id = api_app_id;
	}
	public String getEvent_id() {
		return event_id;
	}
	public void setEvent_id(String event_id) {
		this.event_id = event_id;
	}
	public String getEvent_time() {
		return event_time;
	}
	public void setEvent_time(String event_time) {
		this.event_time = event_time;
	}
	public Event getEvent() {
		return event;
	}
	public void setEvent(Event event) {
		this.event = event;
	}
	public List<String> getAuthed_teams() {
		return authed_teams;
	}
	public void setAuthed_teams(List<String> authed_teams) {
		this.authed_teams = authed_teams;
	}
	public List<String> getAuthed_users() {
		return authed_users;
	}
	public void setAuthed_users(List<String> authed_users) {
		this.authed_users = authed_users;
	}
	public String getChallenge() {
		return challenge;
	}
	public void setChallenge(String challenge) {
		this.challenge = challenge;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
}
