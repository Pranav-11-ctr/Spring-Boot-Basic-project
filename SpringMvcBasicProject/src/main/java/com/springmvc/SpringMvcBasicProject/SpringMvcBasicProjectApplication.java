package com.springmvc.SpringMvcBasicProject;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(
		info = @Info(
				title = "Spring Boot Basic Operations",
				description = "Spring Boot Basic Operations",
				version = "v1.0",
				contact = @Contact(
						name = "Pranav",
				email = "pranav@gmail.com",
				url = "https://www.pranav.net"
		),
				license = @License(
						name="Apache 2.0",
						url = "https://www.javaguides.com"
				)
		),
		externalDocs = @ExternalDocumentation(
				description = "Spring Boot User Management Documentation",
				url="https://www.javaguides.net/user_management.html"
		)
)
public class SpringMvcBasicProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringMvcBasicProjectApplication.class, args);
	}

}
