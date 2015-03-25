package com.travel.customerFeedback.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.travel.customerFeedback.entity.BookingDetail;
import com.travel.customerFeedback.entity.Genie;

public interface BookingDetailRepository extends JpaRepository<BookingDetail, Long> {

}
