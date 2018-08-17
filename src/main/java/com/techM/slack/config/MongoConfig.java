package com.techM.slack.config;

import java.io.InputStream;
import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.authentication.UserCredentials;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.mongodb.MongoClient;

@Configuration
@ComponentScan("com.techM.slack")
@EnableTransactionManagement
@EnableWebMvc
@EnableMongoRepositories(basePackages="com.techM.slack")
public class MongoConfig {
	
	@Bean
    public MongoDbFactory mongoDbFactory() throws Exception {
	
		String database = "slack";
		MongoClient mongoClient = new MongoClient("localhost:27017");
    	UserCredentials userCredentials = new UserCredentials("","");
        return new SimpleMongoDbFactory(mongoClient, database,userCredentials);
    }
	    
	    @Bean
	    public MongoTemplate mongoTemplate() throws Exception {
	        MongoTemplate mongoTemplate = new MongoTemplate(mongoDbFactory());
	        return mongoTemplate;
	    }

}
