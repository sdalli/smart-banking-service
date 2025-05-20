package com.sesami.smart_banking_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SmartBankingServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SmartBankingServiceApplication.class, args);
		
		
		// Example of manually calling the service
//        ApplicationContext context = SpringApplication.run(SmartBankingServiceApplication.class, args);
//        NbfHttpWebServiceClient client = context.getBean(NbfHttpWebServiceClient.class);
//        try {
//			client.fetchOAuthTokenFromServer_debug();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
        
        
	}

}
