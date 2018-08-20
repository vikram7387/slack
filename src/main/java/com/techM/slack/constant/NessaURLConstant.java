package com.techM.slack.constant;

public class NessaURLConstant {

	public static final String BASIC_BOT_URL="http://192.168.0.9:9009/nessa/msgbot";
	
	// 1
	public static final String HAS_INSTANCE_URL="/hasInstance?userID=";
	
	// 2
	//  ?userID={0}
	public static final String BOT_INSTANCE_NOT_AVAILABLE_URL="?userID=";
	
	// 3
	// /USER_SESSION?userMessage=
	public static final String BOT_INSTANCE_AVAILABLE_URL="?userMessage=";
}
