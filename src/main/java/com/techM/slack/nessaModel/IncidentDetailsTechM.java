package com.techM.slack.nessaModel;

public class IncidentDetailsTechM  {

	private String incidentId;
	private String problems;
	private String state;
	private String sys_created_on;
	private String rtmnumber;
    private String short_description;
    private String requestNo;   
    private String name;

    private String stateMessage;
    
    private String incLink;

	public String getSys_created_on() {
			return sys_created_on;
	}
	public void setSys_created_on(String sys_created_on) {
			this.sys_created_on = sys_created_on;
	}
	public String getRtmnumber() {
		return rtmnumber;
	}
	public void setRtmnumber(String rtmnumber) {
		this.rtmnumber = rtmnumber;
	}
	public String getShort_description() {
		return short_description;
	}
	public void setShort_description(String short_description) {
		this.short_description = short_description;
	}
	public String getRequestNo() {
		return requestNo;
	}
	public void setRequestNo(String requestNo) {
		this.requestNo = requestNo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
 
		public String getIncLink() {
		return incLink;
	}
	public void setIncLink(String incLink) {
		this.incLink = incLink;
	}
		@Override
	public String toString() {
		return "IncidentDetailsTechM []";
	}

		public String getStateMessage() {
			return stateMessage;
		}
		public void setStateMessage(String stateMessage) {
			this.stateMessage = stateMessage;
		}
	
}
