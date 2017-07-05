package edu.mum.cs.projects.attendance.domain.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

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
public class Faculty implements Identifiable<Long> {
	
	@Id
	@Column(columnDefinition = "int")
	private Long id;
	
	@Column(name="firstname", columnDefinition = "nvarchar(50)")
	private String firstName;
	
	@Column(name="lastname", columnDefinition = "nvarchar(50)")
	private String lastName;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
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
		Faculty other = (Faculty) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return firstName + " " + lastName;
	}
	
}
