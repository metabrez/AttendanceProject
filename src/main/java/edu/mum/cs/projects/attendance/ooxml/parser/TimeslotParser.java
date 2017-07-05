package edu.mum.cs.projects.attendance.ooxml.parser;

import java.time.ZoneId;
import java.util.function.Function;

import org.apache.poi.ss.usermodel.Row;

import edu.mum.cs.projects.attendance.domain.entity.Timeslot;

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
public class TimeslotParser implements Function<Row, Timeslot> {
    @Override
    public Timeslot apply(Row row) {
        Timeslot ts = new Timeslot();

        ts.setId(row.getCell(0).getStringCellValue());
        ts.setTitle(row.getCell(1).getStringCellValue());
        ts.setBeginTime(row.getCell(2).getDateCellValue().toInstant().atZone(ZoneId.systemDefault()).toLocalTime());
        ts.setEndTime(row.getCell(3).getDateCellValue().toInstant().atZone(ZoneId.systemDefault()).toLocalTime());
        
        return ts;
    }
}
