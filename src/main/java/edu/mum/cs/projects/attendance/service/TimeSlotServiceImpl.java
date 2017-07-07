package edu.mum.cs.projects.attendance.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.mum.cs.projects.attendance.domain.entity.Timeslot;
import edu.mum.cs.projects.attendance.repository.TimeslotRepository;
@Service
public class TimeSlotServiceImpl implements TimeSlotService{
	
	/*@Autowired
	private TimeSlotService timeSlotService;*/
	
	@Autowired
	private TimeslotRepository timeslotRepository;

	@Override
	public List<Timeslot> getTimeSlot() {
		
		return timeslotRepository.findAll();
	}

}
