package edu.mum.cs.projects.attendance.ooxml.parser;

import java.util.function.Function;

import org.apache.poi.ss.usermodel.Row;

import edu.mum.cs.projects.attendance.domain.entity.Faculty;

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
public class FacultyParser implements Function<Row, Faculty> {
	
    @Override
    public Faculty apply(Row row) {
    	Faculty faculty = new Faculty();
    	
    	faculty.setId((long)row.getCell(0).getNumericCellValue());
    	faculty.setFirstName(row.getCell(1).getStringCellValue());
    	faculty.setLastName(row.getCell(2).getStringCellValue());

        return faculty;
    }
}
