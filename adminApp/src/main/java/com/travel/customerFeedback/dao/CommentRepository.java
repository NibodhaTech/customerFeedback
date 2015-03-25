package com.travel.customerFeedback.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.travel.customerFeedback.entity.BookingDetail;
import com.travel.customerFeedback.entity.Comment;

public interface CommentRepository extends JpaRepository<Comment, Long> {
	List<Comment> findAllByGenieId(long genieId);

}
