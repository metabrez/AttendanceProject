package edu.mum.cs.projects.attendance.ooxml.parser;

import java.util.function.Function;

import org.apache.poi.ss.usermodel.Row;

import edu.mum.cs.projects.attendance.domain.entity.Course;

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
public class CourseParser implements Function<Row, Course> {
	
    @Override
    public Course apply(Row row) {
        Course course = new Course();

        course.setNumber(row.getCell(0).getStringCellValue());
        course.setAbbr(row.getCell(1).getStringCellValue());
        course.setName(row.getCell(2).getStringCellValue());
        if(row.getCell(3) != null){
        	course.setDescription(row.getCell(3).getStringCellValue());
        }
        
        return course;
    }
}
