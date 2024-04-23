package com.sports.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sports.model.Esports;
import com.sports.repository.EsportsRepo;

@Service
public class EsportsService {

	@Autowired
	private EsportsRepo esportsRepo;

	public void addplayer(Esports esports) {
		esportsRepo.save(esports);
	}

	public Iterable<Esports> findAll() {
		// TODO Auto-generated method stub
		return esportsRepo.findAll();
	}

	public Optional<Esports> findById(long plrid) {
		// TODO Auto-generated method stub
		return esportsRepo.findById(plrid);
	}

	public void updatePlayerById(Esports existPLr) {

		esportsRepo.save(existPLr);
	}


	public void deletePlayerById(long plrid) {

		esportsRepo.deleteById(plrid);
	}

	public void deleteAll() {
		// TODO Auto-generated method stub
		esportsRepo.deleteAll();
	}
	
}
