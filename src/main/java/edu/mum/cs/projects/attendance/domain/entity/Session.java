package edu.mum.cs.projects.attendance.domain.entity;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Immutable;

import edu.mum.cs.projects.attendance.domain.Identifiable;
import edu.mum.cs.projects.attendance.util.DateUtil;

/**
 * <h1>Maharishi University of Management<br/>Computer Science Department</h1>
 * 
 * <p>Domain entity. Simple POJO.<br/>
 * Represents a session in a block when attendance is mandatory.</p>
 *
 * @author Hong An Nguyen
 * @author Payman Salek
 * 
 * @version 2.0.0
 * @since 1.0.0
 * 
 */
@Entity
@Table(name="Attendance_Session")
@Immutable
public class Session implements Identifiable<Long> {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

	@ManyToOne
    private AcademicBlock block;

	@ManyToOne(fetch=FetchType.EAGER)
	private Timeslot timeslot;

	@Column(nullable=false)
	@Temporal(TemporalType.DATE)
    private Date date;

	public Session() {
		super();
	}

	public Session(AcademicBlock block, Timeslot timeslot, LocalDate date) {
		super();
		this.block = block;
		this.timeslot = timeslot;
		this.date = DateUtil.convertLocalDateToDate(date);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public AcademicBlock getBlock() {
		return block;
	}

	public void setBlock(AcademicBlock block) {
		this.block = block;
		block.addSession(this);
	}

	public Timeslot getTimeslot() {
		return timeslot;
	}

	public void setTimeslot(Timeslot timeslot) {
		this.timeslot = timeslot;
	}

	public LocalDate getDate() {
		return DateUtil.convertDateToLocalDate(date);
	}

	public void setDate(LocalDate date) {
		this.date = DateUtil.convertLocalDateToDate(date);
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
		Session other = (Session) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Session [id=" + id + ", block=" + block + ", timeslot=" + timeslot + ", date=" + getDate() + "]";
	}
}
