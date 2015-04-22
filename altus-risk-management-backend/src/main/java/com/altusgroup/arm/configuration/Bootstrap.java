package com.altusgroup.arm.configuration;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.linking.DeclarativeLinkingFeature;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
public class Bootstrap {
	public static void main(String[] args) {
		SpringApplication.run(Bootstrap.class, args);
	}

	@Configuration
	@ApplicationPath("/resource")
	public static class JerseyConfig extends ResourceConfig {

		public static final String RESOURCE_PACKAGE = "hateoas.example"
				+ ".resource";

		public JerseyConfig() {
			packages(RESOURCE_PACKAGE);
			register(DeclarativeLinkingFeature.class);
		}
	}

}