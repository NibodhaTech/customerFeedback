package com.travel.customerFeedback.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.travel.customerFeedback.entity.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
	public Role findOneByName(String name);

}
