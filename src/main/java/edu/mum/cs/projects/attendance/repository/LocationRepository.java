package edu.mum.cs.projects.attendance.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import edu.mum.cs.projects.attendance.domain.entity.Location;

@Repository
public interface LocationRepository extends CrudRepository<Location, String> {
	
	public List<Location> findAll();
	
	
}
