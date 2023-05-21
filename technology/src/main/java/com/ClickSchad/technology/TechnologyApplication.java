package com.ClickSchad.technology;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@RestController
@ComponentScan(basePackages= "com.ClickSchad.technology")
@EnableJpaRepositories(basePackages = "com.ClickSchad.technology.repository")
@EnableWebMvc
@EnableTransactionManagement
@EnableAutoConfiguration
@EntityScan(basePackages = "com.ClickSchad.technology.models")
public class TechnologyApplication {

	public static void main(String[] args) {
		SpringApplication.run(TechnologyApplication.class, args);
	}

}
