package com.real_boot;

import com.real_boot.ch2.beanValidation.Course;
import com.real_boot.ch2.beanValidation.User;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Set;

@SpringBootApplication
@Slf4j
public class RealSpringBootApplication implements CommandLineRunner {

	public static void main(String[] args) {

		SpringApplication.run(RealSpringBootApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {
		User user1 = new User("snbip01", "sbip");

		Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
		Set<ConstraintViolation<User>> violations = validator.validate(user1);

		log.error("password for user1 do not adhere to the password");

		violations.forEach(userConstraintViolation -> log.error("Violation details: [{}].",
				userConstraintViolation.getMessage()));

		User user2 = new User("sbip02", "Sbip01$4UDfg");
		violations = validator.validate(user2);
		if (violations.isEmpty()) {
			log.info("Password for user2 adhere to the password policy");
		}

		User user3 = new User("sbip03", "Sbip01$4UDfgggg");
		violations = validator.validate(user3);
		log.error("Password for user3 ");
		violations.forEach(userConstraintViolation -> log.error("{}", userConstraintViolation.getMessage()));

		User user4 = new User("sbip04", "Sbip014UDfgggg");
		violations = validator.validate(user4);
		log.error("Password for user4 ");
		violations.forEach(userConstraintViolation -> userConstraintViolation.getMessage());
	}
}
