package com.cricket.service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cricket.dtoentity.CoachDto;
import com.cricket.entity.Coach;
import com.cricket.exception.PlayerNotFound;
import com.cricket.repository.CoachRepository;

@Service
public class CoachService {

	@Autowired
	private CoachRepository coachRepository;

	// addplayer
	public Coach addCoach(CoachDto coachDto) {
		Coach coachSave = new Coach();
		coachSave.setCoachName(coachDto.getCoachName());
		coachSave.setCoachRole(coachDto.getCoachRole());
		return coachRepository.save(coachSave);
	}

	// update player
	public Coach updateCoach(CoachDto coachDto, int coachId) {
		Coach coachUpdate = coachRepository.findById(coachId).get();
		coachUpdate.setCoachName(coachDto.getCoachName());
		coachUpdate.setCoachRole(coachDto.getCoachRole());
		return coachRepository.save(coachUpdate);
	}

	// delete by id
	public String deleteCoach(int coachId) {
		try {
		coachRepository.deleteById(coachId);
		return coachId + " Id Coach is Deleted";
		}catch (Exception e) {
			throw new PlayerNotFound(" Coach ID is not present");
		}
		
	}

	// get by id
	public Coach getCoach(int coachId) throws PlayerNotFound {
		try {
			return coachRepository.findById(coachId).get();
		} catch (NoSuchElementException e) {
			throw new PlayerNotFound(" Coach ID is not present");
		}

	}

	public List<Coach> getAllCoach() {
		return coachRepository.findAll();
	}
	
	public List<Coach> getByCoachName(String coachName)
	{		
		if(coachRepository.findByCoachName(coachName)==null || coachRepository.findByCoachName(coachName).isEmpty())
			{
			throw new PlayerNotFound("Coach Name is not present");
			}
		return coachRepository.findByCoachName(coachName);
		
	}

	public List<Coach> findByCoachRole(String coachName)
	{
		if(coachRepository.findByCoachRole(coachName)==null || coachRepository.findByCoachRole(coachName).isEmpty())
		{
			throw new PlayerNotFound("Coach role is not present");
		}
		else {
		return coachRepository.findByCoachRole(coachName);
	}
	}
	public List<Coach> findByCoachNameAndCoachRole(String coachName,String coachRole)
	{
		if(coachRepository.findByCoachNameAndCoachRole(coachName, coachRole)==null || coachRepository.findByCoachNameAndCoachRole(coachName, coachRole).isEmpty())
		{
			throw new PlayerNotFound("Coach Name or coach role is not present");
		}
		else {
		return coachRepository.findByCoachNameAndCoachRole(coachName, coachRole);
	}
	}
	
}
