package edu.mum.cs.projects.attendance.ooxml.parser;

import java.util.function.Function;

import org.apache.poi.ss.usermodel.Row;
import org.springframework.stereotype.Component;

import edu.mum.cs.projects.attendance.domain.entity.Course;
import edu.mum.cs.projects.attendance.domain.entity.CourseOffering;
import edu.mum.cs.projects.attendance.domain.entity.Faculty;
import edu.mum.cs.projects.attendance.ooxml.SpreadsheetReaderDAO;
import edu.mum.cs.projects.attendance.util.DateUtil;

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
@Component
public class CourseOfferingParser implements Function<Row, CourseOffering> {

    @Override
    public CourseOffering apply(Row row) {
        CourseOffering offering = new CourseOffering();

        offering.setId((long)(row.getCell(0).getNumericCellValue()));

        Course course = SpreadsheetReaderDAO.findCourse(row.getCell(1).getStringCellValue());
        offering.setCourse(course);
        
        offering.setPeriod(row.getCell(2).getStringCellValue());
        
        Faculty faculty = SpreadsheetReaderDAO.findFaculty((long)row.getCell(3).getNumericCellValue());
        offering.setFaculty(faculty);
       
        offering.setStartDate(row.getCell(4).getDateCellValue());
        
        offering.setCapacity((int)(row.getCell(5).getNumericCellValue()));

        offering.setEnrolled((int)(row.getCell(6).getNumericCellValue()));
        
        int active = (int)row.getCell(7).getNumericCellValue();
        if(0 == active) {
        	offering.setActive(false);
        }
        else {
        	offering.setActive(true);
        }
        
        int de = (int)row.getCell(8).getNumericCellValue();
        if(0 == de) {
        	offering.setDe(false);
        }
        else {
        	offering.setDe(true);
        }

        String startDate = DateUtil.convertDateToString(offering.getStartDate());
        offering.setBlock(SpreadsheetReaderDAO.findAcademicBlock(startDate));
        
        return offering;
    }
}
