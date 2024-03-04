package com.real_boot.ch2.beanValidation;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Course2 {

	private long id;
	private String name;
	private String category;

	/** Bean validation 제약 사항 추가 */
	@Min(value = 1, message = "A course should have a minimum of 1 rating")
	@Max(value = 5, message = " A course should have a maximum of 5 rating")
	private int rating;

	private String description;
}
