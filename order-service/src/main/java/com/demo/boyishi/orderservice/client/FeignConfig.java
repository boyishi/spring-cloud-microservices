package com.demo.boyishi.orderservice.client;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import feign.Logger;

@Configuration
public class FeignConfig {
	@Bean
    Logger.Level feignLoggerLevel() {
        return Logger.Level.FULL;
    }
}
