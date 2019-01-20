package com.au.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.client.ResponseErrorHandler;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;

@SpringBootApplication
public class SearchApiApplication {

	private static final Logger LOGGER = LoggerFactory.getLogger(SearchApiApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(SearchApiApplication.class, args);
	}

	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		RestTemplate restTemplate = builder.build();

		restTemplate.setErrorHandler(new ResponseErrorHandler() {
			@Override
			public boolean hasError(ClientHttpResponse response) throws IOException {
				if (!response.getStatusCode().is2xxSuccessful()) {
                    LOGGER.error("Response code from venue search = [{}]", response.getStatusText());
                }
				return false; // or whatever you consider an error
			}

			@Override
			public void handleError(ClientHttpResponse response) throws IOException {
				// do nothing, or something
			}
		});

		return restTemplate;
	}
}

