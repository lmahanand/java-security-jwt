package io.gopulu.javasecurityjwt;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JavaSecurityJwtApplication {
	private static final Logger logger = LoggerFactory.getLogger(JavaSecurityJwtApplication.class);

	public static void main(String[] args) {

		SpringApplication.run(JavaSecurityJwtApplication.class, args);
		logger.info("Application started.");
	}
}
