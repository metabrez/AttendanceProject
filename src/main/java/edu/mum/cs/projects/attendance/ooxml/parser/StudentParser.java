package edu.mum.cs.projects.attendance.ooxml.parser;

import java.util.function.Function;

import org.apache.poi.ss.usermodel.Row;

import edu.mum.cs.projects.attendance.domain.entity.Student;

/**
 * <h1>Maharishi University of Management<br/>Computer Science Department</h1>
 * 
 * <p>Excel row parser/mapper. Converts an Excel row into an object.
 * Note: This file is tightly coupled with the structure of the input Excel sheet.</p>
 *
 * @author Payman Salek
 * 
 * @version 2.0.0
 * @since 1.0.0
 * 
 */
public class StudentParser implements Function<Row, Student> {
    @Override
    public Student apply(Row row) {
    	Student student = new Student();

    	student.setStudentId(row.getCell(0).getStringCellValue());
    	student.setFirstName(row.getCell(1).getStringCellValue());
    	student.setLastName(row.getCell(2).getStringCellValue());
    	student.setEmailaddress(row.getCell(3).getStringCellValue());
    	student.setVisaStatus(row.getCell(4).getStringCellValue());
    	student.setStatus(row.getCell(5).getStringCellValue());
    	
    	if(null != row.getCell(6)) {
    		student.setEntryDate(row.getCell(6).getDateCellValue());
    	}
    	
    	
    	if(null != row.getCell(7)) {
    		student.setBarcode(row.getCell(7).getStringCellValue());
    	}
        
        return student;
    }
}
