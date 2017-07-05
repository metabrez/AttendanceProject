package edu.mum.cs.projects.attendance;

import org.hibernate.HibernateException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import edu.mum.cs.projects.attendance.service.AttendanceService;

/**
 * <h1>Maharishi University of Management<br/>Computer Science Department</h1>
 * 
 * <p>Run reports from here!</p>
 *
 * @author Payman Salek
 * 
 * @version 2.0.0
 * @since 1.0.0
 * 
 */
@SpringBootApplication
public class AttendanceReport {

	public static void main(String[] args) throws HibernateException, Exception {
		ConfigurableApplicationContext context = SpringApplication.run(AttendanceReport.class, args);

		AttendanceService service = context.getBean(AttendanceService.class);
		
		// The String argument is the start date of the block
		service.createAttendanceReportForBlock("2017-06-26");

		System.out.println("\nAttendance Report App finished executing!");		
	}
	
}
