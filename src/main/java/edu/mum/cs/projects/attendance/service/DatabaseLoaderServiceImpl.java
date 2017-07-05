package edu.mum.cs.projects.attendance.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.mum.cs.projects.attendance.domain.entity.BarcodeRecord;
import edu.mum.cs.projects.attendance.ooxml.SpreadsheetReaderDAO;

@Service
public class DatabaseLoaderServiceImpl implements DatabaseLoaderService {
	
	@Autowired
	private EntityManagerFactory emf;
	
	@Autowired
	private BarcodeService barcodeService;

	@Override
	public synchronized void loadDatabaseFromSpreadsheet() throws Exception {
		// hibernate.hbm2ddl.auto = create
		System.out.println("Loading database with data from spreadsheet...");
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();		
		SpreadsheetReaderDAO.loadLocationList().forEach(em::persist);
		SpreadsheetReaderDAO.loadTimeslotList().forEach(em::persist);
		em.getTransaction().commit();		

		em.getTransaction().begin();
		SpreadsheetReaderDAO.loadAcademicBlockList().forEach(em::persist); // This will persist List<Session> too
		em.getTransaction().commit();		

		em.getTransaction().begin();
		SpreadsheetReaderDAO.loadStudentList().forEach(em::persist);
		em.getTransaction().commit();		

		em.getTransaction().begin();
		SpreadsheetReaderDAO.loadFacultyList().forEach(em::persist);
		em.getTransaction().commit();		

		em.getTransaction().begin();
		SpreadsheetReaderDAO.loadCourseList().forEach(em::persist);
		SpreadsheetReaderDAO.loadOfferingList().forEach(em::persist);
		em.getTransaction().commit();		

		em.getTransaction().begin();
		SpreadsheetReaderDAO.loadEnrollmentList().forEach(em::persist);
		em.getTransaction().commit();		

		System.out.println("Finished loading database!");
	}
	
	@Override
	public synchronized void loadScannedBarcodesToDatabase() throws Exception {
		EntityManager em = emf.createEntityManager();
		
		List<BarcodeRecord> barcodes = barcodeService.getBarcodeRecordsList();
		
		int index = 0;
		em.getTransaction().begin();
		for(BarcodeRecord br : barcodes) {
			if(0 == ++index % 100) {
				System.out.println("\nCommitting transaction (100 inserts at a time)...\n");
				em.getTransaction().commit();
				em.getTransaction().begin();
			}
			em.persist(br);
			System.out.println(br);
		}
		em.getTransaction().commit();
	
	}

	@Override
	public void loadAllScannedBarcodesToDatabase() throws Exception {
		// TODO Auto-generated method stub
		
	}
	
}
