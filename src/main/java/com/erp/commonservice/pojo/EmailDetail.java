package com.erp.commonservice.pojo;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the email_details database table.
 * 
 */
@Entity
@Table(name="email_details")
@NamedQuery(name="EmailDetail.findAll", query="SELECT e FROM EmailDetail e")
public class EmailDetail implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;

	@Column(name="receipent_email")
	private String receipentEmail;

	@Column(name="sender_email")
	private String senderEmail;

	@Column(name="sent_on")
	private Long sentOn;

	private String status;

	private String template;

	private String type;

	public EmailDetail() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getReceipentEmail() {
		return this.receipentEmail;
	}

	public void setReceipentEmail(String receipentEmail) {
		this.receipentEmail = receipentEmail;
	}

	public String getSenderEmail() {
		return this.senderEmail;
	}

	public void setSenderEmail(String senderEmail) {
		this.senderEmail = senderEmail;
	}

	public Long getSentOn() {
		return this.sentOn;
	}

	public void setSentOn(Long sentOn) {
		this.sentOn = sentOn;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getTemplate() {
		return this.template;
	}

	public void setTemplate(String template) {
		this.template = template;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

}