package com.erp.commonservice.pojo;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;


/**
 * The persistent class for the user database table.
 * 
 */
@Entity
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;

	private String answer;

	private String email;

	@Column(name="is_active")
	private byte isActive;

	private String name;

	private String password;

	@Column(name="security_question")
	private String securityQuestion;

	
	@OneToMany(mappedBy="user")
	private List<Address> addresses;

	
	@OneToMany(mappedBy="user")
	private List<Complaint> complaints;

	
	@OneToMany(mappedBy="user1")
	private List<Feedback> feedbacks1;

	
	@OneToMany(mappedBy="user2")
	private List<Feedback> feedbacks2;

	
	@OneToMany(mappedBy="user")
	private List<Notification> notifications;

	
	@OneToMany(mappedBy="user")
	private List<Qualification> qualifications;

	
	@OneToMany(mappedBy="user")
	private List<SubjectTimetable> subjectTimetables;

	
	@ManyToOne(cascade=CascadeType.MERGE,fetch=FetchType.LAZY)
	private Role role;

	public User() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAnswer() {
		return this.answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public byte getIsActive() {
		return this.isActive;
	}

	public void setIsActive(byte isActive) {
		this.isActive = isActive;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSecurityQuestion() {
		return this.securityQuestion;
	}

	public void setSecurityQuestion(String securityQuestion) {
		this.securityQuestion = securityQuestion;
	}

	public List<Address> getAddresses() {
		return this.addresses;
	}

	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}

	public Address addAddress(Address address) {
		getAddresses().add(address);
		address.setUser(this);

		return address;
	}

	public Address removeAddress(Address address) {
		getAddresses().remove(address);
		address.setUser(null);

		return address;
	}

	public List<Complaint> getComplaints() {
		return this.complaints;
	}

	public void setComplaints(List<Complaint> complaints) {
		this.complaints = complaints;
	}

	public Complaint addComplaint(Complaint complaint) {
		getComplaints().add(complaint);
		complaint.setUser(this);

		return complaint;
	}

	public Complaint removeComplaint(Complaint complaint) {
		getComplaints().remove(complaint);
		complaint.setUser(null);

		return complaint;
	}

	public List<Feedback> getFeedbacks1() {
		return this.feedbacks1;
	}

	public void setFeedbacks1(List<Feedback> feedbacks1) {
		this.feedbacks1 = feedbacks1;
	}

	public Feedback addFeedbacks1(Feedback feedbacks1) {
		getFeedbacks1().add(feedbacks1);
		feedbacks1.setUser1(this);

		return feedbacks1;
	}

	public Feedback removeFeedbacks1(Feedback feedbacks1) {
		getFeedbacks1().remove(feedbacks1);
		feedbacks1.setUser1(null);

		return feedbacks1;
	}

	public List<Feedback> getFeedbacks2() {
		return this.feedbacks2;
	}

	public void setFeedbacks2(List<Feedback> feedbacks2) {
		this.feedbacks2 = feedbacks2;
	}

	public Feedback addFeedbacks2(Feedback feedbacks2) {
		getFeedbacks2().add(feedbacks2);
		feedbacks2.setUser2(this);

		return feedbacks2;
	}

	public Feedback removeFeedbacks2(Feedback feedbacks2) {
		getFeedbacks2().remove(feedbacks2);
		feedbacks2.setUser2(null);

		return feedbacks2;
	}

	public List<Notification> getNotifications() {
		return this.notifications;
	}

	public void setNotifications(List<Notification> notifications) {
		this.notifications = notifications;
	}

	public Notification addNotification(Notification notification) {
		getNotifications().add(notification);
		notification.setUser(this);

		return notification;
	}

	public Notification removeNotification(Notification notification) {
		getNotifications().remove(notification);
		notification.setUser(null);

		return notification;
	}

	public List<Qualification> getQualifications() {
		return this.qualifications;
	}

	public void setQualifications(List<Qualification> qualifications) {
		this.qualifications = qualifications;
	}

	public Qualification addQualification(Qualification qualification) {
		getQualifications().add(qualification);
		qualification.setUser(this);

		return qualification;
	}

	public Qualification removeQualification(Qualification qualification) {
		getQualifications().remove(qualification);
		qualification.setUser(null);

		return qualification;
	}

	public List<SubjectTimetable> getSubjectTimetables() {
		return this.subjectTimetables;
	}

	public void setSubjectTimetables(List<SubjectTimetable> subjectTimetables) {
		this.subjectTimetables = subjectTimetables;
	}

	public SubjectTimetable addSubjectTimetable(SubjectTimetable subjectTimetable) {
		getSubjectTimetables().add(subjectTimetable);
		subjectTimetable.setUser(this);

		return subjectTimetable;
	}

	public SubjectTimetable removeSubjectTimetable(SubjectTimetable subjectTimetable) {
		getSubjectTimetables().remove(subjectTimetable);
		subjectTimetable.setUser(null);

		return subjectTimetable;
	}

	public Role getRole() {
		return this.role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

}