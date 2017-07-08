package edu.mum.cs.projects.attendance.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import edu.mum.cs.projects.attendance.domain.entity.Course;

@Repository
public interface CourseRepository extends CrudRepository<Course, String> {
	
	List<Course> findAll();
	
	

}
