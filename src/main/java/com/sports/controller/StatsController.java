package com.sports.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.sports.model.Stats;
import com.sports.repository.EsportsRepo;
import com.sports.repository.StatsRepo;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;




@RestController
@RequestMapping("/api")
public class StatsController {

	@Autowired
	StatsRepo statsRepo;
	
	//adding stats in DB
	@PostMapping("/stats")
	public String addNewStats(@RequestBody Stats stats) {
		statsRepo.save(stats);
		return"added successfully";
		
	}
	@GetMapping("/stats")
	public ResponseEntity<List<Stats>> getStats(){
		List<Stats> st = new ArrayList<>();
		statsRepo.findAll().forEach(st::add);
		return new ResponseEntity<List<Stats>>(st,HttpStatus.OK);
	}
	
	//showing stats
	@GetMapping("/stats/{id}")
	public ResponseEntity<Stats> getbyId(@PathVariable Integer id) {
		Optional<Stats> st = statsRepo.findById(id);
		if (st.isPresent()) {
			return new ResponseEntity<Stats>(st.get(),HttpStatus.FOUND);
	
		}else {
			return new ResponseEntity<Stats>(HttpStatus.NOT_FOUND);
		}
		
		
		
	}
	
	@PutMapping("/stats/{id}")
	public String updatestatsById(@PathVariable Integer id, @RequestBody Stats stats) {
		//TODO: process PUT request
		Optional<Stats> esp = statsRepo.findById(id);
		if (esp.isPresent()) {
			Stats st = esp.get();
			st.setId(stats.getId());
			st.setMatch(stats.getMatch());
			st.setInning(stats.getInning());
			st.setRuns(stats.getRuns());
			
			statsRepo.save(st);
			return " "+stats;
		}else {
			return"details not found"+stats;
		}
		
		
		
	}
	
	
}
