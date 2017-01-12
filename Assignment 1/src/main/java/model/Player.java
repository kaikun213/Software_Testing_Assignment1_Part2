package main.java.model;

import javax.xml.bind.annotation.XmlRootElement;

import main.java.model.error.NotEnoughCreditsException;

@XmlRootElement
public class Player {
	
	public static final int defaultCredits = 100;
	String name;
	int credits;
	int highscore;
	
	public Player(){
		this.credits = defaultCredits;
		this.name = "DefaultPlayerName";
		this.highscore = defaultCredits;
	}
	
	public Player(String name){
		this.name = name;
		this.credits = defaultCredits;
		this.highscore = defaultCredits;
	}

	public String getName(){
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public int getCredits() {
		return credits;
	}

	public void setCredits(int credits) {
		this.credits = credits;
	}

	public void setHighscore(int highscore) {
		this.highscore = highscore;
	}

	public void increaseCredits(int credits) {
		this.credits += credits;
		if (this.credits > this.highscore) this.highscore = this.credits;
	}
	public void decreaseCredits(int credits) throws NotEnoughCreditsException {
		if ((this.credits-credits)<0) throw new NotEnoughCreditsException();
		this.credits -= credits;
	}
	
	public void resetCredits(){
		this.credits = defaultCredits;
	}

	public int getHighscore() {
		return highscore;
	}
	

}
