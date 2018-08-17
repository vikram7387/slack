package com.techM.slack.service;

import com.techM.slack.model.SlackConfiguration;
import com.techM.slack.model.SlackRequest;
import com.techM.slack.model.SlackResponse;

public interface SlackService {

	public SlackResponse postMessage(SlackRequest request);
	
	public boolean authService(String code);
	
	public SlackResponse saveSlackConfiguration(SlackConfiguration configuration);	
	
}
