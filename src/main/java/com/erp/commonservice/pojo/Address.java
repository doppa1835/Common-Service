package com.erp.commonservice.pojo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the address database table.
 * 
 */
@Entity
@NamedQuery(name="Address.findAll", query="SELECT a FROM Address a")
public class Address implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;

	@Column(name="address_desc")
	private String addressDesc;

	private String city;

	private String country;

	@Column(name="fax_number")
	private String faxNumber;

	@Column(name="is_permanent")
	private byte isPermanent;

	@Column(name="mobile_number")
	private String mobileNumber;

	@Column(name="phone_number")
	private String phoneNumber;

	private String pincode;

	private String state;

	//bi-directional many-to-one association to User
	@ManyToOne(fetch=FetchType.LAZY)
	private User user;

	//bi-directional many-to-one association to Campus
	@OneToMany(mappedBy="address")
	private List<Campus> campuses;

	//bi-directional many-to-one association to College
	@OneToMany(mappedBy="address")
	private List<College> colleges;

	public Address() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAddressDesc() {
		return this.addressDesc;
	}

	public void setAddressDesc(String addressDesc) {
		this.addressDesc = addressDesc;
	}

	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return this.country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getFaxNumber() {
		return this.faxNumber;
	}

	public void setFaxNumber(String faxNumber) {
		this.faxNumber = faxNumber;
	}

	public byte getIsPermanent() {
		return this.isPermanent;
	}

	public void setIsPermanent(byte isPermanent) {
		this.isPermanent = isPermanent;
	}

	public String getMobileNumber() {
		return this.mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getPhoneNumber() {
		return this.phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getPincode() {
		return this.pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<Campus> getCampuses() {
		return this.campuses;
	}

	public void setCampuses(List<Campus> campuses) {
		this.campuses = campuses;
	}

	public Campus addCampus(Campus campus) {
		getCampuses().add(campus);
		campus.setAddress(this);

		return campus;
	}

	public Campus removeCampus(Campus campus) {
		getCampuses().remove(campus);
		campus.setAddress(null);

		return campus;
	}

	public List<College> getColleges() {
		return this.colleges;
	}

	public void setColleges(List<College> colleges) {
		this.colleges = colleges;
	}

	public College addCollege(College college) {
		getColleges().add(college);
		college.setAddress(this);

		return college;
	}

	public College removeCollege(College college) {
		getColleges().remove(college);
		college.setAddress(null);

		return college;
	}

}