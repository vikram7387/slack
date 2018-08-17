package com.techM.slack;
import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.google.gson.Gson;
import com.techM.slack.constant.Constant;
import com.techM.slack.constant.EndPointReferral;
import com.techM.slack.model.AuthResponse;
import com.techM.slack.model.SlackConfiguration;
import com.techM.slack.model.SlackRequest;
import com.techM.slack.model.SlackResponse;
import com.techM.slack.service.SlackService;


/**
 * Handles requests for the application home page.
 */
@RestController
public class SlackController {
	
	
	@Autowired
	private SlackService slackService;
	
	private static final Logger logger = LoggerFactory.getLogger(SlackController.class);

	
	@RequestMapping(value=EndPointReferral.EVENT,method = RequestMethod.POST)
	@ResponseBody
	public SlackResponse getSlackInitialCall(@RequestBody SlackRequest slackRequest,HttpServletResponse httpServletResponse) throws IOException {
		logger.info("In slack controller :::getSlackInitialCall");
		logger.info("Request Is"+ new Gson().toJson(slackRequest));
	
		System.out.println("Event Call Back is:::"+new Gson().toJson(slackRequest));
		SlackResponse response=new SlackResponse();
		if(slackRequest!=null) {
			if(slackRequest.getType().equals("url_verification")) {
				logger.info("In Event Type URL_Verification");	
				response.setChallenge(slackRequest.getChallenge());			
			}else if(StringUtils.equalsIgnoreCase(slackRequest.getEvent().getType(),"message")) {
				logger.info("In Event Type Message");
				response=slackService.postMessage(slackRequest);
				
			}
		}
		logger.info("Sending response from getSlackInitialCall:::"+new Gson().toJson(response));
		return response;
	}
	
	@RequestMapping(value = EndPointReferral.OAUTH, method=RequestMethod.GET)
	public String getAuth(@RequestParam("code") String code,@RequestParam("state") String state,HttpServletResponse response) throws IOException {
		logger.info("In Auth Controller :: Auth Code is:::",code);
		boolean flag=slackService.authService(code);
		if(flag) {
			response.sendRedirect("https://nessa-world.slack.com/");
		   // return 	"redirect:https://nessa-world.slack.com/";
		}
		return "FAILED";
	}
	
	@RequestMapping(value=EndPointReferral.Auth_FAILED)
	public void authfailedError() {
		logger.info("Authentication failed and cathed at backed");
	}
	
	@RequestMapping(value=EndPointReferral.WORK_SPACE_CONFIG)
	@ResponseBody
	public SlackResponse saveSlackConfiguration(@RequestBody SlackConfiguration slackConfiguration) {
	
		SlackResponse response=slackService.saveSlackConfiguration(slackConfiguration);
		
		return response; 
	}
	
	@RequestMapping(value=EndPointReferral.TEST, method=RequestMethod.POST)
	public void test(@RequestBody AuthResponse authResponse) {
		logger.debug("Body is ::",new Gson().toJson(authResponse));
	}
}
