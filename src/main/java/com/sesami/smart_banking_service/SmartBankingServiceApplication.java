package com.sesami.smart_banking_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SmartBankingServiceApplication {

	public static void main(String[] args) {
		//SpringApplication.run(SmartBankingServiceApplication.class, args);
		
		
		// Example of manually calling the service
        ApplicationContext context = SpringApplication.run(SmartBankingServiceApplication.class, args);
        NbfHttpWebServiceClient client = context.getBean(NbfHttpWebServiceClient.class);
        client.fetchOAuthTokenFromServer();
        
        
	}

}
