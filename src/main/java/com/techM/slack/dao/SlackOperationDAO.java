package com.techM.slack.dao;

import com.techM.slack.model.AuthResponse;
import com.techM.slack.model.SlackConfiguration;

public interface SlackOperationDAO{
	
	public boolean saveUserAuth(AuthResponse authResponse);
	
	public AuthResponse getAuthUser(String user_id);
	
	public boolean saveSlackConfiguration(SlackConfiguration configurations);
	
	public SlackConfiguration getSlackConfiguration();

}
