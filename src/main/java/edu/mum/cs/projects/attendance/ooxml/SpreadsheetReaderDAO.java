package edu.mum.cs.projects.attendance.ooxml;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import edu.mum.cs.projects.attendance.domain.entity.AcademicBlock;
import edu.mum.cs.projects.attendance.domain.entity.Barcode;
import edu.mum.cs.projects.attendance.domain.entity.Course;
import edu.mum.cs.projects.attendance.domain.entity.CourseOffering;
import edu.mum.cs.projects.attendance.domain.entity.Enrollment;
import edu.mum.cs.projects.attendance.domain.entity.Faculty;
import edu.mum.cs.projects.attendance.domain.entity.Location;
import edu.mum.cs.projects.attendance.domain.entity.Session;
import edu.mum.cs.projects.attendance.domain.entity.Student;
import edu.mum.cs.projects.attendance.domain.entity.Timeslot;
import edu.mum.cs.projects.attendance.ooxml.parser.AcademicBlockParser;
import edu.mum.cs.projects.attendance.ooxml.parser.BarcodeParser;
import edu.mum.cs.projects.attendance.ooxml.parser.CourseOfferingParser;
import edu.mum.cs.projects.attendance.ooxml.parser.CourseParser;
import edu.mum.cs.projects.attendance.ooxml.parser.EnrollmentParser;
import edu.mum.cs.projects.attendance.ooxml.parser.FacultyParser;
import edu.mum.cs.projects.attendance.ooxml.parser.LocationParser;
import edu.mum.cs.projects.attendance.ooxml.parser.SessionParser;
import edu.mum.cs.projects.attendance.ooxml.parser.StudentParser;
import edu.mum.cs.projects.attendance.ooxml.parser.TimeslotParser;

/**
 * <h1>Maharishi University of Management<br/>Computer Science Department</h1>
 * 
 * <p>Utility that loads data from Excel file "BaseData.xlsx". Acts as the main dataaccess layer. 
 * All lists are singleton so that data would only be read once from spreadsheet.</p>
 *
 * @author Hong An Nguyen
 * @author Payman Salek
 * 
 * @version 2.0.0
 * @since 1.0.0
 * 
 */
public class SpreadsheetReaderDAO {
	
	private static final String SHEET_BLOCK = "AcademicBlock";
	private static final String SHEET_LOCATION = "Location";
	private static final String SHEET_TIMESLOT = "Timeslot";
	private static final String SHEET_SESSION = "Session";
	private static final String SHEET_BARCODE = "Barcode";
	private static final String SHEET_STUDENT = "Person";
	private static final String SHEET_COURSE = "Course";
	private static final String SHEET_OFFERING = "CourseOffering";
	private static final String SHEET_FACULTY = "Faculty";
	private static final String SHEET_ENROLLMENT = "Enrollment";

	private volatile static List<AcademicBlock> academicBlockList;
	private volatile static List<Location> locationList;
	private volatile static List<Timeslot> timeslotList;
	private volatile static List<Session> sessionList;
	private volatile static List<Barcode> barcodeList;
	private volatile static List<Student> studentList;
	private volatile static List<Course> courseList;
	private volatile static List<CourseOffering> offeringList;
	private volatile static List<Faculty> facultyList;
	private volatile static List<Enrollment> enrollmentList;

	private volatile static Map<String, AcademicBlock> academicBlockMap = new HashMap<>();
	private volatile static Map<String, Location> locationMap = new HashMap<>();
	private volatile static Map<String, Timeslot> timeslotMap = new HashMap<>();
	private volatile static Map<Long, Session> sessionMap = new HashMap<>();
	private volatile static Map<Long, Barcode> barcodeMap = new HashMap<>();
	private volatile static Map<String, Student> studentMap = new HashMap<>();
	private volatile static Map<String, Course> courseMap = new HashMap<>();
	private volatile static Map<Long, CourseOffering> offeringMap = new HashMap<>();
	private volatile static Map<Long, Faculty> facultyMap = new HashMap<>();
	private volatile static Map<Long, Enrollment> enrollmentMap = new HashMap<>();

	public static Enrollment findEnrollment(Long id) {
		loadEnrollmentList();
		return enrollmentMap.get(id);
	}

