package com.sujoy.AI.Code.Scrutinizer;

import java.lang.module.ModuleDescriptor.Builder;

import org.springframework.boot.autoconfigure.cassandra.CassandraProperties.Request;
import org.springframework.boot.autoconfigure.elasticsearch.ElasticsearchProperties.Restclient;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service
public class AiClient {
	private final RestClient client;
	public AiClient(RestClient.Builder build) {
		this.client = build.baseUrl("http://localhost:11434").build();
	}
	public String TheMain(String program, int level) {
		String prompt2 = "";
		if(level == 1) {
			prompt2 = "make a gentle, constructive code review. ";
		}else if(level == 2) {
			prompt2 = "make sarcastic comments, but helpful. ";
		}else if (level == 3){
			prompt2 = "make ruthless roasting, pure toxicity. Do not hold back. ";
		}
		String prompt = "You are a senior developer. On this given code, " + prompt2+ " Also make sure that your answer is very witty, and only maintain the act of the senior developer, not an ai: \n " + program;
		OllamaRequest request  = new OllamaRequest("codellama", prompt, false);
		
		OllamaResponse response = client.post()  //I waana post this
				.uri("/api/generate")  // I gotta go to this generate room
				.body(request)    // here is the package bro
				.retrieve()     //go and dont come back till u have the ans bruh
				.body(OllamaResponse.class); //return the ans to this java buddy (class) for translation
		return response.response();
	}
}
