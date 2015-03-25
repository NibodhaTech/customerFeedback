package com.travel.customerFeedback.model;

import java.util.Date;

public class CommentModel {

	private long id;

	private long userProfileId;

	private Date createdDate;

	private String description;

	private long genieStatusId;

	private Boolean isUser;

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
	 * @return the userProfileId
	 */
	public long getUserProfileId() {
		return userProfileId;
	}

	/**
	 * @param userProfileId
	 *            the userProfileId to set
	 */
	public void setUserProfileId(long userProfileId) {
		this.userProfileId = userProfileId;
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
	 * @return the genieStatusId
	 */
	public long getGenieStatusId() {
		return genieStatusId;
	}

	/**
	 * @param genieStatusId
	 *            the genieStatusId to set
	 */
	public void setGenieStatusId(long genieStatusId) {
		this.genieStatusId = genieStatusId;
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

}
