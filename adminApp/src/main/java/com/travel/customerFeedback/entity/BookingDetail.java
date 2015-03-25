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
public class BookingDetail {

	@Id
	@GeneratedValue(generator = "BookingDetail")
	@GenericGenerator(name = "BookingDetail", strategy = "seqhilo", parameters = {
			@Parameter(name = "max_lo", value = "1"),
			@Parameter(name = "sequence", value = "BookingDetail_seq") })
	private long id;

	@Column
	private Date startDate;

	@Column
	private Date endDate;

	@Column
	private String roomNo;

	@Column
	private String no_of_person;

	@Column
	private String no_of_child;

	@Column
	private String note;

	@ManyToOne
	private UserProfile userProfile;

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
