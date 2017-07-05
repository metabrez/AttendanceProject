package edu.mum.cs.projects.attendance.service;

import java.util.List;

import org.springframework.stereotype.Service;

import edu.mum.cs.projects.attendance.domain.Email;
import edu.mum.cs.projects.attendance.domain.StudentAttendance;
import edu.mum.cs.projects.attendance.domain.entity.CourseOffering;
import edu.mum.cs.projects.attendance.domain.entity.Session;
import edu.mum.cs.projects.attendance.util.FileUtil;

/**
 * <h1>Maharishi University of Management<br/>
 * Computer Science Department</h1>
 * 
 * <p>
 * Service layer facade, hides away details of business logic and dataaccess
 * from client.
 * </p>
 *
 * @author Payman Salek
 * 
 * @version 2.0.0
 * @since 2.0.0
 */
@Service
public class EmailServiceImpl implements EmailService {
	
	@Override
	public void sendEmail(Email email) {
		System.out.println("Sending email - " + email.toString());
		System.out.println(email.getBody());
		
	}

	@Override
	public void emailAttendanceReportToStudents(List<StudentAttendance> studentAttendanceList) {
		if (null == studentAttendanceList || studentAttendanceList.isEmpty()) {
			return;
		}

		CourseOffering courseOffering = studentAttendanceList.get(0).getCourseOffering();

		String directory = FileUtil.createReportDirectory(courseOffering);

		String fileName = directory + courseOffering.getCourse().getNumber() + "-"
				+ courseOffering.getFaculty().getFirstName() + courseOffering.getFaculty().getLastName() + ".txt";

		String from = "abc@xyz.com";
		String subject = "Attendance Report for " + courseOffering.getBlock().getName() + " Block";
		String part1 = FileUtil.readFile("email_body_part1.txt");
		String part2 = FileUtil.readFile("email_body_part2.txt");
		for (StudentAttendance sa : studentAttendanceList) {
			String to = sa.getStudent().getEmailaddress();
			String body = createEmailBody(sa, part1, part2);

			Email email = new Email(from, to, subject, body);
			FileUtil.writeToFile(fileName, email.toString());
			FileUtil.writeToFile(fileName, email.getBody());
			sendEmail(email);
		}

		FileUtil.closeFile(fileName);
	}

	private String createEmailBody(StudentAttendance sa, String part1, String part2) {
		StringBuilder sb = new StringBuilder();

		sb.append("Dear ");
		sb.append(sa.getStudent().getFirstName());
		sb.append(",\n\n");

		sb.append(part1);
		sb.append("\n");

		sb.append("\nPercentage of attendance: ");
		sb.append(String.format("%5.1f", sa.getMeditaionPercentage()));
		sb.append("%");

		sb.append("\nNumber of sessions attended: ");
		sb.append(String.format("%3d", sa.getMeditationCount()));

		sb.append("\nTotal number of sessions in this block: ");
		sb.append(String.format("%3d", sa.getNumberOfRequiredSessions()));

		sb.append("\n\nDetailed attendance report: \n");
		int index = 0;
		for (Session s : sa.getSessions()) {
			sb.append("\n");
			sb.append(s.getDate());
			sb.append(" -> ");
			if (sa.getAttendance().get(index)) {
				sb.append("Present");
			}
			++index;
		}

		sb.append("\n\n");
		sb.append(part2);
		sb.append("\n");

		return sb.toString();
	}

}
