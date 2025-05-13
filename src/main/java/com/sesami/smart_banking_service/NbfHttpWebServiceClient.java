package com.sesami.smart_banking_service;


import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;

@Service
public class NbfHttpWebServiceClient {

    private final WebClient webClient;

    // Inject CustomWebClient to initialize WebClient
    public NbfHttpWebServiceClient(CustomWebClient customWebClient) {
        this.webClient = customWebClient.createWebClient();
    }
    
    
    

    public String fetchOAuthTokenFromServer() {
        // Request payload
        var payload = new OAuthRequestPayload("scdmuseruat", "scdmuseruat123", "client_credentials");

        try {
            // Make the HTTP POST request
            String response = webClient.post()
                    .uri("/gateway/v1/accessToken/getOAuthToken") // Endpoint path
                    .headers(headers -> {
                        headers.add("NBF-APIKey", "387a8061-53e4-4f75-9183-fc07373944ce");
                        headers.add("Content-Type", "application/json");
                        headers.add("Accept", "application/json");
                    })
                    .bodyValue(payload) // Pass the request body
                    .retrieve()
                    .bodyToMono(String.class) // Deserialize the response to a String
                    .block(); // Block for the response (not reactive)

            System.out.println("Access Token Response: " + response);
            return response;
        } catch (WebClientResponseException e) {
            // Handle HTTP error responses
            System.err.println("Error Response: " + e.getResponseBodyAsString());
            throw new RuntimeException("Failed to fetch OAuth token: " + e.getMessage(), e);
        } catch (Exception e) {
            // Handle other exceptions
            e.printStackTrace();
            throw new RuntimeException("An unexpected error occurred.", e);
        }
    }

    // Inner class for the request payload
    private record OAuthRequestPayload(String clientId, String clientSecret, String grantType) {}
}