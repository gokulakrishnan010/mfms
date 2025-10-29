package com.acme.mutualfund;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@SpringBootApplication
@ConfigurationPropertiesScan
public class MfmsApplication {

	public static void main(String[] args) {
		SpringApplication.run(MfmsApplication.class, args);
	}

}
