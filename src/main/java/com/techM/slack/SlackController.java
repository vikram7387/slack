package com.techM.slack;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.techM.slack.constant.Constant;
import com.techM.slack.constant.EndPointReferral;
import com.techM.slack.model.CacheInfo;
import com.techM.slack.model.SlackConfiguration;
import com.techM.slack.model.SlackRequest;
import com.techM.slack.model.SlackResponse;
import com.techM.slack.model.interactiveComp.SelectInteractiveRequest;
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
	public ResponseEntity<?> getSlackInitialCall(@RequestBody SlackRequest slackRequest,HttpServletResponse httpServletResponse) throws IOException {
		CacheInfo cacheInfo=CacheInfo.getInstance();
		SlackResponse response=new SlackResponse();
		String message=CacheInfo.getUserDetails(slackRequest.getEvent().getUser());
		if(!StringUtils.equalsIgnoreCase(message, slackRequest.getEvent().getText())){
			CacheInfo.setUserDetail(slackRequest.getEvent().getUser(), slackRequest.getEvent().getText());
			if(slackRequest!=null) {
				if(slackRequest.getType().equals("url_verification")) {
					logger.info("In Event Type URL_Verification");	
					response.setChallenge(slackRequest.getChallenge());			
				}else if(StringUtils.equalsIgnoreCase(slackRequest.getEvent().getType(),"message")) {
					logger.info("In Event Type Message");
					response=slackService.postMessage(slackRequest);
					
				}
			}
		}		
		logger.info("Sending response from getSlackInitialCall:::"+new Gson().toJson(response));
		return new ResponseEntity<>(response, HttpStatus.OK);
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
	
	
	@RequestMapping(value=EndPointReferral.MESSAGE_ACTION,method=RequestMethod.POST,
			consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE,
			produces = {MediaType.APPLICATION_ATOM_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
	@ResponseBody
	public void dynamicMessages(@RequestBody MultiValueMap<String, String> interactiveRequest1) throws JsonParseException, JsonMappingException, IOException {
		SlackResponse response=new SlackResponse();
		String text = null;	
		System.out.println("+++++++++++++++++++++++++++++++++++++++");
		System.out.println(new Gson().toJson(interactiveRequest1));
		System.out.println(new Gson().toJson(interactiveRequest1.get("payload")));
		System.out.println("first:::"+new Gson().toJson(interactiveRequest1.getFirst("payload")));
		System.out.println("+++++++++++++++++++++++++++++++++++++++");
		String json=new Gson().toJson(interactiveRequest1.getFirst("payload"));
		ObjectMapper mapper = new ObjectMapper();
		System.out.println("JSON:::"+json);
		final SelectInteractiveRequest interactiveRequest =mapper.readValue(interactiveRequest1.getFirst("payload"), SelectInteractiveRequest.class); 
		//SelectInteractiveRequest interactiveRequest=null;
		CacheInfo cacheInfo=CacheInfo.getInstance();
		System.out.println("+++++++++++++++++++++++++++++++++++++++");
		System.out.println(new Gson().toJson(interactiveRequest));
		System.out.println("+++++++++++++++++++++++++++++++++++++++");
		String type=interactiveRequest.getActions().get(0).getType();
		if(StringUtils.equalsIgnoreCase(type, Constant.SELECT)) {
			text=interactiveRequest.getActions().get(0).getSelected_options().get(0).getValue();	
		}else if(StringUtils.equalsIgnoreCase(type, Constant.BUTTON)) {
			text=interactiveRequest.getActions().get(0).getValue();
		}
		String message=CacheInfo.getUserDetails(interactiveRequest.getUser().getName());
	//	if(!StringUtils.equalsIgnoreCase(message, text)) {
	//	CacheInfo.setUserDetail(interactiveRequest.getUser().getName(), text);

		response=slackService.postInteractiveMsgResponse(interactiveRequest);
	//	}
	}
	
	@RequestMapping(value=EndPointReferral.TEST, method=RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<?> test(@RequestBody SelectInteractiveRequest botResult) {
		logger.debug("Body is ::",new Gson().toJson(botResult));
		
		System.out.println("Bot Result is"+new Gson().toJson(botResult));
		
		
		
		return new ResponseEntity<>(true, HttpStatus.OK);
		
	}
}
