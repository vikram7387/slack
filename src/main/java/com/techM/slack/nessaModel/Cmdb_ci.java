package com.techM.slack.nessaModel;

public class Cmdb_ci {
	private String link;

	private String value;

	public Cmdb_ci() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Cmdb_ci(String str) {
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
