package com.erp.commonservice.pojo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the college database table.
 * 
 */
@Entity
@NamedQuery(name="College.findAll", query="SELECT c FROM College c")
public class College implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;

	@Column(name="affiliated_to")
	private String affiliatedTo;

	private String code;

	@Column(name="is_active")
	private byte isActive;

	private String name;

	//bi-directional many-to-one association to Campus
	@OneToMany(mappedBy="college")
	private List<Campus> campuses;

	//bi-directional many-to-one association to Address
	@ManyToOne(fetch=FetchType.LAZY)
	private Address address;

	public College() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAffiliatedTo() {
		return this.affiliatedTo;
	}

	public void setAffiliatedTo(String affiliatedTo) {
		this.affiliatedTo = affiliatedTo;
	}

	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
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

	public List<Campus> getCampuses() {
		return this.campuses;
	}

	public void setCampuses(List<Campus> campuses) {
		this.campuses = campuses;
	}

	public Campus addCampus(Campus campus) {
		getCampuses().add(campus);
		campus.setCollege(this);

		return campus;
	}

	public Campus removeCampus(Campus campus) {
		getCampuses().remove(campus);
		campus.setCollege(null);

		return campus;
	}

	public Address getAddress() {
		return this.address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

}