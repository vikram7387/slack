package com.techM.slack.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.techM.slack.model.interactiveComp.Value;

@JsonIgnoreProperties(ignoreUnknown=true)
public class Action {
	
	@JsonProperty("name")
	private String name;
	
	@JsonProperty("value")
	private String value;

	@JsonProperty("text")
    private String text;
	
	@JsonProperty("type")
    private String type;
	
	@JsonProperty("style")
	private String style;
	
	public String getStyle() {
		return style;
	}

	public void setStyle(String style) {
		this.style = style;
	}

	@JsonProperty("options")
    private List<Option> options; 
	
	@JsonProperty("selected_options")
	private List<Value> selected_options;


	public List<Value> getSelected_options() {
		return selected_options;
	}

	public void setSelected_options(List<Value> selected_options) {
		this.selected_options = selected_options;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public List<Option> getOptions() {
		return options;
	}

	public void setOptions(List<Option> options) {
		this.options = options;
	}
	
	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
}
