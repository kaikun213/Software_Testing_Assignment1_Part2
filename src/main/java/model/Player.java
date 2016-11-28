package main.java.model;

public class Player {
	
	public static final int defaultCredits = 100;
	
	String name;
	int credits;
	
	public Player(){
		this.credits = defaultCredits;
	}
	
	public Player(String name){
		this.name = name;
		this.credits = defaultCredits;
	}

	public String getName() {
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
	

}
