package com.cricket.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Player {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int playerId;
	private String playerName;
	private String playerAddress;
	private String role;
	private int salary;
	
	@ManyToOne(fetch=FetchType.EAGER,
			cascade= {CascadeType.PERSIST, CascadeType.MERGE,
					 CascadeType.DETACH, CascadeType.REFRESH})
	@JoinColumn(name="coach_coachId", nullable=false)
	@JsonManagedReference
	private Coach coach;
	
	public Player() {
		super();
	}

	public Player(String playerName, String playerAddress, String role, int salary) {
		super();
		this.playerName = playerName;
		this.playerAddress = playerAddress;
		this.role = role;
		this.salary = salary;
	}

	public Player(int playerId, String playerName, String playerAddress, String role, int salary) {
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

	
	public Coach getCoach() {
		return coach;
	}

	public void setCoach(Coach coach) {
		this.coach = coach;
	}

	@Override
	public String toString() {
		return "Player [playerId=" + playerId + ", playerName=" + playerName + ", playerAddress=" + playerAddress
				+ ", role=" + role + ", salary=" + salary + "]";
	}
	
	
	

}
