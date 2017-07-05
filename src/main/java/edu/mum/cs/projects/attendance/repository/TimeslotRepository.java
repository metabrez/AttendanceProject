package edu.mum.cs.projects.attendance.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import edu.mum.cs.projects.attendance.domain.entity.Timeslot;

@Repository
public interface TimeslotRepository extends CrudRepository<Timeslot, String> {
}
