package com.sesami.smart_banking_service;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.security.KeyStore;

import javax.net.ssl.TrustManagerFactory;

import org.springframework.core.io.ClassPathResource;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import io.netty.handler.ssl.SslContext;
import io.netty.handler.ssl.SslContextBuilder;
import reactor.netty.http.client.HttpClient;

@Component
public class CustomWebClient {

    private static final String BASE_URL = "https://nbfappextwmuat.nbf.ae";

//    public WebClient createWebClient() {
//        try {
//            // Load Truststore
//            KeyStore trustStore = KeyStore.getInstance(KeyStore.getDefaultType());
//            try (InputStream trustStoreStream = new ClassPathResource("truststore.jks").getInputStream()) {
//                trustStore.load(trustStoreStream, "gunnebo".toCharArray());
//            }
//
//            TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
//            trustManagerFactory.init(trustStore);
//
//            // Build Netty SslContext
//            SslContext sslContext = SslContextBuilder.forClient()
//                    .trustManager(trustManagerFactory) // Set trust manager
//                    .build();
//
//            // Configure HttpClient with custom SslContext
//            HttpClient httpClient = HttpClient.create()
//                    .secure(spec -> spec.sslContext(sslContext));
//
//            // Create WebClient with custom HttpClient
//            return WebClient.builder()
//                    .baseUrl(BASE_URL)
//                    .clientConnector(new ReactorClientHttpConnector(httpClient))
//                    .build();
//        } catch (Exception e) {
//            throw new RuntimeException("Failed to create WebClient with custom SSL configuration", e);
//        }
//    }
    

   

        public WebClient createWebClient() {
            try {
            	 System.setProperty("javax.net.ssl.trustStore", "src/main/resources/truststore.jks");
                 System.setProperty("javax.net.ssl.trustStorePassword", "gunnebo");
                 System.setProperty("javax.net.ssl.keyStore", "src/main/resources/truststore.jks");
                 System.setProperty("javax.net.ssl.keyStorePassword",  "gunnebo");
                 
                // Load Truststore
                KeyStore trustStore = KeyStore.getInstance(KeyStore.getDefaultType());
                try (InputStream trustStoreStream = new ClassPathResource("src/main/resources/truststore.jks").getInputStream()) {
                    trustStore.load(trustStoreStream, "gunnebo".toCharArray()); // Replace "password" with the actual password
                }

                TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
                trustManagerFactory.init(trustStore);

                // Build Netty SslContext
                SslContext sslContext = SslContextBuilder.forClient()
                        .trustManager(trustManagerFactory)
                        .build();

                // Configure HttpClient with custom SslContext
                HttpClient httpClient = HttpClient.create()
                        .secure(spec -> spec.sslContext(sslContext));

                // Create WebClient with custom HttpClient
                return WebClient.builder()
                        .baseUrl(BASE_URL)
                        .clientConnector(new ReactorClientHttpConnector(httpClient))
                        .build();
            } catch (Exception e) {
                throw new RuntimeException("Failed to create WebClient with custom SSL configuration.", e);
            }
        }
    
}