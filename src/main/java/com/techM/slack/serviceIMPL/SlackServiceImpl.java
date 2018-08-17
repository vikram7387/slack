package com.techM.slack.serviceIMPL;


import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.google.gson.*;
import com.techM.slack.constant.Constant;
import com.techM.slack.dao.SlackOperationDAO;
import com.techM.slack.model.AuthResponse;
import com.techM.slack.model.Body;
import com.techM.slack.model.Message;
import com.techM.slack.model.SlackConfiguration;
import com.techM.slack.model.SlackPostMessageRequest;
import com.techM.slack.model.SlackRequest;
import com.techM.slack.model.SlackResponse;
import com.techM.slack.service.SlackService;

@Service
public class SlackServiceImpl implements SlackService{

	private static final Logger logger = LoggerFactory.getLogger(SlackServiceImpl.class);

	private RestTemplate restTemplate=new RestTemplate();
	
	@Autowired
	private SlackOperationDAO slackOperationDAO;

	@Autowired
	HttpServletResponse httpServletResponse;
	
	public SlackResponse postMessage(SlackRequest request) {
		SlackResponse slackResponse=new SlackResponse();
		logger.info("In Post Message Service Impl");
		SlackPostMessageRequest slackPostMessageRequest=getSlackResponse(request);
		logger.info("slack post message Request:::",new Gson().toJson(slackPostMessageRequest));
		if(StringUtils.equalsIgnoreCase(request.getEvent().getText(), "Hi, How Are You?")) {
			logger.info("In true section");
			slackPostMessageRequest.setText("I am Fine. An U?");
		}else if(StringUtils.equalsIgnoreCase(request.getEvent().getText(),"Good" )) {
			slackPostMessageRequest.setText("ok!! Nice meeting With you.");
		}else if(!StringUtils.equalsIgnoreCase(request.getEvent().getText(), "Hi, How Are You?")
				&& !StringUtils.equalsIgnoreCase(request.getEvent().getText(),"I am Fine. An U?")
				&&!StringUtils.equalsIgnoreCase(request.getEvent().getText(),"Good" )
				&&!StringUtils.equalsIgnoreCase(request.getEvent().getText() ,"ok!! Nice meeting With you.")
				&& !StringUtils.equalsIgnoreCase(request.getEvent().getText(),"Sorry!! I don't understand What are you Saying.")){
			slackPostMessageRequest.setText("Sorry!! I don't understand What are you Saying.");
		}
		logger.info("Request for Post Message :::" , new Gson().toJson(slackPostMessageRequest));
		try {
		 AuthResponse authResponse=slackOperationDAO.getAuthUser(request.getEvent().getUser());	
			
		 if(authResponse!=null
				&& authResponse.getBody()!=null
				&& StringUtils.isNotEmpty(authResponse.getBody().getAccess_token())
				&& !StringUtils.equalsIgnoreCase(request.getEvent().getText(),"Sorry!! I don't understand What are you Saying.")){
				ResponseEntity<Object> postResponse=restTemplate.exchange
						 ("https://slack.com/api/chat.postMessage", HttpMethod.POST, new HttpEntity<Object>(slackPostMessageRequest,createHeaders(authResponse.getBody().getAccess_token())), Object.class);
						logger.info("Post Message Response :::",new Gson().toJson(postResponse));

			}
		 if(StringUtils.equalsIgnoreCase(authResponse.getBody().getScope(), "identify,bot,incoming-webhook,chat:write:user,chat:write:bot,links:read")) {
			 slackResponse.setStatus(Constant.SUCCESS);
		 }else {
			 slackResponse.setStatus(Constant.FAILED);
		 }
			}catch (Exception e) {
			logger.debug("Error Occured During Post",e.getMessage());	
		}
		return slackResponse;
	}
	
	private SlackPostMessageRequest getSlackResponse(SlackRequest request) {
		logger.info("In slack post request Builder:::",new Gson().toJson(request));
		SlackPostMessageRequest postRequest=new SlackPostMessageRequest();
		postRequest.setOk(true);
		postRequest.setChannel(request.getEvent().getChannel());
		postRequest.setTs(request.getEvent().getTs());
		Message message=new Message();
		message.setUsername(request.getAuthed_users().get(0));
		message.setBot_id(request.getApi_app_id());
		message.setAttachments(null);
		message.setType(request.getEvent().getType());
		message.setSubtype("bot_message");
		message.setTs(request.getEvent().getTs());
		postRequest.setMessage(message);
		return postRequest;
	}
	
	HttpHeaders createHeaders(final String authCode){
		   return new HttpHeaders() {{
		         String authHeader = "Bearer " + new String( authCode );
		         set( "Authorization", authHeader );
		      }};
	}

	public boolean authService(String code) {
		logger.info("In auth Service");
		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", org.springframework.http.MediaType.APPLICATION_JSON_VALUE);

		SlackConfiguration configuration=slackOperationDAO.getSlackConfiguration();
		
		if(configuration!=null) {
			String url="https://slack.com/api/oauth.access";
			UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(url)
			        .queryParam("code", code)
			        .queryParam("client_id", configuration.getClientId())
			        .queryParam("client_secret", configuration.getClientSecret());
			
			HttpEntity<?> entity = new HttpEntity<Object>(headers);
	
			
			logger.info("URL :::"+builder.build(false).encode().toUriString());
			ResponseEntity<Body> body = restTemplate.exchange(
			        builder.build().toUriString(), 
			        HttpMethod.GET, 
			        entity, 
			        Body.class);
		
		    AuthResponse authResponse=new AuthResponse();
		    authResponse.setBody(body.getBody());
			logger.debug("Auth Response Is ", new Gson().toJson(authResponse.getBody()));
			if(authResponse.getBody()!=null) {
				slackOperationDAO.saveUserAuth(authResponse);
				return true;	
			}else {
				return false;
			}
		}else {
			logger.debug("Configuration Not Found");
			return false;
		}
	}

	public SlackResponse saveSlackConfiguration(SlackConfiguration configuration) {
	
		SlackResponse response=new SlackResponse();
		boolean status= slackOperationDAO.saveSlackConfiguration(configuration);
		
		if(status) {
			response.setStatus(Constant.SUCCESS);
		}else {
			response.setStatus(Constant.FAILED);
		}
		
		return response;
	}

}
