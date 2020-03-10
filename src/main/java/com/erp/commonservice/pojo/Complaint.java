package com.erp.commonservice.pojo;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the complaint database table.
 * 
 */
@Entity
@NamedQuery(name="Complaint.findAll", query="SELECT c FROM Complaint c")
public class Complaint implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;

	@Column(name="action_date")
	private Long actionDate;

	@Column(name="action_taken")
	private String actionTaken;

	@Column(name="complaint_date")
	private Long complaintDate;

	private String description;

	@Column(name="is_resolved")
	private byte isResolved;

	private String type;

	//bi-directional many-to-one association to User
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="complaint_by")
	private User user;

	public Complaint() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getActionDate() {
		return this.actionDate;
	}

	public void setActionDate(Long actionDate) {
		this.actionDate = actionDate;
	}

	public String getActionTaken() {
		return this.actionTaken;
	}

	public void setActionTaken(String actionTaken) {
		this.actionTaken = actionTaken;
	}

	public Long getComplaintDate() {
		return this.complaintDate;
	}

	public void setComplaintDate(Long complaintDate) {
		this.complaintDate = complaintDate;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public byte getIsResolved() {
		return this.isResolved;
	}

	public void setIsResolved(byte isResolved) {
		this.isResolved = isResolved;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}