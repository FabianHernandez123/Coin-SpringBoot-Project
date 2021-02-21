package com.tts.coinCollection.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Coin {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String denomination;
	private String type;
	private int year;
	private String condition;
	
	public Coin() {}

	//allowing Java to generate id so it is not needed in the constructor below
	public Coin(String denomination, String type, int year, String condition) {
		this.denomination = denomination;
		this.type = type;
		this.year = year;
		this.condition = condition;
	}

	public String getDenomination() {
		return denomination;
	}

	public void setDenomination(String denomination) {
		this.denomination = denomination;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getCondition() {
		return condition;
	}

	public void setCondition(String condition) {
		this.condition = condition;
	}

	public Long getId() {
		return id;
	}
	
	@Override
	public String toString() {
		return "Coin [id=" + id + ", denomination=" + denomination + ", type=" + type + ", year=" + year
				+ ", condition=" + condition + "]";
	}

}
