package com.travel.customerFeedback.service;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.travel.customerFeedback.dao.GenieRepository;
import com.travel.customerFeedback.dao.ManagerProfileRepository;
import com.travel.customerFeedback.dao.RoleRepository;
import com.travel.customerFeedback.entity.Genie;
import com.travel.customerFeedback.entity.ManagerProfile;
import com.travel.customerFeedback.entity.Role;

/**
 * @author Nibodha
 * This class will implement the round robin method to identify the user to which the ticket needs
 * to be assigned.
 *
 */
@Service
public class UserAssignmentService  {
	
	@Autowired ManagerProfileRepository managerProfileRepository;
	@Autowired RoleRepository roleRepository;
	@Autowired GenieRepository genieRepositiory;
	/* (non-Javadoc)
	 * @see com.travel.customerFeedback.service.IUserAssignmentService#getToAssignUserId()
	 */
	public long getToAssignUserId(String description) {
		Long selectedId=null;
		if(description.toLowerCase().contains("room")){
			return getUserIdFromTheDepartment("ROOM_DEPARTMENT");
		}else if(description.toLowerCase().contains("food")){
			return getUserIdFromTheDepartment("ROOM_DEPARTMENT");
		}else{
			return getUserIdFromTheDepartment("MISC_DEPARTMENT");
		}
		
	}
	
	/**
	 * @param name
	 * @return
	 */
	private long getUserIdFromTheDepartment(String name) {
		Long selectedId = null;
		Role role = roleRepository.findOneByName(name);
		List<ManagerProfile> listManagerProfile = managerProfileRepository
				.findAllByRoleId(role.getId());
		// Identify who has less number of tickets assigned and assign the
		// ticket to that person

		int ticketCount = 0;
		for (ManagerProfile profile : listManagerProfile) {
			List<Genie> listGenie = genieRepositiory
					.findAllGenieByAssignedToUserId(profile.getId());
			if (selectedId == null) {
				selectedId = profile.getId();
				if (CollectionUtils.isEmpty(listGenie)) {
					ticketCount = listGenie.size();
				} else {
					ticketCount = 0;
				}

			} else {
				if (CollectionUtils.isEmpty(listGenie)
						&& listGenie.size() <= ticketCount) {
					ticketCount = listGenie.size();
					selectedId = profile.getId();
				}
			}

		}
		return selectedId;

	}

}
