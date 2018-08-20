package com.techM.slack.nessaModel;

public class Caller_id {
	private String link;

	private String value;

	public Caller_id() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Caller_id(String str) {
		if (str == null || str.equals("")) {
			link = null;
			value = null;
		}

	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
}
