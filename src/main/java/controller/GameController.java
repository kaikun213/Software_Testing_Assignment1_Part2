package main.java.controller;

import main.java.model.Player;
import main.java.view.IView;

public class GameController {
	
	Player m_player;
	IView m_view;
	
	public GameController(IView a_view){
		this.m_view = a_view;
	}
	
	public void play(){
		//m_view.showMenu();
	}
	

}
