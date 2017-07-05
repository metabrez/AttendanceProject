package edu.mum.cs.projects.attendance.domain.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import edu.mum.cs.projects.attendance.domain.Identifiable;

/**
 * <h1>Maharishi University of Management<br/>Computer Science Department</h1>
 * 
 * <p>Domain entity. Simple POJO.<br/>
 * Represents a mapping between studentID and barcodeID. Each student may have more than one barcode.</p>
 *
 * @author Payman Salek
 * 
 * @version 2.0.0
 * @since 2.0.0
 * 
 */
@Entity
@Table(name="Attendance_Barcode")
public class Barcode implements Identifiable<Long> {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@Column(nullable=false, columnDefinition = "char(13)")
	private String barcodeId;
	
	@Column(nullable=false, columnDefinition = "char(11)")
	private String studentId;
	
	@Column(nullable=false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateAssigned;
	
	public Barcode() {
		super();
	}

	public Long getId() {
		return id;
	}

	public String getBarcodeId() {
		return barcodeId;
	}
	
	public void setBarcodeId(String barcodeId) {
		this.barcodeId = barcodeId;
	}
	
	public String getStudentId() {
		return studentId;
	}
	
	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}

	public Date getDateAssigned() {
		return dateAssigned;
	}

	public void setDateAssigned(Date dateAssigned) {
		this.dateAssigned = dateAssigned;
	}
	
}
