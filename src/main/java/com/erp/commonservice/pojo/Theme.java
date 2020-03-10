package com.erp.commonservice.pojo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the theme database table.
 * 
 */
@Entity
@NamedQuery(name="Theme.findAll", query="SELECT t FROM Theme t")
public class Theme implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;

	@Column(name="baner_images")
	private String banerImages;

	private String images;

	@Column(name="is_active")
	private byte isActive;

	@Column(name="logo_images")
	private String logoImages;

	private String name;

	//bi-directional many-to-one association to Campus
	@OneToMany(mappedBy="theme")
	private List<Campus> campuses;

	//bi-directional many-to-one association to Campus
	@ManyToOne(fetch=FetchType.LAZY)
	private Campus campus;

	public Theme() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getBanerImages() {
		return this.banerImages;
	}

	public void setBanerImages(String banerImages) {
		this.banerImages = banerImages;
	}

	public String getImages() {
		return this.images;
	}

	public void setImages(String images) {
		this.images = images;
	}

	public byte getIsActive() {
		return this.isActive;
	}

	public void setIsActive(byte isActive) {
		this.isActive = isActive;
	}

	public String getLogoImages() {
		return this.logoImages;
	}

	public void setLogoImages(String logoImages) {
		this.logoImages = logoImages;
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
		campus.setTheme(this);

		return campus;
	}

	public Campus removeCampus(Campus campus) {
		getCampuses().remove(campus);
		campus.setTheme(null);

		return campus;
	}

	public Campus getCampus() {
		return this.campus;
	}

	public void setCampus(Campus campus) {
		this.campus = campus;
	}

}