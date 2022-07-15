package com.cricket.dtoentity;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

public class PlayerDto {

	private int playerId;
	
	@NotEmpty(message= "Player name should not be empty")
	private String playerName;
	
	@NotEmpty(message= "Player address should not be empty")
	private String playerAddress;
	
	private String role;
	
	//@NotEmpty(message= "Salary should not be empty")
	@Min(10000)
	private int salary;

	public PlayerDto() {
		super();
	}

	
	
	public PlayerDto(int playerId, String playerName, String playerAddress, String role, int salary) {
		super();
		this.playerId = playerId;
		this.playerName = playerName;
		this.playerAddress = playerAddress;
		this.role = role;
		this.salary = salary;
	}



	public int getPlayerId() {
		return playerId;
	}



	public void setPlayerId(int playerId) {
		this.playerId = playerId;
	}



	public String getPlayerName() {
		return playerName;
	}



	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}



	public String getPlayerAddress() {
		return playerAddress;
	}



	public void setPlayerAddress(String playerAddress) {
		this.playerAddress = playerAddress;
	}



	public String getRole() {
		return role;
	}



	public void setRole(String role) {
		this.role = role;
	}



	public int getSalary() {
		return salary;
	}



	public void setSalary(int salary) {
		this.salary = salary;
	}
	
	
	
}
