package main.java.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Player {
	
	public static final int defaultCredits = 100;
	
	String name;
	int credits;
	int highscore;
	
	public Player(){
		this.credits = defaultCredits;
		this.name = "DefaultPlayerName";
	}
	
	public Player(String name){
		this.name = name;
		this.credits = defaultCredits;
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
	
	public void resetCredits(){
		this.credits = defaultCredits;
	}

	public int getHighscore() {
		return highscore;
	}

	public void setHighscore(int highscore) {
		this.highscore = highscore;
	}
	

}
