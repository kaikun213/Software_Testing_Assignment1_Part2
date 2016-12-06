package main.java.view;


import static main.java.controller.GameController.Event;

import java.io.IOException;

import main.java.model.Player;

public interface IView {
	
	public void showMenu();
	public void showHighScore(int highscore);	
	public Player registerPlayer();
	public Event getUserEvent() throws IOException;
	public String getName() throws IOException;
	
	public void showPickANumberGameRules();
	public int getNumberBetween(int from, int until) throws IOException;
	public void showResultPickANumberGame(boolean won, int winningNumber);

	public void showNotEnoughCredits();
	
	public void showCurrentState(String playerName, int playerCredits);

}
