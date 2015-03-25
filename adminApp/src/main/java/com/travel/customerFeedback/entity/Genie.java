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
public class Genie {

	@Id
	@GeneratedValue(generator = "GenieModel")
	@GenericGenerator(name = "GenieModel", strategy = "seqhilo", parameters = {
			@Parameter(name = "max_lo", value = "1"),
			@Parameter(name = "sequence", value = "genie_seq") })
	private long id;

	@Column
	private Date createdDate;

	@ManyToOne
	private GenieStatusType genieStatusType;

	@Column
	private String description;

	@Column
	private String documentpath;

	@Column
	private String sentiment_score;

	

	@Column
	private long userId;
	
	@Column
	private long assignedToUserId;

	@Column
	private String rating;

	@Column
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

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public long getAssignedToUserId() {
		return assignedToUserId;
	}

	public void setAssignedToUserId(long assignedToUserId) {
		this.assignedToUserId = assignedToUserId;
	}



}
