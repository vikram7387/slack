package com.techM.slack.model.interactiveComp;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Value {
	
	@JsonProperty("value")
	private String value;

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}
