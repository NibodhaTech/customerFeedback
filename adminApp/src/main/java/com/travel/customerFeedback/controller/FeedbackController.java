/**
 * 
 */
package com.travel.customerFeedback.controller;

import java.util.List;

import org.apache.log4j.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.travel.customerFeedback.model.CommentModel;
import com.travel.customerFeedback.model.GenieModel;
import com.travel.customerFeedback.service.FeedbackService;

@RestController
@RequestMapping(value = "/feedbackController")
public class FeedbackController {

	private static final Category LOGGER = Category
			.getInstance(FeedbackController.class);

	@Autowired
	private FeedbackService feedbackService;

	@RequestMapping(value = "/createGenie", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public GenieModel createGenie(@RequestBody GenieModel genieModel) {
		LOGGER.info("executing FeedbackController.createGenie()");
		return  feedbackService.createGenie(genieModel);
		
	}
	
	@RequestMapping(value = "/updateGenie", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public GenieModel updateGenie(@RequestBody GenieModel genieModel) {
		LOGGER.info("executing FeedbackController.updateGenie()");
		return feedbackService.updateGenie(genieModel);
		
	}
	
	@RequestMapping(value = "/updateComments", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public CommentModel updateComments(@RequestBody CommentModel commentModel) {
		LOGGER.info("executing updateUserComments");
		return  feedbackService.updateComments(commentModel);
		
	}
	
	

	@RequestMapping(value = "/getGenieByGenieId/{genieId}", method = RequestMethod.GET)
	@ResponseBody
	public GenieModel getGenieByGenieId(@PathVariable("genieId")long genieId) {
		LOGGER.info("executing FeedbackController.getGenie()");
		return feedbackService.getGenieByGenieId(genieId);
		}
	

	@RequestMapping(value = "/getAllGenieByUserId/{userId}", method = RequestMethod.GET)
	@ResponseBody
	public List<GenieModel> getAllGenieByUserId(@PathVariable("userId")long userId) {
		LOGGER.info("executing FeedbackController.getAllGenieByUserId()");
		return feedbackService.getAllGenieByUserId(userId);
		}
	
	@RequestMapping(value = "/getAllGenieByAssignedUserId", method = RequestMethod.GET)
	@ResponseBody
	public List<GenieModel> getAllGenieByAssignedUserId(long assignedToUserId) {
		LOGGER.info("executing FeedbackController.getAllGenieByUserId()");
		return feedbackService.getAllGenieByAssignedUserId(assignedToUserId);
		}
	
	@RequestMapping(value = "/getAllGenieforSuperAdmin", method = RequestMethod.GET)
	@ResponseBody
	public List<GenieModel> getAllGenieforSuperAdmin() {
		LOGGER.info("executing FeedbackController.getAllGenieByUserId()");
		return feedbackService.getAllGenieforSuperAdmin();
		}

	@RequestMapping(value = "/getOffers", method = RequestMethod.GET)
	public String getOffers(String mobileNumber) {
		return "";
	}
	
	@RequestMapping(value = "/getPromotions", method = RequestMethod.GET)
	public String getPromotions(String mobileNumber) {
		return "";
	}

}
