package edu.mum.cs.projects.attendance.domain.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Immutable;

import edu.mum.cs.projects.attendance.domain.Identifiable;
import edu.mum.cs.projects.attendance.util.DateUtil;

/**
 * <h1>Maharishi University of Management<br/>
 * Computer Science Department</h1>
 * 
 * <p>
 * Domain entity. Simple POJO.<br/>
 * Academic Block is a POJO that defines the beginning and end of a course
 * offering based on the academic calendar.
 * </p>
 *
 * @author Payman Salek
 * 
 * @version 2.0.0
 * @since 1.0.0
 * 
 */
@Entity
@Table(name="Attendance_Block")
@Immutable
public class AcademicBlock implements Identifiable<String> {

	private static final Comparator<Session> BY_DATE = (s1, s2) -> s1.getDate().compareTo(s2.getDate());

	@Id
	@Column(length=12)
	private String id; // User-defined, "usually" in the form of 2017-05A-05D

	@Column(nullable=false)
	private String name;

	@Column(nullable=false)
	@Temporal(TemporalType.DATE)
	private Date beginDate;

	@Column(nullable=false)
	@Temporal(TemporalType.DATE)
	private Date endDate;

	@Column(nullable=false)
	private String semester;

	@OneToMany(mappedBy="block", cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	private List<Session> sessions = new ArrayList<>();

	@Column(nullable=false, name="required")
	private int requiredSessions;

	public int getRequiredSessions() {
		return requiredSessions;
	}

	public void setRequiredSessions(int requiredSessions) {
		this.requiredSessions = requiredSessions;
	}
	
	public void addSession(Session session) {
		sessions.add(session);
	}

	public List<Session> getSessions() {
		return sessions.stream().sorted(BY_DATE).collect(Collectors.toList());
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getBeginDate() {
		return DateUtil.convertDateToLocalDate(beginDate);
	}

	public void setBeginDate(LocalDate beginDate) {
		this.beginDate = DateUtil.convertLocalDateToDate(beginDate);
	}

	public LocalDate getEndDate() {
		return DateUtil.convertDateToLocalDate(endDate);
	}

	public void setEndDate(LocalDate endDate) {
		this.endDate = DateUtil.convertLocalDateToDate(endDate);
	}

	public String getSemester() {
		return semester;
	}

	public void setSemester(String semester) {
		this.semester = semester;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		AcademicBlock other = (AcademicBlock) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "AcademicBlock [id=" + id + ", name=" + name + ", beginDate=" + getBeginDate() + ", endDate=" + getEndDate()
				+ ", semester=" + semester + ", requiredSessions=" + requiredSessions + "]";
	}

}
