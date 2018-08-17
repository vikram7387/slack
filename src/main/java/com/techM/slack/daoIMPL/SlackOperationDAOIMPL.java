package com.techM.slack.daoIMPL;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.CriteriaDefinition;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import com.google.gson.Gson;
import com.techM.slack.dao.SlackOperationDAO;
import com.techM.slack.model.AuthResponse;
import com.techM.slack.model.Message;
import com.techM.slack.model.SlackConfiguration;
import com.techM.slack.serviceIMPL.SlackServiceImpl;

@Repository
public class SlackOperationDAOIMPL implements SlackOperationDAO{

	private static final Logger logger = LoggerFactory.getLogger(SlackOperationDAOIMPL.class);
	
	@Autowired
	MongoTemplate mongoTemplate;

	public boolean saveUserAuth(AuthResponse authResponse) {
		logger.debug("In save Auth ::",new Gson().toJson(authResponse));
		try {
			Query query=new Query();
			query.addCriteria(Criteria.where("body.user_id").is(authResponse.getBody().getUser_id()));
			boolean status=mongoTemplate.exists(query,"authResponse");
			if(status) {
				mongoTemplate.findAllAndRemove(query,"authResponse");
			}
			
			mongoTemplate.save(authResponse);
		}catch (Exception e) {
			logger.debug(e.getMessage());
			return false;
		}
			return true;
	}

	public AuthResponse getAuthUser(String user_id) {
	
		logger.debug("In get Auth User Id:::",user_id);
		try {
				Query query=new Query();
				query.addCriteria(Criteria.where("body.user_id").is(user_id));
				
				AuthResponse authResponse=mongoTemplate.findOne(query, AuthResponse.class);
				
				logger.debug("Auth User Is ", new Gson().toJson(authResponse));
				
				return authResponse;
		}catch (Exception e) {
			logger.debug(e.getMessage());
		}
		return null;
	}

	public boolean saveSlackConfiguration(SlackConfiguration configurations) {
	
		logger.debug("In save Slack config:::",configurations);
		try {
			Query query=new Query();
			query.addCriteria(Criteria.where("active").is(true));
			Update update=new Update();
			update.set("active", false);
			
			mongoTemplate.updateMulti(query,update , "slackConfiguration");
			
			mongoTemplate.save(configurations);
		}catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public SlackConfiguration getSlackConfiguration() {
	logger.debug("In get Slack Configuration Method");
		Query query=new Query();
		query.addCriteria(Criteria.where("workSpaceName").is("nessa-world")
				.and("active").is(true));
		SlackConfiguration configuration=mongoTemplate.findOne(query,SlackConfiguration.class);
		return configuration;
	}
	
}
