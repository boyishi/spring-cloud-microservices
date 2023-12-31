package com.demo.boyishi.orderservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.context.SecurityContextHolder;
// import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
// import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;

import feign.RequestInterceptor;
import lombok.RequiredArgsConstructor;

@SpringBootApplication
@EnableFeignClients
@RequiredArgsConstructor
public class OrderServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrderServiceApplication.class, args);
	}

    @Bean
    RequestInterceptor requestTokenBearerInterceptor() {
	    return requestTemplate -> {
	        JwtAuthenticationToken token = (JwtAuthenticationToken) SecurityContextHolder.getContext()
	                .getAuthentication();
	
	        requestTemplate.header("Authorization", "Bearer " + token.getToken().getTokenValue());
	    };
	}
}
