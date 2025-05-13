package com.sesami.smart_banking_service;

import io.netty.handler.ssl.SslContext;
import io.netty.handler.ssl.SslContextBuilder;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.netty.http.client.HttpClient;

import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.TrustManagerFactory;
import java.io.FileInputStream;
import java.security.KeyStore;
@Component
public class CustomWebClient {
	
	 private static final String BASE_URL = "https://nbfappextwmuat.nbf.ae:443"; // Add your base URL here

	    public WebClient CustomWebClient() {
	        return WebClient.builder()
	                .baseUrl(BASE_URL) // Set the base URL
	                .build();
	    }
	    

    public WebClient createWebClient() {
        try {
            // Load Truststore
            KeyStore trustStore = KeyStore.getInstance(KeyStore.getDefaultType());
            try (FileInputStream trustStoreStream = new FileInputStream("src/main/resources/TGHQGUN - nbf-uat-working-20240216.jks")) {
                trustStore.load(trustStoreStream, "gunnebo".toCharArray());
            }

            TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
            trustManagerFactory.init(trustStore);

            // Load Keystore (if mutual TLS is required)
            KeyStore keyStore = KeyStore.getInstance(KeyStore.getDefaultType());
            try (FileInputStream keyStoreStream = new FileInputStream("src/main/resources/TGHQGUN - nbf-uat-working-20240216.jks")) {
                keyStore.load(keyStoreStream, "gunnebo".toCharArray());
            }

            KeyManagerFactory keyManagerFactory = KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());
            keyManagerFactory.init(keyStore, "gunnebo".toCharArray());

            // Build Netty SslContext
            SslContext sslContext = SslContextBuilder.forClient()
                    .keyManager(keyManagerFactory) // Set client key manager (for mutual TLS)
                    .trustManager(trustManagerFactory) // Set trust manager
                    .build();

            // Configure HttpClient with custom SslContext
            HttpClient httpClient = HttpClient.create()
                    .secure(spec -> spec.sslContext(sslContext));

            // Create WebClient with custom HttpClient
            return WebClient.builder()
                    .clientConnector(new ReactorClientHttpConnector(httpClient))
                    .build();

        } catch (Exception e) {
            throw new RuntimeException("Failed to create WebClient with custom SSL configuration", e);
        }
    }
}
