package com.travel.customerFeedback.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
public class GenieStatusType {

	@Id
	@GeneratedValue(generator = "GenieStatusType")
	@GenericGenerator(name = "GenieStatusType", strategy = "seqhilo", parameters = {
			@Parameter(name = "max_lo", value = "1"),
			@Parameter(name = "sequence", value = "GenieStatusType_seq") })
	private long id;
	
	@Column
	private String type;

	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}
	
	
}
