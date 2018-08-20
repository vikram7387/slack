package com.techM.slack.nessaModel;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SkypeForBusiness {
	
	String startName;
	String completeName;
	String mailId;
	String userId;
	String userPassword;
	String mobileNo;
	String displayName;
	String givenName;
	public String getStartName() {
		return startName;
	}
	public void setStartName(String startName) {
		this.startName = startName;
	}
	public String getCompleteName() {
		return completeName;
	}
	public void setCompleteName(String completeName) {
		this.completeName = completeName;
	}
	public String getMailId() {
		return mailId;
	}
	public void setMailId(String mailId) {
		this.mailId = mailId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public String getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	public String getDisplayName() {
		return displayName;
	}
	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}
	public String getGivenName() {
		return givenName;
	}
	public void setGivenName(String givenName) {
		this.givenName = givenName;
	}
	
	public SkypeForBusiness(String startName, String completeName, String mailId, String userId, String userPassword,
			String mobileNo, String displayName, String givenName) {
		super();
		this.startName = startName;
		this.completeName = completeName;
		this.mailId = mailId;
		this.userId = userId;
		this.userPassword = userPassword;
		this.mobileNo = mobileNo;
		this.displayName = displayName;
		this.givenName = givenName;
	}
	@Override
	public String toString() {
		return "SkypeForBusiness [startName=" + startName + ", completeName=" + completeName + ", mailId=" + mailId
				+ ", userId=" + userId + ", userPassword=" + userPassword + ", mobileNo=" + mobileNo + ", displayName="
				+ displayName + ", givenName=" + givenName + "]";
	}
	
	public SkypeForBusiness() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
