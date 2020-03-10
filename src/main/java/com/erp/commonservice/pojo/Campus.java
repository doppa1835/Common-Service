package com.erp.commonservice.pojo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the campus database table.
 * 
 */
@Entity
@NamedQuery(name="Campus.findAll", query="SELECT c FROM Campus c")
public class Campus implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;

	private String code;

	@Column(name="is_active")
	private byte isActive;

	@Column(name="is_main_campus")
	private byte isMainCampus;

	private String name;

	//bi-directional many-to-one association to Address
	@ManyToOne(fetch=FetchType.LAZY)
	private Address address;

	//bi-directional many-to-one association to College
	@ManyToOne(fetch=FetchType.LAZY)
	private College college;

	//bi-directional many-to-one association to Theme
	@ManyToOne(fetch=FetchType.LAZY)
	private Theme theme;

	//bi-directional many-to-one association to Stream
	@OneToMany(mappedBy="campus")
	private List<Stream> streams;

	//bi-directional many-to-one association to Theme
	@OneToMany(mappedBy="campus")
	private List<Theme> themes;

	public Campus() {
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

	public byte getIsActive() {
		return this.isActive;
	}

	public void setIsActive(byte isActive) {
		this.isActive = isActive;
	}

	public byte getIsMainCampus() {
		return this.isMainCampus;
	}

	public void setIsMainCampus(byte isMainCampus) {
		this.isMainCampus = isMainCampus;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Address getAddress() {
		return this.address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public College getCollege() {
		return this.college;
	}

	public void setCollege(College college) {
		this.college = college;
	}

	public Theme getTheme() {
		return this.theme;
	}

	public void setTheme(Theme theme) {
		this.theme = theme;
	}

	public List<Stream> getStreams() {
		return this.streams;
	}

	public void setStreams(List<Stream> streams) {
		this.streams = streams;
	}

	public Stream addStream(Stream stream) {
		getStreams().add(stream);
		stream.setCampus(this);

		return stream;
	}

	public Stream removeStream(Stream stream) {
		getStreams().remove(stream);
		stream.setCampus(null);

		return stream;
	}

	public List<Theme> getThemes() {
		return this.themes;
	}

	public void setThemes(List<Theme> themes) {
		this.themes = themes;
	}

	public Theme addTheme(Theme theme) {
		getThemes().add(theme);
		theme.setCampus(this);

		return theme;
	}

	public Theme removeTheme(Theme theme) {
		getThemes().remove(theme);
		theme.setCampus(null);

		return theme;
	}

}