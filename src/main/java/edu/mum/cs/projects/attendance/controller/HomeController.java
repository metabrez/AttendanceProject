package edu.mum.cs.projects.attendance.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import edu.mum.cs.projects.attendance.domain.entity.Student;
import edu.mum.cs.projects.attendance.service.StudentServiceImpl;


@Controller
public class HomeController {
	
	@Autowired
	private StudentServiceImpl studentServiceImpl;
	
	@GetMapping("/")
	public String hello(){
		
		 
		return "home";
		
	}
	
	@GetMapping("/students")
	public String getAllStudents(Model model){
		
		List<Student> studentList = studentServiceImpl.getAllStudents();
	model.addAttribute("students", studentList);		
		
	return "studentList";
	
		
	}


}
