/**
 * 
 */
package com.travel.customerFeedback.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value="/testController")
public class TestController {

	
	@RequestMapping(value="/testMethod", method=RequestMethod.GET,produces="application/json")
	@ResponseBody
	public String sortProductUsingType(@RequestBody String test) {
		return "Output from Test Method";
	}

}
