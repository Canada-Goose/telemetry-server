package com.telemetryServer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("com.sullins.telemetryServer.model")
public class TelemetryServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(TelemetryServerApplication.class, args);
	}

}
