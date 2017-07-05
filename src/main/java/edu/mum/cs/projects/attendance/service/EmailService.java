package edu.mum.cs.projects.attendance.service;

import java.util.List;

import edu.mum.cs.projects.attendance.domain.Email;
import edu.mum.cs.projects.attendance.domain.StudentAttendance;

public interface EmailService {

	void sendEmail(Email email);
	
	void emailAttendanceReportToStudents(List<StudentAttendance> studentAttendanceList);
}
