package com.erp.commonservice.pojo;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the qualification database table.
 * 
 */
@Entity
@NamedQuery(name="Qualification.findAll", query="SELECT q FROM Qualification q")
public class Qualification implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;

	private String certificate;

	@Column(name="from_date")
	private Long fromDate;

	private String grade;

	private String institute;

	@Column(name="institute_location")
	private String instituteLocation;

	@Column(name="is_cgpa")
	private byte isCgpa;

	@Column(name="is_highest_qualification")
	private byte isHighestQualification;

	private String name;

	private String other;

	@Column(name="`percentage/cgpa`")
	private String percentage_cgpa;

	@Column(name="to_date")
	private Long toDate;

	private String type;

	private String university;

	//bi-directional many-to-one association to User
	@ManyToOne(fetch=FetchType.LAZY)
	private User user;

	public Qualification() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCertificate() {
		return this.certificate;
	}

	public void setCertificate(String certificate) {
		this.certificate = certificate;
	}

	public Long getFromDate() {
		return this.fromDate;
	}

	public void setFromDate(Long fromDate) {
		this.fromDate = fromDate;
	}

	public String getGrade() {
		return this.grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public String getInstitute() {
		return this.institute;
	}

	public void setInstitute(String institute) {
		this.institute = institute;
	}

	public String getInstituteLocation() {
		return this.instituteLocation;
	}

	public void setInstituteLocation(String instituteLocation) {
		this.instituteLocation = instituteLocation;
	}

	public byte getIsCgpa() {
		return this.isCgpa;
	}

	public void setIsCgpa(byte isCgpa) {
		this.isCgpa = isCgpa;
	}

	public byte getIsHighestQualification() {
		return this.isHighestQualification;
	}

	public void setIsHighestQualification(byte isHighestQualification) {
		this.isHighestQualification = isHighestQualification;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getOther() {
		return this.other;
	}

	public void setOther(String other) {
		this.other = other;
	}

	public String getPercentage_cgpa() {
		return this.percentage_cgpa;
	}

	public void setPercentage_cgpa(String percentage_cgpa) {
		this.percentage_cgpa = percentage_cgpa;
	}

	public Long getToDate() {
		return this.toDate;
	}

	public void setToDate(Long toDate) {
		this.toDate = toDate;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getUniversity() {
		return this.university;
	}

	public void setUniversity(String university) {
		this.university = university;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}