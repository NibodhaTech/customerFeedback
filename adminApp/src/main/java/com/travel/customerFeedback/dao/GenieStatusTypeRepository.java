package com.travel.customerFeedback.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.travel.customerFeedback.entity.GenieStatusType;

@Repository
public interface GenieStatusTypeRepository extends JpaRepository<GenieStatusType, Long> {


	
}
