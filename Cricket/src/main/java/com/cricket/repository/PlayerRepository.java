package com.cricket.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cricket.entity.Player;
import com.cricket.exception.PlayerNotFound;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Integer>{
	
	public List<Player> findByPlayerName(String playerName);
	
	public List<Player> findByRole(String playerName);
	
	public List<Player> findByPlayerAddress(String playerAddress);
	
	public List<Player> findBySalary(int salary);
	
	public List<Player> findBySalaryGreaterThan(int salary);
	
	public List<Player> findBySalaryLessThan(int salary);
	
	public List<Player> findByPlayerNameAndRole(String playerName,String role);
	
	public List<Player>findByPlayerNameStartsWith(String playerName);
	
	public List<Player>findByPlayerNameEndsWith(String playerName);


}
