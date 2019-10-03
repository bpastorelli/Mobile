package br.com.mobile.regression;

import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfiguration {
	
	@Bean
	public TestRestTemplate testRestTemplate() {
		return new TestRestTemplate();
	}
}
