package edu.mum.cs.projects.attendance;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import edu.mum.cs.projects.attendance.service.DatabaseLoaderService;

/**
 * <h1>Maharishi University of Management<br/>Computer Science Department</h1>
 * 
 * <p>Loads databse from BaseData.xlsx spreadsheet</p>
 *
 * @author Payman Salek
 * 
 * @version 2.0.0
 * @since 2.0.0
 * 
 */
@SpringBootApplication
public class DatabaseLoader {

	public static void main(String[] args) throws Exception {
		ConfigurableApplicationContext context = SpringApplication.run(DatabaseLoader.class, args);

		DatabaseLoaderService service = context.getBean(DatabaseLoaderService.class);
		service.loadDatabaseFromSpreadsheet();
		service.loadScannedBarcodesToDatabase();
		
		System.out.println("Closing Spring context...");
		context.close();
	}

}
