package com.real_boot;

import com.real_boot.ch2.beanValidation.Course;
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
		Course course = new Course();
		course.setId(1);
		course.setRating(0);

		Validator validator = Validation.buildDefaultValidatorFactory().getValidator();

		Set<ConstraintViolation<Course>> violations = validator.validate(course);

		violations.forEach(courseConstraintViolation ->
				log.error("A constraint violation has occurred. Violation details: [{}], " , courseConstraintViolation));
	}
}
