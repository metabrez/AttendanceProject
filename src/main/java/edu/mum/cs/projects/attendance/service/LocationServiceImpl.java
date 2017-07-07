package edu.mum.cs.projects.attendance.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.mum.cs.projects.attendance.domain.entity.Location;
import edu.mum.cs.projects.attendance.repository.LocationRepository;

@Service
public class LocationServiceImpl implements LocationService {
	
	@Autowired
	private LocationRepository loactionRepository;

	@Override
	public List<Location> getAllLocations() {
		
		
		return loactionRepository.findAll();
	}

}
