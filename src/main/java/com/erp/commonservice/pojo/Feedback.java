package com.erp.commonservice.pojo;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the feedback database table.
 * 
 */
@Entity
@NamedQuery(name="Feedback.findAll", query="SELECT f FROM Feedback f")
public class Feedback implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;

	private String description;

	private String rating;

	@Column(name="submitted_on")
	private Long submittedOn;

	@Column(name="`type(studen/faculty)`")
	private String type_studen_faculty_;

	//bi-directional many-to-one association to Subject
	@ManyToOne(fetch=FetchType.LAZY)
	private Subject subject;

	//bi-directional many-to-one association to User
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="reported_by_id")
	private User user1;

	//bi-directional many-to-one association to User
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="reported_to_id")
	private User user2;

	public Feedback() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getRating() {
		return this.rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	public Long getSubmittedOn() {
		return this.submittedOn;
	}

	public void setSubmittedOn(Long submittedOn) {
		this.submittedOn = submittedOn;
	}

	public String getType_studen_faculty_() {
		return this.type_studen_faculty_;
	}

	public void setType_studen_faculty_(String type_studen_faculty_) {
		this.type_studen_faculty_ = type_studen_faculty_;
	}

	public Subject getSubject() {
		return this.subject;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
	}

	public User getUser1() {
		return this.user1;
	}

	public void setUser1(User user1) {
		this.user1 = user1;
	}

	public User getUser2() {
		return this.user2;
	}

	public void setUser2(User user2) {
		this.user2 = user2;
	}

}