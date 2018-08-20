package com.techM.slack.service;

import com.techM.slack.model.SlackConfiguration;
import com.techM.slack.model.SlackRequest;
import com.techM.slack.model.SlackResponse;
import com.techM.slack.model.interactiveComp.SelectInteractiveRequest;

public interface SlackService {

	public SlackResponse postMessage(SlackRequest request);
	
	public boolean authService(String code);
	
	public SlackResponse saveSlackConfiguration(SlackConfiguration configuration);	
	
	public boolean isPresentInCache(String user,String msg);
	
	public SlackResponse postInteractiveMsgResponse(SelectInteractiveRequest request);
	
}
