package com.cricket.dtoentity;

public class CoachDto {

	
	private int coachId;
	
	//@NotEmpty(message= "Player name should not be empty")
	private String coachName;
	
	//@NotEmpty(message= "Player name should not be empty")
	private String coachRole;

	public CoachDto() {
		super();
	}

	public CoachDto(int coachId, String coachName, String coachRole) {
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
