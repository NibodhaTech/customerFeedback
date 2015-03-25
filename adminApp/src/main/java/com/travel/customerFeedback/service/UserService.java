package com.travel.customerFeedback.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.travel.customerFeedback.dao.UserRepository;

@Service
public class UserService {
	
	@Autowired UserRepository userRepository;
	
	 public Boolean verifyToken(String verificationCode) {
		 if(userRepository.findOneByVerificationCode(verificationCode)!=null){
			 return true;
		 }else{
			 return false;
		 }
	 }

}
