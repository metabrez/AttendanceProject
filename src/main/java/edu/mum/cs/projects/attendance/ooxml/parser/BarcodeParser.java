package edu.mum.cs.projects.attendance.ooxml.parser;

import java.util.function.Function;

import org.apache.poi.ss.usermodel.Row;

import edu.mum.cs.projects.attendance.domain.entity.Barcode;

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
public class BarcodeParser implements Function<Row, Barcode> {
	
    @Override
    public Barcode apply(Row row) {
    	
    	Barcode barcode = new Barcode();
    	
    	barcode.setStudentId(row.getCell(0).getStringCellValue());
    	barcode.setBarcodeId(row.getCell(1).getStringCellValue());

        return barcode;
    }
}
