//package com.spring.demo.portfoliobackend.services;
//
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.stereotype.Service;
//import org.springframework.web.client.RestTemplate;
//import org.springframework.http.HttpEntity;
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.HttpMethod;
//import org.springframework.http.ResponseEntity;
//
//@Service
//public class RapidApiService {
//
//    @Value("${rapidapi.key}")
//    private String apiKey;
//
//    private final RestTemplate restTemplate;
//
//    public RapidApiService(RestTemplate restTemplate) {
//        this.restTemplate = restTemplate;
//    }
//
//    public String getStockSuggestions(String symbol) {
//        String url = String.format("https://yahoo-finance166.p.rapidapi.com/auto-complete?q=%s&region=US", symbol);
//        HttpHeaders headers = new HttpHeaders();
//        headers.set("X-Rapidapi-Key", apiKey);
//        headers.set("X-Rapidapi-Host", "yahoo-finance166.p.rapidapi.com");
//
//        HttpEntity<String> entity = new HttpEntity<>(headers);
//        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
//        return response.getBody();
//    }
//}