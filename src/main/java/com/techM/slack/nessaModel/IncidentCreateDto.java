package com.techM.slack.nessaModel;

public class IncidentCreateDto {
  private String short_description;
  private String comments;
  private String caller;
  private String urgency;
  private String caller_id;
  private String state;
  
public String getCaller_id() {
	return caller_id;
}
public void setCaller_id(String caller_id) {
	this.caller_id = caller_id;
}
public String getShort_description() {
	return short_description;
}
public void setShort_description(String short_description) {
	this.short_description = short_description;
}
public String getComments() {
	return comments;
}
public void setComments(String comments) {
	this.comments = comments;
}
public String getCaller() {
	return caller;
}
public void setCaller(String caller) {
	this.caller = caller;
}
public String getUrgency() {
	return urgency;
}
public void setUrgency(String urgency) {
	this.urgency = urgency;
}
public String getState() {
	return state;
}
public void setState(String state) {
	this.state = state;
}
  
}
