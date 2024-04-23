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
import com.sports.service.EsportsService;

@RestController
@RequestMapping("/api")
public class EsportsController {
		
	@Autowired
	EsportsService esportsService;
	
	//adding players in DB
        //add new code changes here akshay 
	
	@PostMapping("/add/sports")
	public String addNewPlayer(@RequestBody Esports esports) {
		esportsService.addplayer(esports);
		return "player added successfully";
	}
	
	//showing players
	@GetMapping("/get/sports")
	public ResponseEntity<List<Esports>> getPlayers(){
		List<Esports> plrList = new ArrayList<>();
		esportsService.findAll().forEach(plrList::add);
		return new ResponseEntity<List<Esports>>(plrList,HttpStatus.OK);
	}
	
	//showing players by ID
	@GetMapping("/getbyid/sports/{plrid}")
	public ResponseEntity<Esports> getbyId(@PathVariable long plrid ){
		Optional<Esports> esp = esportsService.findById(plrid);
		if(esp.isPresent()) {
			return new ResponseEntity<Esports>(esp.get(), HttpStatus.FOUND);
		}else {
			return new ResponseEntity<Esports>(HttpStatus.NOT_FOUND);
		}
	}
	
	//updating players
	@PutMapping("/update/sports/{plrid}")
	public String updatePlyerById(@PathVariable long plrid, @RequestBody Esports esports) {
		Optional<Esports> esp = esportsService.findById(plrid);
		if(esp.isPresent()) {
			Esports existPLr = esp.get();
			existPLr.setPlrName(esports.getPlrName());
			existPLr.setPlrGame(esports.getPlrGame());
			existPLr.setPlrTeam(esports.getPlrTeam());
			existPLr.setPlrAge(esports.getPlrAge());
			esportsService.updatePlayerById(existPLr);
			return "Updated the player at ID "+plrid;
		}else {
			return "Player details does not exist for ID "+plrid;
		}
	}
	
	//deleting 1 Player from DB
	@DeleteMapping("/delete/sports/{plrid}")
	public String deletePlyerById(@PathVariable long plrid) {
		esportsService.deletePlayerById(plrid);
		return "Player deleted Successfully at ID "+plrid;
	}
	
	//deleting all players from DB
	@DeleteMapping("/deleteall/sports")
	public String deleteAllPlayers() {
		esportsService.deleteAll();
		return "All players Deleted SuccessFully"; 
	}
}
