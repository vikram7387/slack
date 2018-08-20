package com.techM.slack.serviceIMPL;


import java.util.ArrayList;
import java.util.List;

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
import com.techM.slack.constant.NessaURLConstant;
import com.techM.slack.dao.SlackOperationDAO;
import com.techM.slack.model.Action;
import com.techM.slack.model.Attachments;
import com.techM.slack.model.AuthResponse;
import com.techM.slack.model.Body;
import com.techM.slack.model.Message;
import com.techM.slack.model.Option;
import com.techM.slack.model.SlackConfiguration;
import com.techM.slack.model.SlackPostMessageRequest;
import com.techM.slack.model.SlackRequest;
import com.techM.slack.model.SlackResponse;
import com.techM.slack.model.interactiveComp.SelectInteractiveRequest;
import com.techM.slack.nessaModel.BotResult;
import com.techM.slack.nessaModel.ResultFAQJSON;
import com.techM.slack.nessaModel.Task;
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
	
		if(!StringUtils.equals(request.getEvent().getUsername(), "nessa") && !StringUtils.equalsIgnoreCase(request.getEvent().getText(),"Sorry, I did not understand that. Please try again.")) {
			synchronized (slackPostMessageRequest) {
		
				
				if(request!=null && request.getEvent()!=null && request.getEvent().getUser()!=null && StringUtils.isNotBlank(request.getEvent().getUser())) {	
				
					System.out.println("EVENT OCCURED:::");
					System.out.println("User Text::"+request.getEvent().getText());
					System.out.println("User Id:::"+request.getEvent().getUser());
					BotResult botResult=getResponsrFromNessa(request.getEvent().getUser(),request.getEvent().getText());
					List<Attachments> attachments=getSelectMenu(botResult);
					String replay=botResult.getResult().getReply();
					System.out.println("Replay From nessa IS:::"+replay);
					slackPostMessageRequest.setAttachments(attachments);
					slackPostMessageRequest.setText(replay);	
					System.out.println("Formated text is:::"+slackPostMessageRequest.getText());
					logger.info("Request for Post Message :::" , new Gson().toJson(slackPostMessageRequest));
					try {
					 AuthResponse authResponse=slackOperationDAO.getAuthUser(request.getEvent().getUser());	
						
					 if(authResponse!=null
							&& authResponse.getBody()!=null
							&& StringUtils.isNotEmpty(authResponse.getBody().getAccess_token())
							&& !StringUtils.equalsIgnoreCase(request.getEvent().getText(),"Sorry, I did not understand that. Please try again.")){
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
				}
			
			}
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
	
	private BotResult getResponsrFromNessa(String user,String text) {
		BotResult response = null;
		
		String botInstanceId = "";
		
		try {
			botInstanceId =user; // slackRequest.getEvent().getUser();
			
			String queryString = text;// slackRequest.getEvent().getText();
			
			System.out.println("queryString is::>>>>**********************************>" + queryString);
			
			String basicBotURL = NessaURLConstant.BASIC_BOT_URL;
			String url = NessaURLConstant.HAS_INSTANCE_URL;
			
			String hasInstanceForIdURL = url+botInstanceId;
			
			RestTemplate restTemplate = new RestTemplate();
			ResultFAQJSON isInstanceAlreadyCreted = restTemplate.getForObject(basicBotURL + hasInstanceForIdURL,
					ResultFAQJSON.class);
			BotResult strForFB=null;
			String instanceCheck = isInstanceAlreadyCreted.getResponse();
			
			if(queryString!=null){	
			
				if (instanceCheck.equalsIgnoreCase(Constant.CHECK_STATUS)) {
				
					String botInstanceNotAvailableURL = NessaURLConstant.BOT_INSTANCE_NOT_AVAILABLE_URL;
					String newInstance =botInstanceNotAvailableURL + botInstanceId;
					RestTemplate restUrl = new RestTemplate();
					String response2 = restUrl.getForObject(basicBotURL + newInstance, String.class);
			
					queryString.toLowerCase();

						if(queryString.contains(Constant.HELLO) || queryString.contains(Constant.HEY) || queryString.contains(Constant.HI))
							{
								queryString="show menu";
							}
						
						else{
								queryString="TriggerMenu";
							}
				
							System.out.println("Tushar check first instance >>  "+queryString);
					}
			
					String botInstanceAvailableURL = NessaURLConstant.BOT_INSTANCE_AVAILABLE_URL;
					String existingInstance = "/"+botInstanceId+botInstanceAvailableURL+ queryString;
					
					logger.info("Final URL:::",basicBotURL + existingInstance);
					
					RestTemplate restTemplate1 = new RestTemplate();
					System.out.println("-------------------------------------------------");
					System.out.println("Third URL is:::"+(basicBotURL + existingInstance));
					System.out.println("-------------------------------------------------");
					
					strForFB = restTemplate1.getForObject(basicBotURL + existingInstance, BotResult.class);
					System.out.println("Real Bot Object:::"+strForFB);
			}
			
			response = strForFB;
			System.out.println("BOT OBJECT IS"+new Gson().toJson(response));
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error Occured while connecting to bot" + e.getMessage());
		}

		return response;
	}
	
	public List<Attachments> getSelectMenu(BotResult botResult) {
		List<Attachments> attachment=new ArrayList<Attachments>(); 
		Attachments attachments=new Attachments();
		attachments.setText(botResult.getICard().getType());
		attachments.setColor("#3AA3E3");
		attachments.setAttachment_type("default");
		attachments.setCallback_id("wopr_game");
		
		Action action=new Action();
		action.setName(botResult.getICard().getType());
		action.setText("Please select one option");
		action.setType("select");
		
		List<Option> options=new ArrayList<Option>();
		for(Task task:botResult.getICard().getTasks()) {
			Option option=new Option();
			option.setText(task.getLabel());
			option.setValue(task.getLabel());
			options.add(option);
		}
		action.setOptions(options);
		List<Action> actions=new ArrayList<Action>();
		actions.add(action);
		attachments.setActions(actions);
		attachment.add(attachments);
		return attachment;
	}

	public boolean isPresentInCache(String user, String msg) {
		
		return false;
	}
	
	private SlackPostMessageRequest getSlackResponseForInteractiveMessages(SelectInteractiveRequest request) {
		logger.info("In slack post request Builder:::",new Gson().toJson(request));
		SlackPostMessageRequest postRequest=new SlackPostMessageRequest();
		postRequest.setOk(true);
		postRequest.setChannel(request.getTeam().getId());
		postRequest.setTs(request.getAction_ts());
		Message message=new Message();
		message.setUsername(request.getUser().getName());
		message.setBot_id(request.getOriginal_message().getBot_id());
		message.setAttachments(null);
		message.setType("message");
		message.setSubtype("bot_message");
		message.setTs(request.getAction_ts());
		postRequest.setMessage(message);
		return postRequest;
	}
	
    public SlackResponse postInteractiveMsgResponse(SelectInteractiveRequest request) {
	
		
		SlackResponse slackResponse=new SlackResponse();
		logger.info("In Post Message Service Impl");

		String text=request.getActions().get(0).getSelected_options().get(0).getValue();
		SlackPostMessageRequest slackPostMessageRequest=getSlackResponseForInteractiveMessages(request);
		logger.info("slack post message Request:::",new Gson().toJson(slackPostMessageRequest));
	
		if(!StringUtils.equals(request.getUser().getName(), "nessa") && !StringUtils.equalsIgnoreCase(text,"Sorry, I did not understand that. Please try again.")) {
			synchronized (slackPostMessageRequest) {
		
				if(request!=null && request.getUser()!=null && request.getUser().getId()!=null && StringUtils.isNotBlank(request.getUser().getId())) {	
				
					
					BotResult botResult=getResponsrFromNessa(request.getUser().getId(),text);
					List<Attachments> attachments=null;
					String replay=botResult.getResult().getReply();
					System.out.println("Replay From nessa IS:::"+replay);
					slackPostMessageRequest.setAttachments(attachments);
					slackPostMessageRequest.setText(replay);	
					System.out.println("Formated text is:::"+slackPostMessageRequest.getText());
					logger.info("Request for Post Message :::" , new Gson().toJson(slackPostMessageRequest));
					try {
					 AuthResponse authResponse=slackOperationDAO.getAuthUser(request.getUser().getName());	
						
					 if(authResponse!=null
							&& authResponse.getBody()!=null
							&& StringUtils.isNotEmpty(authResponse.getBody().getAccess_token())
							&& !StringUtils.equalsIgnoreCase(text,"Sorry, I did not understand that. Please try again.")){
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
				}
			
			}
		}
		return slackResponse;
	}
	

}
