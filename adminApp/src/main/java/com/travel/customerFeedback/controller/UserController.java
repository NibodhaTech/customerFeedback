package com.travel.customerFeedback.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.travel.customerFeedback.service.UserService;

@RestController
@RequestMapping(value="/userController")
public class UserController {
	@Autowired
	UserService userService;
	
	/**
	 * Verify the user based on the token generated
	 * @param verificationCode
	 * @return
	 */
	@RequestMapping(value="/verifyToken", method=RequestMethod.GET,produces="application/json")
	@ResponseBody
	public Boolean verifyToken(@RequestParam String verificationCode) {
		return userService.verifyToken(verificationCode);
	}

}
