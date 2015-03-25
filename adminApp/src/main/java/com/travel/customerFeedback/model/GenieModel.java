package com.travel.customerFeedback.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class GenieModel {

	private long id;

	private Date createdDate;

	private long genieStatusId;

	private String description;

	private String documentpath;

	private String sentiment_score;

	private long userId;
	
	private String phoneNumber;

	private String rating;

	private String priority;
	
	List<CommentModel> listCommentModel=new ArrayList<CommentModel>();

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
	 * @return the userId
	 */
	public long getUserId() {
		return userId;
	}

	/**
	 * @param userId
	 *            the userId to set
	 */
	public void setUserId(long userId) {
		this.userId = userId;
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

	public List<CommentModel> getListCommentModel() {
		return listCommentModel;
	}

	public void setListCommentModel(List<CommentModel> listCommentModel) {
		this.listCommentModel = listCommentModel;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

}