	public synchronized static List<Enrollment> loadEnrollmentList() {
		if (null == enrollmentList) {
			System.out.println("Loading list of enrollments...");
			enrollmentList = ExcelReader.<Long, Enrollment>
				getListEntities(SHEET_ENROLLMENT, enrollmentMap, new EnrollmentParser());
			loadSessionList();
		}
		return enrollmentList;
	}

	public static Faculty findFaculty(Long id) {
		loadFacultyList();
		return facultyMap.get(id);
	}

	public synchronized static List<Faculty> loadFacultyList() {
		if (null == facultyList) {
			System.out.println("Loading list of faculty...");
			facultyList = ExcelReader.<Long, Faculty>
				getListEntities(SHEET_FACULTY, facultyMap, new FacultyParser());
			loadSessionList();
		}
		return facultyList;
	}

	public static AcademicBlock findAcademicBlock(String id) {
		loadAcademicBlockList();
		return academicBlockMap.get(id);
	}

	public synchronized static List<AcademicBlock> loadAcademicBlockList() {
		if (null == academicBlockList) {
			System.out.println("Loading list of academic blocks...");
			academicBlockList = ExcelReader.<String, AcademicBlock>
				getListEntities(SHEET_BLOCK, academicBlockMap, new AcademicBlockParser());
			loadSessionList();
		}
		return academicBlockList;
	}

	public static Location findLocation(String id) {
		loadLocationList();
		return locationMap.get(id);
	}

	public synchronized static List<Location> loadLocationList() {
		if (null == locationList) {
			System.out.println("Loading list of course locations...");
			locationList = ExcelReader.<String, Location>
				getListEntities(SHEET_LOCATION, locationMap, new LocationParser());
		}
		return locationList;
	}
	
	public static Timeslot findTimeslot(String id) {
		loadTimeslotList();
		return timeslotMap.get(id);
	}

	public static synchronized List<Timeslot> loadTimeslotList() {
		if (null == timeslotList) {
			System.out.println("Loading list of course timeslots...");
			timeslotList = ExcelReader.<String, Timeslot>
				getListEntities(SHEET_TIMESLOT, timeslotMap, new TimeslotParser());
		}
		return timeslotList;
	}

	public static Session findSession(Long id) {
		loadSessionList();
		return sessionMap.get(id);
	}

	public synchronized static List<Session> loadSessionList() {
		if (null == sessionList) {
			System.out.println("Loading list of sessions...");
			sessionList = ExcelReader.<Long, Session>
				getListEntities(SHEET_SESSION, sessionMap, new SessionParser());
		}
		return sessionList;
	}

	public static Barcode findBarcode(Long id) {
		loadBarcodeList();
		return barcodeMap.get(id);
	}

	public synchronized static List<Barcode> loadBarcodeList() {
		if (null == barcodeList) {
			System.out.println("Loading list of barcodes...");
			barcodeList = ExcelReader.<Long, Barcode>
				getListEntities(SHEET_BARCODE, barcodeMap, new BarcodeParser());
		}
		return barcodeList;
	}

	public static Student findStudent(String id) {
		loadStudentList();
		return studentMap.get(id);
	}

	public synchronized static List<Student> loadStudentList() {
		if (null == studentList) {
			System.out.println("Loading list of barcodes...");
			studentList = ExcelReader.<String, Student>
					getListEntities(SHEET_STUDENT, studentMap, new StudentParser());
		}
		return studentList;
	}

	public static Course findCourse(String id) {
		loadCourseList();
		return courseMap.get(id);
	}

	public synchronized static List<Course> loadCourseList() {
		if (null == courseList) {
			System.out.println("Loading list of barcodes...");
			courseList = ExcelReader.<String, Course>
					getListEntities(SHEET_COURSE, courseMap, new CourseParser());
		}
		return courseList;
	}

	public static CourseOffering findOffering(Long id) {
		loadOfferingList();
		return offeringMap.get(id);
	}

	public synchronized static List<CourseOffering> loadOfferingList() {
		if (null == offeringList) {
			System.out.println("Loading list of barcodes...");
			offeringList = ExcelReader.<Long, CourseOffering>
					getListEntities(SHEET_OFFERING, offeringMap, new CourseOfferingParser());
		}
		return offeringList;
	}
	
}
