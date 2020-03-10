package com.erp.commonservice.pojo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the subject database table.
 * 
 */
@Entity
@NamedQuery(name="Subject.findAll", query="SELECT s FROM Subject s")
public class Subject implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;

	private String code;

	@Column(name="course_year")
	private String courseYear;

	@Column(name="external_marks")
	private int externalMarks;

	@Column(name="internal_marks")
	private int internalMarks;

	@Column(name="is_active")
	private byte isActive;

	private String name;

	private String semester;

	private String type;

	//bi-directional many-to-one association to Feedback
	@OneToMany(mappedBy="subject")
	private List<Feedback> feedbacks;

	//bi-directional many-to-one association to Course
	@ManyToOne(fetch=FetchType.LAZY)
	private Course course;

	//bi-directional many-to-one association to SubjectTimetable
	@OneToMany(mappedBy="subject")
	private List<SubjectTimetable> subjectTimetables;

	public Subject() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getCourseYear() {
		return this.courseYear;
	}

	public void setCourseYear(String courseYear) {
		this.courseYear = courseYear;
	}

	public int getExternalMarks() {
		return this.externalMarks;
	}

	public void setExternalMarks(int externalMarks) {
		this.externalMarks = externalMarks;
	}

	public int getInternalMarks() {
		return this.internalMarks;
	}

	public void setInternalMarks(int internalMarks) {
		this.internalMarks = internalMarks;
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

	public String getSemester() {
		return this.semester;
	}

	public void setSemester(String semester) {
		this.semester = semester;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public List<Feedback> getFeedbacks() {
		return this.feedbacks;
	}

	public void setFeedbacks(List<Feedback> feedbacks) {
		this.feedbacks = feedbacks;
	}

	public Feedback addFeedback(Feedback feedback) {
		getFeedbacks().add(feedback);
		feedback.setSubject(this);

		return feedback;
	}

	public Feedback removeFeedback(Feedback feedback) {
		getFeedbacks().remove(feedback);
		feedback.setSubject(null);

		return feedback;
	}

	public Course getCourse() {
		return this.course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public List<SubjectTimetable> getSubjectTimetables() {
		return this.subjectTimetables;
	}

	public void setSubjectTimetables(List<SubjectTimetable> subjectTimetables) {
		this.subjectTimetables = subjectTimetables;
	}

	public SubjectTimetable addSubjectTimetable(SubjectTimetable subjectTimetable) {
		getSubjectTimetables().add(subjectTimetable);
		subjectTimetable.setSubject(this);

		return subjectTimetable;
	}

	public SubjectTimetable removeSubjectTimetable(SubjectTimetable subjectTimetable) {
		getSubjectTimetables().remove(subjectTimetable);
		subjectTimetable.setSubject(null);

		return subjectTimetable;
	}

}