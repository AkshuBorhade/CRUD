package com.sports.model;

public class PlayerDetailsWithStats {

	private Esports esports;
	private Stats stats;
	

	public PlayerDetailsWithStats(Esports esports, Stats stats) {
		super();
		this.esports = esports;
		this.stats = stats;
	}


	public Esports getEsports() {
		return esports;
	}


	public void setEsports(Esports esports) {
		this.esports = esports;
	}


	public Stats getStats() {
		return stats;
	}


	public void setStats(Stats stats) {
		this.stats = stats;
	}
	
	
	

}
