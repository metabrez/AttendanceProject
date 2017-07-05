package edu.mum.cs.projects.attendance.domain.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

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
@Table(name="Offered")
public class CourseOffering implements Identifiable<Long> {
	
	@Id
	@Column(columnDefinition = "int")
    private Long id;

	@ManyToOne
	@JoinColumn(name="coursenumber", columnDefinition = "nvarchar(50)")
	private Course course;

	@Column(columnDefinition = "nvarchar(50)")
	private String period;
	
	@Column(name="startdate", columnDefinition = "datetime")
    @Temporal(TemporalType.DATE)
    private Date startDate;
	
	@OneToMany(mappedBy="offering", fetch=FetchType.EAGER)	
	private List<Enrollment> enrollments;
	
	@Column
	private int capacity;
	
	@Column
	private int enrolled;
	
	@Column
	private boolean active;	
	
	@Column
	private boolean de;
	
	@ManyToOne
	@JoinColumn(name="faculty")
	private Faculty faculty;

	@Transient
	private AcademicBlock block;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public String getPeriod() {
		return period;
	}

	public void setPeriod(String period) {
		this.period = period;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public List<Enrollment> getEnrollments() {
		return enrollments;
	}

	public void setEnrollments(List<Enrollment> enrollments) {
		this.enrollments = enrollments;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public int getEnrolled() {
		return enrolled;
	}

	public void setEnrolled(int enrolled) {
		this.enrolled = enrolled;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public boolean isOnCampus() {
		return !isDe();
	}

	public boolean isDe() {
		return de;
	}

	public void setDe(boolean de) {
		this.de = de;
	}

	public Faculty getFaculty() {
		return faculty;
	}

	public void setFaculty(Faculty faculty) {
		this.faculty = faculty;
	}

	public AcademicBlock getBlock() {
		return block;
	}

	public void setBlock(AcademicBlock block) {
		this.block = block;
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
		CourseOffering other = (CourseOffering) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "CourseOffering [id=" + id + ", course=" + course + ", period=" + period + ", startDate=" + startDate
				+ ", capacity=" + capacity + ", enrolled=" + enrolled + ", active=" + active + ", de=" + de
				+ ", faculty=" + faculty + ", block=" + block + "]";
	}

}
