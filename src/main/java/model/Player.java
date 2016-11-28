package main.java.model;

public class Player {
	
	String name;
	int credits;
	
	public Player(){
		this.credits = 100;
	}
	
	public Player(String name){
		this.name = name;
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
