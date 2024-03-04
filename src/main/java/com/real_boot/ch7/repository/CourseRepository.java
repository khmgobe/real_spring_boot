package com.real_boot.ch7.repository;

import com.real_boot.ch7.entity.Course;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends CrudRepository<Course, Long> {

	Iterable<Course> findAllByCategory(String category);
}
