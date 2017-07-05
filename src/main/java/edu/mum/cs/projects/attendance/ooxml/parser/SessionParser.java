package edu.mum.cs.projects.attendance.ooxml.parser;

import java.time.ZoneId;
import java.util.function.Function;

import org.apache.poi.ss.usermodel.Row;

import edu.mum.cs.projects.attendance.domain.entity.AcademicBlock;
import edu.mum.cs.projects.attendance.domain.entity.Session;
import edu.mum.cs.projects.attendance.domain.entity.Timeslot;
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
 * @version 2.0.0
 * @since 1.0.0
 * 
 */
public class SessionParser implements Function<Row, Session> {
	
    @Override
    public Session apply(Row row) {
        Session session = new Session();

        // No need to set ID as this field is auto-generated
        //session.setId((long)(row.getCell(0).getNumericCellValue()));
        
        session.setDate(row.getCell(1).getDateCellValue().toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
        
        AcademicBlock block = SpreadsheetReaderDAO.findAcademicBlock(row.getCell(2).getStringCellValue());
        session.setBlock(block);

        Timeslot ts = SpreadsheetReaderDAO.findTimeslot(row.getCell(3).getStringCellValue());
        session.setTimeslot(ts);
        
        return session;
    }
}
