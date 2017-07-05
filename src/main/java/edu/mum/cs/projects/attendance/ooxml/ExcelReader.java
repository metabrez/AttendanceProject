package edu.mum.cs.projects.attendance.ooxml;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import edu.mum.cs.projects.attendance.domain.Identifiable;

/**
 * <h1>Maharishi University of Management<br/>Computer Science Department</h1>
 * 
 * <p>Utility that loads data from Excel file: {@value #FILE_LOCATION}</p>
 *
 * @author Hong An Nguyen
 * @author Payman Salek
 * 
 * @version 2.0.0
 * @since 1.0.0
 * 
 */
public class ExcelReader {
	
	public static final String FILE_LOCATION = "src/main/resources/Database.xlsx";

	private static Workbook workbook;
	
	private static Workbook getWorkbook() {
		if (workbook == null) {
			try {
				workbook = new XSSFWorkbook(FILE_LOCATION);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return workbook;
	}

	private static void closeWorkbook() {
		try {
			workbook.close();
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(1);
		}
	}

	public static <K, V extends Identifiable<K>> List<V> getListEntities(String sheetName, Map<K, V> map, Function<Row, V> mapper) {
		
		Sheet sheet = getWorkbook().getSheet(sheetName);

		List<V> list = new ArrayList<V>();

		Iterator<Row> rowIterator = sheet.rowIterator();
		rowIterator.next();
		while (rowIterator.hasNext()) {
			V value = mapper.apply(rowIterator.next());
			list.add(value);
			map.put(value.getId(), value);
		}
		
		closeWorkbook();

		return list;
	}
	
}
