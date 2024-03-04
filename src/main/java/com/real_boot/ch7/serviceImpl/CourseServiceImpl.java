package com.real_boot.ch7.serviceImpl;

import com.real_boot.ch7.entity.Course;
import com.real_boot.ch7.repository.CourseRepository;
import com.real_boot.ch7.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CourseServiceImpl implements CourseService {

	
	private final CourseRepository courseRepository;
	
	@Autowired
	public CourseServiceImpl(CourseRepository courseRepository) {
		this.courseRepository = courseRepository;
	}

	@Override
	public Course createCourse(Course course) {
		return courseRepository.save(course);
	}

	@Override
	public Optional<Course> getCourseById(long courseId) {
		return courseRepository.findById(courseId);
	}

	@Override
	public Iterable<Course> getCoursesByCategory(String category) {
		return courseRepository.findAllByCategory(category);
	}

	@Override
	public Iterable<Course> getCourses() {
		return courseRepository.findAll();
	}

	@Override
	public void updateCourse(long courseId, Course course) {
		courseRepository.findById(courseId).ifPresent(dbCourse -> {
			dbCourse.setName(course.getName());
			dbCourse.setCategory(course.getCategory());
			dbCourse.setDescription(course.getDescription());
			dbCourse.setRating(course.getRating());
			courseRepository.save(dbCourse);
		});
	}

	@Override
	public void deleteCourseById(long courseId) {
		 courseRepository.deleteById(courseId);
	}

	@Override
	public void deleteCourse() {
	courseRepository.deleteAll();
	}
}
