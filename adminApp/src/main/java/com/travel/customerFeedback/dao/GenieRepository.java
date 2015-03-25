/**
 * 
 */
package com.travel.customerFeedback.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.travel.customerFeedback.entity.Genie;


/**
 * @author Nibodha [Mar 14, 2015:11:28:18 AM]
 *
 */
@Repository
public interface GenieRepository extends JpaRepository<Genie, Long>{
	public List<Genie> findAllGenieByUserId(long userId);
	public List<Genie> findAllGenieByAssignedToUserId(long assignedToUserId);

}
