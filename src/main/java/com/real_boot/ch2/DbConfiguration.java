package com.real_boot.ch2;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

@Configuration
@PropertySource("classpath:dbConfig.properties")
public class DbConfiguration {

	@Autowired
	private  Environment environment;

	@Override
	public String toString() {
		return "Username : " + environment.getProperty("user") +
				", Password: " + environment.getProperty("password");
	}
}
