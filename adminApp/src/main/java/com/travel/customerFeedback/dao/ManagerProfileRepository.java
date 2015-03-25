package com.travel.customerFeedback.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.travel.customerFeedback.entity.ManagerProfile;

public interface ManagerProfileRepository extends JpaRepository<ManagerProfile, Long> {
public List<ManagerProfile> findAllByRoleId(long roleId);
public ManagerProfile findByName(String name);
}
