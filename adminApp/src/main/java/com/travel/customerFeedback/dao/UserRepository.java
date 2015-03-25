package com.travel.customerFeedback.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.travel.customerFeedback.entity.UserProfile;

@Repository
public interface UserRepository extends JpaRepository<UserProfile, Long> {
	public UserProfile findOneByVerificationCode(String verificationCode);
	public UserProfile findOneByPhoneNo(String phoneNo);

}
