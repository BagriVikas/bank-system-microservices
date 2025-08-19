package com.bagrivikas.accounts;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing(auditorAwareRef = "auditAwareImpl")
@OpenAPIDefinition(
		info = @Info(
				title = "Accounts microservice REST API Documentation",
				description = "EazyBank Accounts microservice REST API Documentation by Vikas Bagri",
				version = "v1",
				contact = @Contact(
						name = "Vikas Bagri",
						email = "bagrivikas1998@gmail.com",
						url = "https://www.linkedin.com/in/vikas-bagri-281b01237/"
				),
				license = @License(
						name = "Apache 2.0",
						url = "https://www.linkedin.com/in/vikas-bagri-281b01237/"
				)
		),
		externalDocs = @ExternalDocumentation(
				description =  "EazyBank Accounts microservice REST API Documentation by Vikas Bagri",
				url = "https://www.linkedin.com/in/vikas-bagri-281b01237/"
		)
)
public class AccountsApplication {

	public static void main(String[] args) {
		SpringApplication.run(AccountsApplication.class, args);
	}

}
