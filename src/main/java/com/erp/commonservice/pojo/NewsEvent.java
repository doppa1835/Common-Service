package com.erp.commonservice.pojo;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the news_events database table.
 * 
 */
@Entity
@Table(name="news_events")
@NamedQuery(name="NewsEvent.findAll", query="SELECT n FROM NewsEvent n")
public class NewsEvent implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;

	private String description;

	@Column(name="end_date")
	private Long endDate;

	@Column(name="image_path")
	private String imagePath;

	@Column(name="news_date")
	private Long newsDate;

	@Column(name="start_date")
	private Long startDate;

	private String type;

	private String url;

	public NewsEvent() {
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

	public Long getEndDate() {
		return this.endDate;
	}

	public void setEndDate(Long endDate) {
		this.endDate = endDate;
	}

	public String getImagePath() {
		return this.imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	public Long getNewsDate() {
		return this.newsDate;
	}

	public void setNewsDate(Long newsDate) {
		this.newsDate = newsDate;
	}

	public Long getStartDate() {
		return this.startDate;
	}

	public void setStartDate(Long startDate) {
		this.startDate = startDate;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

}