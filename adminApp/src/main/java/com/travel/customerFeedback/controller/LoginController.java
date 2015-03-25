/**
 * 
 */
package com.travel.customerFeedback.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.travel.customerFeedback.entity.ManagerProfile;
import com.travel.customerFeedback.service.ManagerProfileService;

@RestController
public class LoginController {

	@Autowired
	private ManagerProfileService managerProfileService;

	@RequestMapping(value = "/authenticate", method = RequestMethod.GET)
	public ManagerProfile sortProductUsingType(
			@RequestParam("username") String username,
			@RequestParam("password") String password) {
		ManagerProfile managerProfile = managerProfileService
				.getManager(username);
		return managerProfile;
	}

}
