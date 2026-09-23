package jdbc_implemetation.example.jdbc_implementation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class JdbcImplementationApplication
		extends SpringBootServletInitializer {

	public static void main(String[] args) {

		SpringApplication.run(
				JdbcImplementationApplication.class,
				args
		);
	}

	@Override
	protected SpringApplicationBuilder configure(
			SpringApplicationBuilder application) {

		return application.sources(
				JdbcImplementationApplication.class
		);
	}
}