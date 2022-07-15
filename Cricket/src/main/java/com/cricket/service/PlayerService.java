package com.cricket.service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cricket.dtoentity.PlayerDto;
import com.cricket.entity.Coach;
import com.cricket.entity.Player;
import com.cricket.exception.PlayerNotFound;
import com.cricket.repository.CoachRepository;
import com.cricket.repository.PlayerRepository;

@Service
public class PlayerService {

	@Autowired
	PlayerRepository playerRepository;

	@Autowired
	private CoachRepository coachRepository;

	// addplayer
	public Player addPlayer(PlayerDto playerDto, int coachId) {
		Player playerSave = new Player();
		Coach coach = coachRepository.findById(coachId).get();
		playerSave.setPlayerName(playerDto.getPlayerName());
		playerSave.setPlayerAddress(playerDto.getPlayerAddress());
		playerSave.setRole(playerDto.getRole());
		playerSave.setSalary(playerDto.getSalary());
		playerSave.setCoach(coach);
		//logger.info("Message logged at INFO level");
		
		System.out.println(playerSave);
		return playerRepository.save(playerSave);
	}

	// update player
	public Player updatePlayer(PlayerDto playerDto, int playerId) {
		Player playerUpdate = playerRepository.findById(playerId).get();
		playerUpdate.setPlayerName(playerDto.getPlayerName());
		playerUpdate.setPlayerAddress(playerDto.getPlayerAddress());
		playerUpdate.setRole(playerDto.getRole());
		playerUpdate.setSalary(playerDto.getSalary());
		return playerRepository.save(playerUpdate);
	}

	// delete by id
	public String deletePlayer(int playerId) {
		playerRepository.deleteById(playerId);
		return playerId + " playerId is deleted";
	}

	// get by id
	public Player getPlayer(int playerId) throws PlayerNotFound {
		try {
			return playerRepository.findById(playerId).get();
		} catch (NoSuchElementException e) {
			throw new PlayerNotFound("PlayerId is not present");
		}
	}

	// get by AllPlayer
	public List<Player> getPlayerAll() {
		return playerRepository.findAll();
	}

	public List<Player> getPlayerByName(String playerName)throws PlayerNotFound {
		if (playerRepository.findByPlayerName(playerName).isEmpty()) {
			throw new PlayerNotFound("Player Name is not present");
		} else {
			return playerRepository.findByPlayerName(playerName);
		}

	}

	public List<Player> getPlayerByRole(String role) throws PlayerNotFound {
		if (playerRepository.findByRole(role) == null || playerRepository.findByRole(role).isEmpty()) {
			throw new PlayerNotFound("Player Name is not present");
		} else {
			return playerRepository.findByRole(role);
		}

	}

	public List<Player> getPlayerByPlayerAddress(String playerAddress)throws PlayerNotFound {
		if (playerRepository.findByPlayerAddress(playerAddress) == null
				|| playerRepository.findByPlayerAddress(playerAddress).isEmpty()) {
			throw new PlayerNotFound("Player Address is not present");
		} else {
			return playerRepository.findByPlayerAddress(playerAddress);
		}
	}

	public List<Player> getPlayerBySalary(int salary)throws PlayerNotFound {
		if (playerRepository.findBySalary(salary) == null || playerRepository.findBySalary(salary).isEmpty()) {
			throw new PlayerNotFound("Player Salary is not present");
		} else {
			return playerRepository.findBySalary(salary);
		}
	}

	public List<Player> getPlayerBySalaryGreaterThan(int salary)throws PlayerNotFound {
		if (playerRepository.findBySalaryGreaterThan(salary) == null
				|| playerRepository.findBySalaryGreaterThan(salary).isEmpty()) {
			throw new PlayerNotFound("Player Salary is not present");
		} else {
			return playerRepository.findBySalaryGreaterThan(salary);
		}
	}

	public List<Player> getPlayerBySalaryLessThan(int salary)throws PlayerNotFound {
		if (playerRepository.findBySalaryLessThan(salary) == null
				|| playerRepository.findBySalaryLessThan(salary).isEmpty()) {
			throw new PlayerNotFound("Player Salary is not present");
		} else {
			return playerRepository.findBySalaryLessThan(salary);
		}
	}

	public List<Player> getPlayerByPlayerNameAndRole(String playerName, String role)throws PlayerNotFound {
		if (playerRepository.findByPlayerNameAndRole(playerName, role).isEmpty()) {
			throw new PlayerNotFound("Player Salary is not present");
		} else {
			return playerRepository.findByPlayerNameAndRole(playerName, role);
		}
	}
	

	public List<Player> getPlayerByPlayerNameStartsWith(String playerName)throws PlayerNotFound {
		if (playerRepository.findByPlayerNameStartsWith(playerName).isEmpty()) {
			throw new PlayerNotFound("Player Name is not present");
		} else {
			return playerRepository.findByPlayerNameStartsWith(playerName);
		}
	}
	
	public List<Player> getPlayerByPlayerNameEndsWith(String playerName)throws PlayerNotFound {
		if (playerRepository.findByPlayerNameEndsWith(playerName).isEmpty()) {
			throw new PlayerNotFound("Player Name is not present");
		} else {
			System.out.println("hhhhhhhhhhhhhhh");
			return playerRepository.findByPlayerNameEndsWith(playerName);
		}
	}

}
