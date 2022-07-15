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

import com.cricket.dtoentity.CoachDto;
import com.cricket.entity.Coach;
import com.cricket.exception.PlayerNotFound;
import com.cricket.service.CoachService;

@RestController
@RequestMapping("/coach")
public class CoachController {

	@Autowired
	private CoachService coachService;

	@PostMapping
	public ResponseEntity<Coach> addCoach(@RequestBody @Valid CoachDto coachDto) {
		return new ResponseEntity<>(coachService.addCoach(coachDto), HttpStatus.CREATED);
	}

	@PutMapping("/{coachId}")
	public ResponseEntity<Coach> updateCoach(@RequestBody @Valid CoachDto coachDto, @PathVariable int coachId)
			throws Exception {
		return new ResponseEntity<>(coachService.updateCoach(coachDto, coachId), HttpStatus.OK);

	}

	@DeleteMapping("/{coachId}")
	public ResponseEntity<String> deleteCoach(@PathVariable int coachId) throws Exception {
		return new ResponseEntity<>(coachService.deleteCoach(coachId), HttpStatus.OK);
	}

	@GetMapping("{coachId}")
	public ResponseEntity<Coach> getCoachByCoachId(@PathVariable int coachId) throws PlayerNotFound {
		return ResponseEntity.ok(coachService.getCoach(coachId));

	}

	@GetMapping
	public ResponseEntity<List<Coach>> getAllCoachs() {
		return ResponseEntity.ok(coachService.getAllCoach());

	}
	
	@GetMapping("/coachname/{coachName}")
	public ResponseEntity<List<Coach>> getByCoachName(@PathVariable @Valid String coachName)
	{
		return ResponseEntity.ok(coachService.getByCoachName(coachName));
	}
	
	@GetMapping("/coachrole/{coachRole}")
	public ResponseEntity<List<Coach>> findByCoachRole(@PathVariable @Valid String coachRole)
	{
		return ResponseEntity.ok(coachService.findByCoachRole(coachRole));
	}
	
	@GetMapping("/coachname/coachrole/{coachName}/{coachRole}")
	public ResponseEntity<List<Coach>> findByCoachNameAndCoachRole(@PathVariable @Valid String coachName,@PathVariable @Valid String coachRole)
	{
		return ResponseEntity.ok(coachService.findByCoachNameAndCoachRole(coachName, coachRole));
	}
	
//	@GetMapping("/coachname/coachrole/{coachName}/{coachRole}")
//	public ResponseEntity<List<Coach>> findByCoachNameAndCoachRole(@PathVariable @Valid String coachName,@PathVariable @Valid String coachRole)
//	{
//		return ResponseEntity.ok(coachService.findByCoachNameAndCoachRole(coachName, coachRole));
//	}
}
