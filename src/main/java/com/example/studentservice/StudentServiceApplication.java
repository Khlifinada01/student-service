package com.example.studentservice;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
@EnableFeignClients("com.example.studentservice.feignclients")
@EnableEurekaClient
public class StudentServiceApplication {


	@Value("${adress.service.url}")

	private String adressserviceurl;


	public static void main(String[] args) {
		SpringApplication.run(StudentServiceApplication.class, args);

	}
        @Bean
	public WebClient webClient() {
		WebClient wc = WebClient.builder()
				.baseUrl(adressserviceurl).build();
		System.out.println(adressserviceurl);
		System.out.println("wc :" + wc);
		return wc;

	}
}

