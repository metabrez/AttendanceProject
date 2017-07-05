package edu.mum.cs.projects.attendance.domain.entity;

import java.time.LocalTime;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import edu.mum.cs.projects.attendance.domain.Identifiable;
import edu.mum.cs.projects.attendance.util.DateUtil;

/**
 * <h1>Maharishi University of Management<br/>Computer Science Department</h1>
 * 
 * <p>Domain entity. Simple POJO.<br/>
 * Represents a timeslot. Each day can be divided into multiple timslots.
 * for example there could be morning meditation (AM) and afternoon meditation (PM).</p>
 *
 * @author Hong An Nguyen
 * @author Payman Salek
 * 
 * @version 2.0.0
 * @since 1.0.0
 * 
 */
@Entity
@Table(name="Attendance_Timeslot")
public class Timeslot implements Identifiable<String> {

	@Id
	private String id;

	@Column(nullable=false)
    private String title;

	@Column(nullable=false)
	@Temporal(TemporalType.TIME)
    private Date beginTime;

	@Column(nullable=false)
	@Temporal(TemporalType.TIME)
    private Date endTime;

    public Timeslot() {
    }

    public Timeslot(String id) {
		super();
		this.id = id;
	}

	public Timeslot(String id, String title, LocalTime beginTime, LocalTime endTime) {
        this.id = id;
        this.title = title;
        this.beginTime = DateUtil.convertLocalTimeToDate(beginTime);
        this.endTime = DateUtil.convertLocalTimeToDate(endTime);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalTime getBeginTime() {
        return DateUtil.convertDateToLocalTime(beginTime);
    }

    public void setBeginTime(LocalTime beginTime) {
        this.beginTime = DateUtil.convertLocalTimeToDate(beginTime);
    }

    public LocalTime getEndTime() {
        return DateUtil.convertDateToLocalTime(endTime);
    }

    public void setEndTime(LocalTime endTime) {
        this.endTime = DateUtil.convertLocalTimeToDate(endTime);
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
		Timeslot other = (Timeslot) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Timeslot [id=" + id + ", title=" + title + ", beginTime=" + getBeginTime()
				+ ", endTime=" + getEndTime() + "]";
	}
}
