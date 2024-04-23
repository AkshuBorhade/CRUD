package com.sports.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

import com.sports.model.Esports;
import com.sports.repository.EsportsRepo;

@RestController
@RequestMapping("/api")
public class EsportsController {
		
	@Autowired
	EsportsRepo esportsRepo;
	
	//adding players in DB
        //add new code changes here akshay 
	@PostMapping("/add/sports")
	public String addNewPlayer(@RequestBody Esports esports) {
		esportsRepo.save(esports);
		return "player added successfully";
	}
	
	//showing players
	@GetMapping("/update/sports")
	public ResponseEntity<List<Esports>> getPlayers(){
		List<Esports> plrList = new ArrayList<>();
		esportsRepo.findAll().forEach(plrList::add);
		return new ResponseEntity<List<Esports>>(plrList,HttpStatus.OK);
	}
	
	//showing players by ID
	@GetMapping("/sports/{plrid}")
	public ResponseEntity<Esports> getbyId(@PathVariable long plrid ){
		Optional<Esports> esp = esportsRepo.findById(plrid);
		if(esp.isPresent()) {
			return new ResponseEntity<Esports>(esp.get(), HttpStatus.FOUND);
		}else {
			return new ResponseEntity<Esports>(HttpStatus.NOT_FOUND);
		}
	}
	
	//updating players
	@PutMapping("/sports/{plrid}")
	public String updatePlyerById(@PathVariable long plrid, @RequestBody Esports esports) {
		Optional<Esports> esp = esportsRepo.findById(plrid);
		if(esp.isPresent()) {
			Esports existPLr = esp.get();
			existPLr.setPlr_name(esports.getPlr_name());
			existPLr.setPlr_game(esports.getPlr_game());
			existPLr.setPlr_team(esports.getPlr_team());
			existPLr.setPlr_age(esports.getPlr_age());
			esportsRepo.save(existPLr);
			return "Updated the player at ID "+plrid;
		}else {
			return "Player details does not exist for ID "+plrid;
		}
	}
	
	//deleting 1 Player from DB
	@DeleteMapping("/sports/{plrid}")
	public String deletePlyerById(@PathVariable long plrid) {
		esportsRepo.deleteById(plrid);
		return "Player deleted Successfully at ID "+plrid;
	}
	
	//deleting all players from DB
	@DeleteMapping("/sports")
	public String deleteAllPlayers() {
		esportsRepo.deleteAll();
		return "All players Deleted SuccessFully"; 
	}
}
