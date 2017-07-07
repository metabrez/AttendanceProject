package edu.mum.cs.projects.attendance.Restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.mum.cs.projects.attendance.domain.entity.Student;
import edu.mum.cs.projects.attendance.service.StudentServiceImpl;

@RestController
@RequestMapping(value="/studentRest")
public class StudentController {
	
	@Autowired
	private StudentServiceImpl studentServiceImpl;
	
	@GetMapping("")
	public List<Student> getAllStudent(){
		
		
		return studentServiceImpl.getAllStudents();
	}
	
	
	/*@GetMapping(value="{id}")
	public ResponseEntity<?> getStudent(@PathVariable("id") long  id){
		
		Student student=studentServiceImpl.getStudentById(id);
		
		return new ResponseEntity<Student>(student,HttpStatus.OK);
	}
	@PostMapping("/save")
	public Student saveStudent(Student student){
		
		studentServiceImpl.save(student);
		
		return student;
	}*/

}
