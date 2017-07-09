package edu.mum.cs.projects.attendance.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.mum.cs.projects.attendance.domain.ComproEntry;
import edu.mum.cs.projects.attendance.domain.entity.AcademicBlock;
import edu.mum.cs.projects.attendance.domain.entity.Course;
import edu.mum.cs.projects.attendance.domain.entity.CourseOffering;
import edu.mum.cs.projects.attendance.domain.entity.Enrollment;
import edu.mum.cs.projects.attendance.domain.entity.Student;
import edu.mum.cs.projects.attendance.repository.AcademicBlockRepository;
import edu.mum.cs.projects.attendance.repository.CourseOfferingRepository;
import edu.mum.cs.projects.attendance.repository.CourseRepository;
import edu.mum.cs.projects.attendance.repository.EnrollmentRepository;
import edu.mum.cs.projects.attendance.util.DateUtil;

/**
 * <h1>Maharishi University of Management<br/>
 * Computer Science Department</h1>
 * 
 * <p>
 * Service layer facade, hides away details of dataaccess layer from client.
 * </p>
 *
 * @author Payman Salek
 * 
 * @version 1.0.0
 * @since 1.0.0
 */
@Service
public class CourseServiceImpl implements CourseService {

	@Autowired
	CourseOfferingRepository courseOfferingRepository;

	@Autowired
	AcademicBlockRepository academicBlockRepository;

	@Autowired
	private CourseRepository courseRepository;
	
	@Autowired
	private EnrollmentRepository enrollmentRepository;
	
	@Override
	public List<ComproEntry> getComproEntries(String startDate) {
		Course course = new Course("Entry");
		List<CourseOffering> offerings = courseOfferingRepository.findByCourse(course);

		return offerings.stream().map(offering -> new ComproEntry(offering))
				.filter(ce -> ce.getDate().isAfter(LocalDate.parse(startDate)))
				.sorted(Comparator.comparing(ComproEntry::getDate)).distinct().collect(Collectors.toList());
	}

	@Override
	public List<CourseOffering> getCourseOfferings(String blockStartDate) {
		Date date = DateUtil.convertStringToDate(blockStartDate);
		AcademicBlock block = getAcademicBlock(blockStartDate);

		List<CourseOffering> offerings = courseOfferingRepository.findByStartDate(date);

		return offerings.stream()
				.filter(o -> o.isOnCampus() && o.isActive())
				.peek(o -> o.setBlock(block))
				.collect(Collectors.toList());
	}

	@Override
	public AcademicBlock getAcademicBlock(String blockBeginDate) {
		Date beginDate = DateUtil.convertStringToDate(blockBeginDate);
		return academicBlockRepository.findByBeginDate(beginDate);
	}

	@Override
	public List<Enrollment> getEnrollment(CourseOffering offering) {
		return offering.getEnrollments().stream()
				.filter(o -> Enrollment.Status.SIGNEDUP.toString().equalsIgnoreCase(o.getStatus()))
				.collect(Collectors.toList());
	}

	@Override
	public List<Course> getAllCourses() {
		
		return courseRepository.findAll();
	}

	@Override
	public List<CourseOffering> getCourseOffering() {
		
		return courseOfferingRepository.findAll();
	}

	@Override
	public List<Course> getCourseListByStudentId(String studentId) {
	
		List<Course> courseList = new ArrayList<>();
		List<Enrollment> enrollmentListByStudentId = new ArrayList<>();
		
		//get student object from session using studentId
		Student student = new Student();
		student.setStudentId(studentId);
		
			
		//find list of  enrollment according to studentId
		for(Enrollment e : enrollmentRepository.findAll()){
			if(e.getStudent().equals(student)){
				enrollmentListByStudentId.add(e);
			}
		}
		
		
		//find list of course according to enrollment(course offerring)
		
		for(Enrollment e: enrollmentListByStudentId){
			for(CourseOffering co : courseOfferingRepository.findAll()){
				if(co.equals(e.getOffering())){
					courseList.add(co.getCourse());
					continue;
				}
			}
		}		
		
		return courseList;
	}

	
}
