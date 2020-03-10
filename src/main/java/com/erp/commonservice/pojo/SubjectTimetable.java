package com.erp.commonservice.pojo;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the subject_timetable database table.
 * 
 */
@Entity
@Table(name="subject_timetable")
@NamedQuery(name="SubjectTimetable.findAll", query="SELECT s FROM SubjectTimetable s")
public class SubjectTimetable implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;

	private String days;

	@Column(name="end_date")
	private Long endDate;

	@Column(name="from_time")
	private Long fromTime;

	@Column(name="start_date")
	private Long startDate;

	@Column(name="to_time")
	private Long toTime;

	private String type;

	//bi-directional many-to-one association to Subject
	@ManyToOne(fetch=FetchType.LAZY)
	private Subject subject;

	//bi-directional many-to-one association to User
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="faculty_id")
	private User user;

	public SubjectTimetable() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDays() {
		return this.days;
	}

	public void setDays(String days) {
		this.days = days;
	}

	public Long getEndDate() {
		return this.endDate;
	}

	public void setEndDate(Long endDate) {
		this.endDate = endDate;
	}

	public Long getFromTime() {
		return this.fromTime;
	}

	public void setFromTime(Long fromTime) {
		this.fromTime = fromTime;
	}

	public Long getStartDate() {
		return this.startDate;
	}

	public void setStartDate(Long startDate) {
		this.startDate = startDate;
	}

	public Long getToTime() {
		return this.toTime;
	}

	public void setToTime(Long toTime) {
		this.toTime = toTime;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Subject getSubject() {
		return this.subject;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}