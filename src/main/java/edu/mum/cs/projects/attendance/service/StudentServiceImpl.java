package edu.mum.cs.projects.attendance.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.mum.cs.projects.attendance.domain.entity.Barcode;
import edu.mum.cs.projects.attendance.domain.entity.Student;
import edu.mum.cs.projects.attendance.ooxml.SpreadsheetReaderDAO;
import edu.mum.cs.projects.attendance.repository.StudentRepository;
import edu.mum.cs.projects.attendance.util.DateUtil;

/**
 * <h1>Maharishi University of Management<br/>Computer Science Department</h1>
 * 
 * <p>Service layer facade, hides away details of dataaccess layer from client.</p>
 *
 * @see edu.mum.cs.projects.attendance.service.StudentService
 *
 * @author Payman Salek
 * 
 * @version 1.0.0
 * @since 1.0.0
 */
@Service
public class StudentServiceImpl implements StudentService {
	
	@Autowired
	private StudentRepository studentRepository;
	
	private Map<String, String> barcodeMap; 
	
	{

	}
	
	private Map<String, String> getBarcodeMap() {
		if(null == barcodeMap) {
			barcodeMap = new HashMap<>();
			List<Barcode> barcodeList = SpreadsheetReaderDAO.loadBarcodeList();
			for(Barcode barcode : barcodeList) {
				barcodeMap.put(barcode.getStudentId(), barcode.getBarcodeId());
			}			
		}
		
		return barcodeMap;
	}

	@Override
	public String getBarcodeId(String studentId) {
		return getBarcodeMap().get(studentId);
	}

	@Override
	public List<Student> getStudentsByEntry(String entryDate) {
		return studentRepository.findByEntryDate(DateUtil.convertStringToDate(entryDate));
	}

}
