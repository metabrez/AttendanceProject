package edu.mum.cs.projects.attendance.service;

import java.time.LocalDate;
import java.util.List;

import edu.mum.cs.projects.attendance.domain.entity.BarcodeRecord;

public interface BarcodeService {

	List<BarcodeRecord> getBarcodeRecordsList();

	List<BarcodeRecord> getBarcodeRecordsList(LocalDate startDate, LocalDate endDate);

}