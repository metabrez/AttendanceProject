package edu.mum.cs.projects.attendance.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


import edu.mum.cs.projects.attendance.domain.entity.Course;
import edu.mum.cs.projects.attendance.domain.entity.CourseOffering;
import edu.mum.cs.projects.attendance.domain.entity.Faculty;
import edu.mum.cs.projects.attendance.domain.entity.Location;
import edu.mum.cs.projects.attendance.domain.entity.Student;
import edu.mum.cs.projects.attendance.domain.entity.Timeslot;
import edu.mum.cs.projects.attendance.repository.RoleRepository;
import edu.mum.cs.projects.attendance.service.CourseServiceImpl;
import edu.mum.cs.projects.attendance.service.LocationServiceImpl;
import edu.mum.cs.projects.attendance.service.StudentServiceImpl;
import edu.mum.cs.projects.attendance.service.TimeSlotService;

@Controller
public class HomeController {

	@Autowired
	private StudentServiceImpl studentServiceImpl;

	@Autowired
	private CourseServiceImpl courseServiceImpl;

	@Autowired

	private TimeSlotService timeSlotService;

	@Autowired
	private CourseServiceImpl courseSeviceImpl;

	@Autowired
	private LocationServiceImpl locationServiceImpl;

	@Autowired
	private RoleRepository roleRepository;

	/*
	 * @GetMapping({ "/", "/index", "/home" }) public ModelAndView homePage() {
	 * ModelAndView modelAndView = new ModelAndView("home"); Collection<?
	 * extends GrantedAuthority> authorities =
	 * SecurityContextHolder.getContext().getAuthentication() .getAuthorities();
	 * boolean isAdmin = authorities.contains(new
	 * SimpleGrantedAuthority("ADMIN")); modelAndView.addObject("user", isAdmin
	 * ? "ADMIN" : "USER");
	 * 
	 * return modelAndView; }
	 */

	@GetMapping("/")
	public String homePage() {

		return "home";

	}

	@GetMapping("/studentDetails")
	public String StudentDetails() {

		return "studentDetails";
	}
	
	@GetMapping("/courseList")
	public String CourseList() {

		return "courseList";
	}
	@GetMapping("/attendanceList")
	public String attendanceList() {

		return "studentAttendace";
	}

	@RequestMapping("/login")
	public String login(@RequestParam(value = "error", required = false) String error,
			@RequestParam(value = "logout", required = false) String logout, Model model) {

		if (error != null) {

			model.addAttribute("error", "Invalid UserName and Password");
		}
		if (logout != null) {
			model.addAttribute("error", "You have been logout successfully");
		}

		return "login";
	}

	@GetMapping("/studentDetails/students")
	public String getAllStudents(Model model) {

		List<Student> studentList = studentServiceImpl.getAllStudents();
		model.addAttribute("students", studentList);

		return "studentList";

	}

	@GetMapping("/timeSlots")
	public String getTimeSlots(Model model) {

		List<Timeslot> timeSlotList = timeSlotService.getTimeSlot();

		model.addAttribute("timeSlots", timeSlotList);

		return "timeSlotsList";

	}

	@GetMapping("/courses")
	public String getCourse(Model model) {

		List<Course> courseList = courseServiceImpl.getAllCourses();

		model.addAttribute("courses", courseList);
		return "courseList";
	}

	@GetMapping("/studentDetails/courseOfferings")
	public String getCourseOfferings(Model model) {

		List<CourseOffering> courseOfferingList = courseSeviceImpl.getCourseOffering();

		Course course = new Course();
		Faculty falculty = new Faculty();

		model.addAttribute("courseOfferings", courseOfferingList);
		return "courseOfferingList";
	}

	@GetMapping("/locations")
	public String getLocation(Model model) {

		List<Location> location = locationServiceImpl.getAllLocations();

		model.addAttribute("locations", location);

		return "location";
	}

	/*
	 * public String addStudent(Model model){
	 * 
	 * studentServiceImpl.save(Student student)
	 * 
	 * model.addAttribute("students", student); }
	 */
}
