package com.travel.customerFeedback.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
public class ManagerProfile {

	@Id
	@GeneratedValue(generator = "ManagerProfile")
	@GenericGenerator(name = "ManagerProfile", strategy = "seqhilo", parameters = {
			@Parameter(name = "max_lo", value = "1"),
			@Parameter(name = "sequence", value = "ManagerProfile_seq") })
	private long id;

	@Column
	private String name;

	@Column
	private String password;

	@Column
	private long roleId;

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

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password
	 *            the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	public long getRoleId() {
		return roleId;
	}

	public void setRoleId(long roleId) {
		this.roleId = roleId;
	}

	

}
