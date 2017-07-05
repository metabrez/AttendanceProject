package edu.mum.cs.projects.attendance.domain.entity;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import edu.mum.cs.projects.attendance.domain.Identifiable;
import edu.mum.cs.projects.attendance.util.DateUtil;

/**
 * <h1>Maharishi University of Management<br/>Computer Science Department</h1>
 * 
 * <p>Domain entity. Simple POJO. Represents a scanned barcode record (or one attendance).</p>
 *
 * @author Hong An Nguyen
 * @author Payman Salek
 * 
 * @version 2.0.0
 * @since 1.0.0
 * 
 */
@Entity
@Table(name="Attendance_Record")
//@Table(uniqueConstraints={@UniqueConstraint(columnNames = {"barcode" , "date", "timeslot", "location"})})
public class BarcodeRecord implements Identifiable<Long> {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@Column(nullable=false, length=13)
	private String barcode;
	
	@Column(nullable=false)
	@Temporal(TemporalType.DATE)
	private Date date;
	
	@Column(nullable=false)
	@Temporal(TemporalType.TIME)
	private Date time;
	
	@ManyToOne(optional=false)
	private Timeslot timeslot;
	
	@ManyToOne(optional=false)
	private Location location;

	public BarcodeRecord() {
		super();
	}

	public BarcodeRecord(String barcode, LocalDate date, LocalTime time, Timeslot timeslot, Location location) {
		super();
		this.barcode = barcode;
		setDate(date);
		setTime(time);
		this.timeslot = timeslot;
		this.location = location;
		
		this.toString();
	}

	public Long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getBarcode() {
		return barcode;
	}

	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}
	
	public LocalDate getDate() {
		return DateUtil.convertDateToLocalDate(date);
	}

	public void setDate(LocalDate date) {
		this.date = DateUtil.convertLocalDateToDate(date);
	}

	public LocalTime getTime() {
		return DateUtil.convertDateToLocalTime(time);
	}

	public void setTime(LocalTime time) {
		this.time = DateUtil.convertLocalTimeToDate(time);
	}

	public Timeslot getTimeslot() {
		return timeslot;
	}

	public void setTimeslot(Timeslot timeslot) {
		this.timeslot = timeslot;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BarcodeRecord other = (BarcodeRecord) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "BarcodeRecord [id=" + id + ", barcode=" + barcode + ", date=" + getDate() + ", time=" + getTime() + ", timeslot="
				+ timeslot.getId() + ", location=" + location.getId() + "]";
	}

}
