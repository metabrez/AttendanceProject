package edu.mum.cs.projects.attendance.service;

import java.util.List;

import edu.mum.cs.projects.attendance.domain.ComproEntry;
import edu.mum.cs.projects.attendance.domain.entity.AcademicBlock;
import edu.mum.cs.projects.attendance.domain.entity.Course;
import edu.mum.cs.projects.attendance.domain.entity.CourseOffering;
import edu.mum.cs.projects.attendance.domain.entity.Enrollment;

/**
 * <h1>Maharishi University of Management<br/>Computer Science Department</h1>
 * 
 * <p>Service layer facade, hides away details of dataaccess layer from client.</p>
 *
 * @author Payman Salek
 * 
 * @version 2.0.0
 * @since 1.0.0
 */
public interface CourseService {
	
	List<Enrollment> getEnrollment(CourseOffering offering);

	List<ComproEntry> getComproEntries(String startDate);

	List<CourseOffering> getCourseOfferings(String blockId);

	AcademicBlock getAcademicBlock(String blockStartDate);	
	List<Course> getAllCourses();
	List<CourseOffering> getCourseOffering();
	
	List<Course> getCourseListByStudentId(String studentId);
	
}
