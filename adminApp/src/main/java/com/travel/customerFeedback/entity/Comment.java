package com.travel.customerFeedback.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
public class Comment {

	@Id
	@GeneratedValue(generator = "Comment")
	@GenericGenerator(name = "Comment", strategy = "seqhilo", parameters = {
			@Parameter(name = "max_lo", value = "1"),
			@Parameter(name = "sequence", value = "Comment_seq") })
	private long id;

	@Column
	private long userId;

	@Column
	private Date createdDate;

	@Column
	private String description;

	@ManyToOne
	private GenieStatusType genieStatusType;

	@Column
	private Boolean isUser;
	
	@Column
	private long genieId;

	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}

	

	/**
	 * @return the createdDate
	 */
	public Date getCreatedDate() {
		return createdDate;
	}

	/**
	 * @param createdDate
	 *            the createdDate to set
	 */
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description
	 *            the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the genieStatusType
	 */
	public GenieStatusType getGenieStatusType() {
		return genieStatusType;
	}

	/**
	 * @param genieStatusType
	 *            the genieStatusType to set
	 */
	public void setGenieStatusType(GenieStatusType genieStatusType) {
		this.genieStatusType = genieStatusType;
	}

	/**
	 * @return the isUser
	 */
	public Boolean getIsUser() {
		return isUser;
	}

	/**
	 * @param isUser
	 *            the isUser to set
	 */
	public void setIsUser(Boolean isUser) {
		this.isUser = isUser;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public long getGenieId() {
		return genieId;
	}

	public void setGenieId(long genieId) {
		this.genieId = genieId;
	}

}
