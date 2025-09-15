package com.bagrivikas.cards;

import com.bagrivikas.cards.dto.CardsContactInfoDto;
import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing(auditorAwareRef = "auditAwareImpl")
@EnableConfigurationProperties(value = {CardsContactInfoDto.class})
@OpenAPIDefinition(
        info = @Info(
                title = "Cards microservice REST API Documentation",
                description = "EazyBank Cards microservice REST API Documentation by Vikas Bagri",
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
                description =  "EazyBank Cards microservice REST API Documentation by Vikas Bagri",
                url = "https://www.linkedin.com/in/vikas-bagri-281b01237/"
        )
)
public class CardsApplication {

	public static void main(String[] args) {
		SpringApplication.run(CardsApplication.class, args);
	}

}
