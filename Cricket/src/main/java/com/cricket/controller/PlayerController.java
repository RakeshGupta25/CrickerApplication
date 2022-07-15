package com.cricket.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cricket.dtoentity.PlayerDto;
import com.cricket.entity.Player;
import com.cricket.exception.PlayerNotFound;
import com.cricket.service.PlayerService;

@RestController
@RequestMapping("/player")
public class PlayerController {
	
	
	@Autowired
	private PlayerService playerService;
	
	@PostMapping("{coachId}")
	public ResponseEntity<Player> addPlayer(@RequestBody @Valid PlayerDto playerDto,@PathVariable int coachId) 
	{
		System.out.println("firstttttttttttttttt");
		return  new ResponseEntity<>(playerService.addPlayer(playerDto,coachId),HttpStatus.CREATED);			
	}
	

	@PutMapping("/{playerId}")
	public ResponseEntity<Player> updatePlayer(@RequestBody @Valid PlayerDto playerDto,@PathVariable int playerId) throws Exception
	{
		return  new ResponseEntity<>(playerService.updatePlayer(playerDto, playerId),HttpStatus.OK);			
	}
	
	@DeleteMapping("/{playerId}")
	public ResponseEntity<String> deletePlayer(@PathVariable int playerId) throws Exception
	{
		return  new ResponseEntity<>(playerService.deletePlayer(playerId),HttpStatus.OK);			
	}
	
	@GetMapping("{playerId}")
	public ResponseEntity<Player> getPlayerByPlayerId(@PathVariable int playerId) throws PlayerNotFound
	{
		return  ResponseEntity.ok(playerService.getPlayer(playerId));
						
	}
	
	@GetMapping
	public ResponseEntity<List<Player>> getAllPlayers()
	{	
		System.out.println("------------------------"+playerService.getPlayerAll());
		return  new ResponseEntity<>(playerService.getPlayerAll(),HttpStatus.OK);		
	}
	
	@GetMapping("/name/{playerName}")
	public ResponseEntity<List<Player>> getPlayerByName(@PathVariable @Valid String playerName) throws PlayerNotFound
	{
		return new ResponseEntity<>(playerService.getPlayerByName(playerName),HttpStatus.OK);
	}
	
	@GetMapping("/role/{role}")
	public ResponseEntity<List<Player>> getPlayerByRole(@PathVariable @Valid String role) throws PlayerNotFound
	{
		return new ResponseEntity<>(playerService.getPlayerByRole(role),HttpStatus.OK);
	}
	
	@GetMapping("/address/{playerAddress}")
	public ResponseEntity<List<Player>> getPlayerByPlayerAddress(@PathVariable @Valid String playerAddress) throws PlayerNotFound
	{
		return new ResponseEntity<>(playerService.getPlayerByPlayerAddress(playerAddress),HttpStatus.OK);
	}
	
	@GetMapping("/salary/{salary}")
	public ResponseEntity<List<Player>> getPlayerByPlayerAddress(@PathVariable @Valid int salary) throws PlayerNotFound
	{
		return new ResponseEntity<>(playerService.getPlayerBySalary(salary),HttpStatus.OK);
	}
	
	@GetMapping("/salary/greater/{salary}")
	public ResponseEntity<List<Player>> getPlayerBySalaryGreaterThan(@PathVariable @Valid int salary) throws PlayerNotFound
	{
		return new ResponseEntity<>(playerService.getPlayerBySalaryGreaterThan(salary),HttpStatus.OK);
	}
	
	@GetMapping("/salary/less/{salary}")
	public ResponseEntity<List<Player>> getSalaryByLessThan(@PathVariable @Valid int salary) throws PlayerNotFound
	{
		return new ResponseEntity<>(playerService.getPlayerBySalaryLessThan(salary),HttpStatus.OK);
	}
	
	@GetMapping("/name/role/{playerName}/{role}")
	public ResponseEntity<List<Player>> getPlayerByPlayerNameAndRole(@PathVariable @Valid String playerName,@PathVariable @Valid String role) throws PlayerNotFound
	{
		return new ResponseEntity<>(playerService.getPlayerByPlayerNameAndRole(playerName,role),HttpStatus.OK);
	}
	
	@GetMapping("/startWithname/{playerName}")
	public ResponseEntity<List<Player>> getPlayerByPlayerNameStartsWith(@PathVariable @Valid String playerName)throws PlayerNotFound
	{
		return new ResponseEntity<>(playerService.getPlayerByPlayerNameStartsWith(playerName),HttpStatus.OK);
	}
	
	@GetMapping("/endWithname/{playerName}")
	public ResponseEntity<List<Player>> getPlayerByPlayerNameEndsWith(@PathVariable @Valid String playerName) throws PlayerNotFound
	{
		return new ResponseEntity<>(playerService.getPlayerByPlayerNameEndsWith(playerName),HttpStatus.OK);
	}
	
	
	
	
	
	
	
	@RequestMapping("/cricket")
	public String show()
	{
		return "Hello";
	}

}
