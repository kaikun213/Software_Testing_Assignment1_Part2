package main.java.model.game;

import main.java.model.error.NotEnoughCreditsException;

public interface IPickANumberGame {
	
	public void play(int guess) throws NotEnoughCreditsException;
	public boolean hasWon();
	public int getWinningNumber() throws IndexOutOfBoundsException;
}
