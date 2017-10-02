package com.mrdfood.demo.boot.config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

 
import com.mongodb.MongoClient;
 

@Configuration
@EnableMongoRepositories(basePackages={"com.mrdfood.demo.boot.repository"})
public class ApplicationConfig {
	     
	    public @Bean
	    MongoDbFactory mongoDbFactory() throws Exception {
	        MongoClient mongoClient = new MongoClient("localhost",27017);
	        return new SimpleMongoDbFactory(mongoClient, "MrDFood");
	    }
	 
	    public @Bean
	    MongoTemplate mongoTemplate() throws Exception {
	        MongoTemplate mongoTemplate = new MongoTemplate(mongoDbFactory());
	        return mongoTemplate;
	    }
	     
            
	}

