package com.yc.springcloud812.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.web.client.RestTemplate;

import java.nio.charset.Charset;
import java.util.Base64;

@Configuration
public class AppConfig {

    @Bean
    public RestTemplate restTemplate(){return new RestTemplate();}

    @Bean
    public HttpHeaders getHeaders(){
        HttpHeaders headers=new HttpHeaders();
        String auth="admin:a";
        byte[] encodeAuth= Base64.getEncoder().encode(auth.getBytes(Charset.forName("US-ASCII")));
        String authHeader="Basic "+new String(encodeAuth);
        headers.set("Authorization",authHeader);
        return headers;
    }
}
