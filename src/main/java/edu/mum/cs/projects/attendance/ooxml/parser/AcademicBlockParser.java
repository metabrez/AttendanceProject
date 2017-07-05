package edu.mum.cs.projects.attendance.ooxml.parser;

import java.time.ZoneId;
import java.util.function.Function;

import org.apache.poi.ss.usermodel.Row;

import edu.mum.cs.projects.attendance.domain.entity.AcademicBlock;

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
public class AcademicBlockParser implements Function<Row, AcademicBlock> {
	
	@Override
	public AcademicBlock apply(Row row) {
		AcademicBlock block = new AcademicBlock();

		block.setId(row.getCell(0).getStringCellValue());
        block.setBeginDate(row.getCell(1).getDateCellValue().toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
        block.setEndDate(row.getCell(2).getDateCellValue().toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
        block.setName(row.getCell(3).getStringCellValue());
        block.setRequiredSessions((int)(row.getCell(4).getNumericCellValue()));
        block.setSemester(row.getCell(5).getStringCellValue());
        
        return block;
	}

}
