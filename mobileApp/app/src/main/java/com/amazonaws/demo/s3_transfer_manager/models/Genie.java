package com.amazonaws.demo.s3_transfer_manager.models;

import java.util.Date;

public class Genie {

	private long id;

	private Date createdDate;

	private GenieStatusType genieStatusType;

	private String description;

	private String documentpath;

	private String sentiment_score;

	private String nlp_catagory;

	private UserProfile userProfile;

	private String rating;

	private String priority;

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
	 * @return the documentpath
	 */
	public String getDocumentpath() {
		return documentpath;
	}

	/**
	 * @param documentpath
	 *            the documentpath to set
	 */
	public void setDocumentpath(String documentpath) {
		this.documentpath = documentpath;
	}

	/**
	 * @return the sentiment_score
	 */
	public String getSentiment_score() {
		return sentiment_score;
	}

	/**
	 * @param sentiment_score
	 *            the sentiment_score to set
	 */
	public void setSentiment_score(String sentiment_score) {
		this.sentiment_score = sentiment_score;
	}

	/**
	 * @return the nlp_catagory
	 */
	public String getNlp_catagory() {
		return nlp_catagory;
	}

	/**
	 * @param nlp_catagory
	 *            the nlp_catagory to set
	 */
	public void setNlp_catagory(String nlp_catagory) {
		this.nlp_catagory = nlp_catagory;
	}

	/**
	 * @return the rating
	 */
	public String getRating() {
		return rating;
	}

	/**
	 * @param rating
	 *            the rating to set
	 */
	public void setRating(String rating) {
		this.rating = rating;
	}

	/**
	 * @return the priority
	 */
	public String getPriority() {
		return priority;
	}

	/**
	 * @param priority
	 *            the priority to set
	 */
	public void setPriority(String priority) {
		this.priority = priority;
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

}
