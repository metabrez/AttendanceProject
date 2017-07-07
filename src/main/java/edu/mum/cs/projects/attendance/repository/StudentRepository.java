package edu.mum.cs.projects.attendance.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import edu.mum.cs.projects.attendance.domain.entity.Student;

@Repository
public interface StudentRepository extends CrudRepository<Student, String> {
	List<Student> findByEntryDate(Date entryDate);
	List<Student> findAll();
	/*Student findById(long id);*/
	
}
