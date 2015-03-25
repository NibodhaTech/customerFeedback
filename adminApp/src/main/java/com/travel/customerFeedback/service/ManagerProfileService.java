package com.travel.customerFeedback.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.travel.customerFeedback.dao.ManagerProfileRepository;
import com.travel.customerFeedback.entity.ManagerProfile;

@Service
public class ManagerProfileService {

	@Autowired
	ManagerProfileRepository managerProfileRepository;

	public Boolean verifyManager(String verificationCode) {
		if (managerProfileRepository.findByName(verificationCode) != null) {
			return true;
		} else {
			return false;
		}
	}
	
	public ManagerProfile getManager(String verificationCode) {
		return managerProfileRepository.findByName(verificationCode);
	}

}
