package edu.mum.cs.projects.attendance.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.mum.cs.projects.attendance.domain.entity.BarcodeRecord;
import edu.mum.cs.projects.attendance.domain.entity.Location;
import edu.mum.cs.projects.attendance.domain.entity.Timeslot;
import edu.mum.cs.projects.attendance.repository.LocationRepository;
import edu.mum.cs.projects.attendance.repository.TimeslotRepository;
import edu.mum.cs.projects.attendance.util.DateUtil;

@Service
public class BarcodeServiceImpl implements BarcodeService {
	
	private static final String FILE_PATH = "src/main/resources/barcodes/BarcodeRecords.txt";
	
	@Autowired
	private LocationRepository locationRepository;
	
	@Autowired
	private TimeslotRepository timeslotRepository;
	
	private static volatile Collection<BarcodeRecord> barcodeRecords;
	
	@Override
	@Transactional
	public List<BarcodeRecord> getBarcodeRecordsList() {
		// Default is all dates
		return getBarcodeRecordsList(LocalDate.ofEpochDay(0), LocalDate.now());
	}
	
	@Override
	@Transactional
	public List<BarcodeRecord> getBarcodeRecordsList(LocalDate startDate, LocalDate endDate) {
		Comparator<BarcodeRecord> byDate = (b1, b2) -> b1.getDate().compareTo(b2.getDate());
		Comparator<BarcodeRecord> byTimeslot = (b1, b2) -> b1.getTimeslot().getId().compareTo(b2.getTimeslot().getId());
		Comparator<BarcodeRecord> byBarcode = (b1, b2) -> b1.getBarcode().compareTo(b2.getBarcode());
		
		// The dates are decremented/incremented to make the date range inclusive
		return getBarcodeRecords()
					.stream()
					.filter(b -> b.getDate().isAfter(startDate.minusDays(1)))
					.filter(b -> b.getDate().isBefore(endDate.plusDays(1)))
					.sorted(byDate.thenComparing(byTimeslot).thenComparing(byBarcode))
					.collect(Collectors.toList());
	}
	
	private Collection<BarcodeRecord> getBarcodeRecords() {
		if(null == barcodeRecords) {
			barcodeRecords = loadBarcodeRecords();
		}
		
		return barcodeRecords;
	}
	
	private synchronized Collection<BarcodeRecord> loadBarcodeRecords() {
		if(null != barcodeRecords) {
			return barcodeRecords;
		}
		
		System.out.println("Loading scanned barcode records...");
		
		File file = new File(FILE_PATH);
		long fileSize = file.length();

		Map<String, BarcodeRecord> dataMap = new HashMap<String, BarcodeRecord>((int)(fileSize/20));
		
		try {
			Scanner sc = new Scanner(file);
			
			while (sc.hasNextLine()) {
				String line = sc.nextLine().trim();
				
				if(line.isEmpty()) {
					continue;
				}
						
				// Removes duplicates
				if(dataMap.containsKey(line)) {
					System.out.println("Duplicate line found in scanned barcode import: " + line);
					continue;
				}
				else {
					dataMap.put(line,  convertLineToBarcodeRecord(line));
				}
			}			
			
			sc.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		return dataMap.values();
	}
	
	private BarcodeRecord convertLineToBarcodeRecord(String line) {
		String[] parts = line.split(",");
		
		String barcode = parts[0];		
		LocalDate date = DateUtil.convertDateToLocalDate(DateUtil.convertOldFormatStringToDate(parts[1]));
		LocalTime time = LocalTime.of(00, 00);
		Timeslot timeslot = timeslotRepository.findOne(parts[2]);
		Location location = locationRepository.findOne(parts[3]);
		
		return new BarcodeRecord(barcode, date, time, timeslot, location);
	}
	
//	private static Location getLocationById(String id) {
//		List<Location> locations = SpreadsheetReaderDAO.getLocationList();
//		
//		return locations.stream().filter(l -> l.getId().equals(id)).findAny().get();
//	}
//	
//	private static Timeslot getTimeslotById(String id) {
//		List<Timeslot> slots = SpreadsheetReaderDAO.getTimeslotList();
//		
//		return slots.stream().filter(s -> s.getId().equals(id)).findAny().get();
//	}
//
//	public static void main(String[] args) {
//		List<BarcodeRecord> list = getBarcodeRecordsList();
//		list.stream().forEach(System.out::println);
//		System.out.println("Number of records processed: " + list.size());
//	}
}
