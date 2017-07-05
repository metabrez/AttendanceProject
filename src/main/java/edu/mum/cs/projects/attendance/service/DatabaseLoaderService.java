package edu.mum.cs.projects.attendance.service;

public interface DatabaseLoaderService {

	void loadDatabaseFromSpreadsheet() throws Exception;

	void loadScannedBarcodesToDatabase() throws Exception;

	void loadAllScannedBarcodesToDatabase() throws Exception;

}