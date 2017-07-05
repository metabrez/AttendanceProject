package edu.mum.cs.projects.attendance.ooxml.parser;

import java.util.function.Function;

import org.apache.poi.ss.usermodel.Row;

import edu.mum.cs.projects.attendance.domain.entity.CourseOffering;
import edu.mum.cs.projects.attendance.domain.entity.Enrollment;
import edu.mum.cs.projects.attendance.domain.entity.Student;
import edu.mum.cs.projects.attendance.ooxml.SpreadsheetReaderDAO;

/**
 * <h1>Maharishi University of Management<br/>Computer Science Department</h1>
 * 
 * <p>Excel row parser/mapper. Converts an Excel row into an object.
 * Note: This file is tightly coupled with the structure of the input Excel sheet.</p>
 *
 * @author Hong An Nguyen
 * @author Payman Salek
 * 
 * @version 1.0.0
 * @since 1.0.0
 * 
 */
public class EnrollmentParser implements Function<Row, Enrollment> {

	@Override
	public Enrollment apply(Row row) {
		Enrollment enrollment = new Enrollment();

		enrollment.setId((long)(row.getCell(0).getNumericCellValue()));
		enrollment.setDate(row.getCell(1).getDateCellValue());
		enrollment.setStatus(row.getCell(2).getStringCellValue());
        
        Student student = SpreadsheetReaderDAO.findStudent(row.getCell(3).getStringCellValue());
        enrollment.setStudent(student);
        
        CourseOffering courseOffering = SpreadsheetReaderDAO.findOffering((long)(row.getCell(4).getNumericCellValue()));
        enrollment.setOffering(courseOffering);
                     
        return enrollment;
	}

}
