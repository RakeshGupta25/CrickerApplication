package com.cricket.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Coach {
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int coachId;
	private String coachName;
	private String coachRole;
	
	@OneToMany(mappedBy = "coach")
	@JsonBackReference
	private List<Player> player;
	
	public Coach() {
		super();
	}

	public Coach(int coachId, String coachName, String coachRole) {
		super();
		this.coachId = coachId;
		this.coachName = coachName;
		this.coachRole = coachRole;
	}

	public int getCoachId() {
		return coachId;
	}

	public void setCoachId(int coachId) {
		this.coachId = coachId;
	}

	public String getCoachName() {
		return coachName;
	}

	public void setCoachName(String coachName) {
		this.coachName = coachName;
	}

	public String getCoachRole() {
		return coachRole;
	}

	public void setCoachRole(String coachRole) {
		this.coachRole = coachRole;
	}
	

}
