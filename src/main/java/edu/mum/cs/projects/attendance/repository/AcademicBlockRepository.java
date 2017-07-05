package edu.mum.cs.projects.attendance.repository;

import java.util.Date;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import edu.mum.cs.projects.attendance.domain.entity.AcademicBlock;

/**
 * <h1>Maharishi University of Management<br/>Computer Science Department</h1>
 * 
 * <p>This is a spring-data repository class responsible for CRUD operations pertaining to "AcademicBlock"</p>
 *
 * @author Payman Salek
 * 
 * @version 2.0.0
 * @since 2.0.0
 * 
 */
@Repository
public interface AcademicBlockRepository extends CrudRepository<AcademicBlock, String>{
	AcademicBlock findByBeginDate(Date beginDate);
}
