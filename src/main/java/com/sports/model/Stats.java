package com.sports.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="stats")
public class Stats {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column
	private String formate;
	
	@Column
	private int match;
	
	@Column
	private int inning;
	
	@Column
	private int runs;
	
	@Column
	private int high_score;
	
	
	
	

	public Stats(Integer id, String formate, int match, int inning, int runs, int high_score) {
		super();
		this.id = id;
		this.formate = formate;
		this.match = match;
		this.inning = inning;
		this.runs = runs;
		this.high_score = high_score;
	}

	public Stats() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	@OneToOne
	@JoinColumn(name = "esport_id",referencedColumnName = "plrid")
	private Esports esports;
	
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFormate() {
		return formate;
	}

	public void setFormate(String formate) {
		this.formate = formate;
	}

	public int getMatch() {
		return match;
	}

	public void setMatch(int match) {
		this.match = match;
	}

	public int getInning() {
		return inning;
	}

	public void setInning(int inning) {
		this.inning = inning;
	}

	public int getRuns() {
		return runs;
	}

	public void setRuns(int runs) {
		this.runs = runs;
	}

	public int getHigh_score() {
		return high_score;
	}

	public void setHigh_score(int high_score) {
		this.high_score = high_score;
	}

	@Override
	public String toString() {
		return "Stats [id=" + id + ", formate=" + formate + ", match=" + match + ", inning=" + inning + ", runs=" + runs
				+ ", high_score=" + high_score + "]";
	}
	
	
}
