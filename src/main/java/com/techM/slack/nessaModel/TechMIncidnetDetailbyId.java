package com.techM.slack.nessaModel;

public class TechMIncidnetDetailbyId {

	private String incidentNumber;
	private String state;
	private String assigned_toname;
	private String assignment_group1;
	private String problem;
	private String userFollowUpMsg;
	private String incLink;
	
	
	public String getIncidentNumber() {
		return incidentNumber;
	}
	public void setIncidentNumber(String incidentNumber) {
		this.incidentNumber = incidentNumber;
	}
	
	public String getProblem() {
		return problem;
	}
	public void setProblem(String problem) {
		this.problem = problem;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getAssigned_toname() {
		return assigned_toname;
	}
	public void setAssigned_toname(String assigned_toname) {
		this.assigned_toname = assigned_toname;
	}
	public String getAssignment_group1() {
		return assignment_group1;
	}
	public void setAssignment_group1(String assignment_group1) {
		this.assignment_group1 = assignment_group1;
	}
	public String getUserFollowUpMsg() {
		return userFollowUpMsg;
	}
	public void setUserFollowUpMsg(String userFollowUpMsg) {
		this.userFollowUpMsg = userFollowUpMsg;
	}
	public String getIncLink() {
		return incLink;
	}
	public void setIncLink(String incLink) {
		this.incLink = incLink;
	}
	
	
}
