package main.java.view;


import static main.java.controller.GameController.Event;

import main.java.model.Player;

public interface IView {
	
	public void showMenu();
	public Player registerPlayer();
	public Event getUserEvent();

}
