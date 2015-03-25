package com.travel.customerFeedback.model;

import java.util.Date;

public class BookingDetailModel {
	private long id;

	private Date startDate;

	private Date endDate;

	private String roomNo;

	private String no_of_person;

	private String no_of_child;

	private String note;

	private long userId;

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
	 * @return the startDate
	 */
	public Date getStartDate() {
		return startDate;
	}

	/**
	 * @param startDate
	 *            the startDate to set
	 */
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	/**
	 * @return the endDate
	 */
	public Date getEndDate() {
		return endDate;
	}

	/**
	 * @param endDate
	 *            the endDate to set
	 */
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	/**
	 * @return the roomNo
	 */
	public String getRoomNo() {
		return roomNo;
	}

	/**
	 * @param roomNo
	 *            the roomNo to set
	 */
	public void setRoomNo(String roomNo) {
		this.roomNo = roomNo;
	}

	/**
	 * @return the no_of_person
	 */
	public String getNo_of_person() {
		return no_of_person;
	}

	/**
	 * @param no_of_person
	 *            the no_of_person to set
	 */
	public void setNo_of_person(String no_of_person) {
		this.no_of_person = no_of_person;
	}

	/**
	 * @return the no_of_child
	 */
	public String getNo_of_child() {
		return no_of_child;
	}

	/**
	 * @param no_of_child
	 *            the no_of_child to set
	 */
	public void setNo_of_child(String no_of_child) {
		this.no_of_child = no_of_child;
	}

	/**
	 * @return the note
	 */
	public String getNote() {
		return note;
	}

	/**
	 * @param note
	 *            the note to set
	 */
	public void setNote(String note) {
		this.note = note;
	}

	/**
	 * @return the userId
	 */
	public long getUserId() {
		return userId;
	}

	/**
	 * @param userId the userId to set
	 */
	public void setUserId(long userId) {
		this.userId = userId;
	}

	
}
