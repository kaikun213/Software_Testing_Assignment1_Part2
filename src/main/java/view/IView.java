package main.java.view;


import static main.java.controller.GameController.Event;

import java.io.IOException;

import main.java.model.Player;

public interface IView {
	
	public void showMenu();
	public void showHighScore(int highscore);
	public void showPickANumberGameRules();
	

	public Player registerPlayer();
	public Event getUserEvent() throws IOException;
	public String getName() throws IOException;

}
