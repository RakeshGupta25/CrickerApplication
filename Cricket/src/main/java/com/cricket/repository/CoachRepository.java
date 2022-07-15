package com.cricket.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cricket.entity.Coach;
import com.cricket.entity.Player;

@Repository
public interface CoachRepository extends JpaRepository<Coach,Integer>{
	
	public List<Coach> findByCoachName(String coachName);
	
	public List<Coach> findByCoachRole(String coachName);
			
	public List<Coach> findByCoachNameAndCoachRole(String coachName,String coachRole);

}
