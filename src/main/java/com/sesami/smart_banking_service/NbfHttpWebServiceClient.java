package com.sesami.smart_banking_service;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.URL;
import java.security.KeyStore;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManagerFactory;

import org.springframework.stereotype.Service;


@Service
public class NbfHttpWebServiceClient {

   // private final WebClient webClient;

    // Inject CustomWebClient to initialize WebClient
	/*
	 * public NbfHttpWebServiceClient(CustomWebClient customWebClient) { try {
	 * this.webClient = customWebClient.createWebClient(); } catch (Exception e) {
	 * System.err.println("Error initializing WebClient: " + e.getMessage()); throw
	 * e; } } public String fetchOAuthTokenFromServer() { var payload = new
	 * OAuthRequestPayload("scdmuseruat", "scdmuseruat123", "client_credentials");
	 * 
	 * try { String response = webClient.post()
	 * .uri("/gateway/v1/accessToken/getOAuthToken") .headers(headers -> {
	 * headers.add("NBF-APIKey", "387a8061-53e4-4f75-9183-fc07373944ce");
	 * headers.add("Content-Type", "application/json"); headers.add("Accept",
	 * "application/json"); }) .bodyValue(payload) .retrieve()
	 * .bodyToMono(String.class) .block();
	 * 
	 * System.out.println("Access Token Response: " + response); return response; }
	 * catch (WebClientResponseException e) { System.err.println("Error Response: "
	 * + e.getResponseBodyAsString()); throw new
	 * RuntimeException("Failed to fetch OAuth token: " + e.getMessage(), e); }
	 * catch (Exception e) { e.printStackTrace(); throw new
	 * RuntimeException("An unexpected error occurred.", e); } }
	 */

    // Inner class for the request payload
   // private record OAuthRequestPayload(String clientId, String clientSecret, String grantType) {}
	
	

//	  public String fetchOAuthTokenFromServer() throws IOException {
//	        String tokenUrl = "https://nbfappextwmuat.nbf.ae/gateway/v1/accessToken/getOAuthToken";
//	        String content = "{\"clientId\":\"" + nbfApiClientid + "\",\"clientSecret\":\"" + nbfApiClientSecret
//	                + "\",\"grantType\":\"client_credentials\"}";
//	        HttpsURLConnection connection = null;
//	        BufferedReader reader = null;
//
//	        System.setProperty("javax.net.ssl.trustStore", "src/main/resources/truststore.jks");
//	        System.setProperty("javax.net.ssl.trustStorePassword", "gunnebo");
//	        System.setProperty("javax.net.ssl.keyStore", "src/main/resources/truststore.jks");
//	        System.setProperty("javax.net.ssl.keyStorePassword",  "gunnebo");
//
//	        try {
//	            URL url = new URL(tokenUrl);
//	            connection = (HttpsURLConnection) url.openConnection();
//	            connection.setRequestMethod("POST");
//	            connection.setDoOutput(true);
//	           // connection.setRequestProperty("Content-Type", "application/json");
//	            connection.setRequestProperty("Accept", "application/json");
//	            connection.setRequestProperty("NBF-APIKey", "387a8061-53e4-4f75-9183-fc07373944ce");
//	            connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
//
//
//	            try (OutputStream os = connection.getOutputStream()) {
//	                os.write(content.getBytes());
//	            }
//
//	            StringBuilder response = new StringBuilder();
//	            reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
//	            String line;
//	            while ((line = reader.readLine()) != null) {
//	                response.append(line);
//	            }
//	            System.out.println(response.toString());
//	            return response.toString();
//	        } finally {
//	            if (reader != null) {
//	                reader.close();
//	            }
//	            if (connection != null) {
//	                connection.disconnect();
//	            }
//	        }
//	    }
	  
	  


		 String nbfApiClientid="scdmuseruat";
		  String nbfApiClientSecret="scdmuseruat123";
	  public String fetchOAuthTokenFromServer() throws Exception {
	      String tokenUrl = "https://nbfappextwmuat.nbf.ae/gateway/v1/accessToken/getOAuthToken";
	      String content = "{\"clientId\":\"" + nbfApiClientid + "\",\"clientSecret\":\"" + nbfApiClientSecret
	              + "\",\"grantType\":\"client_credentials\"}";

	      KeyStore keyStore = KeyStore.getInstance(KeyStore.getDefaultType());
	    //  D:\Sesami-workspace-2025\smart-banking-service\src\main\resources
	      try (FileInputStream keyStoreStream = new FileInputStream("D:\\Sesami-workspace-2025\\smart-banking-service\\src\\main\\resources\\keystore.jks")) {
	          keyStore.load(keyStoreStream, "gunnebo".toCharArray());
	      }

	      TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
	      trustManagerFactory.init(keyStore);

	      SSLContext sslContext = SSLContext.getInstance("TLS");
	      sslContext.init(null, trustManagerFactory.getTrustManagers(), null);

	      HttpsURLConnection.setDefaultSSLSocketFactory(sslContext.getSocketFactory());

	      URL url = new URL(tokenUrl);
	      HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();
	      connection.setRequestMethod("POST");
	      connection.setDoOutput(true);
	      connection.setRequestProperty("Accept", "application/json");
	      connection.setRequestProperty("NBF-APIKey", "387a8061-53e4-4f75-9183-fc07373944ce");
	      connection.setRequestProperty("Content-Type", "application/json");

	      try (OutputStream os = connection.getOutputStream()) {
	          os.write(content.getBytes());
	      }

	      StringBuilder response = new StringBuilder();
	      try (BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
	          String line;
	          while ((line = reader.readLine()) != null) {
	              response.append(line);
	          }
	      }

	      System.out.println(response.toString());
	      return response.toString();
	  }
	  
	  

public String fetchOAuthTokenFromServer_new() throws Exception {
    String tokenUrl = "https://nbfappextwmuat.nbf.ae/gateway/v1/accessToken/getOAuthToken";
    String content = "{\"clientId\":\"scdmuseruat\",\"clientSecret\":\"scdmuseruat123\",\"grantType\":\"client_credentials\"}";

    KeyStore keyStore = KeyStore.getInstance(KeyStore.getDefaultType());
    try (FileInputStream keyStoreStream = new FileInputStream("D:\\Sesami-workspace-2025\\smart-banking-service\\src\\main\\resources\\keystore.jks")) {
        keyStore.load(keyStoreStream, "gunnebo".toCharArray());
    }

    TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
    trustManagerFactory.init(keyStore);

    SSLContext sslContext = SSLContext.getInstance("TLS");
    sslContext.init(null, trustManagerFactory.getTrustManagers(), null);

    HttpsURLConnection.setDefaultSSLSocketFactory(sslContext.getSocketFactory());

    URL url = new URL(tokenUrl);
    HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();
    connection.setRequestMethod("POST");
    connection.setDoOutput(true);
    connection.setRequestProperty("Accept", "application/json");
    connection.setRequestProperty("NBF-APIKey", "387a8061-53e4-4f75-9183-fc07373944ce");
    connection.setRequestProperty("Content-Type", "application/json");

    try (OutputStream os = connection.getOutputStream()) {
        os.write(content.getBytes());
    }

    StringBuilder response = new StringBuilder();
    try (BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
        String line;
        while ((line = reader.readLine()) != null) {
            response.append(line);
        }
    }

    System.out.println(response.toString());
    return response.toString();
}
}