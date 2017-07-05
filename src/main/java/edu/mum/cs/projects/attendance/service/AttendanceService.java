package edu.mum.cs.projects.attendance.service;

import java.util.List;

import edu.mum.cs.projects.attendance.domain.StudentAttendance;
import edu.mum.cs.projects.attendance.domain.entity.CourseOffering;

/**
 * <h1>Maharishi University of Management<br/>Computer Science Department</h1>
 * 
 * <p>Service layer facade, hides away details of dataaccess layer from client.</p>
 *
 * @author Payman Salek
 * 
 * @version 1.0.0
 * @since 1.0.0
 */
public interface AttendanceService {
	
	void createAttendanceReportForEntry(String entryDate);
	
	List<StudentAttendance> createAttendanceReportForBlock(String blockStartDate);
	
	List<StudentAttendance> createAttendanceReportForOffering(CourseOffering courseOffering);
	
	void emailReportToStudentsForBlock(String blockStartDate);

	void emailReportToStudentsForOffering(CourseOffering courseOffering);

	List<StudentAttendance> retrieveStudentAttendanceRecords(CourseOffering courseOffering);

	void createAttendanceReportForEntries(String startDate);

	void countAttendancePerDay();
	
}
