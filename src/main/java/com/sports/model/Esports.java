package com.sports.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="esports")
public class Esports {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int plrId;
	
	@Column(name="plrName")
	private String plrName;
	
	@Column(name="plrGame")
	private String plrGame;
	
	@Column(name="plrTeam")
	private String plrTeam;
	
	@Column(name="plrAge")
	private int plrAge;

	public Esports(int plrId, String plrName, String plrGame, String plrTeam, int plrAge) {
		super();
		this.plrId = plrId;
		this.plrName = plrName;
		this.plrGame = plrGame;
		this.plrTeam = plrTeam;
		this.plrAge = plrAge;
	}

	public int getPlrId() {
		return plrId;
	}

	public void setPlrId(int plrId) {
		this.plrId = plrId;
	}

	public String getPlrName() {
		return plrName;
	}

	public void setPlrName(String plrName) {
		this.plrName = plrName;
	}

	public String getPlrGame() {
		return plrGame;
	}

	public void setPlrGame(String plrGame) {
		this.plrGame = plrGame;
	}

	public String getPlrTeam() {
		return plrTeam;
	}

	public void setPlrTeam(String plrTeam) {
		this.plrTeam = plrTeam;
	}

	public int getPlrAge() {
		return plrAge;
	}

	public void setPlrAge(int plrAge) {
		this.plrAge = plrAge;
	}

	public Esports() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Esports [plrId=" + plrId + ", plrName=" + plrName + ", plrGame=" + plrGame + ", plrTeam=" + plrTeam
				+ ", plrAge=" + plrAge + "]";
	}
	
		
	
}
