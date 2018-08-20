package com.techM.slack.nessaModel;

public class ShowAllIncidentsDTO {

	private String incidentId;
	private String problems;
	private String state;
	private String sys_created_on;
	private String stateMessage;
	private String incLink;
	
	public ShowAllIncidentsDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public ShowAllIncidentsDTO(String incidentId, String problems, String state, String sys_created_on,
			String stateMessage, String incLink) {
		super();
		this.incidentId = incidentId;
		this.problems = problems;
		this.state = state;
		this.sys_created_on = sys_created_on;
		this.stateMessage = stateMessage;
		this.incLink = incLink;
	}
	
	public String getIncidentId() {
		return incidentId;
	}
	public void setIncidentId(String incidentId) {
		this.incidentId = incidentId;
	}
	public String getProblems() {
		return problems;
	}
	public void setProblems(String problems) {
		this.problems = problems;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getSys_created_on() {
		return sys_created_on;
	}
	public void setSys_created_on(String sys_created_on) {
		this.sys_created_on = sys_created_on;
	}
	public String getStateMessage() {
		return stateMessage;
	}
	public void setStateMessage(String stateMessage) {
		this.stateMessage = stateMessage;
	}
	public String getIncLink() {
		return incLink;
	}
	public void setIncLink(String incLink) {
		this.incLink = incLink;
	}
	
	
}
