package com.amazonaws.demo.s3_transfer_manager.models;

import java.util.Date;


public class Comment {

	private long id;

	private UserProfile userProfile;

	private Date createdDate;

	private String description;

	private GenieStatusType genieStatusType;

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
	 * @return the userProfile
	 */
	public UserProfile getUserProfile() {
		return userProfile;
	}

	/**
	 * @param userProfile
	 *            the userProfile to set
	 */
	public void setUserProfile(UserProfile userProfile) {
		this.userProfile = userProfile;
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

}
