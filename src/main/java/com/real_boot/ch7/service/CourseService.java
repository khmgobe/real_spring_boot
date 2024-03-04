package com.real_boot.ch7.service;

import com.real_boot.ch7.entity.Course;

import java.util.Optional;

public interface CourseService {

	Course createCourse(Course course);

	Optional<Course> getCourseById(long courseId);

	Iterable<Course> getCoursesByCategory(String category);

	Iterable<Course> getCourses();

	void updateCourse(long courseId, Course course);

	void deleteCourseById(long courseId);

	void deleteCourse();

}
