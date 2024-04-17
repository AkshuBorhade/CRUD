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
	private long plrid;
	
	@Column(name="plr_name")
	private String plr_name;
	
	@Column(name="plr_game")
	private String plr_game;
	
	@Column(name="plr_team")
	private String plr_team;
	
	@Column(name="plr_age")
	private int plr_age;
	
	public Esports() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Esports(long plrid, String plr_name, String plr_game, String plr_team, int plr_age) {
		super();
		this.plrid = plrid;
		this.plr_name = plr_name;
		this.plr_game = plr_game;
		this.plr_team = plr_team;
		this.plr_age = plr_age;
	}

	public long getPlrid() {
		return plrid;
	}

	public void setPlrid(int plrid) {
		this.plrid = plrid;
	}

	public String getPlr_name() {
		return plr_name;
	}

	public void setPlr_name(String plr_name) {
		this.plr_name = plr_name;
	}

	public String getPlr_game() {
		return plr_game;
	}

	public void setPlr_game(String plr_game) {
		this.plr_game = plr_game;
	}

	public String getPlr_team() {
		return plr_team;
	}

	public void setPlr_team(String plr_team) {
		this.plr_team = plr_team;
	}

	public int getPlr_age() {
		return plr_age;
	}

	public void setPlr_age(int plr_age) {
		this.plr_age = plr_age;
	}

	@Override
	public String toString() {
		return "Esports [plrid=" + plrid + ", plr_name=" + plr_name + ", plr_game=" + plr_game + ", plr_team="
				+ plr_team + ", plr_age=" + plr_age + "]";
	}
	
	
	
}
