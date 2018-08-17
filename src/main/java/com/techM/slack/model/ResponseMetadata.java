package com.techM.slack.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ResponseMetadata {
	
	@JsonProperty("warnings")
	private List<String> warnings;

	public List<String> getWarnings() {
		return warnings;
	}

	public void setWarnings(List<String> warnings) {
		this.warnings = warnings;
	}

}
