package main.java.model;

import java.util.Random;

public class PickANumberGame {
	
	public final static int MIN_NUMBER = 1;
	public final static int MAX_NUMBER = 20;
	
	Player player;
	int currentNumber;
	boolean won;
	Random rand;
	
	public PickANumberGame(Player player, Random randomGenerator){
		this.player = player;
		rand = randomGenerator;
		this.currentNumber = 0;
		won = false;
	}
	
	public void play(int guess) throws IndexOutOfBoundsException{
		if ((guess<MIN_NUMBER) || (guess>MAX_NUMBER)) throw new IndexOutOfBoundsException("Your number is not valid!");

		// generate a number in the given bounds, modulo to make sure
		currentNumber = ((rand.nextInt(MAX_NUMBER-MIN_NUMBER)+MIN_NUMBER) %MAX_NUMBER);
		if (guess == currentNumber) won = true;
		else won = false;
	}
	
	public boolean hasWon(){
		return won;
	}

	public int getWinningNumber() throws IndexOutOfBoundsException{
		if (currentNumber<MIN_NUMBER) throw new IndexOutOfBoundsException("You need to play first!");
		return currentNumber;
	}
}
