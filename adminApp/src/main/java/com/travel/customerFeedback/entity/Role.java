package com.travel.customerFeedback.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
public class Role {

	@Id
	@GeneratedValue(generator = "Role")
	@GenericGenerator(name = "Role", strategy = "seqhilo", parameters = {
			@Parameter(name = "max_lo", value = "1"),
			@Parameter(name = "Role", value = "Role_seq") })
	private long id;

	@Column
	private String name;

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
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

}
