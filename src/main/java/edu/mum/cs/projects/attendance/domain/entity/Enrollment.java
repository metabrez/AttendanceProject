package edu.mum.cs.projects.attendance.domain.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Immutable;

import edu.mum.cs.projects.attendance.domain.Identifiable;

/**
 * <h1>Maharishi University of Management<br/>Computer Science Department</h1>
 * 
 * <p>Domain entity. Simple POJO.</p>
 *
 * @author Payman Salek
 * 
 * @version 2.0.0
 * @since 2.0.0
 * 
 */
@Entity
@Immutable
public class Enrollment implements Identifiable<Long> {
	
	public enum Status {SIGNEDUP, INACTIVE, OTHER}
	
	@Id
	@Column(columnDefinition = "int")
	private Long id;
	
	@Column(columnDefinition = "datetime")
	@Temporal(TemporalType.TIMESTAMP)
	private Date date;
	
	@Column(columnDefinition = "nvarchar(50)")
	private String status;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="studentid")
	private Student student;
	
	@ManyToOne
	@JoinColumn(name="offerid")
	private CourseOffering offering;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public CourseOffering getOffering() {
		return offering;
	}

	public void setOffering(CourseOffering offering) {
		this.offering = offering;
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
		Enrollment other = (Enrollment) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Enrollment [id=" + id + ", date=" + date + ", status=" + status + ", student=" + student + ", offering="
				+ offering + "]";
	}
	
}
